package fr.iutbourg.iotv2.ui.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import fr.iutbourg.iotv2.data.SensorAppDatabase
import fr.iutbourg.iotv2.data.SensorDao
import fr.iutbourg.iotv2.data.repository.SensorRepository

class SensorViewModel(
    private val repository: SensorRepository
) : ViewModel() {

    private fun getLocal(context: Context) =  SensorAppDatabase.getInstance(context).sensorDao()

    fun getActuator1STATE(context: Context) = repository.getActuator1STATE(viewModelScope, getLocal(context))
    fun getSensorModel(context: Context) = repository.getSensorModel(viewModelScope, getLocal(context))
    fun getTempOutDHT22(context: Context) = repository.getTempOutDHT22(viewModelScope, getLocal(context))
    fun getTempInTDHT22(context: Context) = repository.getTEMPINTDHT22(viewModelScope, getLocal(context))

    fun updateActuator1STATE(context: Context) = repository.updateActuator1STATE(viewModelScope, getLocal(context))
    fun updateSensorModel(context: Context) = repository.updateSensorModel(viewModelScope, getLocal(context))
    fun updateTempOutDHT22(context: Context) = repository.updateTempOutDHT22(viewModelScope, getLocal(context))
    fun updateTempInTDHT22(context: Context) = repository.updateTEMPINTDHT22(viewModelScope, getLocal(context))

    fun insertActuator1STATE(context: Context) = repository.insertActuator1STATE(viewModelScope, getLocal(context))
    fun insertSensorModel(context: Context) = repository.insertSensorModel(viewModelScope, getLocal(context))
    fun insertTempOutDHT22(context: Context) = repository.insertTempOutDHT22(viewModelScope, getLocal(context))
    fun insertTempInTDHT22(context: Context) = repository.insertTEMPINTDHT22(viewModelScope, getLocal(context))

  fun sensor() = repository.getSensorsValues(viewModelScope)

    companion object Factory : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return SensorViewModel(SensorRepository.sensorContext) as T
        }
    }
}