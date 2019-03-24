package edu.cnm.deepdive.green_print.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import java.io.Serializable;
import java.util.Calendar;


/**
 * <code>Consumption</code> is an entity class that represents parts in a table for
 * the relational local database. Each instance corresponds to a row in the database table.
 *
 * @author Kevin Simms &amp; Deep Dive Coding Java + Android Bootcamp cohort 6
 * @version 1.0
 */

@Entity()
public class Consumption implements Serializable {


  @ColumnInfo(name = "consumption_id")
  @PrimaryKey(autoGenerate = true)
  private long id;


  @NonNull
  private Calendar time = Calendar.getInstance();

  private Float score;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  @NonNull
  public Calendar getTime() {
    return time;
  }

  public void setTime(@NonNull Calendar time) {
    this.time = time;
  }

  public Float getScore() {
    return score;
  }

  public void setScore(Float score) {
    this.score = score;
  }


}
