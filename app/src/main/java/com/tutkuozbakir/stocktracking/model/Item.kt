package com.tutkuozbakir.stocktracking.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "items")
data class Item(
    @ColumnInfo("item_name")
    var item_name: String,
    @ColumnInfo("item_count")
    var item_count: Int
){
    @PrimaryKey(autoGenerate = true)
    val item_id: Int? = null
}
