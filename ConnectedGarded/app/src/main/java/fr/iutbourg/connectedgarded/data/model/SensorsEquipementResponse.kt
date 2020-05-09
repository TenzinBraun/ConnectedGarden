package fr.iutbourg.connectedgarded.data.model

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


data class ACTUATOR1STATE(
    @SerializedName("ACTUATOR9_STATE")
    @Expose
    var aCTUATOR9STATE: Int? = null
)

data class SensorModel(
    @SerializedName("ACTUATOR1_STATE")
    @Expose
    var aCTUATOR1STATE: ACTUATOR1STATE? = null,

    @SerializedName("ACTUATOR9_STATE")
    @Expose
    var aCTUATOR9STATE: Int? = null,

    @SerializedName("PIR1_STATE")
    @Expose
    var pIR1STATE: Int? = null,

    @SerializedName("PIR2_STATE")
    @Expose
    var pIR2STATE: Int? = null,

    @SerializedName("TEMP_INT_DHT22")
    @Expose
    var tEMPINTDHT22: TEMPINTDHT22? = null,

    @SerializedName("TEMP_OUT_DHT22")
    @Expose
    var tEMPOUTDHT22: TEMPOUTDHT22? = null,

    @SerializedName("description")
    @Expose
    var description: String? = null,

    @SerializedName("sample_rate_in_sec")
    @Expose
    var sampleRateInSec: Int? = null,

    @SerializedName("titre")
    @Expose
    var titre: String? = null
)

data class TEMPINTDHT22(
    @SerializedName("humidity")
    @Expose
    var humidity: Double? = null,

    @SerializedName("temperature")
    @Expose
    var temperature: Double? = null

)

data class TEMPOUTDHT22(
    @SerializedName("humidity")
    @Expose
    var humidity: Double? = null,

    @SerializedName("temperature")
    @Expose
    var temperature: Int? = null
)

data class SensorApiResponse (
    val sensor: SensorModel? =  null,
    val message: Int = 1
)