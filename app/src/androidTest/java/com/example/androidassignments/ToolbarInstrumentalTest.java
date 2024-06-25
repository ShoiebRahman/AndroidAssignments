package com.example.androidassignments;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import static org.hamcrest.CoreMatchers.notNullValue;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.assertThat;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class ToolbarInstrumentalTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    private MainActivity activity;
    private Button testToolbarButton;

    @Before
    public void setUp() {
        activity = activityRule.getActivity();
        testToolbarButton = activity.findViewById(R.id.test_toolbar_button);
    }

    @Test
    public void toolbarTest_opt1() throws InterruptedException {
        ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.test_toolbar_button)).perform(click());
        onView(withId(R.id.opt_1)).perform(click());
        onView(withText("Standard Text from Snackbar")).check(matches(isDisplayed()));
        Thread.sleep(2000);
    }
    @Test
    public void toolbarTest_opt2() throws InterruptedException {
        ActivityScenario<TestToolbar> scenario = ActivityScenario.launch(TestToolbar.class);
        onView(withId(R.id.opt_2)).perform(click());
        onView(withText("Do you want to go back?")).check(matches(isDisplayed()));
        onView(withText("No")).perform(click());
        Thread.sleep(2000);
    }
    @Test
    public void toolbarTest_opt3() throws InterruptedException {
        ActivityScenario<TestToolbar> scenario = ActivityScenario.launch(TestToolbar.class);
        onView(withId(R.id.opt_3)).perform(click());
        onView(withId(R.id.custom_msg_input)).perform(typeText("Hello. New Message"),
                closeSoftKeyboard());
        onView(withText("Ok")).perform(click());
        onView(withId(R.id.opt_1)).perform(click());
        onView(withText("Hello. New Message")).check(matches(isDisplayed()));
        Thread.sleep(2000);
    }
    @Test
    public void toolbarTest_opt2_end() throws InterruptedException {
        ActivityScenario<TestToolbar> scenario = ActivityScenario.launch(TestToolbar.class);
        onView(withId(R.id.opt_2)).perform(click());
        onView(withText("Do you want to go back?")).check(matches(isDisplayed()));
        onView(withText("Yes")).perform(click());
        Thread.sleep(2000);
    }

}

