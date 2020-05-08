package fr.iutbourg.connectedgarded.ui.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import fr.iutbourg.connectedgarded.data.database.AppDatabase
import fr.iutbourg.connectedgarded.data.model.ItemSensor
import fr.iutbourg.connectedgarded.data.model.SensorsEquipment
import fr.iutbourg.connectedgarded.data.repository.SensorsEquipmentRepository

class SensorsEquipmentViewModel(private val
    repository: SensorsEquipmentRepository
) : ViewModel() {

    private fun getLocal(context: Context) =  AppDatabase.getInstance(context).sensorDao()

    fun getItemSensor(context: Context): LiveData<List<ItemSensor>> {
        return repository.getItemSensorsList(viewModelScope, getLocal(context))
    }

    fun getSensorsEquipmentList(context: Context): LiveData<List<SensorsEquipment>?> {
        return repository.getSensorsEquipmentList(viewModelScope, getLocal(context))
    }

    fun addSensor(sensorName: String, context: Context) : SensorsEquipment {
        return repository.addSensor(sensorName, viewModelScope, getLocal(context))
    }

    companion object Factory : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return SensorsEquipmentViewModel(SensorsEquipmentRepository.sensorContext) as T
        }
    }
}
