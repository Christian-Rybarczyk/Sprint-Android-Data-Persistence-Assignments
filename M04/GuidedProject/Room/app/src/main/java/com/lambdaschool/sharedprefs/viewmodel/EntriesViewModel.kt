package com.lambdaschool.sharedprefs.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.lambdaschool.sharedprefs.App.Companion.repo
import com.lambdaschool.sharedprefs.model.JournalEntry
import com.lambdaschool.sharedprefs.repo

// TODO 24: Create a ViewModel for entries
class EntriesViewModel : ViewModel() {
    // TODO 25: Create a LiveData object for the entries
    val entries: LiveData<List<JournalEntry>> by lazy {
        readAllEntries()
    }

    // TODO 26: Recreate the repo calls to as functions here.
    fun createEntry(entry: JournalEntry) {
        com.lambdaschool.sharedprefs.repo.createEntry(entry)
    }

    fun readAllEntries(): MutableList<JournalEntry> {
        com.lambdaschool.sharedprefs.repo.readAllEntries()
    }

    override fun updateEntry(entry: JournalEntry) {
        database.entriesDao().updateEntry(entry)
    }

    override fun deleteEntry(entry: JournalEntry) {
        database.entriesDao().deleteEntry(entry)
    }

}