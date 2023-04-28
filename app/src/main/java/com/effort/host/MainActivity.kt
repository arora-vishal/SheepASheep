package com.effort.host

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.effort.host.databinding.ActivityMainBinding

private const val GAME_URL = "https://html5.gamedistribution.com/rvvASMiM/51ab7839879343d98d3b7cbc7164843f/index.html?gd_sdk_referrer_url=https%3A%2F%2Fen.onlygames.io%2Fgames%2Fmatch-3%2Fsheep-sheep.html&gd_zone_config=eyJwYXJlbnRVUkwiOiJodHRwczovL2VuLm9ubHlnYW1lcy5pby9nYW1lcy9tYXRjaC0zL3NoZWVwLXNoZWVwLmh0bWwiLCJwYXJlbnREb21haW4iOiJlbi5vbmx5Z2FtZXMuaW8iLCJ0b3BEb21haW4iOiJlbi5vbmx5Z2FtZXMuaW8iLCJoYXNJbXByZXNzaW9uIjp0cnVlLCJsb2FkZXJFbmFibGVkIjp0cnVlLCJob3N0IjoiaHRtbDUuZ2FtZWRpc3RyaWJ1dGlvbi5jb20iLCJ2ZXJzaW9uIjoiMS41LjE2In0%253D"

class MainActivity : AppCompatActivity(){

    private lateinit var layout: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        layout = DataBindingUtil.setContentView(this, R.layout.activity_main)

        layout.webView.settings.javaScriptEnabled = true
        layout.webView.settings.useWideViewPort = true
        layout.webView.settings.loadWithOverviewMode = true
        layout.webView.settings.saveFormData = false
        layout.webView.settings.domStorageEnabled = true
        layout.webView.settings.databaseEnabled = true
        layout.webView.webViewClient = WebViewClient()

        WebView.setWebContentsDebuggingEnabled(BuildConfig.DEBUG)
        layout.webView.loadUrl(GAME_URL)
    }

    override fun onBackPressed() {
        if (layout.webView.canGoBack()) {
            layout.webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}