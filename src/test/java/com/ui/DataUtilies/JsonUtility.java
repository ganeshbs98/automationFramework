package com.ui.DataUtilies;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;

public class JsonUtility {
    private static Gson gson=new Gson();

//    public <T> configLoader(String filename,Class<T> clazzz){
//        String filePath = System.getProperty("user.dir") + filename;
//        try (FileReader reader = new FileReader(filePath)) {
//            return gson.fromJson(reader, clazzz);
//        } catch (IOException e) {
//            throw new RuntimeException("Error in reading JSON file: " + filePath, e);
//        }
//
//    }


}
