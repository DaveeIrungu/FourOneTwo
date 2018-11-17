package com.example.davee.fouronetwo

class Note {
    var noteID: Int? = null
    var notename: String? = null
    var noteDesc: String? = null

    constructor(noteID: Int, notename: String, noteDesc: String) {
        this.noteID = noteID
        this.notename = notename
        this.noteDesc = noteDesc
    }
}