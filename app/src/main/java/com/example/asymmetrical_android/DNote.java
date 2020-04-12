package com.example.asymmetrical_android;

import androidx.annotation.NonNull;

public class DNote {

    private String name;
    private DFolder file_location;
    private int rating;
    private String comments;

    // DNote Constructor
    public DNote(@NonNull String n_name, String n_comments){
        name = n_name; comments = n_comments;
    }

    public DNote(@NonNull String n_name){
        name = n_name; comments = "";
    }

    // Return Note Name
    public String getName(){
        return name;
    }

    // Return folder note is located in.
    public DFolder getFile_location(){
        return file_location;
    }

    // Return Rating
    public int getRating(){
        return rating;
    }

    // Return comments
    public String getComments(){
        return comments;
    }
}
