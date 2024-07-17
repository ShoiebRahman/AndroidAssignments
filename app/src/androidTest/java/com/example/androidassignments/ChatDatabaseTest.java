package com.example.androidassignments;

import android.content.Context;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.test.core.app.ActivityScenario;
import androidx.test.espresso.Espresso;
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
public class ChatDatabaseTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    private MainActivity activity;


    @Before
    public void setUp() {
        activity = activityRule.getActivity();
        //testToolbarButton = activity.findViewById(R.id.test_toolbar_button);
    }

    @Test
    public void chatDbTest() throws InterruptedException {
        //Launch Activity
        ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class);
        //Enter Chat Window and type 2 messages
        onView(withId(R.id.start_chat)).perform(click());
        onView(withId(R.id.chat_input_edit_text)).perform(typeText("Chat Test Message 1"), closeSoftKeyboard());
        Thread.sleep(1000);
        onView(withId(R.id.send_button)).perform(click());
        Thread.sleep(1000);
        onView(withId(R.id.chat_input_edit_text)).perform(typeText("Chat Test Message 2"), closeSoftKeyboard());
        Thread.sleep(1000);
        onView(withId(R.id.send_button)).perform(click());
        Thread.sleep(1000);

        //Go back
        Espresso.pressBack();
        Thread.sleep(1000);

        //start chat again
        onView(withId(R.id.start_chat)).perform(click());

        //check if messages are printed
        onView(withText("Chat Test Message 1")).check(matches(isDisplayed()));
        onView(withText("Chat Test Message 2")).check(matches(isDisplayed()));

        Thread.sleep(3000);
    }

}

