package com.ui.Utilis;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class propertyUtility {
    public static Properties readProperties(String FileName) {
        File propFile=new File(System.getProperty("user.dir") + "/src/test/resources/"+FileName);
        FileReader fReader= null;
        Properties prop;
        try {
            fReader = new FileReader(propFile);
            prop=new Properties();
            prop.load(fReader);
            return prop;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
