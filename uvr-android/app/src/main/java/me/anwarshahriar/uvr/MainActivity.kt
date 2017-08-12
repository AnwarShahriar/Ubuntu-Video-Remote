package me.anwarshahriar.uvr

import android.app.AlertDialog
import android.content.DialogInterface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Button
import android.widget.EditText
import com.androidnetworking.AndroidNetworking

class MainActivity : AppCompatActivity() {
  val IP_ADDR_KEY = "KEY_IP_ADDR"

  val toggleVideoButton: Button by lazy { findViewById<Button>(R.id.toggle_video_button) }
  val nextVideoButton: Button by lazy { findViewById<Button>(R.id.forward_video_button) }
  val shutdownButton: Button by lazy { findViewById<Button>(R.id.shutdown_button) }
  val ipAddressField: EditText by lazy { findViewById<EditText>(R.id.ip_address_field) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    toggleVideoButton.setOnClickListener {
      val IP = ipAddressField.text
      AndroidNetworking.get("http://${IP}:3000/toggle")
          .build()
          .getAsString(null);
    }

    nextVideoButton.setOnClickListener {
      val IP = ipAddressField.text
      AndroidNetworking.get("http://${IP}:3000/forward")
          .build()
          .getAsString(null);
    }

    shutdownButton.setOnClickListener {
      AlertDialog.Builder(this)
          .setTitle("Are you sure?")
          .setPositiveButton("Shutdown", { dialogInterface, i ->
            val IP = ipAddressField.text
            AndroidNetworking.get("http://${IP}:3000/shutdown")
                .build()
                .getAsString(null);
          })
          .setNegativeButton("Cancel", { dialogInterface, i ->
            // Nothing to do here
          })
          .create()
          .show()

    }

    ipAddressField.setText(getSavedIP())
  }

  override fun onPause() {
    super.onPause()
    saveIP(ipAddressField.text.toString())
  }

  private fun saveIP(IP: String) {
    PreferenceManager.getDefaultSharedPreferences(applicationContext)
        .edit()
        .putString(IP_ADDR_KEY, IP)
        .apply()
  }

  private fun getSavedIP(): String? {
    return PreferenceManager.getDefaultSharedPreferences(applicationContext)
        .getString(IP_ADDR_KEY, null);
  }
}
