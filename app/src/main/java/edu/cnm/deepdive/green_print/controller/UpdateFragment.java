package edu.cnm.deepdive.green_print.controller;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import edu.cnm.deepdive.green_print.R;
import edu.cnm.deepdive.green_print.model.ConsumptionDB;
import edu.cnm.deepdive.green_print.model.entity.Activity;
import edu.cnm.deepdive.green_print.model.entity.Consumption;
import edu.cnm.deepdive.green_print.service.CC_APIWebService.GetCCAPITask;
import edu.cnm.deepdive.green_print.service.FragmentService;
import java.util.List;
import java.util.Map;

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

//  private CC_APIWebService service;
//  private ListView takeActionListView;
//  private Editable edit = null;
//  private EditText textInputScore;
//  private TextView textView;


  public UpdateFragment() {
    // Required empty public constructor
  }


  private List<ConsumptionWithActivities> takeaction;
  //private UpdateAdapter adapter;
  private ScoreFragment scoreFragment;
  private Button applyButton;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setRetainInstance(true);


  }

  /**
   */

  /**
   * <code>OnCreateView</code> launches the UI for the home screen. Calls on the
   * <code>R.layout.fragment_update</code>, which presents the .xml UI design.
   * Implementation of clicked checked box options. Inflates and displays UpdateFragment UI.
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
    View view = inflater.inflate(R.layout.fragment_update, container, false);

    applyButton = view.findViewById(R.id.apply_button);

    applyButton.setOnClickListener(new View.OnClickListener() {

      @Override

      public void onClick(View view) {

//        View parentView;
//        EditText userInputText;
//        int numInputs = 20;
//        int[] inputValues = new int[numInputs];
//        String idStr;
//        String userInputStr;
//        int resID;
//
//       // Toast.makeText(getActivity(), "Update Clicked", Toast.LENGTH_SHORT).show();
//
//
//
//        for(int i = 1; i <= numInputs; i++){
//          idStr = "answer_" + String.valueOf(i) + "_id";
//          resID = getResources().getIdentifier(idStr, "id", getContext().getPackageName());
//
//          parentView = (View)view.getParent();
//          userInputText = parentView.findViewById(resID);
//          userInputStr = userInputText.getText().toString();
//          inputValues[i - 1] = Integer.parseInt(userInputStr);
//        }

        // this is so we can check connectivity to internet, must activate code above

        int[] inputValues2 = new int[]{87107, 3, 2, 1, 200000, 1500, 800, 80, 300, 900, 90, 120,
            18000, 32, 15000, 28, 0, 0, 10000, 500};
        boolean[] takeActionInputs = new boolean[]{false, false, false, false, false, false, true,
            false, false, false, false, false, false, false, false};

        CC_API ccApi = new CC_API();

        //float total_carbon_footprint = ccApi.calculateFootprintParams(inputValues2, takeActionInputs);

        Map<String, String> params2 = ccApi
            .calculateFootprintParams(inputValues2, takeActionInputs);

        new GetCCAPITask()
            .setTransformer((response) -> {
              Consumption consumption = new Consumption();
              consumption.setScore(response.getTakeActionGrandTotal());
              ConsumptionDB.getInstance().getConsumtionDao().insert(consumption);
              return response;
            })
            .setSuccessListener(

                ccResponse ->

                    Toast.makeText(getActivity(),
                        "Take Action Total: " +
                            (ccResponse.getTakeActionGrandTotal() - 11.611036), Toast.LENGTH_LONG)
                        .show()
            ) // Display total carbon footprint if available

            .execute(params2);

        loadFragment(new ScoreFragment());
      }


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
   * @param frag2 instance of a fragment
   */

  private void loadFragment(ScoreFragment frag2) {

    FragmentManager scoreFrag = getFragmentManager();
    FragmentTransaction transaction = scoreFrag.beginTransaction();
    transaction.replace(R.id.fragment_container, frag2);
    transaction.addToBackStack(null);
    transaction.commit();
  }
//    applyButton = view.findViewById(R.id.apply_button);
//
//    applyButton.setOnClickListener(v -> {
//      Toast.makeText(getActivity(), "Update Applied, Going to Your Score", Toast.LENGTH_LONG)
//          .show();
//      ScoreFragment scoreFragment = new ScoreFragment();
//      getFragmentManager().beginTransaction().replace(R.id.fragment_container, scoreFragment)
//          .commit();
//    });

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
