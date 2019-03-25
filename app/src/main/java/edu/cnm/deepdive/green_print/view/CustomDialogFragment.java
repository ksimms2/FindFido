//package edu.cnm.deepdive.green_print.view;
//
//import edu.cnm.deepdive.green_print.R;
//import edu.cnm.deepdive.green_print.controller.MainActivity;
//import edu.cnm.deepdive.green_print.model.dao.ConsumptionDao;
//import edu.cnm.deepdive.green_print.model.entity.Consumption;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.Locale;
//
//import android.app.AlertDialog;
//import android.app.Dialog;
//import android.content.DialogInterface;
//import android.os.Bundle;
//import android.support.v4.app.DialogFragment;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.widget.EditText;
//import android.widget.LinearLayout;
//import android.widget.Toast;
//
//
//public class CustomDialogFragment extends DialogFragment {
//
////  private EditText empNameEtxt;
////  private EditText empSalaryEtxt;
////  private EditText empDobEtxt;
////  private LinearLayout submitLayout;
//
//  private Consumption consumption;
//
//  private static final SimpleDateFormat formatter = new SimpleDateFormat(
//      "yyyy-MM-dd", Locale.ENGLISH);
//
//  ConsumptionDao consumptionDAO;
//
//  public static final String ARG_ITEM_ID = "history_dialog_fragment";
//
//
//  public interface DialogFragmentListener {
//
//    void onFinishDialog();
//  }
//
//  public CustomDialogFragment() {
//
//  }
//
//  @Override
//  public Dialog onCreateDialog(Bundle savedInstanceState) {
//    //consumptionDAO = new ConsumptionDao(getActivity());
//    Bundle bundle = this.getArguments();
//    consumption = bundle.getParcelable("selectedScore");
//
//    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
//    LayoutInflater inflater = getActivity().getLayoutInflater();
//
//
//    //this might be survey fragment
//    View customDialogView = inflater.inflate(R.layout.fragment_history,
//        null);
//    builder.setView(customDialogView);
//
//
//    builder.setTitle(R.string.update_emp);
//    builder.setCancelable(false);
//    builder.setPositiveButton(R.string.update,
//        new DialogInterface.OnClickListener() {
//          public void onClick(DialogInterface dialog, int id) {
//
//            consumption.setName(empNameEtxt.getText().toString());
//            consumption.setScore(Float.parseFloat(
//                .getText().toString()));
//
//          }
//        });
//    builder.setNegativeButton(R.string.cancel,
//        new DialogInterface.OnClickListener() {
//          public void onClick(DialogInterface dialog, int id) {
//            dialog.cancel();
//          }
//        });
//
//    AlertDialog alertDialog = builder.create();
//
//    return alertDialog;
//  }
//
//  }
//}
