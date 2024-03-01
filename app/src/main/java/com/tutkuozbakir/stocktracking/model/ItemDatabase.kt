package com.tutkuozbakir.stocktracking.model

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Item::class], version = 1)
abstract class ItemDatabase: RoomDatabase() {

    abstract fun itemDao() : ItemDAO

    companion object{
        @Volatile
        private var instance: ItemDatabase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: createDatabase(context).also { instance = it }
        }
        private fun createDatabase(context: Context) = Room.databaseBuilder(context.applicationContext,
            ItemDatabase::class.java, "items.db").build()

    }

}