package fr.iutbourg.iotv2.data.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import fr.iutbourg.iotv2.data.model.SensorApiResponse
import fr.iutbourg.iotv2.data.model.SensorModel
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

}


interface SensorRepository {
    fun getSensorsValues(
        viewModelScope: CoroutineScope
    ): LiveData<SensorModel>

    companion object {
        val sensorContext: SensorRepository by lazy {
            SensorRepositoryImpl()
        }
    }
}