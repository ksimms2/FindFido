package edu.cnm.deepdive.green_print.controller;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import edu.cnm.deepdive.green_print.R;

/**
 * <code>HomeFragment</code> displays Logo and welcome on startup.
 *
 * @author Kevin Simms &amp; Deep Dive Coding Java + Android Bootcamp cohort 6
 * @version 1.0
 */

public class HomeFragment extends LinkedFragment {


  public HomeFragment() {
    // Required empty public constructor
  }

  /**
   * <code>OnCreateView</code> launches the UI for the home screen. Calls on the
   * <code>R.layout.fragment_home</code>, which presents the .xml UI design.
   *
   * @param inflater loads UI
   * @param container uses the set container for the group
   * @param savedInstanceState Saves the instance created
   * @return displays the UI on the screen
   */

  @Override
  public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    return inflater.inflate(R.layout.fragment_home, container, false);
  }


}
