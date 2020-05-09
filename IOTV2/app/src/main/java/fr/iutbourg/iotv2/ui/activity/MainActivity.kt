package fr.iutbourg.iotv2.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import fr.iutbourg.iotv2.R
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}