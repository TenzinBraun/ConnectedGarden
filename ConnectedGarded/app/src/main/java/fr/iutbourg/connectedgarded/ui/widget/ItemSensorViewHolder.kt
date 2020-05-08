package fr.iutbourg.connectedgarded.ui.widget

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.iutbourg.connectedgarded.R
import fr.iutbourg.connectedgarded.data.model.ItemSensor
import kotlinx.android.synthetic.main.card_view_item_sensor_holder.view.*

class ItemSensorViewHolder private constructor(itemView: View) : RecyclerView.ViewHolder(itemView)  {

    fun bindViewHolder(itemSensor: ItemSensor){
        itemView.pictureItems.setImageDrawable(itemSensor.drawable)
        itemView.labelItems.text = itemSensor.itemName
    }

    companion object {
        /**
         * Create a new Instance of [SensorsEquipmentViewHolder]
         */
        fun create(parent: ViewGroup): ItemSensorViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(
                R.layout.card_view_item_sensor_holder,
                parent,
                false
            )
            return ItemSensorViewHolder(view)
        }
    }
}

