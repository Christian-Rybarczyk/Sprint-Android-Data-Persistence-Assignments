package com.rybarstudios.datapersistenceassignment1.database

import android.content.Context
import androidx.room.Room
import com.rybarstudios.datapersistenceassignment1.BookRepoInterface
import com.rybarstudios.datapersistenceassignment1.model.Book

class BookDBRepo(contxt: Context) : BookRepoInterface {

    val context = contxt.applicationContext

    override fun createBook(book: Book) {
        database.bookDao().createBook(book)
    }

    override fun readAllBookEntires(): MutableList<Book> {
        return database.bookDao().readAllBookEntries()
    }

    override fun updateBook(book: Book) {
        database.bookDao().updateBook(book)
    }

    override fun deleteBook(book: Book) {
        database.bookDao().deleteBook(book)
    }

    private val database by lazy {
        Room.databaseBuilder(
            context,
            BookDB::class.java,
            "book_database"
        ).fallbackToDestructiveMigration()
            .build()
    }

}