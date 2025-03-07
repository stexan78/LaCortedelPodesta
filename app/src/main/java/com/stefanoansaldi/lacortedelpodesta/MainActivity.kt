package com.stefanoansaldi.lacortedelpodesta

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.google.android.play.core.integrity.IntegrityManagerFactory
import com.google.android.play.core.integrity.IntegrityTokenRequest

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val integrityManager = IntegrityManagerFactory.create(applicationContext)
        val integrityTokenRequest = IntegrityTokenRequest.builder().build()
        val response = integrityManager.requestIntegrityToken(integrityTokenRequest)

        val webView: WebView = findViewById(R.id.webview)
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true

        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.lacortedelpodesta.com")
    }
}