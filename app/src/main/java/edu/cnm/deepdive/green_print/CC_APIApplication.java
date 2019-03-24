package edu.cnm.deepdive.green_print;

import android.app.Application;
import com.facebook.stetho.Stetho;


/**
 * Extends {@link Application}, in order to initialize <a href="http://facebook.github.io/stetho/">Stetho</a>
 * inspection and set up access to this instance via the singleton pattern. At runtime, any instance
 * of an {@link Application} subclass is used a singleton; {@link #getInstance()} implementation is
 * used here to enable access to the singleton by other classes in the app.
 */

public class CC_APIApplication extends Application {


  private static CC_APIApplication instance = null;


  @Override

  public void onCreate() {

    super.onCreate();
    instance = this;
    Stetho.initializeWithDefaults(this); // Comment out this line to disable Stetho.

  }


  /**
   * Returns this instance, for access to application context across the app.
   *
   * @return singleton instance.
   */

  public static CC_APIApplication getInstance() {

    return instance;

  }

}
