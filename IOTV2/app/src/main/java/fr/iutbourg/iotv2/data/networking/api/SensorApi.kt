package fr.iutbourg.iotv2.data.networking.api

import fr.iutbourg.iotv2.data.model.SensorApiResponse
import fr.iutbourg.iotv2.data.model.SensorModel
import retrofit2.Response
import retrofit2.http.GET

interface SensorApi {
    @GET(GET_ALL_SENSORS_VALUES)
    suspend fun getAllSensorsValues() : Response<SensorModel>

    companion object {
        const val BASE_URL: String = "https://api-project-1026902595480.firebaseio.com/"

        const val GET_ALL_SENSORS_VALUES = ".json" // TODO
    }
}