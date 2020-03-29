package com.example.asymmetrical_android;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class FolderDataController {

    // Gson tool to convert objects to JSON
    private Gson gson;
    // List to contain the Folders from the file
    private List<DFolder> folders;


    public FolderDataController(){
        gson = new Gson();
    }

    // Adds a given folder to the the directory.
    public void AddNewFolder(DFolder folder){
        folders.add(folder);

        try (FileWriter writer = new FileWriter("folderStructure.json", true)){

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Removes given folder from the current directory
    public void DeleteFolder(DFolder folder){
        folders.remove(folder);

    }

}
