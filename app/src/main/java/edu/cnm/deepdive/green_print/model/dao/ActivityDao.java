package edu.cnm.deepdive.green_print.model.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.green_print.model.entity.Activity;
import java.util.List;

@Dao
public interface ActivityDao {




    @Insert
    List<Long> insert(Activity... activity);


    @Insert
    List<Long> insert(List<Activity> activity);

    @Query
        ("SELECT * FROM ACTIVITY")

    List<Activity> findAll();
  }
