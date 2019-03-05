package edu.cnm.deepdive.green_print.model;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import edu.cnm.deepdive.green_print.model.dao.ActivityDao;
import edu.cnm.deepdive.green_print.model.dao.ConsumptionApplication;
import edu.cnm.deepdive.green_print.model.dao.ConsumptionDao;
import edu.cnm.deepdive.green_print.model.entity.Activity;
import edu.cnm.deepdive.green_print.model.entity.Consumption;


@Database(
    entities = {Activity.class, Consumption.class},
    version = 1,
    exportSchema = true
)


//@TypeConverters(Converters.class)
public abstract class ConsumptionDB extends RoomDatabase {

    private static final String DB_NAME = "apod_db";

    /**
     * Returns the single instance of {@link ConsumptionDao} for the current application context.
     *
     * @return single {@link ConsumptionDao} instance reference.
     */
    public synchronized static ConsumptionDB getInstance() {
      return InstanceHolder.INSTANCE;
    }

    /**
     * Returns an instance of a Room-generated implementation of {@link ConsumptionDao}.
     *
     * @return data access object for CRUD operations involving {@link Activity} instances.
     */
    public abstract ConsumptionDao getConsumtionDao();

    public abstract ActivityDao getActivityDao();

    private static class InstanceHolder {

      private static final ConsumptionDB INSTANCE = Room.databaseBuilder(
          ConsumptionApplication.getInstance().getApplicationContext(), ConsumptionDB.class, DB_NAME)
          .build();

    }

      /**
       * Supports conversion operations for persistence of relevant types not natively supported by
       * Room/SQLite.
       */

}
