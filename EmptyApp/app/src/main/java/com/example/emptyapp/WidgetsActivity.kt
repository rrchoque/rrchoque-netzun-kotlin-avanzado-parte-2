package com.example.emptyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebViewClient
import com.example.emptyapp.databinding.ActivityWidgetsBinding

class WidgetsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityWidgetsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_widgets)

        binding = ActivityWidgetsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var webView = binding.webView
        webView.settings.javaScriptEnabled
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.google.com")
    }
}