package com.example.crosstheroad.Sprint5Test;


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
public class FinishTest {

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
    public void HardFinishTest() {
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
                allOf(withId(R.id.button_hard), withText("HARD"),
                        childAtPosition(
                                allOf(withId(R.id.radioButton),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                8)),
                                2),
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

        SystemClock.sleep(10500);

        ViewInteraction appCompatImageView8 = onView(
                allOf(withId(R.id.left_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                25),
                        isDisplayed()));
        appCompatImageView8.perform(click());

        ViewInteraction appCompatImageView9 = onView(
                allOf(withId(R.id.up_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                22),
                        isDisplayed()));
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());

        SystemClock.sleep(5000);

        appCompatImageView9.perform(click());

        SystemClock.sleep(10000);


        ViewInteraction textView = onView(
                allOf(withId(R.id.lives_value), withText("2"),
                        withParent(allOf(withId(R.id.ConstraintLayout),
                                withParent(withId(R.id.nav_host_fragment_content_main)))),
                        isDisplayed()));
        textView.check(matches(withText("2")));
    }

    @Test
    public void HardFinishTest2() {
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
                allOf(withId(R.id.button_hard), withText("HARD"),
                        childAtPosition(
                                allOf(withId(R.id.radioButton),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                8)),
                                2),
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

        SystemClock.sleep(10500);

        ViewInteraction appCompatImageView8 = onView(
                allOf(withId(R.id.left_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                25),
                        isDisplayed()));
        appCompatImageView8.perform(click());

        ViewInteraction appCompatImageView9 = onView(
                allOf(withId(R.id.up_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                22),
                        isDisplayed()));
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());

        SystemClock.sleep(5000);

        appCompatImageView9.perform(click());

        SystemClock.sleep(3000);
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView8.perform(click());

        SystemClock.sleep(16000);

        appCompatImageView9.perform(click());

        ViewInteraction appCompatImageView10 = onView(
                allOf(withId(R.id.right_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                24),
                        isDisplayed()));
        appCompatImageView10.perform(click());
        appCompatImageView10.perform(click());
        appCompatImageView10.perform(click());


        SystemClock.sleep(15000);

        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());


        ViewInteraction textView = onView(
                allOf(withId(R.id.lives_value), withText("2"),
                        withParent(allOf(withId(R.id.ConstraintLayout),
                                withParent(withId(R.id.nav_host_fragment_content_main)))),
                        isDisplayed()));
        textView.check(matches(withText("2")));
    }

    @Test
    public void HardFinishTest3() {
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
                allOf(withId(R.id.button_hard), withText("HARD"),
                        childAtPosition(
                                allOf(withId(R.id.radioButton),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                8)),
                                2),
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

        SystemClock.sleep(10500);

        ViewInteraction appCompatImageView8 = onView(
                allOf(withId(R.id.left_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                25),
                        isDisplayed()));
        appCompatImageView8.perform(click());

        ViewInteraction appCompatImageView9 = onView(
                allOf(withId(R.id.up_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                22),
                        isDisplayed()));
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());

        SystemClock.sleep(5000);

        appCompatImageView9.perform(click());

        SystemClock.sleep(3000);
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView8.perform(click());

        SystemClock.sleep(16500);

        appCompatImageView9.perform(click());

        ViewInteraction appCompatImageView10 = onView(
                allOf(withId(R.id.right_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                24),
                        isDisplayed()));
        appCompatImageView10.perform(click());
        appCompatImageView10.perform(click());
        appCompatImageView10.perform(click());


        SystemClock.sleep(15000);

        appCompatImageView9.perform(click());

        SystemClock.sleep(1000);
        appCompatImageView9.perform(click());
        SystemClock.sleep(1000);

        ViewInteraction textView = onView(
                allOf(withId(R.id.score_value), withText("1180.0"),
                        withParent(allOf(withId(R.id.ConstraintLayout),
                                withParent(withId(R.id.nav_host_fragment_content_main)))),
                        isDisplayed()));
        textView.check(matches(withText("1180.0")));
    }

    @Test
    public void EasyFinishTest() {
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

        SystemClock.sleep(10500);

        ViewInteraction appCompatImageView8 = onView(
                allOf(withId(R.id.left_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                25),
                        isDisplayed()));
        appCompatImageView8.perform(click());

        ViewInteraction appCompatImageView9 = onView(
                allOf(withId(R.id.up_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                22),
                        isDisplayed()));
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());

        SystemClock.sleep(5000);

        appCompatImageView9.perform(click());

        SystemClock.sleep(10000);


        ViewInteraction textView = onView(
                allOf(withId(R.id.lives_value), withText("6"),
                        withParent(allOf(withId(R.id.ConstraintLayout),
                                withParent(withId(R.id.nav_host_fragment_content_main)))),
                        isDisplayed()));
        textView.check(matches(withText("6")));
    }

    @Test
    public void EasyFinishTest2() {
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

        SystemClock.sleep(10500);

        ViewInteraction appCompatImageView8 = onView(
                allOf(withId(R.id.left_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                25),
                        isDisplayed()));
        appCompatImageView8.perform(click());

        ViewInteraction appCompatImageView9 = onView(
                allOf(withId(R.id.up_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                22),
                        isDisplayed()));
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());

        SystemClock.sleep(5000);

        appCompatImageView9.perform(click());

        SystemClock.sleep(3000);
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView8.perform(click());

        SystemClock.sleep(16000);

        appCompatImageView9.perform(click());

        ViewInteraction appCompatImageView10 = onView(
                allOf(withId(R.id.right_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                24),
                        isDisplayed()));
        appCompatImageView10.perform(click());
        appCompatImageView10.perform(click());
        appCompatImageView10.perform(click());


        SystemClock.sleep(15000);

        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());


        ViewInteraction textView = onView(
                allOf(withId(R.id.lives_value), withText("6"),
                        withParent(allOf(withId(R.id.ConstraintLayout),
                                withParent(withId(R.id.nav_host_fragment_content_main)))),
                        isDisplayed()));
        textView.check(matches(withText("6")));
    }

    @Test
    public void EasyFinishTest3() {
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

        SystemClock.sleep(10500);

        ViewInteraction appCompatImageView8 = onView(
                allOf(withId(R.id.left_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                25),
                        isDisplayed()));
        appCompatImageView8.perform(click());

        ViewInteraction appCompatImageView9 = onView(
                allOf(withId(R.id.up_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                22),
                        isDisplayed()));
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());

        SystemClock.sleep(5000);

        appCompatImageView9.perform(click());

        SystemClock.sleep(3000);
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView8.perform(click());

        SystemClock.sleep(16000);

        appCompatImageView9.perform(click());

        ViewInteraction appCompatImageView10 = onView(
                allOf(withId(R.id.right_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                24),
                        isDisplayed()));
        appCompatImageView10.perform(click());
        appCompatImageView10.perform(click());
        appCompatImageView10.perform(click());


        SystemClock.sleep(15000);

        appCompatImageView9.perform(click());

        SystemClock.sleep(1000);
        appCompatImageView9.perform(click());
        SystemClock.sleep(1000);

        ViewInteraction textView = onView(
                allOf(withId(R.id.score_value), withText("1180.0"),
                        withParent(allOf(withId(R.id.ConstraintLayout),
                                withParent(withId(R.id.nav_host_fragment_content_main)))),
                        isDisplayed()));
        textView.check(matches(withText("1180.0")));
    }

    @Test
    public void NormalFinishTest() {
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
                allOf(withId(R.id.button_normal), withText("NORMAL"),
                        childAtPosition(
                                allOf(withId(R.id.radioButton),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                8)),
                                1),
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

        SystemClock.sleep(10500);

        ViewInteraction appCompatImageView8 = onView(
                allOf(withId(R.id.left_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                25),
                        isDisplayed()));
        appCompatImageView8.perform(click());

        ViewInteraction appCompatImageView9 = onView(
                allOf(withId(R.id.up_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                22),
                        isDisplayed()));
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());

        SystemClock.sleep(5000);

        appCompatImageView9.perform(click());

        SystemClock.sleep(10000);


        ViewInteraction textView = onView(
                allOf(withId(R.id.lives_value), withText("4"),
                        withParent(allOf(withId(R.id.ConstraintLayout),
                                withParent(withId(R.id.nav_host_fragment_content_main)))),
                        isDisplayed()));
        textView.check(matches(withText("4")));
    }

    @Test
    public void NormalFinishTest2() {
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
                allOf(withId(R.id.button_normal), withText("NORMAL"),
                        childAtPosition(
                                allOf(withId(R.id.radioButton),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                8)),
                                1),
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

        SystemClock.sleep(10500);

        ViewInteraction appCompatImageView8 = onView(
                allOf(withId(R.id.left_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                25),
                        isDisplayed()));
        appCompatImageView8.perform(click());

        ViewInteraction appCompatImageView9 = onView(
                allOf(withId(R.id.up_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                22),
                        isDisplayed()));
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());

        SystemClock.sleep(5000);

        appCompatImageView9.perform(click());

        SystemClock.sleep(3000);
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView8.perform(click());

        SystemClock.sleep(16000);

        appCompatImageView9.perform(click());

        ViewInteraction appCompatImageView10 = onView(
                allOf(withId(R.id.right_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                24),
                        isDisplayed()));
        appCompatImageView10.perform(click());
        appCompatImageView10.perform(click());
        appCompatImageView10.perform(click());


        SystemClock.sleep(15000);

        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());


        ViewInteraction textView = onView(
                allOf(withId(R.id.lives_value), withText("4"),
                        withParent(allOf(withId(R.id.ConstraintLayout),
                                withParent(withId(R.id.nav_host_fragment_content_main)))),
                        isDisplayed()));
        textView.check(matches(withText("4")));
    }

    @Test
    public void NormalFinishTest3() {
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
                allOf(withId(R.id.button_normal), withText("NORMAL"),
                        childAtPosition(
                                allOf(withId(R.id.radioButton),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                8)),
                                1),
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

        SystemClock.sleep(10500);

        ViewInteraction appCompatImageView8 = onView(
                allOf(withId(R.id.left_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                25),
                        isDisplayed()));
        appCompatImageView8.perform(click());

        ViewInteraction appCompatImageView9 = onView(
                allOf(withId(R.id.up_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                22),
                        isDisplayed()));
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());

        SystemClock.sleep(5000);

        appCompatImageView9.perform(click());

        SystemClock.sleep(3000);
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView8.perform(click());

        SystemClock.sleep(16000);

        appCompatImageView9.perform(click());

        ViewInteraction appCompatImageView10 = onView(
                allOf(withId(R.id.right_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                24),
                        isDisplayed()));
        appCompatImageView10.perform(click());
        appCompatImageView10.perform(click());
        appCompatImageView10.perform(click());


        SystemClock.sleep(15000);

        appCompatImageView9.perform(click());

        SystemClock.sleep(1000);
        appCompatImageView9.perform(click());
        SystemClock.sleep(1000);

        ViewInteraction textView = onView(
                allOf(withId(R.id.score_value), withText("1180.0"),
                        withParent(allOf(withId(R.id.ConstraintLayout),
                                withParent(withId(R.id.nav_host_fragment_content_main)))),
                        isDisplayed()));
        textView.check(matches(withText("1180.0")));
    }

    @Test
    public void EasyFinishTest4() {
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

        SystemClock.sleep(10500);

        ViewInteraction appCompatImageView8 = onView(
                allOf(withId(R.id.left_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                25),
                        isDisplayed()));
        appCompatImageView8.perform(click());

        ViewInteraction appCompatImageView9 = onView(
                allOf(withId(R.id.up_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                22),
                        isDisplayed()));
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());

        SystemClock.sleep(5000);

        appCompatImageView9.perform(click());

        SystemClock.sleep(3000);
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView8.perform(click());

        SystemClock.sleep(16000);

        appCompatImageView9.perform(click());

        ViewInteraction appCompatImageView10 = onView(
                allOf(withId(R.id.right_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                24),
                        isDisplayed()));
        appCompatImageView10.perform(click());
        appCompatImageView10.perform(click());
        appCompatImageView10.perform(click());


        SystemClock.sleep(15000);

        appCompatImageView9.perform(click());

        SystemClock.sleep(1000);
        appCompatImageView9.perform(click());
        SystemClock.sleep(1000);

        ViewInteraction textView = onView(
                allOf(withId(R.id.lives_value), withText("7"),
                        withParent(allOf(withId(R.id.ConstraintLayout),
                                withParent(withId(R.id.nav_host_fragment_content_main)))),
                        isDisplayed()));
        textView.check(matches(withText("7")));
    }

    @Test
    public void HardFinishTest4() {
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
                allOf(withId(R.id.button_hard), withText("HARD"),
                        childAtPosition(
                                allOf(withId(R.id.radioButton),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                8)),
                                2),
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

        SystemClock.sleep(10500);

        ViewInteraction appCompatImageView8 = onView(
                allOf(withId(R.id.left_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                25),
                        isDisplayed()));
        appCompatImageView8.perform(click());

        ViewInteraction appCompatImageView9 = onView(
                allOf(withId(R.id.up_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                22),
                        isDisplayed()));
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());

        SystemClock.sleep(5000);

        appCompatImageView9.perform(click());

        SystemClock.sleep(3000);
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView8.perform(click());

        SystemClock.sleep(17000);

        appCompatImageView9.perform(click());

        ViewInteraction appCompatImageView10 = onView(
                allOf(withId(R.id.right_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                24),
                        isDisplayed()));
        appCompatImageView10.perform(click());
        appCompatImageView10.perform(click());
        appCompatImageView10.perform(click());


        SystemClock.sleep(14500);

        appCompatImageView9.perform(click());

        SystemClock.sleep(1000);
        appCompatImageView9.perform(click());
        SystemClock.sleep(1000);

        ViewInteraction textView = onView(
                allOf(withId(R.id.lives_value), withText("3"),
                        withParent(allOf(withId(R.id.ConstraintLayout),
                                withParent(withId(R.id.nav_host_fragment_content_main)))),
                        isDisplayed()));
        textView.check(matches(withText("3")));
    }

    @Test
    public void NormalFinishTest4() {
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
                allOf(withId(R.id.button_normal), withText("NORMAL"),
                        childAtPosition(
                                allOf(withId(R.id.radioButton),
                                        childAtPosition(
                                                withClassName(is("androidx.constraintlayout.widget.ConstraintLayout")),
                                                8)),
                                1),
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

        SystemClock.sleep(10500);

        ViewInteraction appCompatImageView8 = onView(
                allOf(withId(R.id.left_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                25),
                        isDisplayed()));
        appCompatImageView8.perform(click());

        ViewInteraction appCompatImageView9 = onView(
                allOf(withId(R.id.up_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                22),
                        isDisplayed()));
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());

        SystemClock.sleep(5000);

        appCompatImageView9.perform(click());

        SystemClock.sleep(3000);
        appCompatImageView9.perform(click());
        appCompatImageView9.perform(click());
        appCompatImageView8.perform(click());

        SystemClock.sleep(16000);

        appCompatImageView9.perform(click());

        ViewInteraction appCompatImageView10 = onView(
                allOf(withId(R.id.right_arrow),
                        childAtPosition(
                                allOf(withId(R.id.ConstraintLayout),
                                        childAtPosition(
                                                withId(R.id.nav_host_fragment_content_main),
                                                0)),
                                24),
                        isDisplayed()));
        appCompatImageView10.perform(click());
        appCompatImageView10.perform(click());
        appCompatImageView10.perform(click());


        SystemClock.sleep(15000);

        appCompatImageView9.perform(click());

        SystemClock.sleep(1000);
        appCompatImageView9.perform(click());
        SystemClock.sleep(1000);

        ViewInteraction textView = onView(
                allOf(withId(R.id.lives_value), withText("5"),
                        withParent(allOf(withId(R.id.ConstraintLayout),
                                withParent(withId(R.id.nav_host_fragment_content_main)))),
                        isDisplayed()));
        textView.check(matches(withText("5")));
    }
}
