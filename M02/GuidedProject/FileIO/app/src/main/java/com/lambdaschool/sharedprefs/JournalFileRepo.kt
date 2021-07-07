package com.lambdaschool.sharedprefs

import android.content.Context
<<<<<<< HEAD
import android.os.Environment
import com.lambdaschool.sharedprefs.model.JournalEntry
import org.json.JSONException
import org.json.JSONObject
import java.io.*
import java.lang.StringBuilder

class JournalFileRepo(var context: Context): JournalRepoInterface {
    override fun createEntry(entry: JournalEntry) {
        val entryString = entry.toJsonObject()
        val fileName = "journalEntry${entry.date}.json"
        writeToFile(fileName, entryString)
    }

    private fun writeToFile(fileName: String, entryString: String) {
        val dir = storageDirectory
        val outputFile = File(dir, fileName)

        var writer: FileWriter? = null
        try {
            writer = FileWriter(outputFile)
            writer.write(entryString)
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            if (writer != null) {
                try {
                    writer.close()
                } catch (e2: IOException) {
                    e2.printStackTrace()
                }
            }
        }
    }

    val storageDirectory: File
        get() {
            if (isExternalStorageWritable) {
                val directory =
                    Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM)
                return if (!directory.exists() && !directory.mkdirs()) {
                    context.cacheDir
                } else {
                    directory
                }
            }
            else {
                return context.cacheDir
            }
        }

    val isExternalStorageWritable: Boolean
        get() {
            val state = Environment.getExternalStorageState()
            return state == Environment.MEDIA_MOUNTED
        }

    override fun readAllEntries(): MutableList<JournalEntry> {
        val entries = ArrayList<JournalEntry>()
        for (filename in fileList) {
            val json = readFromFile(filename)
            try {
                entries.add(JournalEntry(JSONObject(json)))
            } catch (e: JSONException) {
                e.printStackTrace()
            }
        }
        return entries
    }

    val fileList: ArrayList<String>
        get() {
            val fileNames = arrayListOf<String>()
            val dir = storageDirectory

            val list = dir.list()
            if (list != null) {
                for (name in list) {
                    if (name.contains(".json")) {
                        fileNames.add(name)
                    }
                }
            }
            return fileNames
        }

    private fun readFromFile(fileName: String): String {
        val inputFile = File(storageDirectory, fileName)
        val readData = StringBuilder()
        var reader: FileReader? = null
        try {
            reader = FileReader(inputFile)
            var next = reader.read()
            while (next != -1) {
                readData.append(next)
                next = reader.read()
            }
        }catch (e: FileNotFoundException) {
            e.printStackTrace()
        } catch (e: IOException) {
            e.printStackTrace()
        } finally {
            if (reader != null) {
                try {
                    reader.close()
                }catch (e: IOException) {
                    e.printStackTrace()
                }
            }
        }
        return 
    }
=======
import android.content.SharedPreferences
import android.graphics.Color
import com.lambdaschool.sharedprefs.model.JournalEntry
import java.io.File
import java.io.FileWriter

// TODO 3: Implement the interface here
class JournalFileRepo(var context: Context?): JournalRepoInterface {

    // Basic structure: We will save each object to its own json file

    // TODO 6: createEntry implementation
    override fun createEntry(entry: JournalEntry) {
        val entryString = entry.toJsonObject()
        val filename = context.whichDir
        writeToFile(filename, entryString)
    }

    // TODO 8: writeToFile helper

    // TODO 9: Save storage directory as a member variable

    // TODO 10: Check for external storage is writeable

    // TODO 11: readAllEntries implementation

    // TODO 12: Save fileList as a member variable

    // TODO 13: readFromFile helper

    // TODO 14: updateEntry implementation

    // TODO 15: deleteEntry implementation


>>>>>>> origin/master
}