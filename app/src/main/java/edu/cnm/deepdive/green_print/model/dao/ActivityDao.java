package edu.cnm.deepdive.green_print.model.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import edu.cnm.deepdive.green_print.model.entity.Activity;
import java.util.List;


/**
 * <code>ActivityDao</code> is an interface needed for the relational local database.
 * Inserts one or more {@link Activity} instances into the local database.
 *
 * @author Kevin Simms &amp; Deep Dive Coding Java + Android Bootcamp cohort 6
 * @version 1.0
 */

@Dao
public interface ActivityDao {


  @Insert(onConflict = OnConflictStrategy.IGNORE)
  List<Long> insert(Activity... activities);


}
