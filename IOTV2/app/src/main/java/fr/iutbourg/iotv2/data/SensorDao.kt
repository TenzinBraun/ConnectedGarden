package fr.iutbourg.iotv2.data

import androidx.lifecycle.LiveData
import androidx.room.*
import fr.iutbourg.iotv2.data.model.ACTUATOR1STATE
import fr.iutbourg.iotv2.data.model.SensorModel
import fr.iutbourg.iotv2.data.model.TEMPINTDHT22
import fr.iutbourg.iotv2.data.model.TEMPOUTDHT22

@Dao
interface SensorDao {

    @Query(ACTUATOR)
    suspend fun getActuator1STATE() : ACTUATOR1STATE

    @Query(SensorModel)
    suspend fun getSensorModel() : SensorModel

    @Query(TEMP_OUT_DHT22)
    suspend fun getTempOutDHT22() : TEMPOUTDHT22

    @Query(TEMP_INT_DHT22)
    suspend fun getTempInDHT22() : TEMPINTDHT22


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertACTUATOR1STATE(vararg actuator1STATE: ACTUATOR1STATE)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSensorModel(vararg sensorModel: SensorModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTempOutDHT22(vararg tempOutDHT22: TEMPOUTDHT22)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTempInDHT22(vararg tempInDHT22: TEMPINTDHT22)


    @Update
    suspend fun updateACTUATOR1STATE(vararg sensorsEquipment: ACTUATOR1STATE)

    @Update
    suspend fun updateSensorModel(vararg sensorsEquipment: SensorModel)

    @Update
    suspend fun updateTempOutDHT22(vararg itemSensor: TEMPOUTDHT22)

    @Update
    suspend fun updateTempInDHT22(vararg itemSensor: TEMPINTDHT22)

    companion object QueryName {
        const val ACTUATOR = "SELECT * FROM ACTUATOR1STATE"
        const val SensorModel = "SELECT * FROM SensorModel"
        const val TEMP_OUT_DHT22 = "SELECT * FROM TEMPOUTDHT22"
        const val TEMP_INT_DHT22 = "SELECT * FROM TEMPINTDHT22"
    }
}
