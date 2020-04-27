package com.example.asymmetrical_android;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainController implements Serializable {
    private static final String NAME = "name";
    private static final DFolder ROOT = new DFolder("~");
    private static final String FILENAME_LIST = "folders.json";
    private static final String FILENAME_ROOT = "rootFolder.json";

    // GSON- the JSON translator
    private Gson gson_translater;
    // File Input/Output
    private FileReader reader;
    private FileWriter writer;

    private DFolder homeFolder;

    private ArrayList<DFolder> folders;

    public MainController() {
        folders = new ArrayList<DFolder>();

        gson_translater = new Gson();
        homeFolder = new DFolder("home");
        folders.add(homeFolder);
    }

    // ---------------------------------------------------------------------–––––––---–––––--------
    // Public External Use Methods

    // If the view needs access to the file, it must make requests for data that is in the file
    // through the controller.
    public ArrayList<String> requestFolderNamesFromFile(){
        ArrayList<String> folderNames = new ArrayList<String>();

        folderNames = readFolderNames(FILENAME_LIST);

        return folderNames;
    }


    // ---------------------------------------------------------------------–––––––---–––––--------
    // Private Internal Use Methods

    // Serializable necessary functions:
    private void writeObject(java.io.ObjectOutputStream out) throws IOException {
        out.writeObject(homeFolder.getName());
        String[] outFolderNames = readFolderNames(FILENAME_LIST).toArray(new String[0]);
        out.writeObject(outFolderNames);
    }

    private void readObject(java.io.ObjectInputStream in) throws IOException, ClassNotFoundException {
        homeFolder = new DFolder((String)in.readObject());
        String[] inputFolders = (String[]) in.readObject();
        


    }

    private void readObjectNoData() throws ObjectStreamException {
        gson_translater = new Gson();
        homeFolder = new DFolder("home");

        folders = new ArrayList<DFolder>();
        folders.add(homeFolder);
    }


    // Reads in the folders from the JSON file.
    private ArrayList<DFolder> readFolders(String jsonFileName){
        ArrayList<DFolder> folders_in = new ArrayList<>();

        try (FileReader reader = new FileReader(jsonFileName)){
            folders_in.add(gson_translater.fromJson(reader, DFolder.class));
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("File Not Found Error - MainController.readFolders()");
        }
        return folders_in;
    }

    // Returns an ArrayList<String> of folder names from the given JSON file.
    private ArrayList<String> readFolderNames(String jsonFileName){
        ArrayList<String> folder_names = new ArrayList<>();
        ArrayList<DFolder> folders_in;
        folders_in = readFolders(jsonFileName);

        for (int index = 0; index < folders_in.size(); index++){
            folder_names.add(folders_in.get(index).getName());
        }

        return folder_names;
    }

    // Saves a new folder to the JSON file. Returns true if successful, false otherwise.
    private boolean saveNewFolder(String folderName, String rootFolderName) throws Exception {
        DFolder new_folder = new DFolder(folderName, rootFolderName);
        ArrayList<String> folder_names = readFolderNames(FILENAME_LIST);

        int foundFolder_index = -1;
        for ( String name : folder_names){
            if (name.equalsIgnoreCase(rootFolderName)){
                foundFolder_index = folder_names.indexOf(name);
                break;
            }
        }
        if (foundFolder_index == -1){
            throw new Exception();
        }
        else {
            folders.get(foundFolder_index).AddFolder(new_folder);
            overwriteFolderListToJson();
            return true;
        }
    }


    private void overwriteFolderListToJson() throws Exception {
        writer = new FileWriter(FILENAME_LIST, false);
        gson_translater.toJson(folders, writer);
    }

    private void overwriteHomeFolderToJson() throws Exception {
        writer = new FileWriter(FILENAME_ROOT, false);
        gson_translater.toJson(homeFolder, writer);
    }




}
