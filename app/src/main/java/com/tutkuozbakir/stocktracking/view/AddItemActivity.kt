package com.tutkuozbakir.stocktracking.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.tutkuozbakir.stocktracking.R
import com.tutkuozbakir.stocktracking.databinding.ActivityAddItemBinding
import com.tutkuozbakir.stocktracking.databinding.ActivityMainBinding

class AddItemActivity : AppCompatActivity() {

    private lateinit var binding : ActivityAddItemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddItemBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
    }
}