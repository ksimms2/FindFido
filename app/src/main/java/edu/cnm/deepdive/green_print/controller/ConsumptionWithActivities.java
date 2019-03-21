package edu.cnm.deepdive.green_print.controller;

import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Relation;
import edu.cnm.deepdive.green_print.model.entity.Activity;
import edu.cnm.deepdive.green_print.model.entity.Consumption;
import java.util.List;

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
