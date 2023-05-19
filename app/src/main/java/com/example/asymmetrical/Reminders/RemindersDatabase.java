package com.example.asymmetrical.Reminders;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class RemindersDatabase extends SQLiteOpenHelper {

    // Required values for the use of a SQLite Database
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "RemindersDB";
    private static final String TABLE_NAME = "reminders";

    // Reminders Columns
    private static final String REMINDER_PRIMARY_KEY = "uuid";
    private static final String REMINDER_TEXT = "reminder_text";
    private static final String REMINDER_DATETIME = "reminder_datetime";

    public RemindersDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // --- Required Methods for SQLiteOpenHelper
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createReminderTable = new String("CREATE TABLE reminders ( uuid PRIMARY KEY, reminder_text TEXT NOT NULL, reminder_datetime DATETIME NULL)");

        db.execSQL(createReminderTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        if(oldVersion >= newVersion){
            return;
        } else{
            sqLiteDatabase.execSQL("DROP TABLE IF EXISTS reminders");
            onCreate(sqLiteDatabase);
        }
    }

    public long addReminder(Reminder reminder){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(REMINDER_TEXT, reminder.getReminderText());
        values.put(REMINDER_DATETIME, reminder.getReminderTime().toString());

        return db.insert(TABLE_NAME, null, values);
    }

    public long updateReminder(Reminder reminder, long key) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(REMINDER_PRIMARY_KEY, key);
        values.put(REMINDER_TEXT, reminder.getReminderText());
        values.put(REMINDER_DATETIME, reminder.getReminderTime().toString());
        return db.update(TABLE_NAME,values,"uuid = ?",new String[]{String.valueOf(key)});
    }

    public int deleteReminder(long key){
        SQLiteDatabase db = this.getWritableDatabase();

        return db.delete(TABLE_NAME, "uuid = ?", new String[]{String.valueOf(key)});
    }
}
