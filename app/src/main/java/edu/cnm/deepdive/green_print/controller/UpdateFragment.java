package edu.cnm.deepdive.green_print.controller;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import edu.cnm.deepdive.green_print.R;
import edu.cnm.deepdive.green_print.model.entity.Activity;
import edu.cnm.deepdive.green_print.model.entity.Consumption;
import edu.cnm.deepdive.green_print.service.ConsumptionDBService.SelectAllConsumptionTask;
import edu.cnm.deepdive.green_print.view.UpdateAdapter;
import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass. Activities that contain this fragment must implement the
 * {@link UpdateFragment.OnFragmentInteractionListener} interface to handle interaction events. Use
 * the {@link UpdateFragment#newInstance} factory method to create an instance of this fragment.
 */
public class UpdateFragment extends LinkedFragment implements View.OnClickListener {



  public UpdateFragment() {
    // Required empty public constructor
  }


  private List<ConsumptionWithActivities> takeaction;
  private UpdateAdapter adapter;
  private ScoreFragment scoreFragment;
  private Button updateButton;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);


  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_update, container, false);
    RecyclerView updateView = view.findViewById(R.id.update_view);
    takeaction = new ArrayList<>();
    adapter = new UpdateAdapter(this, takeaction);
    updateView.setAdapter(adapter);
    refresh();
    return view;

    updateButton = (Button) view.findViewById(R.id.update_button);

    updateButton.setOnClickListener(new View.OnClickListener(){

      @Override
      public void onClick(View view) {
//        View parentView;
//        EditText userInputText;
//        int numInputs = 15;
//        int[] inputValues = new int[numInputs];
//        String idStr;
//        String userInputStr;
//        int resID;

        Consumption consumption = (Consumption) view.getTag();
        MainActivity mainActivity = (MainActivity) getActivity();
        FragmentService.getInstance().showFragment(mainActivity, R.id.fragment_container, scoreFragment);
        Activity activity = new Activity();
        activity.setConsumptionId(consumption.getId());
        scoreFragment.setConsumption(consumption);
        //activity.getNavigation().setSelectedItemId(R.id.fragment_questions)
        Toast.makeText(getActivity(), "Update Clicked", Toast.LENGTH_SHORT).show();

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
//        int[] inputValues2 = new int[]{87113, 3, 2, 1, 1, 1700, 80, 40, 0, 11, 100, 200, 10000, 12, 5000, 17, 2000, 19, 0, 0};
//
//        CC_API ccApi = new CC_API();
//        float total_carbon_footprint = ccApi.calculateFootprint(inputValues2);
//
//        // Display total carbon footprint if available
//        if (total_carbon_footprint == -1) {
//          Toast.makeText(getActivity(), "*** Error: Can't Calculate Carbon Footprint. ***", Toast.LENGTH_SHORT).show();
//        } else {
//          String toastStr = "Footprint: " + String.valueOf(total_carbon_footprint) + "tons/year";
//          Toast.makeText(getActivity(), toastStr, Toast.LENGTH_SHORT).show();
//        }

      }
    });


    return view;

  }
  //    public void setUpdateFragment(UpdateFragment fragment) {
//      updateFragment = fragment;
//    }

  /**
   * Queries the local database for {@link Apod} instances, populating (indirectly) a {@link
   * RecyclerView} with the results.
   */
  public void refresh() {
    if (!isHidden()) {
      new SelectAllConsumptionTask()
          .setSuccessListener((consumptions) -> {
            takeaction.clear();
            takeaction.addAll(consumptions);
            adapter.notifyDataSetChanged();
          })
          .execute();
    }
  }

//  public void createContextMenu(ContextMenu menu, int position, Consumption consumption){
//    getActivity().getMenuInflater().inflate(R.menu.item_context, menu);
//    menu.findItem(R.id.context_delete).setOnMenuItemClickListener((item) -> {
//      new DeleteConsumptionTask()
//          .setSuccessListener((v)-> {
//            takeaction.remove(position);
//            adapter.notifyItemRemoved(position);
//          })
//          .execute(consumption);
//      return true;
//    });
  }



}


//    myCheck = (CheckBox) view.findViewById(R.id.myCheckBox1);
//   myCheck.isChecked(); <-- this the handle are you checked


// use for loop from SurveyFragment example with boolean []
// pass boolean [] to CC_API for recall.
