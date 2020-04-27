package com.example.asymmetrical_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import java.io.Serializable;
import java.util.List;

public class NewDataView extends AppCompatActivity {

    // Main Controller for data
    MainController dataController;
    // These objects are what the view will use to save the data to persistent storage

    ArrayAdapter<String> spinnerAdapter;
    List<String> spinnerItemList;

    // These variables are what the View will interact with.
    Switch isFolder;    // Acts like a boolean, chooses if the saved file is a Folder or a Note
    Button save;        // Save button takes input and sets to be persistent within the file system
    EditText name;      // Name of the file
    Spinner location;   // Location of the file
    Spinner rating;     // Integer rating of the file
    EditText comments;  // Saved comments of the file


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dataController = new MainController();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_data_view);

        dataController = (MainController) getIntent().getSerializableExtra("EXTRA_MAIN_CONTROLLER");

        save = findViewById(R.id.save_button);
        isFolder = findViewById(R.id.ev_dir_switch);
        name = findViewById(R.id.name_box);
        location = findViewById(R.id.location_spinner);
        rating = findViewById(R.id.rating_spinner);
        comments = findViewById(R.id.comments_box);


        // Clear list, then add all folders from the list.
//        clearList(spinnerItemList);

//        spinnerItemList.addAll(dataController.readFolderNames());  ** This method is NOT working.
        //addAllFromList(spinnerItemList, dataController.requestFolderNamesFromFile());

        // Adapter is used to add elements to the Spinner when it is created in the view.
//        spinnerAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, spinnerItemList);
//        spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

//        location.setAdapter(spinnerAdapter);

        save.setOnClickListener(v -> {
            if (isFolder.isChecked()){
                saveFolder();}
            else {
                saveNote();
            }
            finish();
        });
    }

    // private method to clear the list before it is loaded with the necessary data each time.
    private boolean clearList(List list){
        try {
            for (int index = 0; index < list.size(); index++){
                list.remove(index);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    // private method to add items from one list to another list
    private boolean addAllFromList(List<String> source, List<String> destination){
        try {
            for (int index = 0; index < source.size(); index++){
                destination.add(source.get(index));
            }
            return true;
        } catch (Exception e){
            e.printStackTrace();
            System.out.println("Exception thrown - NewDataView.addAllFromList()");
            return false;
        }
    }

    // Saves a note for when a Note is checked
    public boolean saveNote(){
        DNote note = new DNote(name.toString(), comments.toString());


        return false;
    }

    // Saves a folder for when a Folder is checked.
    public boolean saveFolder(){
         // Needs to have a way to pass the input for
                                                        // a non-root folder to be assigned.

        return false;
    }
}
