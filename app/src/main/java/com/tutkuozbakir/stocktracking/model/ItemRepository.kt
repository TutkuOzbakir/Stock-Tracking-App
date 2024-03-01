package com.tutkuozbakir.stocktracking.model

class ItemRepository(private val itemDatabase: ItemDatabase) {
    suspend fun insert(item: Item) = itemDatabase.itemDao().insertItem(item)
    suspend fun delete(item: Item) = itemDatabase.itemDao().deleteItem(item)
    fun getAllItems() = itemDatabase.itemDao().getAllItems()
}