package edu.cnm.deepdive.green_print.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import java.io.Serializable;


@Entity(
    foreignKeys = @ForeignKey(entity = Consumption.class, parentColumns = "consumption_id", childColumns = "consumption_id",
        onDelete = ForeignKey.CASCADE))

 public class Activity implements Serializable {


  @ColumnInfo(name = "activity_id")
  @PrimaryKey(autoGenerate = true)

  private long id;

  @ColumnInfo(name = "consumption_id", index = true)
  private long consumptionId;




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


}