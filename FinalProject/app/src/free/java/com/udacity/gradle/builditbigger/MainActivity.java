package com.udacity.gradle.builditbigger;

import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


public class MainActivity extends ActionBarActivity {
    private static final String LOG_TAG = MainActivity.class.getName();

    private InterstitialAd interstitialAd;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(getResources().getString(R.string.interstitial_ad_unit_id));

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                doTellJoke();
                requestNewInterstitial();
            }
        });
        requestNewInterstitial();

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
        if (interstitialAd.isLoaded()) {
            interstitialAd.show();
        } else {
            doTellJoke();
        }
    }

    private void doTellJoke() {
        new EndpointsAsyncTask().execute(this);
        showProgressBar(true);
    }

    private void requestNewInterstitial() {
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(Settings.Secure.ANDROID_ID)
                .build();

        interstitialAd.loadAd(adRequest);
    }
}
