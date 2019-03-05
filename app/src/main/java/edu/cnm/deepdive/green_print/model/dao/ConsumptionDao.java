package edu.cnm.deepdive.green_print.model.dao;


import android.arch.persistence.room.Dao;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import edu.cnm.deepdive.green_print.model.entity.Consumption;

@Dao
public interface ConsumptionDao {




    /**
     * Inserts one or more {@link Consumption} instances into the local database. Any primary or unique key
     * constraint violations will result in the existing records being retained.
     *
     * @param consumptions {@link Consumption} instance(s) to be inserted.
     * @return inserted record ID(s).
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
   public void insertConsumption(Consumption... consumptions);





}
