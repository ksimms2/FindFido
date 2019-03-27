package edu.cnm.deepdive.green_print.model.pojo;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;
import edu.cnm.deepdive.green_print.model.entity.Activity;
import edu.cnm.deepdive.green_print.model.entity.Consumption;
import java.util.List;


/**
 * <code>ConsumptionWithActivities</code>  defines the entity classes,
 * {@link Consumption} and {@link Activity} to declarative references to be used throughout the
 * program.
 */
public class ConsumptionWithActivities {

  @Embedded
  private Consumption consumption;

  @Relation(parentColumn = "consumption_id", entityColumn = "consumption_id")
  private List<Activity> activities;


  public Consumption getConsumption() {
    return consumption;
  }

  public void setConsumption(Consumption consumption) {
    this.consumption = consumption;
  }

  public List<Activity> getActivities() {
    return activities;
  }

  public void setActivities(List<Activity> activities) {
    this.activities = activities;
  }
}
