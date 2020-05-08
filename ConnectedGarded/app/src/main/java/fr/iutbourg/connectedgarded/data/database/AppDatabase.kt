package fr.iutbourg.connectedgarded.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import fr.iutbourg.connectedgarded.data.database.room.SensorsDao
import fr.iutbourg.connectedgarded.data.model.ItemSensor
import fr.iutbourg.connectedgarded.data.model.SensorsEquipment

@Database(entities = [SensorsEquipment::class, ItemSensor::class], version = 4)
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
                AppDatabase::class.java, "con.db"
            )
                .build()
    }

}