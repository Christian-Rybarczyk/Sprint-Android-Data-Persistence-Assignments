package com.rybarstudios.datapersistenceassignment1

import android.app.Application
import com.rybarstudios.datapersistenceassignment1.database.BookDBRepo

val repo: BookRepoInterface by lazy {
    App.repo!!
}

class App : Application() {
    companion object {
        var repo: BookRepoInterface? = null
    }

    override fun onCreate() {
        super.onCreate()
        repo = BookDBRepo(applicationContext)
    }
}