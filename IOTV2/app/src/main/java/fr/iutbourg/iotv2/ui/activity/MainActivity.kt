package fr.iutbourg.iotv2.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.observe
import fr.iutbourg.iotv2.R
import fr.iutbourg.iotv2.ui.viewmodel.SensorViewModel
import java.lang.IllegalStateException
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var sensorViewModel: SensorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.run {
            sensorViewModel = ViewModelProvider(this, SensorViewModel).get()
        } ?: throw IllegalStateException("Invalid access")

        sensorViewModel.sensor.observe(this) {
            it.let {
                it.sensor.let {
                    if (it != null) {
                        it.temp_int_dht22.let {
                            this.value_humidity_IN.text = it.humidity.toString()
                            this.value_temperature_IN.text = it.temperature.toString()
                        }
                        it.temp_out_dht22.let {
                            this.value_temperature_OUT.text = it.temperature.toString()
                            this.value_humidity_OUT.text = it.humidity.toString()
                        }
                        this.value_pir1.text = it.pir1State.toString()
                        this.value_pir2.text = it.pir2State.toString()
                    }
                }
            }
        }
    }
}
