package edu.cnm.deepdive.green_print.controller;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import edu.cnm.deepdive.green_print.R;
import edu.cnm.deepdive.green_print.model.dao.ConsumptionDao;
import edu.cnm.deepdive.green_print.model.entity.Consumption;
import edu.cnm.deepdive.green_print.view.HistoryAdapter;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;


public class HistoryFragment extends Fragment {

  private static final SimpleDateFormat formatter = new SimpleDateFormat(
      "yyyy-MM-dd", Locale.ENGLISH);
  DatePickerDialog datePickerDialog;
  Calendar dateCalendar;
  Consumption consumption = null;
  private List<ConsumptionWithActivities> history;
  private HistoryAdapter adapter;
  private Button backButton;
  private ConsumptionDao consumptionDAO;

  public HistoryFragment() {
    // Required empty public constructor
  }
  //private AddEmpTask task;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    //consumptionDAO = new ConsumptionDao(getActivity());
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View rootView = inflater.inflate(R.layout.fragment_history, container,
        false);

    backButton = rootView.findViewById(R.id.back_button);

    backButton.setOnClickListener(v -> {
      Toast.makeText(getActivity(), "Going to Score", Toast.LENGTH_SHORT).show();
      ScoreFragment scoreFragment = new ScoreFragment();
      getFragmentManager().beginTransaction().replace(R.id.fragment_container, scoreFragment)
          .commit();

    });

//    findViewsById(rootView);
//
//    setListeners();
//
//    //For orientation change.
//    if (savedInstanceState != null) {
//      dateCalendar = Calendar.getInstance();
//      if (savedInstanceState.getLong("dateCalendar") != 0)
//        dateCalendar.setTime(new Date(savedInstanceState
//            .getLong("dateCalendar")));
//    }

    return rootView;
  }

//  private void setListeners() {
//    empDobEtxt.setOnClickListener(this);
//    Calendar newCalendar = Calendar.getInstance();
//    datePickerDialog = new DatePickerDialog(getActivity(),
//        new OnDateSetListener() {
//
//          public void onDateSet(DatePicker view, int year,
//              int monthOfYear, int dayOfMonth) {
//            dateCalendar = Calendar.getInstance();
//            dateCalendar.set(year, monthOfYear, dayOfMonth);
//            empDobEtxt.setText(formatter.format(dateCalendar
//                .getTime()));
//          }
//
//        }, newCalendar.get(Calendar.YEAR),
//        newCalendar.get(Calendar.MONTH),
//        newCalendar.get(Calendar.DAY_OF_MONTH));
//
//    addButton.setOnClickListener(this);
//    resetButton.setOnClickListener(this);
//  }
//
//  protected void resetAllFields() {
//    empNameEtxt.setText("");
//    empSalaryEtxt.setText("");
//    empDobEtxt.setText("");
//  }
//
//  private void setEmployee() {
//    employee = new Employee();
//    employee.setName(empNameEtxt.getText().toString());
//    employee.setSalary(Double.parseDouble(empSalaryEtxt.getText()
//        .toString()));
//    if (dateCalendar != null)
//      employee.setDateOfBirth(dateCalendar.getTime());
//  }
//
//  @Override
//  public void onResume() {
//    getActivity().setTitle(R.string.add_emp);
//    getActivity().getActionBar().setTitle(R.string.add_emp);
//    super.onResume();
//  }
//
//  @Override
//  public void onSaveInstanceState(Bundle outState) {
//    if (dateCalendar != null)
//      outState.putLong("dateCalendar", dateCalendar.getTime().getTime());
//  }
//
//  private void findViewsById(View rootView) {
//    empNameEtxt = (EditText) rootView.findViewById(R.id.etxt_name);
//    empSalaryEtxt = (EditText) rootView.findViewById(R.id.etxt_salary);
//    empDobEtxt = (EditText) rootView.findViewById(R.id.etxt_dob);
//    empDobEtxt.setInputType(InputType.TYPE_NULL);
//
//    addButton = (Button) rootView.findViewById(R.id.button_add);
//    resetButton = (Button) rootView.findViewById(R.id.button_reset);
//  }
//  @Override
//  public void onClick(View view) {
//    if (view == empDobEtxt) {
//      datePickerDialog.show();
//    } else if (view == addButton) {
//      setEmployee();
//
//      task = new AddEmpTask(getActivity());
//      task.execute((Void) null);
//    } else if (view == resetButton) {
//      resetAllFields();
//    }
//  }
//
//  public class AddConsumptionTask extends AsyncTask<Void, Void, Long> {
//
//    private final WeakReference<Activity> activityWeakRef;
//
//    public AddComptionTask(Activity context) {
//      this.activityWeakRef = new WeakReference<Activity>(context);
//    }
//
//    @Override
//    protected Long doInBackground(Void... arg0) {
//      long result = consumptionDAO.save(consumption);
//      return result;
//    }
//
//    @Override
//    protected void onPostExecute(Long result) {
//      if (activityWeakRef.get() != null
//          && !activityWeakRef.get().isFinishing()) {
//        if (result != -1)
//          Toast.makeText(activityWeakRef.get(), "Employee Saved",
//              Toast.LENGTH_LONG).show();
//      }
//    }
//  }
}

