package com.example.asymmetrical_android;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DirectoryEventDao {
    // This is our code that will provide services to query the local SQL light database
    // 1. Get all files/folders (Events and Directories) ordered in Alphabetic Order
    // 2. Insert a file/folder to the system
    // 3. Delete all or one file(s)

    @Insert(OnConflict = OnConflictStrategy.REPLACE)
    void insert(DirectoryEntry directoryEntry);

    @Insert(OnConflict = OnConflictStrategy.REPLACE)
    void insert(EventEntry eventEntry);

    @Query("DELETE FROM directory_table")
    void deleteAllDirectories();

    @Query("DELETE FROM event_table")
    void deleteAllEntries();

    // Allows us to view the updating data without having to use other methods. LiveData provides a
    // sort of observer class.
    @Query("SELECT * from directory_table ORDER BY directory asc")
    LiveData<List<DirectoryEntry>> getAlphabetizedDirectories();

    @Query("SELECT * from event_table ORDER BY event asc")
    LiveData<List<EventEntry>> getAlphabetizedEvents();

}
