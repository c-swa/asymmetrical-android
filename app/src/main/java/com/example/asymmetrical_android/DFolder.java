package com.example.asymmetrical_android;

import androidx.annotation.NonNull;

import java.util.List;


public class DFolder {

    // NoteData is privy to only files stored "within" the folder.
    NoteDataController noteDataController = new NoteDataController();

    private String name;
    private DFolder rootFolder;
    private int rating;

    public String getName(){
        return name;
    }
    public DFolder getRootFolder(){
        return rootFolder;
    }

    // Notes will contain the names of the notes for them to be stored in JSON for the application.
    private List<String> notesNames;
    private List<DNote> notes;
    // Folders contained within this object will be documented in a list for JSON here
    private List<DFolder> foldersList;
    private List<String> foldersNames;


    DFolder(@NonNull String init_name, DFolder upper){
        name = init_name;
        rootFolder = upper;
    }

    DFolder(@NonNull String init_name){
        name = init_name;
        rootFolder = null;
    }

    // Adds a new note to the current folder.
    public void AddNote(DNote note){
        notes.add(note);
        notesNames.add(note.getName());
        noteDataController.SaveNewNote(note);
    }
    // Deletes given note from the current folder.
    public void DeleteNote(DNote note){
        notes.remove(note);
        notesNames.remove(note.getName());
    }
    // Adds a new folder to the current folder.
    public void AddFolder(DFolder folder){
        foldersList.add(folder);
        foldersNames.add((folder.getName()));
    }
    // Delete folder from current folder
    public void DeleteFolder(DFolder folder){
        foldersList.remove(folder);
        foldersNames.remove(folder.getName());
    }

}
