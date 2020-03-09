package com.example.asymmetrical_android;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {EventEntry.class, DirectoryEntry.class}, version = 1, exportSchema = true)
public abstract class DirectoryRoomDatabase extends RoomDatabase {

    public abstract DirectoryEventDao directoryEventDao();

    private static volatile DirectoryRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExtractor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static DirectoryRoomDatabase getDatabase(final Context context){
        if(INSTANCE == null){
            synchronized (DirectoryRoomDatabase.class){
                if(INSTANCE == null){
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            DirectoryRoomDatabase.class, "directory_database").build();
                }
            }
        }
        return INSTANCE;
    }
}
