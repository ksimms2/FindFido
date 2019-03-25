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

  public HistoryAdapter(@NonNull Context context, List<Consumption> items) {
    super(context, R.layout.history_item, items);
    dateFormat = android.text.format.DateFormat.getDateFormat(context);
    scoreFormat = context.getString(R.string.score_format);
  }


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
