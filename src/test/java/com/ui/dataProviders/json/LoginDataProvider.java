package com.ui.dataProviders.json;

import com.google.gson.Gson;
import com.ui.PojoClasses.TestDataPojo.LoginDataPojo;
import com.ui.PojoClasses.TestDataPojo.User;
import com.ui.Utilis.CsvUtility;
import org.testng.annotations.DataProvider;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class LoginDataProvider {

    @DataProvider(name = "LogindataProvider")
    public Iterator<Object[]> LoginDataProvider(String file_path) {
        try{
            Gson gson=new Gson();
            String filePath=System.getProperty("user.dir")+file_path;
            File file=new File(filePath);
            FileReader file_Reader=new FileReader(file);
            LoginDataPojo data=gson.fromJson(file_Reader, LoginDataPojo.class);
            List<Object[]> dataToReturn=new ArrayList<>();
            for(User user:data.getData()){
                dataToReturn.add(new Object[]{user});

            }
            return dataToReturn.iterator();

        }catch(IOException e){
            e.printStackTrace();
            return null;
        }

    }

//    @DataProvider(name = "LogincsvdataProvider")
//    public Iterator<String[]> LoginCSVDataProvider(String filePath){
//        return CsvUtility.readCsv(filePath);
//    }

}
