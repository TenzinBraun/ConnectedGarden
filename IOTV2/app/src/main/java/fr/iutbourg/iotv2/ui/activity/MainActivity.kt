package fr.iutbourg.iotv2.ui.activity

import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.lifecycle.observe
import fr.iutbourg.iotv2.R
import fr.iutbourg.iotv2.ui.viewmodel.SensorViewModel
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private lateinit var sensorViewModel: SensorViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.run {
            sensorViewModel = ViewModelProvider(this, SensorViewModel).get()
        }
        loadData()

        swipe_refresher.setOnRefreshListener {
            loadData()
            swipe_refresher.isRefreshing = false

        }
    }

    private fun loadData() {
        if ((getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager).activeNetworkInfo != null && (getSystemService(
                Context.CONNECTIVITY_SERVICE
            ) as ConnectivityManager).activeNetworkInfo.isConnected
        )
            loadDataWithInternet()
        else
            loadStoredData()
    }

    private fun loadStoredData() {
        sensorViewModel.getSensorModel(this).observe(this) {
            it?.let { sensorModel ->
                this.value_pir1.text = sensorModel.pir1State.toString()
                this.value_pir2.text = sensorModel.pir2State.toString()
            }
        }
        sensorViewModel.getTempOutDHT22(this).observe(this) {
            it?.let { tempOut ->
                this.value_temperature_OUT.text = tempOut.temperature.toString()
                this.value_humidity_OUT.text = tempOut.humidity.toString()
            }
        }
        sensorViewModel.getTempInTDHT22(this).observe(this) {
            it?.let { tempint ->
                this.value_humidity_IN.text = tempint.humidity.toString()
                this.value_temperature_IN.text = tempint.temperature.toString()
            }
        }
    }

    private fun loadDataWithInternet() {
        sensorViewModel.sensor().observe(this) { response ->
            response.let { sensorApi ->
                sensorApi.sensor.let { sensorModel ->
                    if (sensorModel != null) {
                        sensorViewModel.getSensorModel(applicationContext)
                            .observe(this@MainActivity) {
                                if (it == null) {
                                    sensorViewModel.insertSensorModel(
                                        applicationContext,
                                        sensorModel
                                    )
                                } else {
                                    sensorViewModel.updateSensorModel(
                                        applicationContext,
                                        sensorModel
                                    )
                                }
                            }
                        sensorModel.temp_int_dht22?.let { tempint ->
                            this.value_humidity_IN.text = tempint.humidity.toString()
                            this.value_temperature_IN.text = tempint.temperature.toString()
                            sensorViewModel.getTempInTDHT22(applicationContext)
                                .observe(this@MainActivity) {
                                    if (it == null) {
                                        sensorViewModel.insertTempInTDHT22(
                                            applicationContext,
                                            tempint
                                        )
                                    } else {
                                        sensorViewModel.updateTempInTDHT22(
                                            applicationContext,
                                            tempint
                                        )
                                    }
                                }
                        }
                        sensorModel.temp_out_dht22?.let { tempOut ->
                            this.value_temperature_OUT.text = tempOut.temperature.toString()
                            this.value_humidity_OUT.text = tempOut.humidity.toString()
                            sensorViewModel.getTempOutDHT22(applicationContext)
                                .observe(this@MainActivity) {
                                    if (it == null) {
                                        sensorViewModel.insertTempOutDHT22(
                                            applicationContext,
                                            tempOut
                                        )
                                    } else {
                                        sensorViewModel.updateTempOutDHT22(
                                            applicationContext,
                                            tempOut
                                        )
                                    }
                                }
                        }
                        this.value_pir1.text = sensorModel.pir1State.toString()
                        this.value_pir2.text = sensorModel.pir2State.toString()
                    }
                }
            }
        }
    }
}
