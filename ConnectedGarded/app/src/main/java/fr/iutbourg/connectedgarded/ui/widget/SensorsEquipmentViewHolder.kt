package fr.iutbourg.connectedgarded.ui.widget

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.iutbourg.connectedgarded.R
import fr.iutbourg.connectedgarded.data.model.ItemSensor
import fr.iutbourg.connectedgarded.data.model.SensorsEquipment
import kotlinx.android.synthetic.main.card_view_sensors_equipment_holder.view.*

class SensorsEquipmentViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView)  {

    fun bindViewHolder(sensorsEquipment: SensorsEquipment){
        itemView.picture_sensor.setImageDrawable(sensorsEquipment.drawable)
        itemView.labelSensors.text = sensorsEquipment.sensorName
    }

    companion object {
        /**
         * Create a new Instance of [SensorsEquipmentViewHolder]
         */
        fun create(parent: ViewGroup): SensorsEquipmentViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(
                R.layout.card_view_sensors_equipment_holder,
                parent,
                false
            )
            return SensorsEquipmentViewHolder(view)
        }
    }
}
