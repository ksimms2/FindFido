package edu.cnm.deepdive.green_print.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import java.io.Serializable;
import java.util.Calendar;


/**
 * <code>Activity</code> is an entity class that represents parts in a table for
 * the relational local database. Each instance corresponds to a row in the database table.
 *
 * @author Kevin Simms &amp; Deep Dive Coding Java + Android Bootcamp cohort 6
 * @version 1.0
 */

@Entity(
    foreignKeys = @ForeignKey(entity = Consumption.class, parentColumns = "consumption_id", childColumns = "consumption_id",
        onDelete = ForeignKey.CASCADE))

public class Activity implements Serializable {


  @ColumnInfo(name = "activity_id")
  @PrimaryKey(autoGenerate = true)

  private long id;

  @ColumnInfo(name = "consumption_id", index = true)
  private long consumptionId;

  private Calendar timestamp = Calendar.getInstance();

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public long getConsumptionId() {
    return consumptionId;
  }

  public void setConsumptionId(long consumptionId) {
    this.consumptionId = consumptionId;
  }

  public Calendar getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Calendar timestamp) {
    this.timestamp = timestamp;
  }
}