/*
Unneeded for now... will need to reference when you get to a list view to display history.
 */


package edu.cnm.deepdive.green_print.view;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import edu.cnm.deepdive.green_print.R;
import edu.cnm.deepdive.green_print.controller.HistoryFragment;
import edu.cnm.deepdive.green_print.model.entity.Consumption;
import java.text.DateFormat;
import java.util.List;

/**
 * Supplies {@link View} instances&mdash;each presenting an {@link Consumption} instance, to a
 * {@link RecyclerView}.
 */
public class HistoryAdapter extends ArrayAdapter<Consumption> {

  Context context;
  private HistoryFragment historyFragment;
  private List<Consumption> consumptions;
  private DateFormat format;


  /**
   * Initializes {@link HistoryAdapter} instance with the specified {@link HistoryFragment} host and
   * {@link List}&lt;{@link Consumption}&gt; data source.
   *
   * @param context host fragment.
   * @param consumptions source of {@link Consumption} instances.
   */
  public HistoryAdapter(Context context, List<Consumption> consumptions) {
    super(context, R.layout.fragment_list, consumptions);
    this.context = context;
    this.consumptions = consumptions;
  }

  @Override
  public int getCount() {
    return consumptions.size();
  }

  @Override
  public Consumption getItem(int position) {
    return consumptions.get(position);
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

  /**
   * Maintains a connection between a {@link View} and an {@link Consumption} instance. The {@link
   * HistoryAdapter} manages the creation and re-use of Holder instances as rows are scrolled into
   * and out of view.
   * <p>Each view item is clickable (the {@link View.OnClickListener} attached to each is the host
   * {@link HistoryFragment}), supporting display of an APOD selected from the list view.</p>
   */

  public View getHolder(int position, View convertView, ViewGroup parent) {
    ViewHolder holder = null;
    if (convertView == null) {
      LayoutInflater inflater = (LayoutInflater) context
          .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
      convertView = inflater.inflate(R.layout.fragment_list, null);
      holder = new ViewHolder();

      holder.consIdTxt = convertView
          .findViewById(R.id.txt_score_id);
      holder.consScoreTxt = convertView
          .findViewById(R.id.txt_score_result);

      convertView.setTag(holder);
    } else {
      holder = (ViewHolder) convertView.getTag();
    }
    Consumption consumption = (Consumption) getItem(position);
    holder.consIdTxt.setText(consumption.getFie_id() + "");
    holder.consScoreTxt.setText(consumption.getScore() + "");

    return convertView;
  }

  @Override
  public void add(Consumption consumption) {
    consumptions.add(consumption);
    notifyDataSetChanged();
    super.add(consumption);
  }

  @Override
  public void remove(Consumption consumption) {
    consumptions.remove(consumption);
    notifyDataSetChanged();
    super.remove(consumption);
  }

  private class ViewHolder {

    TextView consIdTxt;
    TextView consScoreTxt;
  }

}
