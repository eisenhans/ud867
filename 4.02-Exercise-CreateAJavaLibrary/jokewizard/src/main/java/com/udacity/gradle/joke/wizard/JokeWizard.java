package com.udacity.gradle.joke.wizard;

import com.udacity.gradle.jokes.JokeSmith;

public class JokeWizard {

    private JokeSmith smith = new JokeSmith();

    public String tellJoke() {
        return "Retelling joke from smith: " + smith.tellJoke();
    }
}
