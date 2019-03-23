package edu.cnm.deepdive.green_print.model.dao;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import edu.cnm.deepdive.green_print.model.entity.Consumption;
import java.util.List;

@Dao
public interface ConsumptionDao {

  /**
   * Alt-Enter on interface name
   * check both boxes in JUnit4
   * use android testing.
   *
   * This will run on emulator
   * Will make it's own test.
   *
   * Go to ApodDaoTest
   * and make private variables
   * and context the same.
   *    Context context = InstrumentationRegistry.getTargetContext();
   *     apodDB = Room.inMemoryDatabaseBuilder(context, ApodDB.class).build();
   *     apodDao = apodDB.getApodDao();
   *
   *     tearDown()
   *     apodDB.close() starts clean every time
   *
   *     JUnit 4 uses more public
   *
   *     insert()
   *     make new Apod (Consumption)
   *
   *     apodDao.insert(apod) puts test in DB
   *
   *     Run test class
   *
   *  New test Select test
   *
   *  select is probably what you would use...
   *  selects by dates and title.. maybe dont have dates
   *
   *  Export mode on the test shows the tests in HTML
   *
   *  Delete return ints that are equal to the number of time deletes
   *
   *  Lambda....
   *
   * Have to override equals in the Apod entity
   */



    /**
     * Inserts one or more {@link Consumption} instances into the local database. Any primary or unique key
     * constraint violations will result in the existing records being retained.
     *
     * @param consumptions {@link Consumption} instance(s) to be inserted.
     * @return inserted record ID(s).
     */
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    List<Long>insert(Consumption... consumptions);


   // @Query("SELECT * FROM Consumption ORDER BY time DESC")
    //List<Consumption> findFirstByTime(Calendar time);

    @Query("SELECT * FROM Consumption ORDER BY time DESC")
    List<Consumption> findAll();

    @Delete
    int delete(Consumption... consumptions);


}
