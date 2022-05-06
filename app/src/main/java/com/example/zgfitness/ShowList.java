package com.example.zgfitness;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class ShowList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_main);

        //Setting Icon & Title to the Title Bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setIcon(R.drawable.ic_baseline_keyboard_command_key_24);
        setTitle(" " +getString(R.string.services));

        //Using Fragment Manager to perform action on the app's Fragment.
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                    new FragmentItem()).commit();
        }
    }
}
