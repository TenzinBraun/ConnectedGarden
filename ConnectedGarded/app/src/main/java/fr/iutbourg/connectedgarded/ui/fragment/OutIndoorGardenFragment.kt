package fr.iutbourg.connectedgarded.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import fr.iutbourg.connectedgarded.R
import fr.iutbourg.connectedgarded.ui.widget.SwitchFragmentCallback
import kotlinx.android.synthetic.main.fragment_outindoor_garden.view.*

enum class AppEntry{
    INDOOR,
    OUTDOOR
}

class OutIndoorGardenFragment(private val callback: SwitchFragmentCallback) : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_outindoor_garden, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.outdoorGarden.setOnClickListener {
            callback.switchToMainFragment(SensorsEquipmentFragment())
        }

        view.indoorGarden.setOnClickListener {
            callback.switchToMainFragment(SensorsEquipmentFragment())
        }
    }
}