package fr.iutbourg.iotv2.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import fr.iutbourg.iotv2.data.model.ACTUATOR1STATE
import fr.iutbourg.iotv2.data.model.SensorModel
import fr.iutbourg.iotv2.data.model.TEMPINTDHT22
import fr.iutbourg.iotv2.data.model.TEMPOUTDHT22

@Database(entities = [SensorModel::class, TEMPOUTDHT22::class, TEMPINTDHT22::class, ACTUATOR1STATE::class], exportSchema = true, version = 1)
abstract class SensorAppDatabase : RoomDatabase() {
    abstract fun sensorDao(): SensorDao

    companion object {
        @Volatile
        private var INSTANCE: SensorAppDatabase? = null

        fun getInstance(context: Context): SensorAppDatabase =
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
                    SensorAppDatabase::class.java, "testIOTDB.db"
                )
                .build()
    }

}