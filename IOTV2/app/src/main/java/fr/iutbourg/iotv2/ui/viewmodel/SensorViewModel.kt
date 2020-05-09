package fr.iutbourg.iotv2.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import fr.iutbourg.iotv2.data.repository.SensorRepository

class SensorViewModel(private val
    repository: SensorRepository
): ViewModel(){

    val sensor = repository.getSensorsValues(viewModelScope)

    companion object Factory : ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return SensorViewModel(SensorRepository.sensorContext) as T
        }
    }
}