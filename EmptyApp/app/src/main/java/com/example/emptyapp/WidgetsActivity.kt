package com.example.emptyapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebViewClient
import android.widget.MediaController
import com.example.emptyapp.databinding.ActivityWidgetsBinding

class WidgetsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityWidgetsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_widgets)

        binding = ActivityWidgetsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /**
         * WebView
         */
        var webView = binding.webView
        webView.settings.javaScriptEnabled
        webView.webViewClient = WebViewClient()
        webView.loadUrl("https://www.google.com")

        /**
         * VideoView
         */
        var videoViewLocal = binding.videoViewLocal
        var mcLocal = MediaController(this)
        mcLocal.setAnchorView(videoViewLocal)

        val path = "android.resource://"+packageName+"/"+R.raw.cat_feline_animal_pet_house_cat_427
        videoViewLocal.setVideoURI(Uri.parse(path))
        videoViewLocal.setMediaController(mcLocal)

        var videoViewInternet = binding.videoViewInternet
        var mcInternet = MediaController(this)
        mcInternet.setAnchorView(videoViewInternet)
        videoViewInternet.setVideoPath("https://www.defensoria.gob.bo/uploads/boletin/videos/video-sin-titulo-hecho-con-clipchamp-8-compressed-with-flexclip-65a4c200583c2.mp4")
        videoViewInternet.setMediaController(mcInternet)


    }
}