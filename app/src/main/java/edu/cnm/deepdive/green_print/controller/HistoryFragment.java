package edu.cnm.deepdive.green_print.controller;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import edu.cnm.deepdive.green_print.R;
import edu.cnm.deepdive.green_print.model.ConsumptionDB;
import edu.cnm.deepdive.green_print.model.entity.Consumption;
import edu.cnm.deepdive.green_print.view.HistoryAdapter;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

/**
 * <code>HistoryFragmen</code> displays the users previous carbon footprint scores that populate after
 * each successful completion of {@link SurveyFragment}. The user is able to scroll through each
 * score to see their progress throughout the year and the scores from the prior years.
 * Future applications will allow the user to will allow the user to delete older scores or will
 * auto-delete.
 *
 * @author Kevin Simms &amp; Deep Dive Coding Java + Android Bootcamp cohort 6
 * @version 1.0
 */
public class HistoryFragment extends Fragment {

  private List<Consumption> scores;
  private HistoryAdapter adapter;

  /**
   * <code>onCreateView</code> loads and displays the layout for {@link HistoryFragment} by
   * inflating the resource files of fragment_history, list_history, header and categories to
   * provide a {@link ListView} of the users history. Resource files header makes a stylized header.
   * Resource file categories displays the titles for the two columns, Date and Score.
   * In order for this to be successful this <code>onCreateView</code> uses access to
   * {@link HistoryAdapter} which provides a link from the database to the UI.
   *
   * @param inflater inflates xml files as a display
   * @param container contains access as group to the display files
   * @param savedInstanceState saves the current instance of the fragments
   * @return a stylized display for the user.
   */

  public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,

      @Nullable Bundle savedInstanceState) {

    View view = inflater.inflate(R.layout.fragment_history, container, false);

    ListView listView = view.findViewById(R.id.list_history);
    ViewGroup header = (ViewGroup) inflater.inflate(R.layout.header, listView,
        false);
    ViewGroup categories = (ViewGroup) inflater.inflate(R.layout.categories, listView,
        false);
    listView.addHeaderView(header, null, false);
    listView.addHeaderView(categories, null, false);

    scores = new LinkedList<>();

    adapter = new HistoryAdapter(Objects.requireNonNull(getContext()), scores);
    listView.setAdapter(adapter);

    new ScoreQueryTask().execute();
    return view;
  }

  /**
   * <code>ScoreQueryTask</code> takes a query of the local database and displays the scores in
   * descending order by date. The categories are provided by the entity classes {@link Consumption}
   * and {@link edu.cnm.deepdive.green_print.model.entity.Activity}. The query method is provided by
   * {@link edu.cnm.deepdive.green_print.model.dao.ConsumptionDao}.
   */
  @SuppressLint("StaticFieldLeak")
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
