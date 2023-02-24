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
                putExtra("accessToken", "eyJhbGciOiJSUzI1NiIsInR5cCIgOiAiSldUIiwia2lkIiA6ICJPU2VZeFExZG8yN25jOV9iQ2F2U01CQmhiVldfbnRpcEhna2xmV2RCZllzIn0.eyJleHAiOjE2NzcyMTIxOTYsImlhdCI6MTY3NzIxMTU5NiwianRpIjoiOGUxYTY0NjYtZjg4OC00M2M0LTllZjgtZDk1MTA3NDAxMjE2IiwiaXNzIjoiaHR0cHM6Ly9pZC5kZXYuZ2FsYXh5am95LnZuL3JlYWxtcy9sb3lhbHR5IiwiYXVkIjoiYWNjb3VudCIsInN1YiI6IjM2M2IwZjcwLTNkNDUtNGQ5Yi1iMTNhLThjZTA3ZTg5YjZiOSIsInR5cCI6IkJlYXJlciIsImF6cCI6IjhjOGVkZTQxLWU3Y2UtNGIwZi1iNzVjLTFhMGE2N2IxMWYxMCIsInNlc3Npb25fc3RhdGUiOiJlYTBkZDJhZC1hY2I5LTQyOTAtODIyZi0zOWEyYmRjN2ZhY2IiLCJhY3IiOiIxIiwicmVhbG1fYWNjZXNzIjp7InJvbGVzIjpbIm9mZmxpbmVfYWNjZXNzIiwiZGVmYXVsdC1yb2xlcy1sb3lhbHR5IiwidW1hX2F1dGhvcml6YXRpb24iXX0sInJlc291cmNlX2FjY2VzcyI6eyJhY2NvdW50Ijp7InJvbGVzIjpbIm1hbmFnZS1hY2NvdW50IiwibWFuYWdlLWFjY291bnQtbGlua3MiLCJ2aWV3LXByb2ZpbGUiXX19LCJzY29wZSI6Im9wZW5pZCBwcm9maWxlIHBob25lIGRvYiBlbWFpbCIsInNpZCI6ImVhMGRkMmFkLWFjYjktNDI5MC04MjJmLTM5YTJiZGM3ZmFjYiIsImVtYWlsX3ZlcmlmaWVkIjpmYWxzZSwiZGF0ZV9vZl9iaXJ0aCI6IjAzLTAxLTE5OTIiLCJuYW1lIjoiVCBIIiwicGhvbmVfbnVtYmVyIjoiKzg0ODE0NjUzMDc3IiwicHJlZmVycmVkX3VzZXJuYW1lIjoiKzg0ODE0NjUzMDc3IiwiZ2l2ZW5fbmFtZSI6IlQiLCJmYW1pbHlfbmFtZSI6IkgifQ.oDTS_wv2iEnr9mr1ac3asfim3U1-FlR8JPqUZ8Xt5SOP0LFwbgWahm7zn8vu9cAisqT29I9qbyfXQy88dTPgKuE7L4QxPSckQjkSS1MovWQixzYR2JIwGqj4cbGyCGGyUo9AsancOgphz-BkXI7sh_onbTqwSaE6FHObFMpz8TRwIgQMovai-JbSwLQwHCK1yQNs6eE3hWVM42-sAitvwi51wbfQbmU0uEi4MTPGu2eeKNxI48askItdYLwjfAZsmOmwXCpFKwKItTwDGceiS6k6weirFE6Ngukuqt_i630vnfY9vrk1dL7P2m0UWYvmw8j4zekuKPEZjKD9N4T_AQ")
                putExtra("clientKey", "galaxyjoy")
                putExtra("xPhone", "0814653077")
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