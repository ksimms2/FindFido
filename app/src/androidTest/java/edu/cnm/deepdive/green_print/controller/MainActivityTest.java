package edu.cnm.deepdive.green_print.controller;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import android.support.test.espresso.contrib.DrawerActions;
import android.support.test.espresso.contrib.NavigationViewActions;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import edu.cnm.deepdive.green_print.R;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
@LargeTest
public class MainActivityTest {

  @Rule
  public ActivityTestRule<MainActivity> activityTestRule =
      new ActivityTestRule<>(MainActivity.class);

  @Test
  public void navigateToSurvey() {
    // click on navigation item to survey
    onView(withId(R.id.drawer_layout))
        .perform(DrawerActions.open());

    onView(withId(R.id.nav_view))
        .perform(NavigationViewActions.navigateTo(R.id.fragment_questions));


    onView(withId(R.id.survey_id))
        .check(matches(isDisplayed()));
//
//    onView(withId(R.id.survey_id))
//        .check(matches(isDisplayed()));
  }

}