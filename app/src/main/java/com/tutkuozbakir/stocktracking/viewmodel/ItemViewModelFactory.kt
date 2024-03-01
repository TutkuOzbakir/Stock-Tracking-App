package com.tutkuozbakir.stocktracking.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tutkuozbakir.stocktracking.model.ItemRepository

class ItemViewModelFactory(private val repository: ItemRepository): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ItemViewModel(repository) as T
    }
}