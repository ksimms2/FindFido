/*
Unneeded for now... will need to reference when you get to a list view to display history.
 */



//package edu.cnm.deepdive.green_print.view;
//
//import android.content.Context;
//import android.support.annotation.NonNull;
//import android.support.v7.widget.RecyclerView;
//import android.support.v7.widget.RecyclerView.ViewHolder;
//import android.view.ContextMenu;
//import android.view.ContextMenu.ContextMenuInfo;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.CheckBox;
//import android.widget.CompoundButton;
//import edu.cnm.deepdive.green_print.R;
//import edu.cnm.deepdive.green_print.controller.ConsumptionWithActivities;
//import edu.cnm.deepdive.green_print.controller.UpdateFragment;
//import edu.cnm.deepdive.green_print.model.entity.Consumption;
//import java.util.List;
//
//public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.Holder> {
//// does this need to extend something?
//// in Apod it extends RecylcerView which I dont have
//
//  Context context;
//  private HistoryFragment historyFragment;
//  private List<ConsumptionWithActivities> items;
//  //private DateFormat format;
//
//  public HistoryAdapter(HistoryFragment updateFragment, List<ConsumptionWithActivities> items) {
//    context = historyFragment.getContext();
//    this.historyFragment = historyFragment;
//    this.items = items;
//    //format = android.text.format.DateFormat.getDateFormat(context);
//  }
//
//  @NonNull
//  @Override
//  public Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
//    View view = LayoutInflater.from(context)
//        .inflate(R.layout.takeaction_item_list, viewGroup, false)
//    return new Holder(view);
//  }
//
//  @Override
//  public void onBindViewHolder(final ViewHolder holder, int position) {
//
//    //in some cases, it will prevent unwanted situations
//    holder.checkbox.setOnCheckedChangeListener(null);
//
//    //if true, your checkbox will be selected, else unselected
//    holder.checkbox.setChecked(numbers.get(position).isSelected());
//
//    holder.checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
//      @Override
//      public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
//        numbers.get(holder.getAdapterPosition()).setSelected(isChecked);
//      }
//    });
//  }
//
//  @Override
//  public int getItemCount() {
//    return items.size();
//  }
//
//  public class Holder extends RecyclerView.ViewHolder
//      implements View.OnCreateContextMenuListener {
//
//    private Consumption consumption;
//    private View view;
//    private CheckBox titleCheckBox;
//
//    private Holder(@NonNull View itemView) {
//      super(itemView);
//      view = itemView;
//      view.setOnClickListener(updateFragment);
//      view.setOnCreateContextMenuListener(this);
//      titleCheckBox = itemView.findViewById(R.id.check_1);// how to do multiple ids
//    }
//
//    private void bind(ConsumptionWithActivities consumptionWithActivities) {
//      this.consumption = consumptionWithActivities.getConsumption();
//      view.setTag(consumption);
//      //titleCheckBox.setText(consumption.getId());
//
//    }
////    @Override
////    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenuInfo menuInfo) {
////      updateFragment.createContextMenu(menu, getAdapterPosition(), consumption);
////    }
//  }
//}
