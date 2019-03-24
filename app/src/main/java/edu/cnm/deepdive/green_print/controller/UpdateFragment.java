package edu.cnm.deepdive.green_print.controller;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import edu.cnm.deepdive.green_print.R;
import edu.cnm.deepdive.green_print.model.ConsumptionDB;
import edu.cnm.deepdive.green_print.model.entity.Activity;
import edu.cnm.deepdive.green_print.model.entity.Consumption;
import edu.cnm.deepdive.green_print.service.CC_APIWebService;
import edu.cnm.deepdive.green_print.service.FragmentService;
import java.util.List;

/**
 * <code>UpdateFragment</code> gives the user checkbox options with activities which lower the
 * users
 * carbon footprint on completion. Update button sends a request to API and database to apply
 * changes to the user score.
 *
 * @author Kevin Simms &amp; Deep Dive Coding Java + Android Bootcamp cohort 6
 * @version 1.0
 */


public class UpdateFragment extends LinkedFragment { //implements View.OnClickListener


  private CC_APIWebService service;
  private ListView takeActionListView;
  private Editable edit = null;
  private EditText textInputScore;
  private TextView textView;


  public UpdateFragment() {
    // Required empty public constructor
  }


  private List<ConsumptionWithActivities> takeaction;
  //private UpdateAdapter adapter;
  private ScoreFragment scoreFragment;
  private Button updateButton;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);


  }

  /**
   * Implementation of clicked checked box options. Inflates and displays UpdateFragment UI.
   */

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {

    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_update, container, false);

//    RecyclerView updateView = view.findViewById(R.id.update_view);
//    takeaction = new ArrayList<>();
//    adapter = new UpdateAdapter(this, takeaction);
//    updateView.setAdapter(adapter);
//    refresh();
//    return view;

//    updateButton.setOnClickListener((v) -> new CC_APIWebService.GetCCAPITask()
//        .setSuccessListener((result) -> {
//          //ArrayAdapter<String> adapter = new ArrayAdapter<>(
//              Objects.requireNonNull(this.getContext()), android.R.layout.simple_list_item_1,
//              result.getGrandTotal());
//         // textView.setText(result.getGrandTotal());// not sure what to put here
//          takeActionListView.setAdapter(adapter);
//          Log.d(getClass().getSimpleName(), result.toString());
//          updateButton.setOnClickListener((b) -> new SaveScoreTask());
//          )
//
//          updateButton = (Button) view.findViewById(R.id.update_button);
//
//          //updateButton.setOnClickListener(new View.OnClickListener(){
//
//        })
//
//        //.execute(textInputScore.getText().toString()));
    return view;

  }



  public void onClick(View view) {

    Consumption consumption = (Consumption) view.getTag();
    MainActivity mainActivity = (MainActivity) getActivity();
    FragmentService
        .getInstance().showFragment(mainActivity, R.id.fragment_container, scoreFragment);
    Activity activity = new Activity();
    activity.setConsumptionId(consumption.getId());
    // scoreFragment.setConsumption(consumption);
    //activity.getNavigation().setSelectedItemId(R.id.fragment_questions)
    Toast.makeText(getActivity(), "Update Clicked", Toast.LENGTH_SHORT).show();


  }


  private static class SaveScoreTask extends AsyncTask<Consumption, Void, Void> {


    @Override

    protected Void doInBackground(Consumption... consumptions) {
      ConsumptionDB.getInstance().getConsumtionDao().insert(consumptions);
      return null;

    }
    //    public void setUpdateFragment(UpdateFragment fragment) {
//      updateFragment = fragment;
//    }

    /**
     * Queries the local database for {@link Apod} instances, populating (indirectly) a {@link
     * RecyclerView} with the results.
     */
//  public void refresh() {
//    if (!isHidden()) {
//      new SelectAllConsumptionTask()
//          .setSuccessListener((consumptions) -> {
//            takeaction.clear();
//            takeaction.addAll(consumptions);
//            adapter.notifyDataSetChanged();
//          })
//          .execute();
//    }
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







//    myCheck = (CheckBox) view.findViewById(R.id.myCheckBox1);
//   myCheck.isChecked(); <-- this the handle are you checked


// use for loop from SurveyFragment example with boolean []
// pass boolean [] to CC_API for recall.
