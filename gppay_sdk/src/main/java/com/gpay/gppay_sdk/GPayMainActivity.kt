package com.gpay.gppay_sdk

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.gpay.gppay_sdk.databinding.ActivityGpayMainBinding
import vn.galaxypay.gpaysdkmodule.ui.view.activity.HomePageActivity
import vn.galaxypay.gpaysdkmodule.utils.AppConstants

class GPayMainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityGpayMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGpayMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.fab.setOnClickListener {
           startWalletHome(this)
       }
    }

    private fun startWalletHome(activity: Activity) {
        val homeIntent = Intent(activity, HomePageActivity::class.java).apply {
            putExtra(AppConstants.accessToken, intent.getStringExtra(AppConstants.accessToken))
            putExtra(AppConstants.clientKey, intent.getStringExtra(AppConstants.clientKey))
            putExtra(AppConstants.xPhone, intent.getStringExtra(AppConstants.xPhone))
            putExtra(AppConstants.xTenant, intent.getStringExtra(AppConstants.xTenant))
            putExtra(AppConstants.action, AppConstants.homeActivity)
        }
        startActivityForResult(homeIntent, 200)
    }


    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == 200) {
                val success = intent.getBooleanExtra("success", false)
                val intent = Intent()
                intent.putExtra("success", success)
                setResult(Activity.RESULT_OK, intent);
                finish()
            }
        }
    }
}