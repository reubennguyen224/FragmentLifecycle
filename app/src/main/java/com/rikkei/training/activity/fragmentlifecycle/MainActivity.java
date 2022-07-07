package com.rikkei.training.activity.fragmentlifecycle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getSupportActionBar().setTitle("Fragment Lifecycle");

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, new FragmentA()).commit();
    }
}