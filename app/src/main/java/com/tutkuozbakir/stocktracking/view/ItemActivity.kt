package com.tutkuozbakir.stocktracking.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.tutkuozbakir.stocktracking.dialog.AddItemDialog
import com.tutkuozbakir.stocktracking.adapter.ItemAdapter
import com.tutkuozbakir.stocktracking.databinding.ActivityMainBinding
import com.tutkuozbakir.stocktracking.dialog.AddDialogListener
import com.tutkuozbakir.stocktracking.model.StockItemDatabase
import com.tutkuozbakir.stocktracking.model.StockItem
import com.tutkuozbakir.stocktracking.model.StockItemRepository
import com.tutkuozbakir.stocktracking.viewmodel.ItemViewModel
import com.tutkuozbakir.stocktracking.viewmodel.ItemViewModelFactory

class ItemActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)


        val database = StockItemDatabase(this@ItemActivity)
        val repository = StockItemRepository(database)
        val factory = ItemViewModelFactory(repository)
        val viewModel = ViewModelProvider(this, factory).get(ItemViewModel::class.java)

        val adapter = ItemAdapter(listOf(), viewModel)
        binding.recyclerView.layoutManager = LinearLayoutManager(this)
        binding.recyclerView.adapter = adapter

        viewModel.getAllItems().observe(this, Observer {
            adapter.itemList = it
            adapter.notifyDataSetChanged()
        })

        binding.button.setOnClickListener {
            AddItemDialog(this, object : AddDialogListener {
                override fun onAddButtonClicked(item: StockItem) {
                    viewModel.insert(item)
                }
            }).show()
        }
    }
}
