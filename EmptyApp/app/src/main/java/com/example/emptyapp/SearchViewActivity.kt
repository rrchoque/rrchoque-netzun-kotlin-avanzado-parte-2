package com.example.emptyapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import androidx.appcompat.widget.SearchView
import com.example.emptyapp.databinding.ActivitySearchViewBinding
import com.example.emptyapp.databinding.ActivityWidgetsBinding

class SearchViewActivity : AppCompatActivity() {
    private lateinit var binding : ActivitySearchViewBinding
    var list = listOf<String>("Pan","Queso","Huevos","Pollo","Leche","Cebolla","Zanahoria","Pescado")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_search_view)
        binding = ActivitySearchViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        var searchView = binding.searchView
        var editTextMultiLine = binding.editTextMultiLine

        editTextMultiLine.setText(listToString(list))
        searchView.setOnQueryTextListener(object :SearchView.OnQueryTextListener,
            android.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                binding.searchView.clearFocus()
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                allOperation(newText, editTextMultiLine)
                return false
            }

        })
    }

    fun listToString(list: List<String>):String{
        var string:String = ""
        list.forEach {
            string=string+it+"\n"
        }
        return string
    }

    fun searchList(text:String?):List<String>{
        var filterList = list.filter {
            it.contains(text?:"",true)
        }
        return filterList
    }

    fun allOperation(text: String?, multiLineText:EditText ){
        var newList = searchList(text)
        var newString = listToString(newList)
        multiLineText.setText(newString)
    }
}