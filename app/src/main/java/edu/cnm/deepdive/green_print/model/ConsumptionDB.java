package edu.cnm.deepdive.green_print.model;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;
import edu.cnm.deepdive.green_print.CC_APIApplication;
import edu.cnm.deepdive.green_print.model.ConsumptionDB.Converters;
import edu.cnm.deepdive.green_print.model.dao.ActivityDao;
import edu.cnm.deepdive.green_print.model.dao.ConsumptionDao;
import edu.cnm.deepdive.green_print.model.entity.Activity;
import edu.cnm.deepdive.green_print.model.entity.Consumption;
import edu.cnm.deepdive.green_print.view.DataBaseHelper;
import java.util.Calendar;


/**
 * Uses a singleton pattern to implement a single app-wide connection by defining the local database
 * assembled by its entities and converters. Asserts methods to obtain data access objects (DAOs)
 * for the database entities.
 *
 * @author Kevin Simms &amp; Deep Dive Coding Java + Android Bootcamp cohort 6
 * @version 1.0
 */

@Database(
    entities = {Activity.class, Consumption.class},
    version = 1,
    exportSchema = true
)

@TypeConverters(Converters.class)
public abstract class ConsumptionDB extends RoomDatabase {

  protected SQLiteDatabase database;
  private DataBaseHelper dbHelper;
  private Context dbContext;

  private static final String DB_NAME = "consumption_db";

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
   * @return data access object for CRUD operations involving {@link Consumption} instances.
   */
  public abstract ConsumptionDao getConsumptionDao();

  public abstract ActivityDao getActivityDao();

  private static class InstanceHolder {

    private static final ConsumptionDB INSTANCE = Room.databaseBuilder(
        CC_APIApplication.getInstance().getApplicationContext(), ConsumptionDB.class, DB_NAME)
        .build();

  }

  public void open() throws SQLException {
    if (dbHelper == null) {
      dbHelper = DataBaseHelper.getHelper(dbContext);
    }
    database = dbHelper.getWritableDatabase();
  }

//  public ConsumptionDB(Context context) {
//    this.dbContext = context;
//    dbHelper = DataBaseHelper.getHelper(dbContext);
//    open();
//
//  }

  /**
   * Supports conversion operations for persistence of relevant types not natively supported by
   * Room/SQLite.
   */


  public static class Converters {


    /**
     * Converts a Long value containing the number of milliseconds since the start of the Unix epoch
     * (1970-01-01 00:00:00.000 UTC) to an instance of {@link Calendar}, and returns the latter.
     *
     * @param milliseconds date-time as a number of milliseconds since the start of the Unix epoch.
     * @return date-time as a {@link Calendar} instance.
     */

    @Nullable
    @TypeConverter
    public static Calendar calendarFromLong(@Nullable Long milliseconds) {
      if (milliseconds != null) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliseconds);
        return calendar;
      }
      return null;
    }

    /**
     * Converts a {@link Calendar} date-time value number of milliseconds since the start of the
     * Unix epoch (1970-01-01 00:00:00.000 UTC), and returns the latter.
     *
     * @param calendar date-time as a {@link Calendar} instance.
     * @return date-time as a number of milliseconds since the start of the Unix epoch.
     */
    @Nullable
    @TypeConverter
    public static Long longFromCalendar(@Nullable Calendar calendar) {
      return (calendar != null) ? calendar.getTimeInMillis() : null;
    }

  }
}



