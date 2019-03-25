package edu.cnm.deepdive.green_print.controller;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import edu.cnm.deepdive.green_print.R;
import edu.cnm.deepdive.green_print.model.dao.ConsumptionDao;
import edu.cnm.deepdive.green_print.model.entity.Consumption;
import edu.cnm.deepdive.green_print.view.HistoryAdapter;
import java.util.ArrayList;

//import edu.cnm.deepdive.green_print.view.CustomDialogFragment;

public class DisplayHistoryFragment extends Fragment implements OnItemClickListener,
    OnItemLongClickListener {


  Activity venture;
  ArrayList<Consumption> consumptions;
  HistoryAdapter historyAdapter;
  ConsumptionDao consumptionDAO;
  private ListView historyListView;

  //private GetConsumptionTask task;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    venture = getActivity();
    //consumptionDAO = new ConsumptionDao(venture);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_list, container,
        false);
    //findViewsById(view);

//      task = new GetConsumptionTask(activity);
//      task.execute((Void) null);

    historyListView.setOnItemClickListener(this);
    historyListView.setOnItemLongClickListener(this);
    return view;
  }

  private void findViewsById(View view) {
    historyListView = (ListView) view.findViewById(R.id.list_history);
  }

  @Override
  public void onResume() {
    getActivity().setTitle(R.string.app_name);
    getActivity().getActionBar().setTitle(R.string.app_name);
    super.onResume();
  }

  @Override
  public void onItemClick(AdapterView<?> list, View arg1, int position,
      long arg3) {
    Consumption consumption = (Consumption) list.getItemAtPosition(position);

//      if (consumption != null) {
//        Bundle arguments = new Bundle();
//        arguments.putParcelable("selectedScore", consumption);
//        CustomDialogFragment customEmpDialogFragment = new CustomDialogFragment();
//        customEmpDialogFragment.setArguments(arguments);
//        customEmpDialogFragment.show(getFragmentManager(),
//            CustomDialogFragment.ARG_ITEM_ID);
//      }
  }

  @Override
  public boolean onItemLongClick(AdapterView<?> parent, View view,
      int position, long arg3) {
    Consumption consumption = (Consumption) parent.getItemAtPosition(position);

    // Use AsyncTask to delete from database
    consumptionDAO.delete(consumption);
    historyAdapter.remove(consumption);
    return true;
  }
//    public class GetConsumptionTask extends
//        AsyncTask<Void, Void, ArrayList<Consumption>> {
//
//      //private final WeakReference<Activity> activityWeakRef;
//
//      public GetConsumtionTask(Activity context) {
//        this.activityWeakRef = new WeakReference<Activity>(context);
//      }
//
//      @Override
//      protected ArrayList<Consumption> doInBackground(Void... arg0) {
//        ArrayList<Consumption> consumptionList = consumptionDAO.getClass();
//        return consumptionList;
//      }
//
//      @Override
//      protected void onPostExecute(ArrayList<Consumption> consList) {
//        if (activityWeakRef.get() != null
//            && !activityWeakRef.get().isFinishing()) {
//          Log.d("consumption", consList.toString());
//          consumptions = consList;
//          if (consList != null) {
//            if (consList.size() != 0) {
//              historyAdapter = new HistoryAdapter(activity,
//                  consList);
//              historyAdapter.setAdapter(historyAdapter);
//            } else {
//              Toast.makeText(activity, "No Employee Records",
//                  Toast.LENGTH_LONG).show();
//            }
//          }
//
//        }
//      }
//    }

}