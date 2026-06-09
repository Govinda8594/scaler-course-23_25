package com.scaler.DesignPattern.creation.factory;


import java.io.*;


public class FileLogger implements Logger{
    @Override
    public void log(String message) {
        File file = new File("C://filepath");
        FileWriter fw = null;
        try {
            fw = new FileWriter(file);
            fw.write(message);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
