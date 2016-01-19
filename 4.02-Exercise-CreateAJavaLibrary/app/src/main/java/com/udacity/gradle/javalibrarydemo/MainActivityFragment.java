package com.udacity.gradle.javalibrarydemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.udacity.gradle.joke.wizard.JokeWizard;
import com.udacity.gradle.jokes.JokeSmith;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment {

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = (View) inflater.inflate(R.layout.fragment_main, container, false);

        TextView jokesmithTextView = (TextView) rootView.findViewById(R.id.jokesmithTextView);

        String joke = new JokeSmith().tellJoke();
        jokesmithTextView.setText(joke);

        TextView jokewizardTextView = (TextView) rootView.findViewById(R.id.jokewizardTextView);

        String joke2 = new JokeWizard().tellJoke();
        jokewizardTextView.setText(joke2);

        return rootView;
    }
}
