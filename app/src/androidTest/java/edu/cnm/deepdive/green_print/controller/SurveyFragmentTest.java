package edu.cnm.deepdive.green_print.controller;


import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import edu.cnm.deepdive.green_print.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class SurveyFragmentTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void surveyFragmentTest() {
        ViewInteraction appCompatImageButton = onView(
                allOf(withContentDescription("Open navigation drawer"),
                        childAtPosition(
                                allOf(withId(R.id.toolbar),
                                        childAtPosition(
                                                withClassName(is("android.support.design.widget.AppBarLayout")),
                                                0)),
                                1),
                        isDisplayed()));
        appCompatImageButton.perform(click());

        ViewInteraction navigationMenuItemView = onView(
                allOf(childAtPosition(
                        allOf(withId(R.id.design_navigation_view),
                                childAtPosition(
                                        withId(R.id.nav_view),
                                        0)),
                        3),
                        isDisplayed()));
        navigationMenuItemView.perform(click());

        ViewInteraction appCompatEditText = onView(
                allOf(withId(R.id.answer_1_id),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.survey_id2),
                                        0),
                                3)));
        appCompatEditText.perform(scrollTo(), replaceText("87107"), closeSoftKeyboard());

        ViewInteraction appCompatEditText2 = onView(
                allOf(withId(R.id.answer_2_id),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.survey_id2),
                                        0),
                                5)));
        appCompatEditText2.perform(scrollTo(), replaceText("3"), closeSoftKeyboard());

        ViewInteraction appCompatEditText3 = onView(
                allOf(withId(R.id.answer_3_id),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.survey_id2),
                                        0),
                                7)));
        appCompatEditText3.perform(scrollTo(), replaceText("2"), closeSoftKeyboard());

        ViewInteraction appCompatEditText4 = onView(
                allOf(withId(R.id.answer_4_id),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.survey_id2),
                                        0),
                                9)));
        appCompatEditText4.perform(scrollTo(), replaceText("1"), closeSoftKeyboard());

        ViewInteraction appCompatEditText5 = onView(
                allOf(withId(R.id.answer_5_id),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.survey_id2),
                                        0),
                                11)));
        appCompatEditText5.perform(scrollTo(), replaceText("150000"), closeSoftKeyboard());

        ViewInteraction appCompatEditText6 = onView(
                allOf(withId(R.id.answer_6_id),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.survey_id2),
                                        0),
                                13)));
        appCompatEditText6.perform(scrollTo(), replaceText("1300"), closeSoftKeyboard());

        ViewInteraction appCompatEditText7 = onView(
                allOf(withId(R.id.answer_7_id),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.survey_id2),
                                        0),
                                15)));
        appCompatEditText7.perform(scrollTo(), replaceText("800"), closeSoftKeyboard());

        ViewInteraction appCompatEditText8 = onView(
                allOf(withId(R.id.answer_8_id),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.survey_id2),
                                        0),
                                17)));
        appCompatEditText8.perform(scrollTo(), replaceText("700"), closeSoftKeyboard());

        ViewInteraction appCompatEditText9 = onView(
                allOf(withId(R.id.answer_9_id),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.survey_id2),
                                        0),
                                19)));
        appCompatEditText9.perform(scrollTo(), replaceText("0"), closeSoftKeyboard());

        ViewInteraction appCompatEditText10 = onView(
                allOf(withId(R.id.answer_10_id),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.survey_id2),
                                        0),
                                21)));
        appCompatEditText10.perform(scrollTo(), replaceText("1000"), closeSoftKeyboard());

        ViewInteraction appCompatEditText11 = onView(
                allOf(withId(R.id.answer_11_id),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.survey_id2),
                                        0),
                                23)));
        appCompatEditText11.perform(scrollTo(), replaceText("90"), closeSoftKeyboard());

        ViewInteraction appCompatEditText12 = onView(
                allOf(withId(R.id.answer_12_id),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.survey_id2),
                                        0),
                                25)));
        appCompatEditText12.perform(scrollTo(), replaceText("120"), closeSoftKeyboard());

        ViewInteraction appCompatEditText13 = onView(
                allOf(withId(R.id.answer_13_id),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.survey_id2),
                                        0),
                                27)));
        appCompatEditText13.perform(scrollTo(), click());

        ViewInteraction appCompatEditText14 = onView(
                allOf(withId(R.id.answer_13_id),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.survey_id2),
                                        0),
                                27)));
        appCompatEditText14.perform(scrollTo(), replaceText("18000"), closeSoftKeyboard());

        ViewInteraction appCompatEditText15 = onView(
                allOf(withId(R.id.answer_14_id),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.survey_id2),
                                        0),
                                29)));
        appCompatEditText15.perform(scrollTo(), replaceText("32"), closeSoftKeyboard());

        ViewInteraction appCompatEditText16 = onView(
                allOf(withId(R.id.answer_15_id),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.survey_id2),
                                        0),
                                31)));
        appCompatEditText16.perform(scrollTo(), replaceText("12000"), closeSoftKeyboard());

        ViewInteraction appCompatEditText17 = onView(
                allOf(withId(R.id.answer_16_id),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.survey_id2),
                                        0),
                                33)));
        appCompatEditText17.perform(scrollTo(), replaceText("25"), closeSoftKeyboard());

        ViewInteraction appCompatEditText18 = onView(
                allOf(withId(R.id.answer_17_id),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.survey_id2),
                                        0),
                                35)));
        appCompatEditText18.perform(scrollTo(), replaceText("0"), closeSoftKeyboard());

        ViewInteraction appCompatEditText19 = onView(
                allOf(withId(R.id.answer_18_id),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.survey_id2),
                                        0),
                                37)));
        appCompatEditText19.perform(scrollTo(), replaceText("0"), closeSoftKeyboard());

        ViewInteraction appCompatEditText20 = onView(
                allOf(withId(R.id.answer_19_id),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.survey_id2),
                                        0),
                                39)));
        appCompatEditText20.perform(scrollTo(), replaceText("5000"), closeSoftKeyboard());

        ViewInteraction appCompatEditText21 = onView(
                allOf(withId(R.id.answer_20_id),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.survey_id2),
                                        0),
                                41)));
        appCompatEditText21.perform(scrollTo(), replaceText("500"), closeSoftKeyboard());

        pressBack();

        ViewInteraction appCompatButton = onView(
                allOf(withId(R.id.submit_button), withText("Submit"),
                        childAtPosition(
                                childAtPosition(
                                        withId(R.id.survey_id2),
                                        0),
                                42)));
        appCompatButton.perform(scrollTo(), click());
    }

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
}
