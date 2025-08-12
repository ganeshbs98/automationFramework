package com.ui.Utilis;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import com.ui.PojoClasses.TestDataPojo.User;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CsvUtility {
    public static Iterator<User> readCsv(String file_path) {
//        String filePath = System.getProperty("user.dir") + file_path;
        String filePath = System.getProperty("user.dir") + "/TestData/data.csv";
        File file;
        FileReader fileReader;
        CSVReader csvReader;
        String[] data;
        List<User> userlist = null;
        try {
            file = new File(filePath);
            fileReader = new FileReader(file);
            csvReader = new CSVReader(fileReader);
            csvReader.readNext();//reading the Row with header name
            data=csvReader.readNext();
            userlist=new ArrayList<User>();

//            while((data=csvReader.readNext())!=null){
//                User user=new User(data[0],data[1]);
//                userlist.add(user);
//            }

        } catch (IOException | CsvValidationException e) {
            e.printStackTrace();

        }
        return userlist.iterator();
    }


}
