package com.example.asymmetrical_android;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;


public class DFolder {


    private String name;
    private DFolder parentFolder;
    private String parentName;

    private int rating;

    public String getName(){
        return name;
    }
    public DFolder getParentFolder(){
        return parentFolder;
    }

    private ArrayList<DNote> internalNotes;
    private ArrayList<DFolder> internalFolders;

    DFolder(@NonNull String init_name, DFolder rootFolder){
        name = init_name;
        parentFolder = rootFolder;
        parentName = rootFolder.getName();
    }

    DFolder(@NonNull String init_name){
        name = init_name;
        parentFolder = null;
        parentName = "";
    }

    DFolder(@NonNull String init_name, String rootName){
        name = init_name;
        parentName = rootName;
    }

    // Adds a new note to the current folder.
    public boolean AddNote(DNote note){
        return internalNotes.add(note);
    }
    // Deletes given note from the current folder.
    public boolean DeleteNote(DNote note){
        return internalNotes.remove(note);
    }
    // Adds a new folder to the current folder.
    public boolean AddFolder(DFolder folder){
        return internalFolders.add(folder);
    }
    // Delete folder from current folder
    public boolean DeleteFolder(DFolder folder){
        return internalFolders.remove(folder);
    }

    // Search function to find a Note inside the folder, returns null if item is not found, else
    // returns item.
    public DNote searchByName(String name){
        ListIterator<DNote> internalNoteIterator = internalNotes.listIterator();
        while(internalNoteIterator.hasNext()){
            DNote element = internalNoteIterator.next();
            if (element.getName().contentEquals(name)){
                return element;
            }
        }
        return null;
    }
}
