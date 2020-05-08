package fr.iutbourg.connectedgarded.data.model

import android.graphics.drawable.Drawable
import androidx.room.*
import com.google.gson.annotations.SerializedName

@Entity
data class SensorsEquipementResponse(
    @PrimaryKey
    val uid: Int,
    @Ignore
    val errorCode: Int
)



@Entity(tableName = "item_sensor")
data class ItemSensor(
    @PrimaryKey(autoGenerate = true) @SerializedName("item_ID")
    val item_ID: Int,
    @SerializedName("item_name") val itemName: String
)
{
    @Ignore
    val drawable: Drawable? = null
}
@Entity(tableName = "sensor_equipment")
data class SensorsEquipment(
    @PrimaryKey(autoGenerate = true) @SerializedName("sensor_ID")
    var sensor_ID: Int,
    @SerializedName("sensor_name") var sensorName: String
){
    @Ignore
    val drawable: Drawable? = null
}