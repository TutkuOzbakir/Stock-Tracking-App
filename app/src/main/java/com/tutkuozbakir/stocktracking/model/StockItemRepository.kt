package com.tutkuozbakir.stocktracking.model

class StockItemRepository(private val itemDatabase: StockItemDatabase) {
    suspend fun insert(item: StockItem) = itemDatabase.itemDao().insertItem(item)
    suspend fun delete(item: StockItem) = itemDatabase.itemDao().deleteItem(item)
    fun getAllItems() = itemDatabase.itemDao().getAllItems()
}