package com.example.emptyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.emptyapp.databinding.ActivityButtonsBinding
import com.example.emptyapp.databinding.ActivityButtonsBinding.*
import com.example.emptyapp.databinding.ActivityMainBinding

private lateinit var binding: ActivityButtonsBinding
class ButtonsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_buttons)
        binding=ActivityButtonsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var button = binding.button
        button.text="Modificado"

        button.setOnClickListener {
            Toast.makeText(this,"Haz presionado el boton", Toast.LENGTH_SHORT).show()
        }
    }
}