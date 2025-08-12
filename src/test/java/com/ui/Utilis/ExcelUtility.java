package com.ui.Utilis;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelUtility {
    public static void main(String[] args) throws IOException, InvalidFormatException {
        File f=new File(System.getProperty("user.dir")+"filepath");
        FileInputStream fis = new FileInputStream(f);
        XSSFWorkbook Ws=new XSSFWorkbook(fis);
        int sheet_no=Ws.getNumberOfSheets();
        for (int i = 0; i < sheet_no; i++) {
            String sheetname=Ws.getSheetAt(i).getSheetName();
            XSSFSheet sheet=Ws.getSheet(sheetname);
            int total_row=sheet.getLastRowNum();
            for (int j = 1; j <total_row ; j++) {
                Row row=sheet.getRow(j);
                if(row!=null){
                    for(Cell cell:row){
                        cell.getStringCellValue().trim();
                    }
                }
            }

        }
        Ws.close();
        fis.close();



    }
}
