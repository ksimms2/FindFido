package edu.cnm.deepdive.green_print.view;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import edu.cnm.deepdive.green_print.R;
import edu.cnm.deepdive.green_print.model.entity.Consumption;
import java.text.DateFormat;
import java.util.List;

public class HistoryAdapter extends ArrayAdapter<Consumption> {

  DateFormat dateFormat;
  String scoreFormat;

  /**
   * <code>HistoryAdapter</code> provides a link between the database and UI display. Using the
   * the available categories within the {@link Consumption} entity as a reference to make the
   * columns (date and score) that are displayed when {@link edu.cnm.deepdive.green_print.controller.HistoryFragment}
   * is inflated for display for the user.
   *
   * @param context access to the database
   * @param items categories from Consumption (date, score)
   */

  public HistoryAdapter(@NonNull Context context, List<Consumption> items) {
    super(context, R.layout.history_item, items);
    dateFormat = android.text.format.DateFormat.getDateFormat(context);
    scoreFormat = context.getString(R.string.score_format);
  }


  /**
   * <code>getView</code> converts the database items within {@link Consumption} entity class to
   * be viewed as a text.
   *
   * @param position position of each item.
   * @param convertView converts view.
   * @param parent group of Consumption
   * @return visual text of the items
   */
  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    View view = (convertView != null) ? convertView
        : LayoutInflater.from(getContext()).inflate(R.layout.history_item, parent, false);
    Consumption consumption = getItem(position);
    TextView date = view.findViewById(R.id.date);
    TextView score = view.findViewById(R.id.score);
    date.setText(dateFormat.format(consumption.getTime().getTime()));
    score.setText(String.format(scoreFormat, consumption.getScore()));

    return view;
  }

}
