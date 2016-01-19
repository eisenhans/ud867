package com.udacity.gradle.jokeaar;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A placeholder fragment containing a simple view.
 */
public class JokeActivityFragment extends Fragment {

    public JokeActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_joke, container, false);

        TextView textView = (TextView) rootView.findViewById(R.id.jokeView);

        String joke = getActivity().getIntent().getStringExtra("joke");
        if (joke != null && joke.length() > 0) {
            textView.setText("Retelling joke that was passed from other activity via intent: " + joke);
        }

        return rootView;
    }
}
