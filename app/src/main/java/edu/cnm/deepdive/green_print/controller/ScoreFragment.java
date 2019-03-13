package edu.cnm.deepdive.green_print.controller;


import android.os.Bundle;
;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import edu.cnm.deepdive.green_print.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFragment extends LinkedFragment {

  //Button surveyButton = (Button) findViewId(R.id.retake_survey_button);

  private static final String TAG = "ScoreFragment";

  private Button surveyButton;
  private Button updateButton;

  public ScoreFragment() {
    // Required empty public constructor
  }


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment

      View view = inflater.inflate(R.layout.fragment_score, container, false);

      surveyButton = (Button) view.findViewById(R.id.retake_survey_button);
      updateButton = (Button) view.findViewById(R.id.update_score_button);

    surveyButton.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View v) {
        Toast.makeText(getActivity(), "Going to Survey", Toast.LENGTH_SHORT).show();
          SurveyFragment surveyFragment = new SurveyFragment();
       getFragmentManager().beginTransaction().replace(R.id.fragment_container, surveyFragment).commit();
      }
    });
    updateButton.setOnClickListener(new View.OnClickListener(){
      @Override
      public void onClick(View v) {
        Toast.makeText(getActivity(), "Going to Update Score", Toast.LENGTH_SHORT).show();
      // need to create the update fragment maybe... it might stay on Score
      }
    });


      return view;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {

  }



}