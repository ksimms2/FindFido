package edu.cnm.deepdive.green_print.service;

import android.support.annotation.Nullable;
import edu.cnm.deepdive.green_print.model.ConsumptionDB;
import edu.cnm.deepdive.green_print.model.entity.Activity;
import edu.cnm.deepdive.green_print.model.entity.Consumption;
import edu.cnm.deepdive.green_print.service.BaseFluentAsyncTask.TaskException;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public final class ConsumptionDBService {

  private ConsumptionDBService(){

  }

  public static class InsertConsumptionTask extends
      BaseFluentAsyncTask<Consumption, Void, List<Long>, List<Long>> {
    private boolean foreground;

    public InsertConsumptionTask(boolean foreground) {
      this.foreground = foreground;
    }

    @Override
    protected List<Long> perform (Consumption... consumptions){
      List<Long> consumptionIds = ConsumptionDB.getInstance().getConsumtionDao().insert(consumptions);
      if(foreground){
        List<Activity> activities = new LinkedList<>();

        for(long id : consumptionIds){
          Activity activity = new Activity();
          activity.setConsumptionId(id);
          activities.add(activity);
        }
        ConsumptionDB.getInstance().getActivityDao().insert(activities);
      }
      return consumptionIds;
    }
  }
                                                                    //this is Date in Apod, but mine is time?
  public static class SelectConsumptionTask extends BaseFluentAsyncTask<Calendar, Void, Consumption, Consumption>{
//   @Override
//   protected Consumption perform(Calendar... time) {
//     Consumption consumption = ConsumptionDB.getInstance().getConsumptionDao().findFirstByTime(time);
//     if(consumption == null){
//       throw new TaskException();
//     }
//     Activity activity = new Activity();
//     activity.setConsumptionId(consumption.getId());
//     ConsumptionDB.getInstance().getActivityDao().insert(activity);
//     return consumption;
//   }
  }


  public static class SelectAllConsumptionTask
      extends BaseFluentAsyncTask<Void, Void, List<Consumption>, List<Consumption>> {

    @Override
    protected List<Consumption> perform(Void... voids) {
      return ConsumptionDB.getInstance().getConsumtionDao().findAll();
    }

  }

  public static class DeleteApodTask extends BaseFluentAsyncTask<Consumption, Void, Void, Void>{

    @Nullable
    @Override
    protected Void perform(Consumption... consumptions) throws TaskException {
      ConsumptionDB.getInstance().getConsumtionDao().delete(consumptions);
      return null;
    }
  }
  public static class InsertActivityTask extends BaseFluentAsyncTask<Activity, Void, List<Long>, List<Long>>{

  @Nullable
  @Override
  protected List<Long> perform(Activity... activities) throws TaskException {
    return ConsumptionDB.getInstance().getActivityDao().insert(activities);
  }
}
}
