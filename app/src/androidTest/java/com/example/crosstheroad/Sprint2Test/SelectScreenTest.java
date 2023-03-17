package com.example.crosstheroad.Sprint2Test;


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
import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SelectScreenTest {

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
    public void noneTest() {
        ViewInteraction materialButton = onView(
                Matchers.allOf(ViewMatchers.withId(R.id.button_start), withText("Start"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.button_select), withText("Select"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        onView(withId(com.google.android.material.R.id.snackbar_text))
                .check(matches(withText("Check the character")));
    }

    @Test
    public void onlyCharacterSelectedTest() {
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

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.button_select), withText("Select"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        onView(withId(com.google.android.material.R.id.snackbar_text))
                .check(matches(withText("Check the difficulty")));
    }

    @Test
    public void onlyDifficultySelectedTest() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.button_start), withText("Start"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

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

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.button_select), withText("Select"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        onView(withId(com.google.android.material.R.id.snackbar_text))
                .check(matches(withText("Check the character")));
    }

    @Test
    public void emptyStringName() {
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

        ViewInteraction materialButton2 = onView(
                allOf(withId(R.id.button_select), withText("Select"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                0),
                        isDisplayed()));
        materialButton2.perform(click());

        onView(withId(com.google.android.material.R.id.snackbar_text))
                .check(matches(withText("Check the name")));
    }

    @Test
    public void spaceName() {
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
        appCompatEditText.perform(replaceText("    "), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.Name), withText("    "),
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

        onView(withId(com.google.android.material.R.id.snackbar_text))
                .check(matches(withText("Check the name")));
    }

    @Test
    public void characterWithValidName() {
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

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.Name),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        appCompatEditText.perform(replaceText("asdf"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.Name), withText("asdf"),
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

        onView(withId(com.google.android.material.R.id.snackbar_text))
                .check(matches(withText("Check the difficulty")));
    }

    @Test
    public void difficultyWithValidName() {
        ViewInteraction materialButton = onView(
                allOf(withId(R.id.button_start), withText("Start"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.nav_host_fragment_content_main),
                                        0),
                                1),
                        isDisplayed()));
        materialButton.perform(click());

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
        appCompatEditText.perform(replaceText("asdf"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.Name), withText("asdf"),
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

        onView(withId(com.google.android.material.R.id.snackbar_text))
                .check(matches(withText("Check the character")));
    }

    @Test
    public void validName() {
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
        appCompatEditText.perform(replaceText("asdf"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.Name), withText("asdf"),
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

        ViewInteraction viewGroup = onView(
                allOf(withParent(allOf(withId(R.id.nav_host_fragment_content_main),
                                withParent(IsInstanceOf.<View>instanceOf(android.view.ViewGroup.class)))),
                        isDisplayed()));
        viewGroup.check(matches(isDisplayed()));
    }
}
