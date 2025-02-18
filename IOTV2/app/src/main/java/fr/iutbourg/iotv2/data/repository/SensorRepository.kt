package fr.iutbourg.iotv2.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import fr.iutbourg.iotv2.data.model.SensorApiResponse
import fr.iutbourg.iotv2.data.SensorDao
import fr.iutbourg.iotv2.data.model.*
import fr.iutbourg.iotv2.data.networking.datasource.SensorDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class SensorRepositoryImpl : SensorRepository {

    override fun getSensorsValues(
        viewModelScope: CoroutineScope
    ): LiveData<SensorApiResponse> {
        val data = MutableLiveData<SensorApiResponse>()
        viewModelScope.launch(Dispatchers.IO) {
            val dataSource = SensorDataSource.instance
            data.postValue(dataSource.getSensorsValues())
        }
        return data
    }

    override fun getActuator1STATE(
        viewModelScope: CoroutineScope,
        dao: SensorDao
    ): LiveData<ACTUATOR1STATE?> {
        val data = MutableLiveData<ACTUATOR1STATE>()
        viewModelScope.launch(Dispatchers.IO) {
            data.postValue(dao.getActuator1STATE())
        }
        return data
    }

    override fun getSensorModel(
        viewModelScope: CoroutineScope,
        local: SensorDao
    ): LiveData<SensorModel?> {
        val data = MutableLiveData<SensorModel>()
        viewModelScope.launch(Dispatchers.IO) {
            data.postValue(local.getSensorModel())
        }
        return data
    }

    override fun getTempOutDHT22(
        viewModelScope: CoroutineScope,
        local: SensorDao
    ): LiveData<TEMPOUTDHT22?> {
        val data = MutableLiveData<TEMPOUTDHT22>()
        viewModelScope.launch(Dispatchers.IO) {
            data.postValue(local.getTempOutDHT22())
        }
        return data
    }

    override fun getTEMPINTDHT22(
        viewModelScope: CoroutineScope,
        local: SensorDao
    ): LiveData<TEMPINTDHT22?> {
        val data = MutableLiveData<TEMPINTDHT22>()
        viewModelScope.launch(Dispatchers.IO) {
            data.postValue(local.getTempInDHT22())
        }
        return data
    }

    override fun updateActuator1STATE(
        viewModelScope: CoroutineScope,
        local: SensorDao,
        actuator1STATE: ACTUATOR1STATE
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            local.updateACTUATOR1STATE(actuator1STATE)
        }
    }

    override fun updateSensorModel(
        viewModelScope: CoroutineScope,
        local: SensorDao,
        sensorModel: SensorModel
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            sensorModel.sensorID = 0

            local.updateSensorModel(sensorModel)
        }
    }

    override fun updateTempOutDHT22(
        viewModelScope: CoroutineScope,
        local: SensorDao,
        tempoutdhT22: TEMPOUTDHT22
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            tempoutdhT22.tempOutDHT22ID = 0
            local.updateTempOutDHT22(tempoutdhT22)
        }
    }

    override fun updateTEMPINTDHT22(
        viewModelScope: CoroutineScope,
        local: SensorDao,
        tempintdhT22: TEMPINTDHT22
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            tempintdhT22.tempInDHT22ID = 0
            local.updateTempInDHT22(tempintdhT22)
        }
    }

    override fun insertActuator1STATE(
        viewModelScope: CoroutineScope,
        local: SensorDao,
        actuator1STATE: ACTUATOR1STATE
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            local.insertACTUATOR1STATE(actuator1STATE)
        }
    }

    override fun insertSensorModel(
        viewModelScope: CoroutineScope,
        local: SensorDao,
        sensorModel: SensorModel?
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            if (sensorModel != null) {
                local.insertSensorModel(sensorModel)
            }
        }
    }

    override fun insertTempOutDHT22(
        viewModelScope: CoroutineScope,
        local: SensorDao,
        tempoutdhT22: TEMPOUTDHT22?
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            if (tempoutdhT22 != null) {
                local.insertTempOutDHT22(tempoutdhT22)
            }
        }
    }

    override fun insertTEMPINTDHT22(
        viewModelScope: CoroutineScope,
        local: SensorDao,
        tempintdhT22: TEMPINTDHT22?
    ) {
        viewModelScope.launch(Dispatchers.IO) {
            if (tempintdhT22 != null) {
                local.insertTempInDHT22(tempintdhT22)
            }
        }
    }

}


interface SensorRepository {
    fun getSensorsValues(
        viewModelScope: CoroutineScope
    ): LiveData<SensorApiResponse>

    fun getActuator1STATE(viewModelScope: CoroutineScope, dao: SensorDao): LiveData<ACTUATOR1STATE?>
    fun getSensorModel(viewModelScope: CoroutineScope, local: SensorDao): LiveData<SensorModel?>
    fun getTempOutDHT22(viewModelScope: CoroutineScope, local: SensorDao): LiveData<TEMPOUTDHT22?>
    fun getTEMPINTDHT22(viewModelScope: CoroutineScope, local: SensorDao): LiveData<TEMPINTDHT22?>

    fun insertTempOutDHT22(
        viewModelScope: CoroutineScope,
        local: SensorDao,
        tempoutdhT22: TEMPOUTDHT22?
    )

    fun insertTEMPINTDHT22(
        viewModelScope: CoroutineScope,
        local: SensorDao,
        tempintdhT22: TEMPINTDHT22?
    )

    fun insertSensorModel(
        viewModelScope: CoroutineScope,
        local: SensorDao,
        sensorModel: SensorModel?
    )

    fun insertActuator1STATE(
        viewModelScope: CoroutineScope,
        local: SensorDao,
        actuator1STATE: ACTUATOR1STATE
    )

    fun updateTEMPINTDHT22(
        viewModelScope: CoroutineScope,
        local: SensorDao,
        tempintdhT22: TEMPINTDHT22
    )

    fun updateTempOutDHT22(
        viewModelScope: CoroutineScope,
        local: SensorDao,
        tempoutdhT22: TEMPOUTDHT22
    )

    fun updateSensorModel(
        viewModelScope: CoroutineScope,
        local: SensorDao,
        sensorModel: SensorModel
    )

    fun updateActuator1STATE(
        viewModelScope: CoroutineScope,
        local: SensorDao,
        actuator1STATE: ACTUATOR1STATE
    )

    companion object {
        val sensorContext: SensorRepository by lazy {
            SensorRepositoryImpl()
        }
    }

}