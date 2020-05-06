package com.example.asymmetrical_android;

import java.security.spec.PKCS8EncodedKeySpec;
import java.sql.Date;
import java.util.ArrayList;

// Book is the object that will be used for containing the details of each book from the Database
public class Book {

    // Instance Variables for each item in the database (These will be the columns).
    private long primaryKey;
    private String bookTitle;
    private Date creationDate;
    private Date modificationDate;

    // This ArrayList is used for storing the data that the User is entering as a Chapter.
    private ArrayList<Chapter> chapters;

    public Book(){
        chapters = new ArrayList<>();
        setBookTitle("");
        setCreationDate(null);
        setModificationDate(null);
    }

    public Book(int key){
        primaryKey = key;
        chapters = new ArrayList<>();
        setBookTitle("");
        setCreationDate(null);
        setModificationDate(null);
    }

    public Book(int key, String title){
        primaryKey = key;
        chapters = new ArrayList<>();
        setBookTitle(title);
        setCreationDate(null);
        setModificationDate(null);
    }

    // Public Get Methods
    public String getBookTitle(){
        return bookTitle;
    }
    public Date getCreationDate(){
        return creationDate;
    }
    public Date getModificationDate(){
        return modificationDate;
    }
    public Chapter getChapter(int index){
        return chapters.get(index);
    }

    // Public Set Methods
    public  void setBookTitle(String title){
        bookTitle = title;
    }
    public void setCreationDate(Date date){
        creationDate = date;
    }
    public void setModificationDate(Date date){
        modificationDate = date;
    }
    public void addChapter(Chapter newChapter){
        chapters.add(newChapter);
    }


}
