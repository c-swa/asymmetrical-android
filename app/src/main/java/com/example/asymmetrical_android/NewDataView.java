package com.example.asymmetrical_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

import java.util.List;

public class NewDataView extends AppCompatActivity {

    // These objects are what the view will use to save the data to persistent storage
    FolderDataController folderController ;
    NoteDataController noteDataController;

    ArrayAdapter<DFolder> spinnerAdapter;
    List<DFolder> spinnerItemList;

    // These variables are what the View will interact with.
    Switch isFolder;    // Acts like a boolean, chooses if the saved file is a Folder or a Note
    Button save;        // Save button takes input and sets to be persistent within the file system
    EditText name;      // Name of the file
    Spinner location;   // Location of the file
    Spinner rating;     // Integer rating of the file
    EditText comments;  // Saved comments of the file


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_data_view);

        save = (Button) findViewById(R.id.save_button);
        isFolder = (Switch) findViewById(R.id.ev_dir_switch);
        name = (EditText) findViewById(R.id.name_box);
        location = (Spinner) findViewById(R.id.location_spinner);
        rating = (Spinner) findViewById(R.id.rating_spinner);
        comments = (EditText) findViewById(R.id.comments_box);

        // Clear list, then add all folders from the list.
        clearList(spinnerItemList);
     //    spinnerItemList.addAll(folderController.readFolders());

        // Adapter is used to add elements to the Spinner when it is created in the view.
     //   spinnerAdapter = new ArrayAdapter<DFolder>(getApplicationContext(), android.R.layout.simple_spinner_item, spinnerItemList);
     //   spinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
     //   location.setAdapter(spinnerAdapter);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFolder.isChecked()){
                    saveFolder();}
                else {
                    saveNote();
                }
                finish();
            }
        });
    }

    // private method for the list to clear before it is loaded with the necessary data each time.
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

    public boolean saveNote(){
        folderController = new FolderDataController();

        DNote note = new DNote(name.toString(), comments.toString());

        return false;
    }

    public boolean saveFolder(){
        return false;
    }
}
