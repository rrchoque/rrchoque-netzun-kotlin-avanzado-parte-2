package com.example.emptyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import com.example.emptyapp.databinding.ActivityButtonsBinding
import com.example.emptyapp.databinding.ActivityButtonsBinding.*
import com.example.emptyapp.databinding.ActivityMainBinding
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

private lateinit var binding: ActivityButtonsBinding
class ButtonsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_buttons)
        binding=ActivityButtonsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var chipGroup = binding.chipGroup
        var chip: Chip

        var button = binding.button
        button.text="Modificado"

        var radioGroup = binding.radioGroup

        button.setOnClickListener {
            //Toast.makeText(this,"Has presionado el boton", Toast.LENGTH_SHORT).show()
            chipGroup.addChip()

            var id = radioGroup.checkedRadioButtonId
            var rb = findViewById<RadioButton>(id)
            Toast.makeText(this,"Has seleccionado ${rb.text} ", Toast.LENGTH_SHORT).show()
        }

        /**
         * Ships
         */

        for (i in 0..<chipGroup.childCount){
            chip = chipGroup.getChildAt(i) as Chip
            chip.setOnCloseIconClickListener {
                chipGroup.removeView(it)
            }

            chip.setOnClickListener {
                val temp = it as Chip
                Toast.makeText(this, "${temp.text} pulsado", Toast.LENGTH_SHORT).show()
            }
        }

        /**
         * Radio Group
         */


        var radioButton = radioGroup.getChildAt(1) as RadioButton
        radioButton.text = "Mujer"

        radioGroup.check(binding.radioButton1.id)
    }

    fun ChipGroup.addChip(){
        var chip = Chip(this.context)
        chip.text = "Nuevo Chip"
        chip.chipIcon = getDrawable(R.drawable.baseline_agriculture_24)
        chip.isCloseIconVisible= true
        //chip.style=getDrawable(R.style.chipsEntry)

        chip.setOnCloseIconClickListener {
            this.removeView(it)
        }

        chip.setOnClickListener {
            val temp = it as Chip
            Toast.makeText(this.context, "${temp.text} pulsado", Toast.LENGTH_SHORT).show()
        }

        this.addView(chip as View)
    }
}