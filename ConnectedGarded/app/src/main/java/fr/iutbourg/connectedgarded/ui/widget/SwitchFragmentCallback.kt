package fr.iutbourg.connectedgarded.ui.widget

import fr.iutbourg.connectedgarded.data.model.ItemSensor
import fr.iutbourg.connectedgarded.data.model.SensorsEquipment

interface SwitchFragmentCallback {
    fun switchToMainFragment(itemID: Any)
}
