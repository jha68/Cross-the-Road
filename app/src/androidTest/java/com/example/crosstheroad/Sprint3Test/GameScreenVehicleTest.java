package com.example.crosstheroad.Sprint3Test;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.pressImeActionButton;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.os.SystemClock;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.example.crosstheroad.MainActivity;
import com.example.crosstheroad.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class GameScreenVehicleTest {

    @Rule
    public ActivityScenarioRule<MainActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(MainActivity.class);

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }

    @Test
    public void gameScreenVehicle1Test() {
        ViewInteraction materialButton = onView(
                Matchers.allOf(ViewMatchers.withId(R.id.button_start), withText("Start"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.blue_frog), withContentDescription("TODO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                5),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction materialRadioButton = onView(
                allOf(withId(R.id.button_easy), withText("EASY"),
                        childAtPosition(
                                allOf(withId(R.id.radioButton),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                8)),
                                0),
                        isDisplayed()));
        materialRadioButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.Name),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("asf"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.Name), withText("asf"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(pressImeActionButton());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.button_select), withText("Select"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction imageView = onView(
                allOf(withId(R.id.car1),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));

        ViewInteraction imageView2 = onView(
                allOf(withId(R.id.car1_1),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))),
                        isDisplayed()));
        imageView2.check(matches(isDisplayed()));
    }

    @Test
    public void gameScreenVehicle2Test() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.button_start), withText("Start"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.blue_frog), withContentDescription("TODO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                5),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction materialRadioButton = onView(
                allOf(withId(R.id.button_easy), withText("EASY"),
                        childAtPosition(
                                allOf(withId(R.id.radioButton),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                8)),
                                0),
                        isDisplayed()));
        materialRadioButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.Name),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("asf"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.Name), withText("asf"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(pressImeActionButton());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.button_select), withText("Select"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction imageView1 = onView(
                allOf(withId(R.id.car2),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))),
                        isDisplayed()));
        imageView1.check(matches(isDisplayed()));

        ViewInteraction imageView2 = onView(
                allOf(withId(R.id.car2_1),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))),
                        isDisplayed()));
        imageView2.check(matches(isDisplayed()));
    }

    @Test
    public void gameScreenVehicle3Test() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.button_start), withText("Start"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.blue_frog), withContentDescription("TODO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                5),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction materialRadioButton = onView(
                allOf(withId(R.id.button_easy), withText("EASY"),
                        childAtPosition(
                                allOf(withId(R.id.radioButton),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                8)),
                                0),
                        isDisplayed()));
        materialRadioButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.Name),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("asf"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.Name), withText("asf"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(pressImeActionButton());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.button_select), withText("Select"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction imageView1 = onView(
                allOf(withId(R.id.car3),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))),
                        isDisplayed()));
        imageView1.check(matches(isDisplayed()));

        ViewInteraction imageView2 = onView(
                allOf(withId(R.id.car3_1),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))),
                        isDisplayed()));
        imageView2.check(matches(isDisplayed()));

        ViewInteraction imageView3 = onView(
                allOf(withId(R.id.car3_2),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))),
                        isDisplayed()));
        imageView3.check(matches(isDisplayed()));
    }

    @Test
    public void gameScreenVehicle4Test() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.button_start), withText("Start"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.blue_frog), withContentDescription("TODO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                5),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction materialRadioButton = onView(
                allOf(withId(R.id.button_easy), withText("EASY"),
                        childAtPosition(
                                allOf(withId(R.id.radioButton),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                8)),
                                0),
                        isDisplayed()));
        materialRadioButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.Name),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("asf"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.Name), withText("asf"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(pressImeActionButton());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.button_select), withText("Select"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction imageView1 = onView(
                allOf(withId(R.id.car4),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))),
                        isDisplayed()));
        imageView1.check(matches(isDisplayed()));

        ViewInteraction imageView2 = onView(
                allOf(withId(R.id.car4_1),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))),
                        isDisplayed()));
        imageView2.check(matches(isDisplayed()));
    }

    @Test
    public void gameScreenVehicle5Test() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.button_start), withText("Start"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.blue_frog), withContentDescription("TODO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                5),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction materialRadioButton = onView(
                allOf(withId(R.id.button_easy), withText("EASY"),
                        childAtPosition(
                                allOf(withId(R.id.radioButton),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                8)),
                                0),
                        isDisplayed()));
        materialRadioButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.Name),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("asf"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.Name), withText("asf"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(pressImeActionButton());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.button_select), withText("Select"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction imageView1 = onView(
                allOf(withId(R.id.car5),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))),
                        isDisplayed()));
        imageView1.check(matches(isDisplayed()));

        ViewInteraction imageView2 = onView(
                allOf(withId(R.id.car5_1),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))),
                        isDisplayed()));
        imageView2.check(matches(isDisplayed()));
    }

    @Test
    public void gameScreenVehicle1MovementTest() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.button_start), withText("Start"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.blue_frog), withContentDescription("TODO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                5),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction materialRadioButton = onView(
                allOf(withId(R.id.button_easy), withText("EASY"),
                        childAtPosition(
                                allOf(withId(R.id.radioButton),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                8)),
                                0),
                        isDisplayed()));
        materialRadioButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.Name),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("asf"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.Name), withText("asf"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(pressImeActionButton());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.button_select), withText("Select"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction imageView = onView(
                allOf(withId(R.id.car1),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))),
                        isDisplayed()));
        SystemClock.sleep(5000);
        imageView.check(matches(isDisplayed()));
    }

    @Test
    public void gameScreenVehicle2MovementTest() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.button_start), withText("Start"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.blue_frog), withContentDescription("TODO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                5),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction materialRadioButton = onView(
                allOf(withId(R.id.button_easy), withText("EASY"),
                        childAtPosition(
                                allOf(withId(R.id.radioButton),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                8)),
                                0),
                        isDisplayed()));
        materialRadioButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.Name),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("asf"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.Name), withText("asf"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(pressImeActionButton());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.button_select), withText("Select"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction imageView = onView(
                allOf(withId(R.id.car2),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))),
                        isDisplayed()));
        SystemClock.sleep(5000);
        imageView.check(matches(isDisplayed()));
    }

    @Test
    public void gameScreenVehicle3MovementTest() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.button_start), withText("Start"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.blue_frog), withContentDescription("TODO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                5),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction materialRadioButton = onView(
                allOf(withId(R.id.button_easy), withText("EASY"),
                        childAtPosition(
                                allOf(withId(R.id.radioButton),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                8)),
                                0),
                        isDisplayed()));
        materialRadioButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.Name),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("asf"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.Name), withText("asf"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(pressImeActionButton());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.button_select), withText("Select"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction imageView = onView(
                allOf(withId(R.id.car3),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))),
                        isDisplayed()));
        SystemClock.sleep(5000);
        imageView.check(matches(isDisplayed()));
    }

    @Test
    public void gameScreenVehicle4MovementTest() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.button_start), withText("Start"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.blue_frog), withContentDescription("TODO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                5),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction materialRadioButton = onView(
                allOf(withId(R.id.button_easy), withText("EASY"),
                        childAtPosition(
                                allOf(withId(R.id.radioButton),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                8)),
                                0),
                        isDisplayed()));
        materialRadioButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.Name),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("asf"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.Name), withText("asf"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(pressImeActionButton());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.button_select), withText("Select"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction imageView = onView(
                allOf(withId(R.id.car4),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))),
                        isDisplayed()));
        SystemClock.sleep(5000);
        imageView.check(matches(isDisplayed()));
    }

    @Test
    public void gameScreenVehicle5MovementTest() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.button_start), withText("Start"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.blue_frog), withContentDescription("TODO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                5),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction materialRadioButton = onView(
                allOf(withId(R.id.button_easy), withText("EASY"),
                        childAtPosition(
                                allOf(withId(R.id.radioButton),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                8)),
                                0),
                        isDisplayed()));
        materialRadioButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.Name),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("asf"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.Name), withText("asf"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(pressImeActionButton());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.button_select), withText("Select"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction imageView = onView(
                allOf(withId(R.id.car5),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))),
                        isDisplayed()));
        SystemClock.sleep(5000);
        imageView.check(matches(isDisplayed()));
    }

    @Test
    public void gameScreenVehicle1ElementTest() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.button_start), withText("Start"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.blue_frog), withContentDescription("TODO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                5),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction materialRadioButton = onView(
                allOf(withId(R.id.button_easy), withText("EASY"),
                        childAtPosition(
                                allOf(withId(R.id.radioButton),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                8)),
                                0),
                        isDisplayed()));
        materialRadioButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.Name),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("asf"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.Name), withText("asf"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(pressImeActionButton());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.button_select), withText("Select"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction imageView1 = onView(
                allOf(withId(R.id.car1),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))),
                        isDisplayed()));
        imageView1.check((matches(withId(R.id.car1))));

        ViewInteraction imageView2 = onView(
                allOf(withId(R.id.car1_1),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))),
                        isDisplayed()));
        imageView2.check((matches(withId(R.id.car1_1))));
    }

    @Test
    public void gameScreenVehicle2ElementTest() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.button_start), withText("Start"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.blue_frog), withContentDescription("TODO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                5),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction materialRadioButton = onView(
                allOf(withId(R.id.button_easy), withText("EASY"),
                        childAtPosition(
                                allOf(withId(R.id.radioButton),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                8)),
                                0),
                        isDisplayed()));
        materialRadioButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.Name),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("asf"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.Name), withText("asf"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(pressImeActionButton());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.button_select), withText("Select"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction imageView1 = onView(
                allOf(withId(R.id.car2),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))),
                        isDisplayed()));
        imageView1.check((matches(withId(R.id.car2))));

        ViewInteraction imageView2 = onView(
                allOf(withId(R.id.car2_1),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))),
                        isDisplayed()));
        imageView2.check((matches(withId(R.id.car2_1))));
    }

    @Test
    public void gameScreenVehicle3ElementTest() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.button_start), withText("Start"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.blue_frog), withContentDescription("TODO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                5),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction materialRadioButton = onView(
                allOf(withId(R.id.button_easy), withText("EASY"),
                        childAtPosition(
                                allOf(withId(R.id.radioButton),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                8)),
                                0),
                        isDisplayed()));
        materialRadioButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.Name),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("asf"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.Name), withText("asf"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(pressImeActionButton());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.button_select), withText("Select"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction imageView1 = onView(
                allOf(withId(R.id.car3),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))),
                        isDisplayed()));
        imageView1.check((matches(withId(R.id.car3))));

        ViewInteraction imageView2 = onView(
                allOf(withId(R.id.car3_1),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))),
                        isDisplayed()));
        imageView2.check((matches(withId(R.id.car3_1))));

        ViewInteraction imageView3 = onView(
                allOf(withId(R.id.car3_2),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))),
                        isDisplayed()));
        imageView3.check((matches(withId(R.id.car3_2))));
    }

    @Test
    public void gameScreenVehicle4ElementTest() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.button_start), withText("Start"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.blue_frog), withContentDescription("TODO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                5),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction materialRadioButton = onView(
                allOf(withId(R.id.button_easy), withText("EASY"),
                        childAtPosition(
                                allOf(withId(R.id.radioButton),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                8)),
                                0),
                        isDisplayed()));
        materialRadioButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.Name),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("asf"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.Name), withText("asf"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(pressImeActionButton());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.button_select), withText("Select"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction imageView1 = onView(
                allOf(withId(R.id.car4),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))),
                        isDisplayed()));
        imageView1.check((matches(withId(R.id.car4))));

        ViewInteraction imageView2 = onView(
                allOf(withId(R.id.car4_1),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))),
                        isDisplayed()));
        imageView2.check((matches(withId(R.id.car4_1))));
    }

    @Test
    public void gameScreenVehicle5ElementTest() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.button_start), withText("Start"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction appCompatImageButton = onView(
                allOf(withId(R.id.blue_frog), withContentDescription("TODO"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                5),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction materialRadioButton = onView(
                allOf(withId(R.id.button_easy), withText("EASY"),
                        childAtPosition(
                                allOf(withId(R.id.radioButton),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                8)),
                                0),
                        isDisplayed()));
        materialRadioButton.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.Name),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("asf"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.Name), withText("asf"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText2.perform(pressImeActionButton());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.button_select), withText("Select"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        ViewInteraction imageView1 = onView(
                allOf(withId(R.id.car5),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))),
                        isDisplayed()));
        imageView1.check((matches(withId(R.id.car5))));

        ViewInteraction imageView2 = onView(
                allOf(withId(R.id.car5_1),
                        withParent(withParent(withId(R.id.nav_host_fragment_content_main))),
                        isDisplayed()));
        imageView2.check((matches(withId(R.id.car5_1))));
    }
}
