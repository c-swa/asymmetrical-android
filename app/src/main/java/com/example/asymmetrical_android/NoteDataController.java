package com.example.asymmetrical_android;

// gson is used for outputting files to a persistent storage in an easier format than a SQL-lite database
// could for me. If this develops too much overhead, than the SQL-lite database will be reused.
import android.hardware.camera2.DngCreator;

import com.google.gson.Gson;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;


class NoteDataController {

    private Gson gson;

    // Default Constructor
    NoteDataController(){
        gson = new Gson();
    }

    // Write new Note to file
    public boolean SaveNewNote(DNote note){
        try (FileWriter fileWriter = new FileWriter(note.getName()+".json") ) {
            gson.toJson(note, fileWriter);
            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // Retrieves a note by the noteName and returns it.
    public DNote GetNoteByName(String noteName){
        try (FileReader reader = new FileReader(noteName+".json")){
            // ** Test getting a new DNote
            DNote newNote;
            newNote = gson.fromJson(reader, DNote.class);
            return newNote;

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return (new DNote("file_not_found_exception_thrown"));
        } catch (IOException e) {
            e.printStackTrace();
            return new DNote("note_IO_exception_thrown");
        }
    }




}
