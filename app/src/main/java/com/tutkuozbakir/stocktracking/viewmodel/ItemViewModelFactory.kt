package com.tutkuozbakir.stocktracking.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tutkuozbakir.stocktracking.model.StockItemRepository

class ItemViewModelFactory(private val repository: StockItemRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ItemViewModel(repository) as T
    }
}