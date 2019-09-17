package com.rybarstudios.datapersistenceassignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rybarstudios.datapersistenceassignment1.model.Book
import kotlinx.android.synthetic.main.activity_edit_book.*

class EditBookActivity : AppCompatActivity() {

    lateinit var book: Book

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_book)

        val createEntryData = intent.getStringExtra(MainActivity.NEW_ENTRY_KEY)
        val editEntryData = intent.getStringExtra(MainActivity.EDIT_ENTRY_KEY)

        if (editEntryData != null) {
            book = Book(editEntryData)
            edit_text_title.setText(book.title)
            edit_text_description.setText(book.reasonToRead)
            checkBox.isChecked = book.hasBeenRead
        }
    }

    fun returnData() {
        val title = edit_text_title.toString()
        val description = edit_text_description.toString()
        val isRead = checkBox.isChecked
        
    }
}
