package edu.cnm.deepdive.green_print.controller;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import edu.cnm.deepdive.green_print.R;
import edu.cnm.deepdive.green_print.model.entity.Consumption;
import edu.cnm.deepdive.green_print.service.ConsumptionDBService.SelectConsumptionTask;


/**
 * <code>ScoreFragment</code> displays the user carbon footprint score. Allows user to click one
 * of two buttons to either take them to {@link SurveyFragment} or {@link UpdateFragment}.
 * If the retake survey button is clicked, users previous answers to the survey are cleared and user
 * is allowed to retake the survey. If the update button is clicked, the user is moved to
 * {@link UpdateFragment} where the user can choose tasks to complete that allow the user to lower
 * their overall carbon footprint.
 *
 * @author Kevin Simms &amp; Deep Dive Coding Java + Android Bootcamp cohort 6
 * @version 1.0
 */


public class ScoreFragment extends Fragment {



  private Button surveyButton;
  private Button updateButton;
  private EditText scoreToText;
  public ScoreFragment() {
    // Required empty public constructor
  }


  /**
   * <code>OnCreateView</code> launches the UI for the home screen. Calls on the
   * <code>R.layout.fragment_score</code>, which presents the .xml UI design.
   * Inflates either {@link SurveyFragment} or {@link UpdateFragment} on the click of the
   * corresponding button. Inflates ScoreFragment's UI.
   *
   * @param inflater loads UI
   * @param container uses the set container for the group
   * @param savedInstanceState Saves the instance created
   * @return displays the UI on the screen
   *
   */


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment

    View view = inflater.inflate(R.layout.fragment_score, container, false);

    surveyButton = view.findViewById(R.id.retake_survey_button);
    updateButton = view.findViewById(R.id.update_score_button);
    scoreToText = view.findViewById(R.id.scoreBox);


    surveyButton.setOnClickListener(v -> {
      Toast.makeText(getActivity(), "Going to Survey", Toast.LENGTH_SHORT).show();
      SurveyFragment surveyFragment = new SurveyFragment();
      getFragmentManager().beginTransaction().replace(R.id.fragment_container, surveyFragment)
          .commit();
    });
    updateButton.setOnClickListener(v -> {
      Toast.makeText(getActivity(), "Going to Update Score", Toast.LENGTH_SHORT).show();
      UpdateFragment updateFragment = new UpdateFragment();
      getFragmentManager().beginTransaction().replace(R.id.fragment_container, updateFragment)
          .commit();

    });

    return view;
  }

  public void setScore(Consumption consumption) {

    // TODO apply score to score box

  }

  // History fragment lines 94-100, apoddbservice 88-94, using findLast in dao, invoke loadscore
  // when you want update the score, setscore

  public void loadScore() {

    new SelectConsumptionTask()
        .setTransformer((consumption) -> {
          //TODO Insert Access object
          return consumption.;
        })
        .setSuccessListener(this::setScore)
        .setFailureListener((nullConsumption) -> {
          // TODO some stuff
        })
        .execute();
  }
// TODO remove
//  private MainActivity getNavActivity() {
//    return (MainActivity) getActivity();
//
//  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

  }



}