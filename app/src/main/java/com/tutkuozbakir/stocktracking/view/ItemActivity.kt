package com.tutkuozbakir.stocktracking.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import com.tutkuozbakir.stocktracking.R
import com.tutkuozbakir.stocktracking.databinding.ActivityMainBinding
import com.tutkuozbakir.stocktracking.model.ItemDatabase
import com.tutkuozbakir.stocktracking.model.ItemRepository
import com.tutkuozbakir.stocktracking.viewmodel.ItemViewModel
import com.tutkuozbakir.stocktracking.viewmodel.ItemViewModelFactory

class ItemActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val database = ItemDatabase(this@ItemActivity)
        val repository = ItemRepository(database)
        val factory = ItemViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory).get(ItemViewModel::class.java)
    }
}