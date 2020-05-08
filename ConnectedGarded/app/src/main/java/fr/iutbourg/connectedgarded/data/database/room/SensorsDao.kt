package fr.iutbourg.connectedgarded.data.database.room

import androidx.room.*
import fr.iutbourg.connectedgarded.data.model.ItemSensor
import fr.iutbourg.connectedgarded.data.model.SensorsEquipment

@Dao
interface SensorsDao {
    @Query("SELECT * FROM sensor_equipment")
    fun getAllSensorsEquipments(): List<SensorsEquipment>

    @Query("SELECT * FROM item_sensor")
    fun getAllItemSensor(): List<ItemSensor>


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertSensorEquipment(vararg sensorsEquipment: SensorsEquipment)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertItemSensor(vararg users: ItemSensor)

    @Update
    fun updateSensorEquipment(vararg sensorsEquipment: SensorsEquipment)

    @Update
    fun updateItemSensor(vararg itemSensor: ItemSensor)


    @Delete
    fun delete(user: SensorsEquipment)
}