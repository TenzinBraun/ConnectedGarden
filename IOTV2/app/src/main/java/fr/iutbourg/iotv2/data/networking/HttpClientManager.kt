package fr.iutbourg.iotv2.data.networking

import fr.iutbourg.iotv2.BuildConfig
import fr.iutbourg.iotv2.data.networking.api.SensorApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

private object HttpClientManagerImpl: HttpClientManager{

    private val client: OkHttpClient =
        OkHttpClient.Builder()
            .apply {
                if (BuildConfig.DEBUG)
                    this.addInterceptor(HttpLoggingInterceptor().apply {
                        this.level = HttpLoggingInterceptor.Level.BODY
                    })
            }
            .build()

    override val sensorRetrofit: Retrofit =
        Retrofit.Builder()
            .baseUrl(SensorApi.BASE_URL)
            .client(client)
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