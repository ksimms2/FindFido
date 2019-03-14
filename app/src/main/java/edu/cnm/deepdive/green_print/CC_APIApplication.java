package edu.cnm.deepdive.green_print;

import android.app.Application;
import com.facebook.stetho.Stetho;

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
