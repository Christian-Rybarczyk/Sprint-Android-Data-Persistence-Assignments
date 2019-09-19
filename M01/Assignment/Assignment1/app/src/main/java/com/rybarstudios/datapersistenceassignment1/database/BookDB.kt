package com.rybarstudios.datapersistenceassignment1.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.rybarstudios.datapersistenceassignment1.model.Book

@Database(entities = [Book::class], version = 1, exportSchema = false)
abstract class BookDB : RoomDatabase(){
    abstract fun bookDao() : BookDAO
}