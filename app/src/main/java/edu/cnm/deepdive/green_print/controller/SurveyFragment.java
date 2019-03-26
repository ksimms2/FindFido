package edu.cnm.deepdive.green_print.controller;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import edu.cnm.deepdive.green_print.R;
import edu.cnm.deepdive.green_print.model.ConsumptionDB;
import edu.cnm.deepdive.green_print.model.entity.Consumption;
import edu.cnm.deepdive.green_print.service.CC_APIWebService.GetCCAPITask;
import java.util.Map;


/**
 * <code>SurveyFragment</code> implements user input to API when submit button is clicked.
 * Saves user inputs in shared preferences. Submit button also implements saving grand total (score)
 * in local database and displays score on {@link ScoreFragment}.
 *
 * @author Kevin Simms &amp; Deep Dive Coding Java + Android Bootcamp cohort 6
 * @version 1.0
 */

public class SurveyFragment extends LinkedFragment {


  private Button submitButton;
  public static final String MY_PREFERENCES = "MyPrefs";
  SharedPreferences sharedPreferences;

  public SurveyFragment() {
    // Required empty public constructor
  }

  /**
   * <code>OnCreateView</code> launches the UI for the home screen. Calls on the
   * <code>R.layout.fragment_survey</code>, which presents the .xml UI design.
   * Implements API using input from survey. Saves survey answers in shared preferences. Displays
   * the score into the ScoreFragment.
   *
   * @param inflater loads UI
   * @param container uses the set container for the group
   * @param savedInstanceState Saves the instance created
   * @return displays the UI on the screen
   */


  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_survey, container, false);

    EditText answer1Id = view.findViewById(R.id.answer_1_id);
    EditText answer2Id = view.findViewById(R.id.answer_2_id);
    EditText answer3Id = view.findViewById(R.id.answer_3_id);
    EditText answer4Id = view.findViewById(R.id.answer_4_id);
    EditText answer5Id = view.findViewById(R.id.answer_5_id);
    EditText answer6Id = view.findViewById(R.id.answer_6_id);
    EditText answer7Id = view.findViewById(R.id.answer_7_id);
    EditText answer8Id = view.findViewById(R.id.answer_8_id);
    EditText answer9Id = view.findViewById(R.id.answer_9_id);
    EditText answer10Id = view.findViewById(R.id.answer_10_id);
    EditText answer11Id = view.findViewById(R.id.answer_11_id);
    EditText answer12Id = view.findViewById(R.id.answer_12_id);
    EditText answer13Id = view.findViewById(R.id.answer_13_id);
    EditText answer14Id = view.findViewById(R.id.answer_14_id);
    EditText answer15Id = view.findViewById(R.id.answer_15_id);
    EditText answer16Id = view.findViewById(R.id.answer_16_id);
    EditText answer17Id = view.findViewById(R.id.answer_17_id);
    EditText answer18Id = view.findViewById(R.id.answer_18_id);
    EditText answer19Id = view.findViewById(R.id.answer_19_id);
    EditText answer20Id = view.findViewById(R.id.answer_20_id);

    submitButton = view.findViewById(R.id.submit_button);
    sharedPreferences = this.getActivity()
        .getSharedPreferences(MY_PREFERENCES, Context.MODE_PRIVATE);

    answer1Id.setText(sharedPreferences.getString("SavedAnswer1", ""));
    answer2Id.setText(sharedPreferences.getString("SavedAnswer2", ""));
    answer3Id.setText(sharedPreferences.getString("SavedAnswer3", ""));
    answer4Id.setText(sharedPreferences.getString("SavedAnswer4", ""));
    answer5Id.setText(sharedPreferences.getString("SavedAnswer5", ""));
    answer6Id.setText(sharedPreferences.getString("SavedAnswer6", ""));
    answer7Id.setText(sharedPreferences.getString("SavedAnswer7", ""));
    answer8Id.setText(sharedPreferences.getString("SavedAnswer8", ""));
    answer9Id.setText(sharedPreferences.getString("SavedAnswer9", ""));
    answer10Id.setText(sharedPreferences.getString("SavedAnswer10", ""));
    answer11Id.setText(sharedPreferences.getString("SavedAnswer11", ""));
    answer12Id.setText(sharedPreferences.getString("SavedAnswer12", ""));
    answer13Id.setText(sharedPreferences.getString("SavedAnswer13", ""));
    answer14Id.setText(sharedPreferences.getString("SavedAnswer14", ""));
    answer15Id.setText(sharedPreferences.getString("SavedAnswer15", ""));
    answer16Id.setText(sharedPreferences.getString("SavedAnswer16", ""));
    answer17Id.setText(sharedPreferences.getString("SavedAnswer17", ""));
    answer18Id.setText(sharedPreferences.getString("SavedAnswer18", ""));
    answer19Id.setText(sharedPreferences.getString("SavedAnswer19", ""));
    answer20Id.setText(sharedPreferences.getString("SavedAnswer20", ""));

    submitButton.setOnClickListener(view1 -> {

      String answer1 = answer1Id.getText().toString();
      String answer2 = answer2Id.getText().toString();
      String answer3 = answer3Id.getText().toString();
      String answer4 = answer4Id.getText().toString();
      String answer5 = answer5Id.getText().toString();
      String answer6 = answer6Id.getText().toString();
      String answer7 = answer7Id.getText().toString();
      String answer8 = answer8Id.getText().toString();
      String answer9 = answer9Id.getText().toString();
      String answer10 = answer10Id.getText().toString();
      String answer11 = answer11Id.getText().toString();
      String answer12 = answer12Id.getText().toString();
      String answer13 = answer13Id.getText().toString();
      String answer14 = answer14Id.getText().toString();
      String answer15 = answer15Id.getText().toString();
      String answer16 = answer16Id.getText().toString();
      String answer17 = answer17Id.getText().toString();
      String answer18 = answer18Id.getText().toString();
      String answer19 = answer19Id.getText().toString();
      String answer20 = answer20Id.getText().toString();

      View parentView;
      EditText userInputText;
      int numInputs = 20;
      int[] inputValues = new int[numInputs];
      String idStr;
      String userInputStr;
      int resID;

      for (int i = 1; i <= numInputs; i++) {
        idStr = "answer_" + String.valueOf(i) + "_id";
        resID = getResources().getIdentifier(idStr, "id", getContext().getPackageName());

        parentView = (View) view1.getParent();

        userInputText = parentView.findViewById(resID);
        userInputStr = userInputText.getText().toString();
        inputValues[i - 1] = Integer.parseInt(userInputStr);

      }

      SharedPreferences.Editor editor = sharedPreferences.edit();

      editor.putString("SavedAnswer1", answer1);
      editor.putString("SavedAnswer2", answer2);
      editor.putString("SavedAnswer3", answer3);
      editor.putString("SavedAnswer4", answer4);
      editor.putString("SavedAnswer5", answer5);
      editor.putString("SavedAnswer6", answer6);
      editor.putString("SavedAnswer7", answer7);
      editor.putString("SavedAnswer8", answer8);
      editor.putString("SavedAnswer9", answer9);
      editor.putString("SavedAnswer10", answer10);
      editor.putString("SavedAnswer11", answer11);
      editor.putString("SavedAnswer12", answer12);
      editor.putString("SavedAnswer13", answer13);
      editor.putString("SavedAnswer14", answer14);
      editor.putString("SavedAnswer15", answer15);
      editor.putString("SavedAnswer16", answer16);
      editor.putString("SavedAnswer17", answer17);
      editor.putString("SavedAnswer18", answer18);
      editor.putString("SavedAnswer19", answer19);
      editor.putString("SavedAnswer20", answer20);
      editor.apply();

      Toast.makeText(getActivity(), "Saved in Preferences", Toast.LENGTH_LONG).show();

      // this is hard code so we can check connectivity to internet, must activate code above
      // Integer[] inputValues2 = new Integer[]{87113, 3, 2, 1, 1, 1700, 80, 40, 0, 11, 100, 200,
      // 10000, 12, 5000, 17, 2000, 19, 0, 0};
      boolean[] takeActionInputs = new boolean[]{false, false, false, false, false, false, false,
          false, false, false, false, false, false, false, false};

      CC_API ccApi = new CC_API();
      Map<String, String> params = ccApi.calculateFootprintParams(inputValues, takeActionInputs);

      new GetCCAPITask()
          .setTransformer((response) -> {
            Consumption consumption = new Consumption();
            consumption.setScore(response.getGrandTotal());
            ConsumptionDB.getInstance().getConsumtionDao().insert(consumption);
            return response;
          })
          .setSuccessListener(

              ccResponse ->

                  Toast.makeText(getActivity(),
                      "Total: " + ccResponse.getGrandTotal(), Toast.LENGTH_LONG)
                      .show()
          ) // Display total carbon footprint if available

          .execute(params);

      loadScoreFragment(new ScoreFragment());

    });

    return view;

  }


  /**
   * <code>loadFragment</code> allows submit button <code>R.id.submit_button</code>
   * to transition to <code>ScoreFragment</code> after implementation of <code>GetCCAPITask</code>
   *
   * Creates a fragment manager, replaces the current fragment and transitions to new fragment, and
   * saves changes.
   *
   * @param frag instance of a fragment
   */

  private void loadScoreFragment(ScoreFragment frag) {

    FragmentManager nextFrag;
    nextFrag = getFragmentManager();
    FragmentTransaction transaction = nextFrag.beginTransaction();
    transaction.replace(R.id.fragment_container, frag);
    transaction.addToBackStack(null);
    transaction.commit();
  }


}
