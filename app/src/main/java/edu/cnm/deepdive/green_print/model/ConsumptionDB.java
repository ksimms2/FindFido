package edu.cnm.deepdive.green_print.model;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverter;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.Nullable;
import edu.cnm.deepdive.green_print.CC_APIApplication;
import edu.cnm.deepdive.green_print.model.ConsumptionDB.Converters;
import edu.cnm.deepdive.green_print.model.dao.ActivityDao;
import edu.cnm.deepdive.green_print.model.dao.ConsumptionDao;
import edu.cnm.deepdive.green_print.model.entity.Activity;
import edu.cnm.deepdive.green_print.model.entity.Consumption;
import java.util.Calendar;
import java.util.Date;


@Database(
    entities = {Activity.class, Consumption.class},
    version = 1,
    exportSchema = true
)

@TypeConverters(Converters.class)
public abstract class ConsumptionDB extends RoomDatabase {

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
   * @return data access object for CRUD operations involving {@link Activity} instances.
   */
  public abstract ConsumptionDao getConsumtionDao();

  public abstract ActivityDao getActivityDao();

  private static class InstanceHolder {

    private static final ConsumptionDB INSTANCE = Room.databaseBuilder(
        CC_APIApplication.getInstance().getApplicationContext(), ConsumptionDB.class, DB_NAME)
        .build();

  }

  public static class Converters {

    private static final String JOIN_DELIMITER = "|";
    private static final String SPLIT_DELIMITER = "\\|";


    @TypeConverter
    public static String stringArrayToString(String[] values) {
      StringBuilder builder = new StringBuilder();
      for (String value : values) {
        builder.append(value);
        builder.append(JOIN_DELIMITER);
      }

      builder.deleteCharAt(builder.length() - 1);
      return builder.toString();

    }

    @TypeConverter
    public static String[] stringToStringArray(String value) {
      return value.split(SPLIT_DELIMITER);

    }

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

/**
 * Supports conversion operations for persistence of relevant types not natively supported by
 * Room/SQLite.
 */


