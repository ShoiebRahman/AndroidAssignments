package com.example.androidassignments;

import androidx.annotation.ContentView;

import android.content.Context;
import android.content.Intent;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.espresso.Espresso.onView;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.intent.Intents.intended;
import static androidx.test.espresso.intent.matcher.IntentMatchers.hasComponent;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import junit.framework.TestCase;
@RunWith(AndroidJUnit4.class)
public class MainActivityTest extends TestCase {

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);
    public void setUp() throws Exception {
        super.setUp();
    }
/*
    public void tearDown() throws Exception {
    }

    public void testOnCreate() {
    }*/

    //@Test
    public void testOnButtonClicked() {
        onView(withId(R.id.main_button)).perform(click());
        intended(hasComponent(ListItemsActivity.class.getName()));
    }
/*
    public void testOnStartChatClicked() {
    }*/
}