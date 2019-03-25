package edu.cnm.deepdive.green_print.model.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;
import java.util.Calendar;


/**
 * <code>Consumption</code> is an entity class that represents parts in a table for
 * the relational local database. Each instance corresponds to a row in the database table.
 *
 * @author Kevin Simms &amp; Deep Dive Coding Java + Android Bootcamp cohort 6
 * @version 1.0
 */

@Entity()
public class Consumption {




  @ColumnInfo(name = "consumption_id")
  @PrimaryKey(autoGenerate = true)
  private Long fie_id;



  @NonNull
  private Calendar time = Calendar.getInstance();

  private Float score;


  public Long getFie_id() {
    return fie_id;
  }

  public void setFie_id(Long fie_id) {
    this.fie_id = fie_id;
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

//  public Consumption() {
//    super();
//  }
//
//  private Consumption(Parcel in) {
//    super();
//    this.fie_id = in.readInt();
//    this.score = in.readFloat();
//    //this.time = new Calendar(in.readLong()) {};
//
//  }
//  @Override
//  public String toString() {
//    return "Consumption [fie_id=" + fie_id + ", score=" + score + " ]";
//  }
//
//  @Override
//  public int hashCode() {
//    final int prime = 31;
//    int result = 1;
//    result = prime * result + fie_id;
//    return result;
//  }

//  @Override
//  public boolean equals(Object obj) {
//    if (this == obj)
//      return true;
//    if (obj == null)
//      return false;
//    if (getClass() != obj.getClass())
//      return false;
//    Consumption other = (Consumption) obj;
//    if (fie_id != other.fie_id)
//      return false;
//    return true;
//  }

//  @Override
//  public int describeContents() {
//    return 0;
//  }
//
//  @Override
//  public void writeToParcel(Parcel parcel, int flags) {
//    parcel.writeLong(getFie_Id());
//    parcel.writeFloat(getScore());
//
//  }
//
//  public static final Parcelable.Creator<Consumption> CREATOR = new Parcelable.Creator<Consumption>() {
//    public Consumption createFromParcel(Parcel in) {
//      return new Consumption(in);
//    }
//
//    public Consumption[] newArray(int size) {
//      return new Consumption[size];
//    }
//  };
//
//  public static Creator<Consumption> getCREATOR() {
//    return CREATOR;
//  }
}
