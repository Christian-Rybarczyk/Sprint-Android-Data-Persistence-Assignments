package com.lambdaschool.sharedprefs

import android.app.Application
import timber.log.Timber

<<<<<<< HEAD
// TODO: 5. Lazy initialization of a prefs object for Activities to use...
=======
// TODO 4: Change to the repo interface here
>>>>>>> origin/master
val repo: JournalRepoInterface by lazy {
    App.repo!!
}

class MyDebugTree : Timber.DebugTree() {
    override fun createStackElementTag(element: StackTraceElement): String? {
        return String.format(
            "[C:%s] [M:%s] [L:%s]",
            super.createStackElementTag(element),
            element.methodName,
            element.lineNumber
        )
    }
}

class App : Application() {

    companion object {
        var repo: JournalRepoInterface? = null
    }

    override fun onCreate() {
        super.onCreate()

<<<<<<< HEAD
//        repo = Prefs(applicationContext)
        repo = JournalFileRepo(applicationContext)
        // TODO: 2. Configure Timber logging
=======
        // TODO 5: Instantiate the File repo here instead of Prefs
        //repo = Prefs(applicationContext)
        repo = JournalFileRepo(applicationContext)

>>>>>>> origin/master
        // "Timber" Library
        if (BuildConfig.DEBUG) {
            Timber.plant(MyDebugTree())
        }
    }
}