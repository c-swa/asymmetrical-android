package com.example.asymmetrical_android;

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


}
