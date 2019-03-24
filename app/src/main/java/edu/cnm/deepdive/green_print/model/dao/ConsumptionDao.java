package edu.cnm.deepdive.green_print.model.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.green_print.model.entity.Consumption;
import java.util.List;

/**
 * <code>ConsumptionDao</code> is an interface needed for the relational local database.
 * Inserts one or more {@link Consumption} instances into the local database.
 *
 * @author Kevin Simms &amp; Deep Dive Coding Java + Android Bootcamp cohort 6
 * @version 1.0
 */

@Dao
public interface ConsumptionDao {


    /**
     * Inserts one or more {@link Consumption} instances into the local database.
     *
     * @param consumptions {@link Consumption} instance(s) to be inserted.
     * @return inserted record ID(s).
     *
     */


    @Insert(onConflict = OnConflictStrategy.IGNORE)
    List<Long>insert(Consumption... consumptions);

    /**
     * Selects and returns all {@link Consumption} instances in the local database, sorting the result
     * in descending date order.
     *
     * @return all {@link Consumption} instances in local database.
     */

    @Query("SELECT * FROM Consumption ORDER BY time DESC")
    List<Consumption> findAll();

    /**
     * Allows for intances of {@link Consumption} to be deleted from the local database.
     */

    @Delete
    int delete(Consumption... consumptions);


}
