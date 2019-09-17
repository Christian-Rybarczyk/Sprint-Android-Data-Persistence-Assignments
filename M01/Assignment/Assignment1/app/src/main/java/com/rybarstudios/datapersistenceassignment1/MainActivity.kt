package com.rybarstudios.datapersistenceassignment1

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.rybarstudios.datapersistenceassignment1.model.Book
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    companion object {
        const val NEW_ENTRY_KEY = "New Entry"
        const val EDIT_ENTRY_KEY = "Edit Entry"
        const val ENTRY_REQUEST_CODE = 42
        const val EDIT_REQUEST_CODE = 33
    }

    val bookList = mutableListOf<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bookList.add(Book("Harry Potter", "this is a reason to read", true, "1"))
        bookList.add(Book("Kotlin for Dummies", "To not be a dummy", false, "2"))

        for (i in 0 until bookList.size) {
            listLayout.addView(buildItemView(bookList[i]))
        }

        floatingActionButton.setOnClickListener {
            val intent = Intent(this, EditBookActivity::class.java)
            intent.putExtra(NEW_ENTRY_KEY, listLayout.childCount.toString())
            startActivityForResult(intent, ENTRY_REQUEST_CODE)
        }
    }

    private fun buildItemView(book: Book): TextView {
        val view = TextView(this)
        view.text = book.title
        val newId = book.id?.toInt()
        if (newId != null) {
            view.id = newId
        }
        view.textSize = 24f

        view.setOnClickListener {
            val intent = Intent(this, EditBookActivity::class.java)
            intent.putExtra(EDIT_ENTRY_KEY, book.toCsvString())
            startActivityForResult(intent, EDIT_REQUEST_CODE)
        }
        return view
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == ENTRY_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val book = data?.getStringExtra(NEW_ENTRY_KEY)
            book?.let {
                listLayout.addView(buildItemView(Book(book)))
            }
        }
        if (requestCode == EDIT_REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            val editedBook = data?.getStringExtra(NEW_ENTRY_KEY)
            if (editedBook != null) {
                checkBookId(Book(editedBook))
            }
        }
    }

    private fun checkBookId(book: Book) {
        var count = 0
        for (i in 0 until bookList.size) {
            if (book.id == bookList[i].id) {
                bookList[i] = book
                listLayout.removeViewAt(i)
                listLayout.addView(buildItemView(book), i)
                count++
            }
        }
        if (count == 0) {
            listLayout.addView(buildItemView(book))
        }
    }
}
