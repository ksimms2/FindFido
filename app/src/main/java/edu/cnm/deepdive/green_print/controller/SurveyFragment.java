package edu.cnm.deepdive.green_print.controller;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import edu.cnm.deepdive.green_print.R;


public class SurveyFragment extends LinkedFragment {

  private Button submitButton;

  public SurveyFragment() {
    // Required empty public constructor
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_survey, container, false);
    submitButton = (Button) view.findViewById(R.id.submit_button);

    submitButton.setOnClickListener(new View.OnClickListener(){

      @Override
      public void onClick(View view) {
        View parentView;
        EditText userInputText;
        int numInputs = 20;
        int[] inputValues = new int[numInputs];
        String idStr;
        String userInputStr;
        int resID;

        //Toast.makeText(getActivity(), "Submit Clicked", Toast.LENGTH_SHORT).show();

/*
        for(int i = 1; i <= numInputs; i++){
          idStr = "answer_" + String.valueOf(i) + "_id";
          resID = getResources().getIdentifier(idStr, "id", getContext().getPackageName());

          parentView = (View)view.getParent();

          userInputText = parentView.findViewById(resID);
          userInputStr = userInputText.getText().toString();
          inputValues[i - 1] = Integer.parseInt(userInputStr);

        }
*/
        // this is so we can check connectivity to internet, must activate code above
        Integer[] inputValues2 = new Integer[]{87113, 3, 2, 1, 1, 1700, 80, 40, 0, 11, 100, 200, 10000, 12, 5000, 17, 2000, 19, 0, 0};


        // had to alt-enter/ to to revert to last commit
        new CCAPITask().execute(inputValues2);
        // Display total carbon footprint if available

      }
    });

  return view;

  }
  private class CCAPITask extends AsyncTask<Integer, Void, Float>{


    @Override
    protected Float doInBackground(Integer... inputValues2) {
      CC_API ccApi = new CC_API();
      float total_carbon_footprint = ccApi.calculateFootprint(inputValues2);

      return total_carbon_footprint;
    }

    @Override
    protected void onPostExecute(Float total_carbon_footprint) {
      if (total_carbon_footprint == -1) {
        Toast.makeText(getActivity(), "*** Error: Can't Calculate Carbon Footprint. ***", Toast.LENGTH_SHORT).show();
      } else {
        String toastStr = "Footprint: " + String.valueOf(total_carbon_footprint) + "tons/year";
        Toast.makeText(getActivity(), toastStr, Toast.LENGTH_SHORT).show();
      }

    }
  }


}
