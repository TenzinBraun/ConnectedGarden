package fr.iutbourg.connectedgarded.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import fr.iutbourg.connectedgarded.data.database.datasource.SensorEquipmentDataSource
import fr.iutbourg.connectedgarded.data.database.room.SensorsDao
import fr.iutbourg.connectedgarded.data.model.ItemSensor
import fr.iutbourg.connectedgarded.data.model.SensorApiResponse
import fr.iutbourg.connectedgarded.data.model.SensorModel
import fr.iutbourg.connectedgarded.data.model.SensorsEquipment
import fr.iutbourg.connectedgarded.data.networking.datasource.SensorDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


private class SensorsEquipmentRepositoryImpl : SensorsEquipmentRepository {

    override fun getSensorsEquipmentList(
        viewModelScope: CoroutineScope,
        local: SensorsDao
    ): LiveData<List<SensorsEquipment>?> {
        val data = MutableLiveData<List<SensorsEquipment>>()
        viewModelScope.launch(Dispatchers.IO) {
            val dataSource =
                SensorEquipmentDataSource(
                    local
                )
            data.postValue(dataSource.getSensorsEquipmentsList())
        }
        return data
    }

    override fun getItemSensorsList(
        viewModelScope: CoroutineScope,
        local: SensorsDao
    ): LiveData<List<ItemSensor>> {
        val data = MutableLiveData<List<ItemSensor>>()
        viewModelScope.launch(Dispatchers.IO) {
            val dataSource =
                SensorEquipmentDataSource(
                    local
                )
            data.postValue(dataSource.getItemSensorsList())
        }
        return data
    }

    override fun addSensor(
        sensorName: String,
        viewModelScope: CoroutineScope,
        local: SensorsDao) : SensorsEquipment {
        return SensorEquipmentDataSource(local).addSensorEquipement(sensorName)
    }

    override fun getSensorValues(scope: CoroutineScope): LiveData<SensorModel> {
        val data = MutableLiveData<SensorModel>()
        scope.launch(Dispatchers.IO){
            val dataSource = SensorDataSource.instance
            data.postValue(dataSource.getSensorsValues())
        }
        return data
    }

}


interface SensorsEquipmentRepository {
    fun getSensorsEquipmentList(
        viewModelScope: CoroutineScope,
        local: SensorsDao
    ): LiveData<List<SensorsEquipment>?>

    fun getItemSensorsList(
        viewModelScope: CoroutineScope,
        local: SensorsDao
    ): LiveData<List<ItemSensor>>

    fun addSensor(sensorName: String, viewModelScope: CoroutineScope, local: SensorsDao) : SensorsEquipment

    fun getSensorValues(scope: CoroutineScope): LiveData<SensorModel>

    companion object {
        /**
         * Singleton for the interface [SensorsEquipmentRepository]
         */
        val sensorContext: SensorsEquipmentRepository by lazy {
            SensorsEquipmentRepositoryImpl()
        }
    }
}


