package com.example.asymmetrical_android;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;

public class FolderDataController {

    Gson gson;

    public FolderDataController(){
        gson = new Gson();
    }

    public boolean AddNewFolder(String newFolderName){
        try (FileWriter writer = new FileWriter("folderStructure.json", true)){

            return true;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

}
