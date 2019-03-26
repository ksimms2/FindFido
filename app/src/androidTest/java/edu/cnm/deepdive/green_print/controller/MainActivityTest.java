package edu.cnm.deepdive.green_print.controller;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import edu.cnm.deepdive.green_print.R;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;


@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

  @Rule
  public ActivityTestRule<MainActivity> activityTestRule =
      new ActivityTestRule<>(MainActivity.class);

  @Test
  public void navigateToSurvey() {
    // click on navigation item to survey
    onView(withId(R.id.fragment_container))
        .perform(click());

    onView(withId(R.id.toolbar))
        .perform(click());
    onView(withId(R.id.drawer_layout))
        .perform(click());

    onView(withId(R.id.survey_id2))
        .perform(click());

    onView(withId(R.id.survey_id))
        .check(matches(isDisplayed()));
//
//    onView(withId(R.id.survey_id))
//        .check(matches(isDisplayed()));
  }

}