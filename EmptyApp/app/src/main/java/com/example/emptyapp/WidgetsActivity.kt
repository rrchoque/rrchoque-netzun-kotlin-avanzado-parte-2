package com.example.emptyapp

import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebSettings
import android.webkit.WebViewClient
import android.widget.MediaController
import android.widget.ProgressBar
import com.example.emptyapp.databinding.ActivityWidgetsBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Calendar

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

        /**
         * CalendarView
         */
        var calendarView = binding.calendarView
        var tvDate = binding.tvDate

        calendarView.setOnDateChangeListener { calendarView, year, month, dayOfMonth ->
            var date = "$dayOfMonth/${month+1}/$year"
            tvDate.text=date
        }
        var calendar = Calendar.getInstance()
        calendar.set(2025, 1, 17)
        calendarView.date = calendar.timeInMillis

        /**
         * ProgressBar
         */
        var progressBarCircular = binding.progressBar1

        progressBarCircular.max = 2000
        progressBarCircular.progress = 0

        var progressBarHorizontal = binding.progressBar2

        progressBarHorizontal.max = 1000
        progressBarHorizontal.progress = 0

        GlobalScope.launch {
            updateProgressBar(progressBarCircular)
        }

        GlobalScope.launch {
            updateProgressBar(progressBarHorizontal)
        }
    }

    suspend fun updateProgressBar(progressBar: ProgressBar){
        while (progressBar.progress < progressBar.max){
            //progressBar.progress += 10
            delay(100)
            progressBar.incrementProgressBy(10)
        }
    }
}