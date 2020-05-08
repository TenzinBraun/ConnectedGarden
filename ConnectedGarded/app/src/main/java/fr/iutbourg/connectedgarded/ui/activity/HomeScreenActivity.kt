package fr.iutbourg.connectedgarded.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.iutbourg.connectedgarded.R
import fr.iutbourg.connectedgarded.ui.fragment.OutIndoorGardenFragment
import fr.iutbourg.connectedgarded.ui.fragment.SensorsEquipmentFragment
import fr.iutbourg.connectedgarded.ui.widget.SwitchFragmentCallback
import kotlinx.android.synthetic.main.activity_home_screen.*

class HomeScreenActivity : AppCompatActivity(), SwitchFragmentCallback {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        setupFragment()
    }

    private fun setupFragment() {
        supportFragmentManager.beginTransaction()
            .add(containerID.id,OutIndoorGardenFragment(this), "TAG")
            .commit()
    }

    override fun switchToMainFragment(itemID: Any) {
        val test = ""
        supportFragmentManager.beginTransaction()
            .add(containerID.id,itemID as SensorsEquipmentFragment, "TAG")
            .addToBackStack(this.localClassName)
            .commit()
    }
}
