package fr.iutbourg.connectedgarded.ui.dialog

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.FragmentActivity
import fr.iutbourg.connectedgarded.R
import fr.iutbourg.connectedgarded.ui.viewmodel.SensorsEquipmentViewModel
import fr.iutbourg.connectedgarded.ui.widget.MyCallback
import kotlinx.android.synthetic.main.add_sensor_equipment_dialog.*

class AddSensorEquipmentDialog(
    context: Context,
    private var activity: FragmentActivity,
    private var viewModel: SensorsEquipmentViewModel,
    private var callback : MyCallback
) :
    BaseDialog(context, activity) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        this.window?.setBackgroundDrawableResource(android.R.color.transparent)
        setContentView(R.layout.add_sensor_equipment_dialog)
        addSensorEquipment.setOnClickListener {
            callback.submit(viewModel.addSensor(sensorName.text.toString(), context))
            this.dismiss()
        }
        setSizeForDialog()
    }
}