package fr.iutbourg.connectedgarded.ui.adapter
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import fr.iutbourg.connectedgarded.data.model.SensorsEquipment
import fr.iutbourg.connectedgarded.ui.widget.SensorsEquipmentViewHolder
import fr.iutbourg.connectedgarded.ui.widget.SwitchFragmentCallback

class SensorsEquipmentAdapter(callback: SwitchFragmentCallback): RecyclerView.Adapter<SensorsEquipmentViewHolder>() {

    private var sensorsEquipementList = emptyList<SensorsEquipment>()
    private val switchFragmentCallback = callback

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SensorsEquipmentViewHolder {
        return SensorsEquipmentViewHolder.create(parent)
    }

    override fun getItemCount(): Int {
        return sensorsEquipementList.size
    }

    override fun onBindViewHolder(holder: SensorsEquipmentViewHolder, position: Int) {
        val item = sensorsEquipementList[position]
        holder.bindViewHolder(item)
        holder.itemView.setOnClickListener{
            switchFragmentCallback.switchToMainFragment(item.sensor_ID)
        }
    }

    fun submitList(sensorEquipment: List<SensorsEquipment>) {
        this.sensorsEquipementList = sensorEquipment
    }

}
