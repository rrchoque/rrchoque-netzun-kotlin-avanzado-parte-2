package com.example.emptyapp

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.example.emptyapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_main)
        setContentView(binding.root)

        /**
         * TextView
         */
        //val tvNameDev = findViewById<TextView>(R.id.tvNameDev)
        val tvNameDev = binding.tvNameDev
        //tvNameDev.text = getString(R.string.hola_mundo)
        //tvNameDev.setTextColor(Color.BLUE)
        //tvNameDev.setOnClickListener {
        //    Toast.makeText(this,"Haz hecho click en el texto", Toast.LENGTH_SHORT).show()
        //    tvNameDev.setTextColor(Color.RED)
        //}
        tvNameDev.apply {
            text = getString(R.string.hola_mundo)
            setTextColor(Color.BLUE)
            setOnClickListener {
                Toast.makeText(this.context,"Haz hecho click en el texto", Toast.LENGTH_SHORT).show()
                tvNameDev.setTextColor(Color.RED)
            }
        }

        /**
         * EditText
         */
        val etName = binding.etName
        etName.addTextChangedListener {
            if (etName.text.isEmpty()){
                etName.error = "Este campo no puede estar vacio"
            }
        }
    }
}