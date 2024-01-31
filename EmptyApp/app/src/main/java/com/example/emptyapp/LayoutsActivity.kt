package com.example.emptyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.emptyapp.databinding.ActivityLayoutsBinding
import com.example.emptyapp.databinding.ActivityWidgetsBinding

class LayoutsActivity : AppCompatActivity() {
    private lateinit var binding : ActivityLayoutsBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_layouts)
        binding = ActivityLayoutsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        /*
        var imageView = binding.imageView
        var button1 = binding.button1
        var button2 = binding.button2
        var button3 = binding.button3
        var button4 = binding.button4
        var button5 = binding.button5
        var button6 = binding.button6

        button1.setOnClickListener {
            imageView.scaleX-=0.1f
            imageView.scaleY-=0.1f
        }

        button2.setOnClickListener {
            imageView.scaleX+=0.1f
            imageView.scaleY+=0.1f
        }

        button3.setOnClickListener {
            imageView.rotation-=15
        }

        button4.setOnClickListener {
            imageView.rotation+=15
        }

        button5.setOnClickListener {
            if (imageView.alpha>0) imageView.alpha-=0.1f
        }

        button6.setOnClickListener {
            if (imageView.alpha<1) imageView.alpha+=0.1f
        }
         */
    }
}