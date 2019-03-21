package edu.cnm.deepdive.green_print.controller;

import android.os.Bundle;
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

    submitButton.setOnClickListener(new View.OnClickListener() {

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


        for(int i = 1; i <= numInputs; i++){
          idStr = "answer_" + String.valueOf(i) + "_id";
          resID = getResources().getIdentifier(idStr, "id", getContext().getPackageName());

          parentView = (View)view.getParent();

          userInputText = parentView.findViewById(resID);
          userInputStr = userInputText.getText().toString();
          inputValues[i - 1] = Integer.parseInt(userInputStr);

        }

        // this is hard code so we can check connectivity to internet, must activate code above
 //       Integer[] inputValues2 = new Integer[]{87113, 3, 2, 1, 1, 1700, 80, 40, 0, 11, 100, 200,
  //         10000, 12, 5000, 17, 2000, 19, 0, 0};


        CC_API ccApi = new CC_API();
        Map<String, String> params = ccApi.calculateFootprintParams(inputValues);

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
                        .show())
            .execute(params);

        // Display total carbon footprint if available

      }
    });

    return view;

  }


}
