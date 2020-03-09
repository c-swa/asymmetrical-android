package com.example.asymmetrical_android;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "event_table")
public class EventEntry {

    //Room Database pertinent information
    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "event")
    private String name;
    private DirectoryEntry file_location;
    private int rating;
    private String comments;

    public EventEntry(@NonNull String n_name){
        name = n_name;
    }

    public String getName(){
        return name;
    }

    public DirectoryEntry getFile_location(){
        return file_location;
    }

    public int getRating(){
        return rating;
    }

    public String getComments(){
        return comments;
    }
}
