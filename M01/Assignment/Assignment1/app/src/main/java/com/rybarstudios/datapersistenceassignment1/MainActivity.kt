package com.rybarstudios.datapersistenceassignment1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.rybarstudios.datapersistenceassignment1.model.Book
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val bookList = mutableListOf<Book>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        for (book in testData) {
            listLayout.addView(buildItemView(book))
        }
    }

    fun buildItemView(book: Book): TextView {
        val view = TextView(this)
        view.text = book.title
        view.textSize = 24f
        return view
    }

    val testData = mutableListOf<Book>(
        Book("Harry Potter", "this is a reason to read", true, "1"),
        Book("Kotlin for Dummies", "To not be a dummy", false, "2")
    )
}
