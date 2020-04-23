package com.example.asymmetrical_android;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class MainController {
    private static final String NAME = "name";
    private static final DFolder ROOT = new DFolder("~");
    private static final String FILENAME = "folders.json";

    // GSON- the JSON translator
    private Gson gson_translater;
    // File Input/Output

    private ArrayList<DFolder> folders;

    public MainController(){
        gson_translater = new Gson();

    }

    // Reads in the folders from the JSON file.
    public ArrayList<DFolder> readFolders(){
        ArrayList<DFolder> folders_in = new ArrayList<>();

        try (FileReader reader = new FileReader(FILENAME)){
            folders_in.add(gson_translater.fromJson(reader, DFolder.class));
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("File Not Found Error - MainController.readFolders()");
        }
        return folders_in;
    }

    // Returns the folder names from the JSON file.
    public ArrayList<String> readFolderNames(){
        ArrayList<String> folder_names = new ArrayList<>();
        ArrayList<DFolder> folders_in;
        folders_in = readFolders();

        for (int index = 0; index < folders_in.size(); index++){
            folder_names.add(folders_in.get(index).getName());
        }

        return folder_names;
    }

    // Saves a new folder to the JSON file. Returns true if successful, false otherwise.
    public boolean saveNewFolder(String folderName, String rootFolderName) throws Exception {
        DFolder folder = new DFolder(folderName);
        ArrayList<String> folder_names = readFolderNames();
        for (int index = 0; index < folder_names.size(); index++){
            if (folder_names.get(index).equals(rootFolderName)){
                folder = new DFolder(folderName, readFolders().get(index));
            } else if (index == folder_names.size()-1){
                throw new Exception("This Folder's Root is NOT in the list of Folders");
            }
        }

        if (folder.getName().equals(""))



        folders.add(folder);
        try (FileWriter writer = new FileWriter(FILENAME, true)){
            gson_translater.toJson(folder,writer);
            return true;
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("File Not Found Error - MainController.saveNewFolder()");
            return false;
        }
    }





}
