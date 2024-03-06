package com.tutkuozbakir.stocktracking.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [StockItem::class], version = 1)
abstract class StockItemDatabase: RoomDatabase() {

    abstract fun itemDao() : StockItemDAO

    companion object{
        @Volatile
        private var instance: StockItemDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it }
        }
        private fun createDatabase(context: Context) = Room.databaseBuilder(context.applicationContext,
            StockItemDatabase::class.java, "items.db").build()

    }

}