package fr.iutbourg.connectedgarded.ui.widget

import fr.iutbourg.connectedgarded.data.model.SensorsEquipment

interface MyCallback {
    fun submit(addSensor: SensorsEquipment)
}
