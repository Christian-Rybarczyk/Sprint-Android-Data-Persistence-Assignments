package com.rybarstudios.datapersistenceassignment1

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
    }

    val bookList = mutableListOf<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (book in testData) {
            bookList.add(book)
            listLayout.addView(buildItemView(book))
        }

        floatingActionButton.setOnClickListener {
            val intent = Intent(this, EditBookActivity::class.java)
            intent.putExtra(NEW_ENTRY_KEY, listLayout.childCount)
            startActivity(intent)
        }
    }

    private fun buildItemView(book: Book): TextView {
        val view = TextView(this)
        view.text = book.title
        view.textSize = 24f

        view.setOnClickListener {
            val intent = Intent(this, EditBookActivity::class.java)
            intent.putExtra(EDIT_ENTRY_KEY, book.toCsvString())
            startActivity(intent)
        }
        return view
    }

    val testData = mutableListOf<Book>(
        Book("Harry Potter", "this is a reason to read", true, "1"),
        Book("Kotlin for Dummies", "To not be a dummy", false, "2")
    )
}
