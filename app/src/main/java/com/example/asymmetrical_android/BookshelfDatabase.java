package com.example.asymmetrical_android;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BookshelfDatabase extends SQLiteOpenHelper {

    // Required values for the use of a SQLite Database
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "BookshelfDB";
    private static final String TABLE_BOOK_NAME = "BookTable";
    private static final String TABLE_CHAPTER_NAME = "ChapterTable";
    private static final String TABLE_SHELF_NAME = "BookshelfTable";

    // BookTable Column Names
    private static final String BOOK_PRIMARY_KEY = "key";
    private static final String BOOK_TITLE = "title";

    // ChapterTable Column Names
    private static final String CHAPTER_PRIMARY_KEY = "chapter_number";
    private static final String CHAPTER_TITLE = "title";
    private static final String CHAPTER_CONTENT = "page";

    // BookshelfTable
    private static final String SHELF_PRIMARY_KEY = "key";
    private static final String SHELF_BOOK_ID = "bookshelf_id";
    private static final String SHELF_CHAPTER_ID = "book_id";

    // Default inherited Constructor
    public BookshelfDatabase(Context context){
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    // ---------------------------------------------------------------------------------------------
    // Required methods to extend SQLiteOpenHelper

    // Create the tables in the database.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createBookTable = String.format("CREATE TABLE %s ("
                + "\n" + "%s PRIMARY KEY NOT NULL,"
                + "\n" + "%s TEXT NOT NULL"
                + "\n" + " )", TABLE_BOOK_NAME, BOOK_PRIMARY_KEY, BOOK_TITLE);
        String createChapterTable = String.format("CREATE TABLE %s ("
                + "\n" + "%s PRIMARY KEY NOT NULL,"
                + "\n" + "%s TEXT NOT NULL, "
                + "\n" + "%s TEXT"
                + "\n" + " )", TABLE_CHAPTER_NAME, CHAPTER_PRIMARY_KEY, CHAPTER_TITLE, CHAPTER_CONTENT);
        String createBookshelfTable = String.format("CREATE TABLE %s )"
                + "\n" + "%s PRIMARY KEY NOT NULL,"
                + "\n" + "%s INTEGER,"
                + "\n" + "%s INTEGER"
                + "\n" + " )", TABLE_SHELF_NAME, SHELF_PRIMARY_KEY, SHELF_BOOK_ID, SHELF_CHAPTER_ID);

        db.execSQL("PRAGMA foreign_keys = ON");
        db.execSQL(createBookTable);
        db.execSQL(createChapterTable);
        db.execSQL(createBookshelfTable);
    }

    // If a new version of the database exists, upgrade the database.
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (oldVersion >= newVersion)
            return;
        else {
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOK_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_BOOKSHELF_NAME);
            db.execSQL("DROP TABLE IF EXISTS " + TABLE_CATALOGUE_NAME);
            onCreate(db);
        }
    }

    // -------------------------------–––––––-------------------------------------------------------

    // Adds a Book to the Bookshelf Database
    public long addBook(Book book){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(BOOKSHELF_BOOK_TITLE, book.getBookTitle());
        values.put(BOOKSHELF_DATE_CREATION, book.getCreationDate().toString());
        values.put(BOOKSHELF_DATE_MODIFIED, book.getModificationDate().toString());

        // Inserts the data into the database
        long key = db.insert(TABLE_BOOKSHELF_NAME, null, values);
        return key;
    }

    // Adds a chapter to the Book Database - returns chapter number as a key
    public long addChapter(Chapter chapter){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(BOOK_CHAPTER_TITLE, chapter.getChapterTitle());
        values.put(BOOK_DATE_CREATION, chapter.getCreationDate().toString());
        values.put(BOOK_DATE_MODIFIED, chapter.getModificationDate().toString());

        // Inserts data into the database
        long key = db.insert(TABLE_BOOK_NAME, null, values);
        return key;
    }

    // Updates the specific chapter
    public long updateChapter(Chapter chapter){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(BOOK_CHAPTER_TITLE, chapter.getChapterTitle());
        values.put(BOOK_PAGE_CONTENT, chapter.getPage());
        values.put(BOOK_DATE_MODIFIED, chapter.getModificationDate().toString());

        return db.update(TABLE_BOOK_NAME, values,BOOK_CHAPTER_NUMBER+"=?", new String[]{String.valueOf(chapter.getChapterNumber())});

    }

}
