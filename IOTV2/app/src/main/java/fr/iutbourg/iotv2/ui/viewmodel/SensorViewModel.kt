package fr.iutbourg.iotv2.ui.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import fr.iutbourg.iotv2.data.SensorAppDatabase
import fr.iutbourg.iotv2.data.model.ACTUATOR1STATE
import fr.iutbourg.iotv2.data.model.SensorModel
import fr.iutbourg.iotv2.data.model.TEMPINTDHT22
import fr.iutbourg.iotv2.data.model.TEMPOUTDHT22
import fr.iutbourg.iotv2.data.repository.SensorRepository

class SensorViewModel(
    private val repository: SensorRepository
) : ViewModel() {

    private fun getLocal(context: Context) = SensorAppDatabase.getInstance(context).sensorDao()
    fun getActuator1STATE(context: Context) =
        repository.getActuator1STATE(viewModelScope, getLocal(context))

    fun getSensorModel(context: Context) =
        repository.getSensorModel(viewModelScope, getLocal(context))

    fun getTempOutDHT22(context: Context) =
        repository.getTempOutDHT22(viewModelScope, getLocal(context))

    fun getTempInTDHT22(context: Context): LiveData<TEMPINTDHT22?> =
        repository.getTEMPINTDHT22(viewModelScope, getLocal(context))

    fun updateActuator1STATE(context: Context, it: ACTUATOR1STATE) =
        repository.updateActuator1STATE(viewModelScope, getLocal(context), it)

    fun updateSensorModel(
        context: Context,
        it: SensorModel
    ) = repository.updateSensorModel(viewModelScope, getLocal(context), it)

    fun updateTempOutDHT22(
        context: Context,
        it: TEMPOUTDHT22
    ) = repository.updateTempOutDHT22(viewModelScope, getLocal(context), it)

    fun updateTempInTDHT22(
        context: Context,
        it: TEMPINTDHT22
    ) = repository.updateTEMPINTDHT22(viewModelScope, getLocal(context), it)

    fun insertActuator1STATE(context: Context, it: ACTUATOR1STATE) =
        repository.insertActuator1STATE(viewModelScope, getLocal(context), it)

    fun insertSensorModel(context: Context, it: SensorModel?) =
        repository.insertSensorModel(viewModelScope, getLocal(context), it)

    fun insertTempOutDHT22(context: Context, it: TEMPOUTDHT22?) =
        repository.insertTempOutDHT22(viewModelScope, getLocal(context), it)

    fun insertTempInTDHT22(context: Context, it: TEMPINTDHT22?) =
        repository.insertTEMPINTDHT22(viewModelScope, getLocal(context), it)

    fun sensor() = repository.getSensorsValues(viewModelScope)

    companion object Factory : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return SensorViewModel(SensorRepository.sensorContext) as T
        }
    }
}