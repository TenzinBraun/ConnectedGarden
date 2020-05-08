package fr.iutbourg.connectedgarded.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import fr.iutbourg.connectedgarded.R
import fr.iutbourg.connectedgarded.data.model.ItemSensor
import fr.iutbourg.connectedgarded.data.model.SensorsEquipment
import fr.iutbourg.connectedgarded.ui.adapter.ItemSensorAdapter
import fr.iutbourg.connectedgarded.ui.viewmodel.SensorsEquipmentViewModel
import fr.iutbourg.connectedgarded.ui.widget.SwitchFragmentCallback
import kotlinx.android.synthetic.main.fragment_item_sensor.view.*
import kotlinx.android.synthetic.main.fragment_sensors_equipment.view.*

class InfoSensorFragment() : Fragment(), SwitchFragmentCallback {

    private lateinit var sensorsEquipmentViewModel: SensorsEquipmentViewModel
    private lateinit var itemSensorAdapter: ItemSensorAdapter
    private lateinit var itemSensors: List<ItemSensor>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activity?.run {
            sensorsEquipmentViewModel = ViewModelProvider(this, SensorsEquipmentViewModel).get()
        } ?: throw IllegalStateException("Invalid Activity")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_item_sensor, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        itemSensorAdapter = ItemSensorAdapter(itemSensors, this)

        view.recyclerImageView.layoutManager = GridLayoutManager(activity, 2)
        view.recyclerViewImage.adapter = itemSensorAdapter

        sensorsEquipmentViewModel.getItemSensor(requireContext())
            .observe(this) {
                it.let { itemSensors ->
                    this.itemSensors = itemSensors
                    itemSensorAdapter.submitList(itemSensors)
                }
            }
    }

    override fun switchToMainFragment(itemID: Any) {
        activity!!.supportFragmentManager
            .beginTransaction()
            .add(DetailItemSensorFragment(itemID as ItemSensor), "TAG")
            .commit()
    }

}
