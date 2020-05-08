package fr.iutbourg.connectedgarded.ui.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.iutbourg.connectedgarded.data.model.ItemSensor
import fr.iutbourg.connectedgarded.ui.widget.ItemSensorViewHolder
import fr.iutbourg.connectedgarded.ui.widget.SwitchFragmentCallback

class ItemSensorAdapter(itemSensors: List<ItemSensor>, callback: SwitchFragmentCallback): RecyclerView.Adapter<ItemSensorViewHolder>() {

    private var sensorsEquipmentList = itemSensors
    private val switchFragmentCallback = callback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemSensorViewHolder {
        return ItemSensorViewHolder.create(parent)
    }

    override fun getItemCount(): Int {
        return sensorsEquipmentList.size
    }

    override fun onBindViewHolder(holder: ItemSensorViewHolder, position: Int) {
        val item = sensorsEquipmentList[position]
        holder.bindViewHolder(item)
        holder.itemView.setOnClickListener{
            switchFragmentCallback.switchToMainFragment(item)
        }
    }

    fun submitList(sensorEquipment: List<ItemSensor>) {
        this.sensorsEquipmentList = sensorEquipment
    }

}
