package edu.cnm.deepdive.green_print.controller;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;
import edu.cnm.deepdive.green_print.R;
import edu.cnm.deepdive.green_print.model.ConsumptionDB;
import edu.cnm.deepdive.green_print.model.entity.Consumption;
import edu.cnm.deepdive.green_print.view.HistoryAdapter;
import java.util.LinkedList;
import java.util.List;

public class HistoryFragment extends Fragment {


  private Button backButton;

  private List<Consumption> scores;

  private HistoryAdapter adapter;


  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,

      @Nullable Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_history, container, false);

    ListView listView = view.findViewById(R.id.list_history);
    //listView.setOnItemClickListener(this);

    scores = new LinkedList<>();

    adapter = new HistoryAdapter(getContext(), scores);
    listView.setAdapter(adapter);

    new ScoreQueryTask().execute();
    return view;
  }

  private class ScoreQueryTask extends AsyncTask<Void, Void, List<Consumption>> {

    @Override
    protected void onPostExecute(List<Consumption> consumptions) {
      scores.clear();
      scores.addAll(consumptions);
      adapter.notifyDataSetChanged();
    }

    @Override
    protected List<Consumption> doInBackground(Void... voids) {
      return ConsumptionDB.getInstance().getConsumtionDao().findAll();
    }
  }

}
