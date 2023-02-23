package com.gpay.sdk

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.gpay.gppay_sdk.GPayMainActivity
import com.gpay.sdk.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.fab.setOnClickListener {
            val intent = Intent(this, GPayMainActivity::class.java).apply {
                putExtra("accessToken", "accessToken")
                putExtra("clientKey", "galaxyjoy")
                putExtra("xPhone", "0376249134")
                putExtra("xTenant", "GALAXYJOY")
            }
            startActivityForResult(intent, 200)
        }

    }
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 200) {
                val success = intent.getBooleanExtra("success", false)
                Log.d("LOG_DATA", "$success")
            }
        }
    }
}