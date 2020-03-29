package com.example.asymmetrical_android;

import android.provider.ContactsContract;

import androidx.annotation.NonNull;

import java.io.FileWriter;
import java.util.List;


public class DFolder {

    // NoteData is privy to only files stored "within" the folder.
    NoteDataController noteDataController = new NoteDataController();

    private String name;
    private DFolder rootFolder;
    private int rating;

    // Notes will contain the names of the notes for them to be stored in JSON for the application.
    private List<String> noteNames;

    DFolder(@NonNull String init_name, DFolder upper){
        name = init_name;
        rootFolder = upper;
    }

    // Adds a new note to the current folder.
    public void AddNote(DNote note){
        noteNames.add(note.getName());
        noteDataController.SaveNewNote(note);
    }
}
