package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.RootMatchers.withDecorView;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.startsWith;

@RunWith(AndroidJUnit4.class)
public class JokeTellerEspressoTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    private MainActivity mainActivity;

    @Before
    public void before() {
        mainActivity = activityRule.getActivity();
    }

    /**
     * Because the jokeEndpoints work on an emulator only, the same is true for this test.
     */
    @Test
    public void testJokeDisplayedAsToast() {
        onView(withId(R.id.joke_button)).perform(click());

        onView(withText(startsWith("This is joke")))
                .inRoot(withDecorView(not(mainActivity.getWindow().getDecorView())))
                .check(matches(isDisplayed()));
    }

}