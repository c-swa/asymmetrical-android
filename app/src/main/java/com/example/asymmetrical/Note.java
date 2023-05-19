package com.example.asymmetrical;

import java.io.*;

public class Note {
    private FileReader fileReader;
    private FileWriter fileWriter;

    public void ReadFile(String filename){
        try {
            fileReader = new FileReader(filename);
        } catch (Exception e){
            System.out.println("Exception thrown: " + e.getMessage());
        }
    }
}
