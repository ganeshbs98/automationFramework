package com.ui.Utilis;

import com.google.gson.Gson;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class JsonUtility {
    private static final Gson gson = new Gson();

    public static <T> T readJson(String filePath, Class<T> clazz) {
        String fil = System.getProperty("user.dir") + filePath;
        try {
            File file = new File(fil);
            FileReader reader = new FileReader(file);
            return gson.fromJson(reader, clazz);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

}
