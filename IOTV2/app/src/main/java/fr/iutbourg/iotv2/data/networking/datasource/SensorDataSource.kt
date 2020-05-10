package fr.iutbourg.iotv2.data.networking.datasource

import fr.iutbourg.iotv2.data.model.SensorApiResponse
import fr.iutbourg.iotv2.data.networking.HttpClientManager
import fr.iutbourg.iotv2.data.networking.api.SensorApi
import fr.iutbourg.iotv2.data.networking.createApi

private class SensorDataSourceImpl (private val api: SensorApi): SensorDataSource{
    override suspend fun getSensorsValues(): SensorApiResponse {
        val response = api.getAllSensorsValues()
        return if (response.isSuccessful) {
            val sensor = response.body()
            SensorApiResponse(sensor)
        } else {
            SensorApiResponse(message = 0)
        }
    }

}

interface SensorDataSource {

    suspend fun getSensorsValues(): SensorApiResponse

    companion object {
        val instance: SensorDataSource by lazy {
            SensorDataSourceImpl(HttpClientManager.sensorInstance.createApi())
        }
    }
}