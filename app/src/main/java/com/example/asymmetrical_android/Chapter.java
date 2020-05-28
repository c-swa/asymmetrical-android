package com.example.asymmetrical_android;

import java.sql.Date;

class Page {
    private String contents;

    public String getContents(){
        return contents;
    }

    public void setContents(String contents) { this.contents = contents; }
}

public class Chapter {

    private long primaryKey;
    private String chapterTitle;
    private Date creationDate;
    private Date modificationDate;
    private Page page;

    public long getChapterNumber() {
        return primaryKey;
    }

    public String getChapterTitle() {
        return chapterTitle;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Date getModificationDate() {
        return modificationDate;
    }

    public String getPage(){
        return page.getContents();
    }

    public void setPage(String contents){
        page.setContents(contents);
    }

    public void setChapterTitle(String title){
        chapterTitle = title;
    }

    public void setCreationDate(Date date){
        creationDate = date;
    }

    public void setModificationDate(Date date){
        modificationDate = date;
    }
}
