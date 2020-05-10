package fr.iutbourg.iotv2.data.model


import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName

@Entity(tableName = "ACTUATOR1STATE")
data class ACTUATOR1STATE(
    @PrimaryKey
    @SerializedName("actuator1StateID")
    var actuator1StateID: Int ,
    @SerializedName("ACTUATOR9_STATE")
    @Expose
    var actuatorState: Int? = null
)


@Entity(tableName = "SensorModel")
data class SensorModel(
    @PrimaryKey
    @SerializedName("sensor_id")
    var sensorID: Int,

    @SerializedName("ACTUATOR9_STATE")
    @Expose
    var actuator9State: Int? = null,

    @SerializedName("PIR1_STATE")
    @Expose
    var pir1State: Int? = null,

    @SerializedName("PIR2_STATE")
    @Expose
    var pir2State: Int? = null,

    @SerializedName("description")
    @Expose
    var description: String? = null,

    @SerializedName("sample_rate_in_sec")
    @Expose
    var sampleRateInSec: Int? = null,

    @SerializedName("titre")
    @Expose
    var titre: String? = null
) {
    @SerializedName("TEMP_INT_DHT22")
    @Expose
    @Ignore
    val temp_int_dht22: TEMPINTDHT22? = null

    @SerializedName("TEMP_OUT_DHT22")
    @Expose
    @Ignore
    val temp_out_dht22: TEMPOUTDHT22? = null

    @SerializedName("ACTUATOR1_STATE")
    @Expose
    @Ignore
    val actuator1State: ACTUATOR1STATE? = null
}

@Entity(tableName = "TEMPINTDHT22")
data class TEMPINTDHT22(
    @PrimaryKey
    @SerializedName("temp_in_dht22_id")
    var tempInDHT22ID: Int?,

    @SerializedName("humidity")
    @Expose
    var humidity: Double? = null,

    @SerializedName("temperature")
    @Expose
    var temperature: Double? = null
)

@Entity(tableName = "TEMPOUTDHT22")
data class TEMPOUTDHT22(
    @PrimaryKey
    @SerializedName("temp_out_dht22_id")
    var tempOutDHT22ID: Int?,

    @SerializedName("humidity")
    @Expose
    var humidity: Double? = null,

    @SerializedName("temperature")
    @Expose
    var temperature: Double? = null
)

data class SensorApiResponse (
    val sensor: SensorModel? =  null,
    val message: Int = 1
)