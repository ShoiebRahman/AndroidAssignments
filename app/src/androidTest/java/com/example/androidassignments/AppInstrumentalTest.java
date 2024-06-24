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

@RunWith(AndroidJUnit4.class)
public class AppInstrumentalTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule<>(MainActivity.class);

    private MainActivity activity;
    private TextView textView;
    private Button button;
    private Button startChat;

    @Before
    public void setUp() {
        activity = activityRule.getActivity();
        textView = activity.findViewById(R.id.textView);
        button = activity.findViewById(R.id.main_button);
        startChat = activity.findViewById(R.id.start_chat);
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();
        assertEquals("com.example.androidassignments", appContext.getPackageName());
    }

    @Test
    public void loginActivityTest() throws InterruptedException {
        ActivityScenario<LoginActivity> scenario = ActivityScenario.launch(LoginActivity.class);
        scenario.onActivity(activity -> {
            EditText passwd = activity.findViewById(R.id.edit_pass);
            assertThat(activity, notNullValue());
            passwd.setText("abc123");
        });
        onView(withId(R.id.login_button)).perform(click());
        Thread.sleep(2000);
    }

    @Test
    public void mainActivityTest() throws InterruptedException {
        ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.main_button)).perform(click());
        int cnt=0;
        Thread.sleep(10000);
        while(cnt!=2) {
            onView(withId(R.id.switch2)).check(matches(isDisplayed())).perform(click());
            Thread.sleep(6000);
            cnt++;
        }
    }

    @Test
    public void chatWindowTest() throws InterruptedException {
        ActivityScenario<MainActivity> scenario = ActivityScenario.launch(MainActivity.class);
        onView(withId(R.id.start_chat)).perform(click());
        onView(withId(R.id.chat_input_edit_text)).perform(typeText("Chat Text 1"), closeSoftKeyboard());
        Thread.sleep(2000);
        onView(withId(R.id.send_button)).perform(click());
        Thread.sleep(5000);
        onView(withId(R.id.chat_input_edit_text)).perform(typeText("Chat Text 2"), closeSoftKeyboard());
        Thread.sleep(2000);
        onView(withId(R.id.send_button)).perform(click());
        Thread.sleep(5000);
    }

    /*@Test
    public void testInitialTextViewState() {
        // Check that the text view has the initial text "Initial Text"
        assertNotNull(textView);
        //assertEquals("Initial Text", textView.getText().toString());
    }*/

    //@Test
    /*public void testButtonClick() throws InterruptedException {
        // Simulate button click

        // Perform a click on the button with ID button
        onView(withId(R.id.main_button)).perform(click());

        Thread.sleep(5000);
        // Verify that an intent was sent to launch NewActivity
        intended(hasComponent(ListItemsActivity.class.getName()));
        activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //button.performClick();
            }
        });

        // Give some time for the UI to update
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Check that the text view has the text "Hello World!"
        assertNotNull(textView);
        //assertEquals("Hello World!", textView.getText().toString());
    }*/
}
