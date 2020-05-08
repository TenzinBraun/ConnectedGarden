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
import fr.iutbourg.connectedgarded.data.model.SensorsEquipment
import fr.iutbourg.connectedgarded.ui.adapter.SensorsEquipmentAdapter
import fr.iutbourg.connectedgarded.ui.dialog.AddSensorEquipmentDialog
import fr.iutbourg.connectedgarded.ui.viewmodel.SensorsEquipmentViewModel
import fr.iutbourg.connectedgarded.ui.widget.MyCallback
import fr.iutbourg.connectedgarded.ui.widget.SwitchFragmentCallback
import kotlinx.android.synthetic.main.fragment_sensors_equipment.*
import kotlinx.android.synthetic.main.fragment_sensors_equipment.view.*

class SensorsEquipmentFragment : Fragment(), SwitchFragmentCallback, MyCallback {

    private lateinit var sensorsEquipmentViewModel: SensorsEquipmentViewModel
    private lateinit var sensorsEquipmentAdapter: SensorsEquipmentAdapter
    private lateinit var sensorsEquipmentList: List<SensorsEquipment>

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
        return inflater.inflate(R.layout.fragment_sensors_equipment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sensorsEquipmentAdapter = SensorsEquipmentAdapter(this)

        view.recyclerViewImage.layoutManager = GridLayoutManager(activity, 2)
        view.recyclerViewImage.adapter = sensorsEquipmentAdapter

        addSensor.setOnClickListener {
            val addSensorEquipmentDialog = AddSensorEquipmentDialog(requireContext(), requireActivity(), sensorsEquipmentViewModel, this)
            addSensorEquipmentDialog.show()
        }

        sensorsEquipmentViewModel.getSensorsEquipmentList(requireContext())
            .observe(this) {
                it?.let { sensorEquipment ->
                    this.sensorsEquipmentList = sensorEquipment
                    sensorsEquipmentAdapter.submitList(sensorEquipment)
                }
            }

    }

    override fun switchToMainFragment(itemID: Any) {
        activity!!.supportFragmentManager
            .beginTransaction()
            .add(InfoSensorFragment(), "TAG")
            .commit()
    }

    override fun submit(addSensor: SensorsEquipment) {
        val templist = sensorsEquipmentList as MutableList
        templist.add(addSensor)
        sensorsEquipmentList = templist
        sensorsEquipmentAdapter.submitList(sensorsEquipmentList)
    }
}
