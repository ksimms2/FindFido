package edu.cnm.deepdive.green_print.model.dao;

import android.app.Application;


public class ConsumptionApplication extends Application{


    private static ConsumptionApplication instance = null;

    @Override
    public void onCreate() {
      super.onCreate();
      instance = this;
     // Stetho.initializeWithDefaults(this); // Comment out this line to disable Stetho.
    }

    /**
     * Returns this instance, for access to application context across the app.
     *
     * @return singleton instance.
     */
    public static ConsumptionApplication getInstance() {
      return instance;
    }

  }


