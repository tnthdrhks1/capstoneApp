package nodomain.freeyourgadget.gadgetbridge.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import nodomain.freeyourgadget.gadgetbridge.GBApplication
import nodomain.freeyourgadget.gadgetbridge.R
import nodomain.freeyourgadget.gadgetbridge.activities.charts.ChartsActivity
import nodomain.freeyourgadget.gadgetbridge.activities.charts.LiveActivityFragment
import nodomain.freeyourgadget.gadgetbridge.devices.DeviceManager
import nodomain.freeyourgadget.gadgetbridge.impl.GBDevice
import nodomain.freeyourgadget.gadgetbridge.util.DateTimeUtils
import java.util.*

class MainActivity_test : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_test)

//        var editTextMain : EditText = findViewById(R.id.EditText_main)
        var buttonMain = findViewById<Button>(R.id.Button_main_sj)

        var deviceManager: DeviceManager? = null
        deviceManager = (application as GBApplication).deviceManager

        var deviceList: List<GBDevice> = deviceManager.devices
        var device = deviceList[0]

        deviceList.forEach{
            println(it.name)
            if(it.name == "MI Band 2") device = it
        }

        for(i in 0..10) println(device.name)

        val startIntent  = Intent(this, ChartsActivity::class.java)
        startIntent.putExtra(GBDevice.EXTRA_DEVICE, device)

        val DiscoveryIntent  = Intent(this, DiscoveryActivity::class.java)
        DiscoveryIntent.putExtra(GBDevice.EXTRA_DEVICE, device)

        if (device.isInitialized  || device.isConnected) {

        } else {
            GBApplication.deviceService().connect(device)
        }

        buttonMain.setOnClickListener(object : View.OnClickListener {

            override fun onClick(v: View?) {
                setFrag()

            }
        })
    }
    private fun setFrag(){
        val ft = supportFragmentManager.beginTransaction()
        ft.replace(R.id.FrameHeartrate, LiveActivityFragment()).commit()
    }
}