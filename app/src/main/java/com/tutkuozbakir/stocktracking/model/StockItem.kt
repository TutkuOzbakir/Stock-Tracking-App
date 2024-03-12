package com.tutkuozbakir.stocktracking.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "items", indices = [Index("item_name", unique = true)])
data class StockItem(
    @ColumnInfo("item_name")
    var item_name: String,
    @ColumnInfo("item_count")
    var item_count: Int
){
    @PrimaryKey(autoGenerate = true)
    var item_id: Int? = null
}
