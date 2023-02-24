package com.gpay.my_gpay_sdk

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.gpay.my_gpay_sdk.databinding.ActivityGpayMainBinding
import vn.galaxypay.gpaysdkmodule.ui.view.activity.HomePageActivity
import vn.galaxypay.gpaysdkmodule.utils.AppConstants

class GPayMainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityGpayMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityGpayMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_gpay_main)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

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
        startActivity(intent)
    }
}