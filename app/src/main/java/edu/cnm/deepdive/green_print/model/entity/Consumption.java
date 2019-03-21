package edu.cnm.deepdive.green_print.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
//import com.google.gson.annotations.Expose;
//import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Calendar;


@Entity()


 public class Consumption implements Serializable {


  @ColumnInfo(name = "consumption_id")
  @PrimaryKey(autoGenerate = true)
  private long id;






  @NonNull
 // @Expose
  private Calendar time = Calendar.getInstance();
 // @Expose
  private Float score;

  public long getId(){
    return id;
  }

  public void setId(long id) {
    this.id=id;
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

  public void setScore(Float score){
    this.score = score;
    }


    //TODO make a time stamp category



}
