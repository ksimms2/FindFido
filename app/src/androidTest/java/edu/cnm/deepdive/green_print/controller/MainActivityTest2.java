package edu.cnm.deepdive.green_print.controller;


import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
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
public class MainActivityTest2 {

  @Rule
  public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(
      MainActivity.class);

  @Test
  public void mainActivityTest2() {
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

    ViewInteraction appCompatImageButton3 = onView(
        allOf(withContentDescription("Open navigation drawer"),
            childAtPosition(
                allOf(withId(R.id.toolbar),
                    childAtPosition(
                        withClassName(is("android.support.design.widget.AppBarLayout")),
                        0)),
                1),
            isDisplayed()));
    appCompatImageButton3.perform(click());

    ViewInteraction navigationMenuItemView3 = onView(
        allOf(childAtPosition(
            allOf(withId(R.id.design_navigation_view),
                childAtPosition(
                    withId(R.id.nav_view),
                    0)),
            5),
            isDisplayed()));
    navigationMenuItemView3.perform(click());

    ViewInteraction appCompatImageButton4 = onView(
        allOf(withContentDescription("Open navigation drawer"),
            childAtPosition(
                allOf(withId(R.id.toolbar),
                    childAtPosition(
                        withClassName(is("android.support.design.widget.AppBarLayout")),
                        0)),
                1),
            isDisplayed()));
    appCompatImageButton4.perform(click());

    ViewInteraction navigationMenuItemView4 = onView(
        allOf(childAtPosition(
            allOf(withId(R.id.design_navigation_view),
                childAtPosition(
                    withId(R.id.nav_view),
                    0)),
            2),
            isDisplayed()));
    navigationMenuItemView4.perform(click());
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
