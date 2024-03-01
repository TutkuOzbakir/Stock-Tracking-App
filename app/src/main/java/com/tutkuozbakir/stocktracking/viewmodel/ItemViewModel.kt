package com.tutkuozbakir.stocktracking.viewmodel

import androidx.lifecycle.ViewModel
import com.tutkuozbakir.stocktracking.model.Item
import com.tutkuozbakir.stocktracking.model.ItemDatabase
import com.tutkuozbakir.stocktracking.model.ItemRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ItemViewModel(private val repository: ItemRepository): ViewModel(){
    fun insert(item: Item) = CoroutineScope(Dispatchers.IO).launch {
        repository.insert(item)
    }

    fun delete(item: Item) = CoroutineScope(Dispatchers.IO).launch {
        repository.delete(item)
    }

    fun getAllItems() = repository.getAllItems()

}