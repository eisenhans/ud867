package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;


public class MainActivity extends ActionBarActivity {
    private static final String LOG_TAG = MainActivity.class.getName();

    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        progressBar = (ProgressBar) findViewById(R.id.progress_bar);
        showProgressBar(false);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public void showProgressBar(boolean show) {
        if (show) {
            Log.i(LOG_TAG, "showing progress bar");
            progressBar.setVisibility(View.VISIBLE);
        } else {
            Log.i(LOG_TAG, "hiding progress bar");
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void tellJoke(View view) {
        new EndpointsAsyncTask().execute((Context) this);
        showProgressBar(true);

//        Intent jokeIntent = new Intent(this, JokeDisplayActivity.class);
//        jokeIntent.putExtra(JokeDisplayActivity.JOKE_KEY, jokeTeller.tellJoke());
//        startActivity(jokeIntent);
    }

}
