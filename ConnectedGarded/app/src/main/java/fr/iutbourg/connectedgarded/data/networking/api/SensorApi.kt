package fr.iutbourg.connectedgarded.data.networking.api

import fr.iutbourg.connectedgarded.data.model.SensorApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface SensorApi {

    @GET(GET_ALL_SENSORS_VALUES)
    suspend fun getAllSensorsValues(

    ) : Response<SensorApiResponse>

    companion object {
        const val BASE_URL: String = "https://api-project-1026902595480.firebaseio.com/.json"

        const val GET_ALL_SENSORS_VALUES = "" // TODO
    }
}