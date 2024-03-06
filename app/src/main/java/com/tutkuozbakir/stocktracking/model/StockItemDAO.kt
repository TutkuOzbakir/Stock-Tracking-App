package com.tutkuozbakir.stocktracking.model

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface StockItemDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertItem(item: StockItem)

    @Delete
    suspend fun deleteItem(item: StockItem)

    @Query("SELECT * FROM items")
    fun getAllItems(): LiveData<List<StockItem>>
}