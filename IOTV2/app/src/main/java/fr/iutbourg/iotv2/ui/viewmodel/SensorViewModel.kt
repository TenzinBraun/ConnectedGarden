package fr.iutbourg.iotv2.ui.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import fr.iutbourg.iotv2.data.repository.SensorRepository

class SensorViewModel(private val
    repository: SensorRepository
): ViewModel(){

    val sensor = repository.getSensorsValues(viewModelScope)

}