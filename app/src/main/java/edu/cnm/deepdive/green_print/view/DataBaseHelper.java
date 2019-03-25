package edu.cnm.deepdive.green_print.view;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DataBaseHelper extends SQLiteOpenHelper {

  public static final String CONSUMPTION_TABLE = "consumption";
  public static final String ID_COLUMN = "id";
  public static final String SCORE_COLUMN = "score";
  public static final String TIME = "time";
  public static final String CREATE_SCORE_TABLE = "CREATE TABLE "
      + CONSUMPTION_TABLE + "(" + ID_COLUMN + " INTEGER PRIMARY KEY, "
      + SCORE_COLUMN + " TEXT, "
      + TIME + " DATE" + ")";
  private static final String DATABASE_NAME = "consumptiondb";
  private static final int DATABASE_VERSION = 1;
  private static DataBaseHelper instance;

  private DataBaseHelper(Context context) {
    super(context, DATABASE_NAME, null, DATABASE_VERSION);
  }

  public static synchronized DataBaseHelper getHelper(Context context) {
    if (instance == null) {
      instance = new DataBaseHelper(context);
    }
    return instance;
  }

  @Override
  public void onOpen(SQLiteDatabase db) {
    super.onOpen(db);
  }

  @Override
  public void onCreate(SQLiteDatabase db) {
    db.execSQL(CREATE_SCORE_TABLE);
  }

  @Override
  public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
  }
}
