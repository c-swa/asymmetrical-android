package com.example.asymmetrical_android;

import androidx.annotation.NonNull;

public class DNote {

    private String name;
    private DFolder file_location;
    private int rating;
    private String comments;

    public DNote(@NonNull String n_name){
        name = n_name;
    }

    public String getName(){
        return name;
    }

    public DFolder getFile_location(){
        return file_location;
    }

    public int getRating(){
        return rating;
    }

    public String getComments(){
        return comments;
    }
}
