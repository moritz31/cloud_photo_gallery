package com.example.cloud_photo_gallery

import android.os.Bundle
import android.os.Environment
import android.util.Log
import io.flutter.app.FlutterActivity
import io.flutter.plugin.common.MethodChannel
import io.flutter.plugins.GeneratedPluginRegistrant
import java.io.File

class MainActivity : FlutterActivity() {
    private val CHANNEL = "flutter.native/helper"

    override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    GeneratedPluginRegistrant.registerWith(this)
    MethodChannel(flutterView, CHANNEL).setMethodCallHandler { call, result ->
      // Note: this method is invoked on the main thread.
      if (call.method == "helloFromNativeCode") {
        result.success(helloFromNativeCode())
      } else {
        result.notImplemented()
      }
    }
  }

  private fun helloFromNativeCode(): String {
      val cameraDir = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM).absolutePath + "/Camera")
      val files = cameraDir.listFiles()
      return files.toString()
  }

}

