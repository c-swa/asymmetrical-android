package com.example.asymmetrical_android;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "directory_table")
public class Directory_Entry {


    //Room Database pertinent information
    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = "directory")
    private String name;
    private Directory_Entry file_location;
    private int rating;
    private String comments;
}
