package com.example.asymmetrical_android;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Switch;

public class NewDataView extends AppCompatActivity {

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

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isFolder.isChecked())
                    saveFolder();
                else
                    saveNote();
            }
        });
    }

    public boolean saveNote(){
        
    }

    public boolean saveFolder(){

    }
}
