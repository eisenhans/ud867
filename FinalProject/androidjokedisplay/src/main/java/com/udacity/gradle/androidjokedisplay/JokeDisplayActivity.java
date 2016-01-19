package com.udacity.gradle.androidjokedisplay;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class JokeDisplayActivity extends AppCompatActivity {

    public static final String JOKE_KEY = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_joke_display);

        String joke = getIntent().getStringExtra(JOKE_KEY);
        if (joke == null || joke.length() == 0) {
            joke = "No joke to tell.";
        }
        Toast.makeText(this, joke, Toast.LENGTH_SHORT).show();
    }
}
