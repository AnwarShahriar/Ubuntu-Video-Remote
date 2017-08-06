package me.anwarshahriar.uvr

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.androidnetworking.AndroidNetworking

class MainActivity : AppCompatActivity() {

  val toggleVideoButton: Button by lazy { findViewById<Button>(R.id.toggle_video_button) }
  val ipAddressField: EditText by lazy { findViewById<EditText>(R.id.ip_address_field) }

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_main)

    toggleVideoButton.setOnClickListener {
      val IP = ipAddressField.text
      AndroidNetworking.get("http://${IP}:3000/play")
          .build()
          .getAsString(null);
    }
  }
}
