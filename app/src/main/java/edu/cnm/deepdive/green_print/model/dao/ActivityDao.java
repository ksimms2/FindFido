package edu.cnm.deepdive.green_print.model.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.green_print.model.entity.Activity;
import edu.cnm.deepdive.green_print.model.entity.Consumption;
import java.util.List;

@Dao
public interface ActivityDao {




    @Insert(onConflict = OnConflictStrategy.IGNORE)
    List<Long> insert(Activity... activities);




   @Insert
   List<Long> insert(List<Activity> activities);
//
//    @Query
//        ("SELECT * FROM ACTIVITY")
//
//    List<Activity> findAll();
  }
