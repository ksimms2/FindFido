package edu.cnm.deepdive.green_print.controller;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import edu.cnm.deepdive.green_print.R;


public abstract class LinkedFragment extends Fragment {


  /**
   * <code>LinkedFragment</code> provides a link to load the {@link HomeFragment} within
   * other fragments.
   */

  private void loadHomeFragment() {

    Fragment fragmentHome = new HomeFragment();

    FragmentManager manager = getFragmentManager();
    assert manager != null;
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.add(R.id.fragment_container, fragmentHome, "home");
    transaction.addToBackStack(null);
    transaction.commit();

  }


  protected View linkButton(View view) {

    Button retakeSurvey = view.findViewById(R.id.retake_survey_button);
    retakeSurvey.setOnClickListener(view1 -> loadHomeFragment());

    return view;

  }


}
