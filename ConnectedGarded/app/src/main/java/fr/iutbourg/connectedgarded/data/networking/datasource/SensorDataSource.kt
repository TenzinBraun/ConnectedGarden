package fr.iutbourg.connectedgarded.data.networking.datasource

import fr.iutbourg.connectedgarded.data.model.SensorApiResponse
import fr.iutbourg.connectedgarded.data.model.SensorModel
import fr.iutbourg.connectedgarded.data.networking.HttpClientManager
import fr.iutbourg.connectedgarded.data.networking.api.SensorApi
import fr.iutbourg.connectedgarded.data.networking.createApi

private class SensorDataSourceImpl (private val api: SensorApi): SensorDataSource{
    override suspend fun getSensorsValues(): SensorModel {
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

    suspend fun getSensorsValues(): SensorModel

    companion object {
        val instance: SensorDataSource by lazy {
            SensorDataSourceImpl(HttpClientManager.sensorInstance.createApi())
        }
    }
}