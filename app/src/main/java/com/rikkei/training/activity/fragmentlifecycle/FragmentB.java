package com.rikkei.training.activity.fragmentlifecycle;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentTransaction;

public class FragmentB extends Fragment {

    View view;
    Button btnA;
    String tag = "----Fragment 2----";
    MediaPlayer mediaPlayer;
    int time;
    Bundle res;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_b, container, false);

        btnA = view.findViewById(R.id.btnA);

        Log.d(tag, "onCreateView");
        Toast.makeText(getContext(), "Fragment 2: onCreateView", Toast.LENGTH_SHORT).show();

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(tag, "onCreate");
        Toast.makeText(getContext(), "Fragment 2: onCreate", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnA.setOnClickListener(view1 -> {
            getFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentA()).addToBackStack(null).commit();
        });

        mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.bai2);
        mediaPlayer.setLooping(true);

        if (savedInstanceState != null) time = savedInstanceState.getInt("key", 0);
        mediaPlayer.seekTo(time);
        mediaPlayer.start();


        Log.d(tag, "onViewCreated");
        Toast.makeText(getContext(), "Fragment 2: onViewCreated", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();

        mediaPlayer.start();

        Log.d(tag, "onStart");
        Toast.makeText(getContext(), "Fragment 2: onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();

        mediaPlayer.seekTo(time);
        mediaPlayer.start();

        Log.d(tag, "onResume");
        Toast.makeText(getContext(), "Fragment 2: onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("key", time);

        Log.d(tag, "onSaveInstanceState");
        Toast.makeText(getContext(), "Fragment 2: onSaveInstanceState", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();
        mediaPlayer.pause();
        Log.d(tag, "onStop");
        Toast.makeText(getContext(), "Fragment 2: onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        mediaPlayer.stop();
        mediaPlayer.release();

        Log.d(tag, "onDestroyView");
        Toast.makeText(getContext(), "Fragment 2: onDestroyView", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        Log.d(tag, "onDestroy");
        Toast.makeText(getContext(), "Fragment 2: onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();

        mediaPlayer.pause();
        time = mediaPlayer.getCurrentPosition();

        Log.d(tag, "onPause");
        Toast.makeText(getContext(), "Fragment 2: onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        Log.d(tag, "onViewStateRestored");
        Toast.makeText(getContext(), "Fragment 2: onViewStateRestored", Toast.LENGTH_SHORT).show();
    }
}
