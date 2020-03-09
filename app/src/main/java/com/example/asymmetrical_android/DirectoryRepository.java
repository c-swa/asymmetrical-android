package com.example.asymmetrical_android;

import android.app.Application;

import androidx.lifecycle.LiveData;

import java.util.List;

class DirectoryRepository {
    private DirectoryEventDao nDirectoryEDao;
    private LiveData<List<DirectoryEntry>> nAllDirectories;
    private LiveData<List<EventEntry>> nAllEvents;

    DirectoryRepository(Application application){
        DirectoryRoomDatabase db = DirectoryRoomDatabase.getDatabase(application);
        nDirectoryEDao = db.directoryEventDao();
        nAllDirectories = nDirectoryEDao.getAlphabetizedDirectories();
        nAllEvents = nDirectoryEDao.getAlphabetizedEvents();
    }

    // Observed LiveData notifies the observer when data changes.
    LiveData<List<DirectoryEntry>> getnAllDirectories(){
        return nAllDirectories;
    }
    LiveData<List<EventEntry>> getAnllEvents(){
        return nAllEvents;
    }


    //Adds new data to the database
    void insert(DirectoryEntry directory) {
        DirectoryRoomDatabase.databaseWriteExtractor.execute(() -> {
                nDirectoryEDao.insert(directory);
        });
    }

    void insert(EventEntry event){
        DirectoryRoomDatabase.databaseWriteExtractor.execute(() -> {
            nDirectoryEDao.insert(event)
        });
    }

    
}
