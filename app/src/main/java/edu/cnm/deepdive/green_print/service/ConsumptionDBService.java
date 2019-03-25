package edu.cnm.deepdive.green_print.service;

import android.support.annotation.Nullable;
import edu.cnm.deepdive.android.BaseFluentAsyncTask;
import edu.cnm.deepdive.green_print.model.ConsumptionDB;
import edu.cnm.deepdive.green_print.model.entity.Activity;
import edu.cnm.deepdive.green_print.model.entity.Consumption;
import java.util.Calendar;
import java.util.List;

/**
 * Provides a service layer for accessing te {@link ConsumptionDB} Room/SQLite database. Each
 * operation is implemented by a static nested class that extends {@link BaseFluentAsyncTask}.
 */

public final class ConsumptionDBService {

  private ConsumptionDBService(){

  }

  /**
   * Implements an asynchronous <code>INSERT</code> of an {@link Consumption} instance into the local
   * database.
   */

  public static class InsertConsumptionTask extends
      BaseFluentAsyncTask<Consumption, Void, List<Long>, List<Long>> {


    @Override
    protected List<Long> perform (Consumption... consumptions){
      return ConsumptionDB.getInstance().getConsumtionDao().insert(consumptions);
    }
  }

  /**
   * Provides a connection to the local database
   */
  public static class SelectConsumptionTask extends
      BaseFluentAsyncTask<Calendar, Void, Consumption, Consumption> {

    @Override
    protected Consumption perform(Calendar... time) {
      Consumption consumption = ConsumptionDB.getInstance()
          .getConsumtionDao()
          .findFirstByTime(time[0]);
      if (consumption == null) {
        throw new TaskException();
      }
      Activity activity = new Activity();
      activity.setConsumptionId(consumption.getId());
      ConsumptionDB.getInstance().getActivityDao().insert(activity);
      return consumption;
    }
  }

  /**
   * Implements an asynchronous <code>SELECT</code> of all {@link Consumption} instances (sorted in
   * descending date order) from the local database.
   */

  public static class SelectAllConsumptionTask
      extends BaseFluentAsyncTask<Void, Void, List<Consumption>, List<Consumption>> {

    @Override
    protected List<Consumption> perform(Void... voids) {
      return ConsumptionDB.getInstance().getConsumtionDao().findAll();
    }

  }

  /**
   * Ability to delete items from the database
   */
  public static class DeleteConsumptionTask extends
      BaseFluentAsyncTask<Consumption, Void, Void, Void> {

    @Nullable
    @Override
    protected Void perform(Consumption... consumptions) throws TaskException {
      ConsumptionDB.getInstance().getConsumtionDao().delete(consumptions);
      return null;
    }
  }

  /**
   * Ability to manually insert an {@link Activity}.
   */
  public static class InsertActivityTask extends BaseFluentAsyncTask<Activity, Void, List<Long>, List<Long>>{

    @Nullable
    @Override
    protected List<Long> perform(Activity... activities) throws TaskException {
      return ConsumptionDB.getInstance().getActivityDao().insert(activities);
    }
  }
}
