package com.lambdaschool.sharedprefs

import com.lambdaschool.sharedprefs.model.JournalEntry

<<<<<<< HEAD
=======
// TODO 1: Extract behavior from Prefs to an interface

>>>>>>> origin/master
interface JournalRepoInterface {
    fun createEntry(entry: JournalEntry)
    fun readAllEntries(): MutableList<JournalEntry>
    fun updateEntry(entry: JournalEntry)
    fun deleteEntry(entry: JournalEntry)
}