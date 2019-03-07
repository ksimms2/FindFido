package edu.cnm.deepdive.green_print.controller;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import edu.cnm.deepdive.green_print.R;

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(edu.cnm.deepdive.green_print.R.layout.activity_main);
    Toolbar toolbar = (Toolbar) findViewById(edu.cnm.deepdive.green_print.R.id.toolbar);
    setSupportActionBar(toolbar);

    FloatingActionButton fab = (FloatingActionButton) findViewById(edu.cnm.deepdive.green_print.R.id.fab);
    fab.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view) {
        Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
            .setAction("Action", null).show();
      }
    });

    //API_KEY
    String api_id = "d6f58a93";
    String api_key = "0a16fb60fa68e7fdd7551231dd01a736";
    String url = "https://api-central.berkeley.edu/api/11";
    String delimeter = "?";
    String apiEndPt = "https://apis.berkeley.edu/coolclimate/footprint-sandbox";

    //C02 calculator
    //vehicle type
    //vehicle year
    //vehicle make
    // vehicle model
    // vehicle annual mileage
    // description of use of vehicle
    //travel by train,bus,taxi, ferry
    // how many times a week do you travel by train,bus,taxi,ferry
    // estimate using gallons of fuel
    //// gallons used in a year
    // zipcode
    //electricity
    //natural gas
    // heating oil
    // propane
    //gasoline
    //diesel




    DrawerLayout drawer = (DrawerLayout) findViewById(edu.cnm.deepdive.green_print.R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, edu.cnm.deepdive.green_print.R.string.navigation_drawer_open, edu.cnm.deepdive.green_print.R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = (NavigationView) findViewById(edu.cnm.deepdive.green_print.R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);

    Fragment fragmentHome = new HomeFragment();

    FragmentManager manager = getSupportFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.add(R.id.fragment_container, fragmentHome ,"home" );
    transaction.addToBackStack(null);
    transaction.commit();

  }

  @Override
  public void onBackPressed() {
    DrawerLayout drawer = (DrawerLayout) findViewById(edu.cnm.deepdive.green_print.R.id.drawer_layout);
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(edu.cnm.deepdive.green_print.R.menu.main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the HomeFragment/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == edu.cnm.deepdive.green_print.R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  @SuppressWarnings("StatementWithEmptyBody")
  @Override
  public boolean onNavigationItemSelected(MenuItem item) {
//    // Handle navigation view item clicks here.
//    int id = item.getItemId();
//
//    if (id == edu.cnm.deepdive.green_print.R.id.home) {
//      // Handle the camera action
//    } else if (id == edu.cnm.deepdive.green_print.R.id.profile) {
//
//    } else if (id == edu.cnm.deepdive.green_print.R.id.details) {
//
//    } else if (id == edu.cnm.deepdive.green_print.R.id.nav_notify) {
//
//    } else if (id == edu.cnm.deepdive.green_print.R.id.nav_tips) {
//
//    } else if (id == edu.cnm.deepdive.green_print.R.id.nav_send) {
//
//    }
    Bundle args = new Bundle();
    switch(item.getItemId()){
      case R.id.fragment_home:
        loadFragment(new HomeFragment(), R.id.fragment_container, "HomeFragment", null);
        break;
      case R.id.fragment_questions:
        loadFragment(new SurveyFragment(), R.id.fragment_container, "SurveyFragment", null);
        break;
      case R.id.fragment_score:
        loadFragment(new ScoreFragment(), R.id.fragment_container, "ScoreFragment", null);
        break;

//      case R.id.fragment_2a:
//        args.putString(Fragment2.BODY_TEXT_KEY, "");

    }

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }

  public void loadFragment(Fragment fragment, int container, String tag, Bundle args) {
    FragmentManager manager = getSupportFragmentManager();
    if (args != null){
      fragment.setArguments(args);
    }
    manager.beginTransaction()
        .add(container, fragment, tag)
        .commit();

  }
}
