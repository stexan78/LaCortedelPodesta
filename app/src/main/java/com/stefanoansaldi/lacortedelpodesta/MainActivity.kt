package com.stefanoansaldi.lacortedelpodesta

import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import com.google.android.play.core.integrity.IntegrityManagerFactory
import com.google.android.play.core.integrity.IntegrityTokenRequest
import java.util.UUID

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val nonce: String = generateNonce() // Generate a unique nonce
        val integrityManager = IntegrityManagerFactory.create(applicationContext)
        val integrityTokenRequest = IntegrityTokenRequest.builder()
            .setNonce(nonce) // Ensure this is set
            .build()

        val webView: WebView = findViewById(R.id.webview)
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webSettings.domStorageEnabled = true

        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.lacortedelpodesta.com")
    }

    private fun generateNonce(): String {
        return UUID.randomUUID().toString() // Generates a unique nonce
    }
}