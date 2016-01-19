package com.example.android.clickcounter;

import android.support.test.espresso.action.ViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.assertEquals;

@RunWith(AndroidJUnit4.class)
public class ClickCounterEspressoTest {

    @Rule
    public ActivityTestRule<ClickActivity> activityRule = new ActivityTestRule<>(ClickActivity.class);

    private Button button;
    private TextView textView;

    @Before
    public void before() {
        button = (Button) activityRule.getActivity().findViewById(R.id.click_button);
        textView = (TextView) activityRule.getActivity().findViewById(R.id.click_count_text_view);
    }

    @Test
    public void click() {
        assertCountEquals(0);
        onView(withId(R.id.click_button)).perform(ViewActions.click());
        assertCountEquals(1);
        onView(withId(R.id.click_button)).perform(ViewActions.click());
        onView(withId(R.id.click_button)).perform(ViewActions.click());
        assertCountEquals(3);
    }

    private void assertCountEquals(int i) {
        assertEquals(i, Integer.parseInt(textView.getText().toString()));
    }

}