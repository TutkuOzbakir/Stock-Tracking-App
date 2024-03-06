package com.tutkuozbakir.stocktracking.viewmodel

import androidx.lifecycle.ViewModel
import com.tutkuozbakir.stocktracking.model.StockItemDatabase
import com.tutkuozbakir.stocktracking.model.StockItemRepository
import com.tutkuozbakir.stocktracking.model.StockItem
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemViewModel(private val repository: StockItemRepository): ViewModel(){
    fun insert(item: StockItem) = CoroutineScope(Dispatchers.IO).launch {
        repository.insert(item)
    }

    fun delete(item: StockItem) = CoroutineScope(Dispatchers.IO).launch {
        repository.delete(item)
    }

    fun getAllItems() = repository.getAllItems()

}