package com.rybarstudios.datapersistenceassignment1

import com.rybarstudios.datapersistenceassignment1.model.Book

interface BookRepoInterface {

    fun createBook(book: Book)
    fun readAllBookEntires(): MutableList<Book>
    fun updateBook(book: Book)
    fun deleteBook(book: Book)
}