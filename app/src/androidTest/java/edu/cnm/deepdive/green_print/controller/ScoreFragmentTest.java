package edu.cnm.deepdive.green_print.controller;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import edu.cnm.deepdive.green_print.R;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ScoreFragmentTest {

  @Rule
  public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(
      MainActivity.class);

  @Test
  public void scoreFragmentTest() {
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
            4),
            isDisplayed()));
    navigationMenuItemView.perform(click());

    ViewInteraction appCompatButton = onView(
        allOf(withId(R.id.retake_survey_button), withText("Retake Survey"),
            childAtPosition(
                childAtPosition(
                    withId(R.id.fragment_container),
                    1),
                4),
            isDisplayed()));
    appCompatButton.perform(click());

    pressBack();

    ViewInteraction appCompatImageButton2 = onView(
        allOf(withContentDescription("Open navigation drawer"),
            childAtPosition(
                allOf(withId(R.id.toolbar),
                    childAtPosition(
                        withClassName(is("android.support.design.widget.AppBarLayout")),
                        0)),
                1),
            isDisplayed()));
    appCompatImageButton2.perform(click());

    ViewInteraction navigationMenuItemView2 = onView(
        allOf(childAtPosition(
            allOf(withId(R.id.design_navigation_view),
                childAtPosition(
                    withId(R.id.nav_view),
                    0)),
            4),
            isDisplayed()));
    navigationMenuItemView2.perform(click());

    ViewInteraction appCompatButton2 = onView(
        allOf(withId(R.id.update_score_button), withText("Update Score"),
            childAtPosition(
                childAtPosition(
                    withId(R.id.fragment_container),
                    1),
                5),
            isDisplayed()));
    appCompatButton2.perform(click());

    ViewInteraction appCompatButton3 = onView(
        allOf(withId(R.id.apply_button), withText("Apply"),
            childAtPosition(
                childAtPosition(
                    withClassName(is("android.widget.ScrollView")),
                    0),
                16)));
    appCompatButton3.perform(scrollTo(), click());

    ViewInteraction appCompatButton4 = onView(
        allOf(withId(R.id.retake_survey_button), withText("Retake Survey"),
            childAtPosition(
                childAtPosition(
                    withId(R.id.fragment_container),
                    0),
                4),
            isDisplayed()));
    appCompatButton4.perform(click());

    ViewInteraction appCompatButton5 = onView(
        allOf(withId(R.id.submit_button), withText("Submit"),
            childAtPosition(
                childAtPosition(
                    withId(R.id.survey_id2),
                    0),
                42)));
    appCompatButton5.perform(scrollTo(), click());
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
