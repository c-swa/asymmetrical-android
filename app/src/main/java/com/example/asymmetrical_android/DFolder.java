package com.example.asymmetrical_android;

import androidx.annotation.NonNull;


public class DFolder {

    private String name;
    private DFolder fileLocation;
    private int rating;

    DFolder(@NonNull String init_name, DFolder init_fileLocation){
        name = init_name;
        fileLocation = init_fileLocation;
    }
}
