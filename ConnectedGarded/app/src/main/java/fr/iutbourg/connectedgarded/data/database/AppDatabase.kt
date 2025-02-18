package fr.iutbourg.connectedgarded.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import fr.iutbourg.connectedgarded.data.database.room.SensorsDao
import fr.iutbourg.connectedgarded.data.model.*

@Database(entities = [SensorModel::class, TEMPOUTDHT22::class, TEMPINTDHT22::class, ACTUATOR1STATE::class], exportSchema = false, version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun sensorDao(): SensorsDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase =
            INSTANCE
                ?: synchronized(this) {
                    INSTANCE
                        ?: buildDatabase(
                            context
                        ).also { INSTANCE = it }
                }

        private fun buildDatabase(context: Context) =
            Room.databaseBuilder(
                context.applicationContext,
                AppDatabase::class.java, "test.db"
            )
                .build()
    }

}