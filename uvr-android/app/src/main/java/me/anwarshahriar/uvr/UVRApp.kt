package me.anwarshahriar.uvr

import android.app.Application
import com.androidnetworking.AndroidNetworking

class UVRApp : Application() {
  override fun onCreate() {
    super.onCreate()
    AndroidNetworking.initialize(applicationContext)
  }
}
