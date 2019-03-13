package edu.cnm.deepdive.green_print.controller;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.Button;
import edu.cnm.deepdive.green_print.R;


public abstract class LinkedFragment extends Fragment {


  private Button mainMenuButton;





  protected void loadHomeFragment() {

    Fragment fragmentHome = new HomeFragment();

    FragmentManager manager = getFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.add(R.id.fragment_container, fragmentHome ,"home" );
    transaction.addToBackStack(null);
    transaction.commit();

  }



  protected View linkButton(View view) {

    mainMenuButton = (Button) view.findViewById(R.id.retake_survey_button);

    mainMenuButton.setOnClickListener(new View.OnClickListener() {



      @Override

      public void onClick(View view) {

        loadHomeFragment();

      }



    });

    return view;

  }

}
