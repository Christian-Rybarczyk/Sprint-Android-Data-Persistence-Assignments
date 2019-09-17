package com.rybarstudios.datapersistenceassignment1.model

import java.io.Serializable

class Book : Serializable {

    var title: String? = null
    var reasonToRead: String? = null
    var hasBeenRead: Boolean = false
    var id: String? = null

    constructor(title: String?, reasonToRead: String?, hasBeenRead: Boolean = false, id: String?) {
        this.title = title
        this.reasonToRead = reasonToRead
        this.hasBeenRead = hasBeenRead
        this.id = id
    }

    constructor(csvString: String) {
        val values = csvString.split(",")

        if (values.size == 4) {
            this.title = values[0]
            this.reasonToRead = values[1].replace("~@", ",")
            this.hasBeenRead = values[2].toBoolean()
            this.id = values[3]
        }
    }

    fun toCsvString(): String {
        return "$title,${reasonToRead?.replace(",", "~@")},$hasBeenRead,$id"
    }


}