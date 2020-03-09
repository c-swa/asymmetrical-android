package com.example.asymmetrical_android;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {EventEntry.class, DirectoryEntry.class}, version = 1, exportSchema = true)
public abstract class DirectoryRoomDatabase extends RoomDatabase {

    public abstract DirectoryEventDao directoryEventDao();

}
