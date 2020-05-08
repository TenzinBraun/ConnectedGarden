package fr.iutbourg.connectedgarded.data.database.datasource

import fr.iutbourg.connectedgarded.data.database.room.SensorsDao
import fr.iutbourg.connectedgarded.data.model.ItemSensor
import fr.iutbourg.connectedgarded.data.model.SensorsEquipment

class SensorEquipmentDataSource(private val sensorsDao: SensorsDao) {
    fun getSensorsEquipmentsList(): List<SensorsEquipment>? {
        val response = sensorsDao.getAllSensorsEquipments()
        return if (response.isNotEmpty()) {
            response
        } else {
            null
        }
    }

    fun getItemSensorsList(): List<ItemSensor>? {
        val response = sensorsDao.getAllItemSensor()
        return if (response.isNotEmpty()) {
            response
        } else {
            null
        }
    }

    fun addSensorEquipement(sensorName: String) : SensorsEquipment {
        val sensorsEquipment =  SensorsEquipment(0, sensorName)
        sensorsDao.insertSensorEquipment(sensorsEquipment)
        return sensorsEquipment
    }
}

