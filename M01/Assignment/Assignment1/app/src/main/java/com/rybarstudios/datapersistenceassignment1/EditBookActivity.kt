package com.rybarstudios.datapersistenceassignment1

import android.app.Activity
import android.content.Intent
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
        } else {
            book = Book("", "", false, createEntryData)
        }
    }

    override fun onBackPressed() {
        returnData()
        super.onBackPressed()
    }

    private fun returnData() {
        val title = edit_text_title.text.toString()
        val description = edit_text_description.text.toString()
        val isRead = checkBox.isChecked
        val id = book.id

        val returnedBook = Book(title, description, isRead, id)
        val intent = Intent()
        intent.putExtra(MainActivity.NEW_ENTRY_KEY, returnedBook.toCsvString())
        setResult(Activity.RESULT_OK, intent)
        finish()
        
    }
}
