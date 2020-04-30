package com.example.asymmetrical_android;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BookshelfDatabase extends SQLiteOpenHelper {

    // Required values for the use of a SQLite Database
    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "BookshelfDB";
    private static final String TABLE_BOOKSHELF_NAME = "BookshelfTable";
    private static final String TABLE_BOOK_NAME = "BookTable";
    private static final String TABLE_CATALOGUE_NAME = "CataglogueTable";

    // BookshelfTable Column Names
    private static final String BOOKSHELF_PRIMARY_KEY = "key";
    private static final String BOOKSHELF_BOOK_TITLE = "title";
    private static final String BOOKSHELF_DATE_CREATION = "creation_date";
    private static final String BOOKSHELF_DATE_MODIFIED = "modification_date";

    // BookTable Column Names
    private static final String BOOK_PRIMARY_KEY = "chapter_number";
    private static final String BOOK_CHAPTER_TITLE = "title";
//    private static final String BOOK_PAGE_KEY = "page_number";
    private static final String BOOK_PAGE_CONTENT = "page";
    private static final String BOOK_DATE_CREATION = "creation_date";
    private static final String BOOK_DATE_MODIFIED = "modification_date";

    // BookCatalogue
    private static final String CATALOGUE_PRIMARY_KEY = "key";
    private static final String CATALOGUE_BOOKSHELF_ID = "bookshelf_id";
    private static final String CATALOGUE_BOOK_ID = "book_id";

    public BookshelfDatabase(Context context){
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    // ---------------------------------------------------------------------------------------------
    // Required methods to extend SQLiteOpenHelper

    // Create the tables in the database.
    @Override
    public void onCreate(SQLiteDatabase db) {
        String createBookshelfTable = String.format("CREATE TABLE %s ("
                + "\n" + "%s PRIMARY KEY NOT NULL,"
                + "\n" + "%s TEXT NOT NULL,"
                + "\n" + "%s DATE,"
                + "\n" + "%s DATE"
                + "\n" + " )", TABLE_BOOKSHELF_NAME, BOOKSHELF_PRIMARY_KEY, BOOKSHELF_BOOK_TITLE, BOOKSHELF_DATE_CREATION, BOOKSHELF_DATE_MODIFIED);
        String createBookTable = String.format("CREATE TABLE %s ("
                + "\n" + "%s PRIMARY KEY NOT NULL,"
                + "\n" + "%s TEXT NOT NULL, "
                // + "\n" + "%s INTEGER,"
                + "\n" + "%s TEXT"
                + "\n" + "%s DATE,"
                + "\n" + "%s DATE"
                + "\n" + " )", TABLE_BOOK_NAME, BOOK_PRIMARY_KEY, BOOK_CHAPTER_TITLE, BOOK_PAGE_CONTENT, BOOK_DATE_CREATION, BOOK_DATE_MODIFIED); // Removed BOOK_PAGE_KEY, from Table
        String createCatalogueTable = String.format("CREATE TABLE %s )"
                + "\n" + "%s PRIMARY KEY NOT NULL,"
                + "\n" + "%s INTEGER,"
                + "\n" + "%s INTEGER"
                + "\n" + " )", TABLE_CATALOGUE_NAME, CATALOGUE_PRIMARY_KEY, CATALOGUE_BOOKSHELF_ID, CATALOGUE_BOOK_ID);

        db.execSQL(createBookshelfTable);
        db.execSQL(createBookTable);
        db.execSQL(createCatalogueTable);
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

    public long updateChapter(Chapter chapter){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(BOOK_CHAPTER_TITLE, chapter.getChapterTitle());
        values.put(BOOK_PAGE_CONTENT, chapter.getPage());
        values.put(BOOK_DATE_MODIFIED, chapter.getModificationDate().toString());

        return db.update(TABLE_BOOK_NAME, values,BOOK_PRIMARY_KEY+"=?", new String[]{String.valueOf(chapter.getChapterNumber())});

    }

}
