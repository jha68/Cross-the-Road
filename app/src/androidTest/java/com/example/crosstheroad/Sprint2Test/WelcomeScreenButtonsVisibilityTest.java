package com.example.crosstheroad.Sprint2Test;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.crosstheroad.MainActivity;
import com.example.crosstheroad.R;

import org.hamcrest.Matchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class WelcomeScreenButtonsVisibilityTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void welcomeScreenButtonsVisibilityTest() {
        ViewInteraction button = onView(
                Matchers.allOf(ViewMatchers.withId(R.id.button_start), withText("START"),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))),
                        isDisplayed()));
        button.check(matches(isDisplayed()));

        ViewInteraction textView = onView(
                allOf(withId(R.id.textview_welcome), withText("Welcome"),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))),
                        isDisplayed()));
        textView.check(matches(isDisplayed()));

        ViewInteraction textView2 = onView(
                allOf(withId(R.id.textView), withText("Press Start to Start the Game"),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))),
                        isDisplayed()));
        textView2.check(matches(isDisplayed()));
    }
}
