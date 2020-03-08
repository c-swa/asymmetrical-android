package com.example.asymmetrical_android;

import android.util.EventLog;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "event_table")
public class Event_Entry {

    //Room Database pertinent information
    @PrimaryKey
    @NonNull
    @ColumnInfo(name = "event")
    private String name;
    private Directory_Entry file_location;
    private int rating;
    private String comments;

    public Event_Entry(@NonNull String n_name){
        name = n_name;
    }

    public String getName(){
        return name;
    }

    public Directory_Entry getFile_location(){
        return file_location;
    }

    public int getRating(){
        return rating;
    }

    public String getComments(){
        return comments;
    }
}
