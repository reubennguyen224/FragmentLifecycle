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

import java.util.Objects;
import java.util.zip.Inflater;

public class FragmentA extends Fragment {

    View view;
    Button btnB;
    String tag = "---Fragment 1---";
    MediaPlayer mediaPlayer;
    int time;
    Bundle res;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_a, container, false);

        btnB = view.findViewById(R.id.btnB);

        Log.d(tag, "onCreateView");
        Toast.makeText(getContext(), "Fragment 1: onCreateView", Toast.LENGTH_SHORT).show();

        return view;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Log.d(tag, "onCreate");
        Toast.makeText(getContext(), "Fragment 1: onCreate", Toast.LENGTH_LONG).show();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        btnB.setOnClickListener(view1 -> {
            getFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentB()).addToBackStack(null).commit();
        });


        mediaPlayer = MediaPlayer.create(view.getContext(), R.raw.bai1);
        mediaPlayer.setLooping(true);

        if (savedInstanceState != null) time = savedInstanceState.getInt("key", 0);
        mediaPlayer.seekTo(time);
        mediaPlayer.start();

        Log.d(tag, "onViewCreated");
        Toast.makeText(getContext(), "Fragment 1: onViewCreated", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStart() {
        super.onStart();

        mediaPlayer.start();
        Log.d(tag, "onStart");
        Toast.makeText(getContext(), "Fragment 1: onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);

        Log.d(tag, "onViewStateRestored");
        Toast.makeText(getContext(), "Fragment 1: onViewStateRestored", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();

        mediaPlayer.seekTo(time);
        mediaPlayer.start();

        Log.d(tag, "onResume");
        Toast.makeText(getContext(), "Fragment 1: onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();

        mediaPlayer.pause();
        time = mediaPlayer.getCurrentPosition();

        Log.d(tag, "onPause");
        Toast.makeText(getContext(), "Fragment 1: onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();

        mediaPlayer.pause();
        time = mediaPlayer.getCurrentPosition();

        Log.d(tag, "onStop");
        Toast.makeText(getContext(), "Fragment 1: onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);

        outState.putInt("key", time);

        Log.d(tag, "onSaveInstanceState");
        Toast.makeText(getContext(), "Fragment 1: onSaveInstanceState", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();

        Log.d(tag, "onDestroyView");
        Toast.makeText(getContext(), "Fragment 1: onDestroyView", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        mediaPlayer.stop();
        mediaPlayer.release();

        Log.d(tag, "onDestroy");
        Toast.makeText(getContext(), "Fragment 1: onDestroy", Toast.LENGTH_SHORT).show();
    }
}
