package com.rybarstudios.datapersistenceassignment1.database

import androidx.room.*
import com.rybarstudios.datapersistenceassignment1.model.Book

interface BookDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun createBook(book: Book)

    @Query("SELECT * FROM book")
    fun readAllBookEntries(): MutableList<Book>

    @Update(onConflict = OnConflictStrategy.REPLACE)
    fun updateBook(book: Book)

    @Delete
    fun deleteBook(book: Book)
}