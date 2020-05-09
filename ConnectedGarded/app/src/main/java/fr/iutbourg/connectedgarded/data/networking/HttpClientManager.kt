package fr.iutbourg.connectedgarded.data.networking

import fr.iutbourg.connectedgarded.data.networking.api.SensorApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private object HttpClientManagerImpl: HttpClientManager{

    override val sensorRetrofit: Retrofit =
        Retrofit.Builder()
            .baseUrl(SensorApi.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
}

interface HttpClientManager {
    val sensorRetrofit: Retrofit

    companion object Instance {
        val sensorInstance: HttpClientManager = HttpClientManagerImpl
    }
}

inline fun <reified T> HttpClientManager.createApi(): T {
    return this.sensorRetrofit.create()
}