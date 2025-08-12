package com.dataProviders;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class JsonUtility {
    public static Gson gson=new Gson();

    public static <T> T  loadConfig(String filename, Class<T> clazz) {
        File jsonfile=new File(System.getProperty("user.dir")+filename);
        FileReader jsonFileReader = null;
        try{
            jsonFileReader= new FileReader(jsonfile);
            return gson.fromJson(jsonFileReader,clazz);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException(ex);
        }



    }
}
