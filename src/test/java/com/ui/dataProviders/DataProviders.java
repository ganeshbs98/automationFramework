//package com.ui.dataProviders;
//
//import com.ui.dataProviders.json.JSONDataProvider;
//import org.testng.annotations.DataProvider;
//
//import java.lang.reflect.Method;
//
//public class DataProviders {
//
//    @DataProvider(name = "getDataFromJson")
//    public Object[][] jsonDataProvider(Method method) {
//        JSONDataProvider jsonDataProvider = new JSONDataProvider();
//        Object[][] dataProvider = jsonDataProvider.getJsonData(method.getName());
//        return dataProvider;
//    }
//}
