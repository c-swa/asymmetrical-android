package com.example.asymmetrical_android;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;



public class FolderDataController {

    public static final String NAME = "name";
    public static final DFolder ROOT = new DFolder("root");

    // Gson tool to convert objects to JSON
    private Gson gson;
    // List to contain the Folders from the file
    private ArrayList<DFolder> folders;


    public FolderDataController(){
        gson = new Gson();
        folders = readFolders();
    }

    // Adds a given folder to the the directory.
    public void AddNewFolder(DFolder folder){
        folders.add(folder);

        try (FileWriter writer = new FileWriter("folderStructure.json", true)){
            writer.append(gson.toJson(folder)); // writes folder to a string
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Reads the folders from the json file, and pulls them for the application to display them.
    public ArrayList<DFolder> readFolders(){
        ArrayList<DFolder> dFolders = new ArrayList<DFolder>();
        try (FileReader reader = new FileReader("folderStructure.json")){
            folders.add(gson.fromJson(reader, DFolder.class));
        } catch (IOException e){
            e.printStackTrace();
        }

        return dFolders;
    }

    // Removes given folder from the current directory
    public void DeleteFolder(DFolder folder){
        folders.remove(folder);

    }

}
