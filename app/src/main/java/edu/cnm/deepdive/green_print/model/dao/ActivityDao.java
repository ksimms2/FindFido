package edu.cnm.deepdive.green_print.model.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import edu.cnm.deepdive.green_print.model.entity.Activity;
import java.util.List;

@Dao
public interface ActivityDao {




    @Insert
    List<Long> insert(Activity... activity);





  }
