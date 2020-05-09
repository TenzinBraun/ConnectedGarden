package fr.iutbourg.iotv2.data

import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import fr.iutbourg.iotv2.data.model.ACTUATOR1STATE
import fr.iutbourg.iotv2.data.model.SensorModel
import fr.iutbourg.iotv2.data.model.TEMPINTDHT22
import fr.iutbourg.iotv2.data.model.TEMPOUTDHT22

interface SensorDao {

    @Query(ACTUATOR)
    fun getActuator1STATE() : ACTUATOR1STATE

    @Query(SensorModel)
    fun getSensorModel() : SensorModel

    @Query(TEMP_OUT_DHT22)
    fun getTempOutDHT22() : TEMPOUTDHT22

    @Query(TEMP_INT_DHT22)
    fun getTempInDHT22() : TEMPINTDHT22


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertACTUATOR1STATE(vararg actuator1STATE: ACTUATOR1STATE)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSensorModel(vararg sensorModel: SensorModel)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTempOutDHT22(vararg tempOutDHT22: TEMPOUTDHT22)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTempInDHT22(vararg tempInDHT22: TEMPINTDHT22)


    @Update
    fun updateACTUATOR1STATE(vararg sensorsEquipment: ACTUATOR1STATE)

    @Update
    fun updateSensorModel(vararg sensorsEquipment: SensorModel)

    @Update
    fun updateTempOutDHT22(vararg itemSensor: TEMPOUTDHT22)

    @Update
    fun updateTempInDHT22(vararg itemSensor: TEMPINTDHT22)

    companion object QueryName {
        const val ACTUATOR = ""
        const val SensorModel = ""
        const val TEMP_OUT_DHT22 = ""
        const val TEMP_INT_DHT22 = ""
    }
}
