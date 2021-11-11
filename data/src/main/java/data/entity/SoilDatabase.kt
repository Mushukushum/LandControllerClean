package data.entity

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase


@Database(entities = [SoilCondition::class], version = 1, exportSchema = false)
abstract class SoilDatabase : RoomDatabase() {

    abstract val soilDatabaseDao: data.dao.DatabaseDao

    companion object {

        @Volatile
        private var INSTANCE: SoilDatabase? = null

        fun getInstance(context: Context): SoilDatabase {

            synchronized(this) {

                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        SoilDatabase::class.java,
                        "sleep_history_database"
                    )
                        .fallbackToDestructiveMigration()
                        .build()
                    INSTANCE = instance
                }

                return instance
            }
        }
    }
}