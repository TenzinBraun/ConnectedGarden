package fr.iutbourg.iotv2.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import fr.iutbourg.iotv2.data.SensorDao
import fr.iutbourg.iotv2.data.model.*
import fr.iutbourg.iotv2.data.networking.datasource.SensorDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SensorRepositoryImpl: SensorRepository {

    override fun getSensorsValues(
        viewModelScope: CoroutineScope
    ): LiveData<SensorModel> {
        val data = MutableLiveData<SensorApiResponse>()
        viewModelScope.launch(Dispatchers.IO) {
            val dataSource = SensorDataSource.instance
            data.postValue(dataSource.getSensorsValues())
        }
    }

    override fun getActuator1STATE(viewModelScope: CoroutineScope, dao: SensorDao): ACTUATOR1STATE {
        TODO("Not yet implemented")
    }

    override fun getSensorModel(viewModelScope: CoroutineScope, local: SensorDao): SensorModel {
        TODO("Not yet implemented")
    }

    override fun getTempOutDHT22(viewModelScope: CoroutineScope, local: SensorDao): TEMPOUTDHT22 {
        TODO("Not yet implemented")
    }

    override fun getTEMPINTDHT22(viewModelScope: CoroutineScope, local: SensorDao): TEMPINTDHT22 {
        TODO("Not yet implemented")
    }

    override fun updateActuator1STATE(
        viewModelScope: CoroutineScope,
        local: SensorDao
    ): ACTUATOR1STATE {
        TODO("Not yet implemented")
    }

    override fun updateSensorModel(viewModelScope: CoroutineScope, local: SensorDao): SensorModel {
        TODO("Not yet implemented")
    }

    override fun updateTempOutDHT22(
        viewModelScope: CoroutineScope,
        local: SensorDao
    ): TEMPOUTDHT22 {
        TODO("Not yet implemented")
    }

    override fun updateTEMPINTDHT22(
        viewModelScope: CoroutineScope,
        local: SensorDao
    ): TEMPINTDHT22 {
        TODO("Not yet implemented")
    }

    override fun insertActuator1STATE(
        viewModelScope: CoroutineScope,
        local: SensorDao
    ): ACTUATOR1STATE {
        TODO("Not yet implemented")
    }

    override fun insertSensorModel(viewModelScope: CoroutineScope, local: SensorDao): SensorModel {
        TODO("Not yet implemented")
    }

    override fun insertTempOutDHT22(
        viewModelScope: CoroutineScope,
        local: SensorDao
    ): TEMPOUTDHT22 {
        TODO("Not yet implemented")
    }

    override fun insertTEMPINTDHT22(
        viewModelScope: CoroutineScope,
        local: SensorDao
    ): TEMPINTDHT22 {
        TODO("Not yet implemented")
    }

}


interface SensorRepository {
    fun getSensorsValues(
        viewModelScope: CoroutineScope
    ): LiveData<SensorModel>

    fun getActuator1STATE(viewModelScope: CoroutineScope, dao: SensorDao): ACTUATOR1STATE
    fun getSensorModel(viewModelScope: CoroutineScope, local: SensorDao): SensorModel
    fun getTempOutDHT22(viewModelScope: CoroutineScope, local: SensorDao): TEMPOUTDHT22
    fun getTEMPINTDHT22(viewModelScope: CoroutineScope, local: SensorDao): TEMPINTDHT22
    fun updateActuator1STATE(viewModelScope: CoroutineScope, local: SensorDao): ACTUATOR1STATE
    fun updateSensorModel(viewModelScope: CoroutineScope, local: SensorDao): SensorModel
    fun updateTempOutDHT22(viewModelScope: CoroutineScope, local: SensorDao): TEMPOUTDHT22
    fun updateTEMPINTDHT22(viewModelScope: CoroutineScope, local: SensorDao): TEMPINTDHT22
    fun insertActuator1STATE(viewModelScope: CoroutineScope, local: SensorDao): ACTUATOR1STATE
    fun insertSensorModel(viewModelScope: CoroutineScope, local: SensorDao): SensorModel
    fun insertTempOutDHT22(viewModelScope: CoroutineScope, local: SensorDao): TEMPOUTDHT22
    fun insertTEMPINTDHT22(viewModelScope: CoroutineScope, local: SensorDao): TEMPINTDHT22

    companion object {
        val sensorContext: SensorRepository by lazy {
            SensorRepositoryImpl()
        }
    }
}