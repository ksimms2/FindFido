package edu.cnm.deepdive.green_print.controller;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;
import edu.cnm.deepdive.green_print.R;


/**
 * <code>MainActivity</code> activates the side drawer menu {@link NavigationView} to show one of 2
 * main {@link android.support.v4.app.Fragment} instances. It also responds to clicks on a single
 * options {@link MenuItem} and displays the fragment on the screen
 *
 * @author Kevin Simms &amp; Deep Dive Coding Java + Android Bootcamp cohort 6
 * @version 1.0
 */

public class MainActivity extends AppCompatActivity
    implements NavigationView.OnNavigationItemSelectedListener {


  //private ImageFragment imageFragment;
  private UpdateFragment updateFragment;
  private ProgressBar loading;
  private DrawerLayout navigation;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(edu.cnm.deepdive.green_print.R.layout.activity_main);
    Toolbar toolbar = findViewById(edu.cnm.deepdive.green_print.R.id.toolbar);
    setSupportActionBar(toolbar);

    DrawerLayout drawer = findViewById(edu.cnm.deepdive.green_print.R.id.drawer_layout);
    ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
        this, drawer, toolbar, edu.cnm.deepdive.green_print.R.string.navigation_drawer_open,
        edu.cnm.deepdive.green_print.R.string.navigation_drawer_close);
    drawer.addDrawerListener(toggle);
    toggle.syncState();

    NavigationView navigationView = findViewById(edu.cnm.deepdive.green_print.R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this);

    loadHomeFragment();

  }

  /**
   * Loads the HomeFragment on startup.
   */
  private void loadHomeFragment() {

    Fragment fragmentHome = new HomeFragment();
    FragmentManager manager = getSupportFragmentManager();
    FragmentTransaction transaction = manager.beginTransaction();
    transaction.add(R.id.fragment_container, fragmentHome, "home");
    transaction.addToBackStack(null);
    transaction.commit();

  }


  @Override
  public void onBackPressed() {
    DrawerLayout drawer = findViewById(edu.cnm.deepdive.green_print.R.id.drawer_layout);
    if (drawer.isDrawerOpen(GravityCompat.START)) {
      drawer.closeDrawer(GravityCompat.START);
    } else {
      super.onBackPressed();
    }
  }

  /**
   * Inflate the menu; this adds items to the action bar if it is present.
   *
   * @param menu items for action bar
   * @return items form the action bar
   */
  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    getMenuInflater().inflate(edu.cnm.deepdive.green_print.R.menu.main, menu);
    return true;
  }

  /**
   * Handle action bar item clicks here. The action bar will automatically handle clicks on the
   * HomeFragment/Up button, so long as you specify a parent activity in AndroidManifest.xml.
   */

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {

    int id = item.getItemId();

    if (id == edu.cnm.deepdive.green_print.R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }

  //  private void setupFragments(Bundle savedInstanceState) {
//    navigation = findViewById(R.id.nav_view);
//    //navigation.setOnNavigationItemSelectedListener(this);
//    FragmentService fragmentService = FragmentService.getInstance();
//    if (savedInstanceState == null) {
//      surveyFragment = new SurveyFragment();
//      fragmentService.loadFragment(this, R.id.fragment_container, imageFragment,
//          imageFragment.getClass().getSimpleName(), true);
//      historyFragment = new HistoryFragment();
//      fragmentService.loadFragment(this, R.id.fragment_container, updateFragment,
//          updateFragment.getClass().getSimpleName(), false);
//    } else {
//      imageFragment = (ImageFragment) fragmentService.findFragment(
//          this, R.id.fragment_container, ImageFragment.class.getSimpleName());
//      updateFragment = (UpdateFragment) fragmentService.findFragment(
//          this, R.id.fragment_container, UpdateFragment.class.getSimpleName());
//    }
//    surveyFragment.setHistoryFragment(updateFragment);
//    UpdateFragment.setSurveyFragment(surveyFragment);
//  }
  public DrawerLayout getNavigation() {
    return navigation;
  }

  /**
   * Implements navigation to other fragments once clicked.
   *
   * @param item available fragments in menu bar
   * @return the fragment selected
   */
  @Override
  public boolean onNavigationItemSelected(MenuItem item) {

    switch (item.getItemId()) {
      case R.id.fragment_home:
        loadFragment(new HomeFragment(), R.id.fragment_container, "HomeFragment", null);
        break;
      case R.id.fragment_questions:
        loadFragment(new SurveyFragment(), R.id.fragment_container, "SurveyFragment", null);
        break;
      case R.id.fragment_score:
        loadFragment(new ScoreFragment(), R.id.fragment_container, "ScoreFragment", null);
        break;
//      case R.id.fragment_update:
//        loadFragment(new UpdateFragment(), R.id.fragment_container, "UpdateFragment", null);
//        break;

    }

    DrawerLayout drawer = findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
  }


  private void loadFragment(Fragment fragment, int container, String tag, Bundle args) {
    FragmentManager manager = getSupportFragmentManager();
    if (args != null) {
      fragment.setArguments(args);
    }
    manager.beginTransaction()
        .add(container, fragment, tag)
        .commit();

  }


}
