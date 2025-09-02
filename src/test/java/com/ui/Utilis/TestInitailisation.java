package com.ui.Utilis;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.PojoClasses.ExtentPojo;
import com.ui.PojoClasses.RemoteEnvPojo;
import com.ui.PojoClasses.TestEnvPojo;
import org.testng.ITestContext;
import org.testng.xml.XmlTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.Calendar;
import java.util.Locale;

public class TestInitailisation extends TestBase {

    public void reportInitailsation(ITestContext context) {
        String suiteNameReplaced = context.getSuite().getName().replaceAll(" ", "").trim();
        String[] tType = suiteNameReplaced.split("\\|");
        if(platformType==null){
            platformType=tType[1];
        }
        RemoteEnvPojo tRemoteEnv=JsonUtility.readJson("tenv/remote-env.json", RemoteEnvPojo.class);
        String suiteNameWithTime = context.getSuite().getName();
        LocalDate currentDate = LocalDate.now();
        String Year = String.valueOf(currentDate.getYear());
        String month = currentDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH);
        String currentDay = String.valueOf(currentDate.getDayOfMonth());
        String datePath = creatFolder("src/test/resources", "TestResults", Year);
        String MonthPath = creatFolder(datePath, month, currentDay);
        String finalReportPath = creatFolder(MonthPath, suiteNameWithTime, "");


    }

    private void initializeExtentReport(String finalReportPath, String suiteNameWithTime) {
        extent = new ExtentReports();
        ExtentSparkReporter sparkFail = new ExtentSparkReporter(finalReportPath + "/" + suiteNameWithTime + "/failed.html").filter().statusFilter().as(new Status[]{Status.FAIL}).apply();
        ExtentSparkReporter sparkAll = new ExtentSparkReporter(finalReportPath + "/" + suiteNameWithTime + ".html");
        extent.attachReporter(sparkFail, sparkAll);

    }


    public void createExtentClassName(XmlTest xmlTest) {
        if (extent != null) {
            if (xmlTest.getParallel().toString().equals("classes")) {
                if (extentPojo == null) {
                    createExtentTest(xmlTest.getName(), "");
                }
                extentClassNode.set(extentPojo.getExtentTest().createNode(getClass().getSimpleName()));
            } else if (xmlTest.getParallel().toString().equals("tests")) {
                if (extentTestNode.get() == null) {
                    createExtentTest(xmlTest.getName(), "");
                }
                extentClassNode.set(extentTestNode.get().createNode(getClass().getSimpleName()));
            } else {
                if (extentPojo == null) {
                    createExtentTest(xmlTest.getName(), "");
                }
                extentClassNode.set(extentPojo.getExtentTest().createNode(getClass().getSimpleName()));
            }

        }
    }

    public void createExtentTest(String moduleNameReplaced, String testEnvVariables) {
        if (extent != null) {
            extentTest = extent.createTest(moduleNameReplaced + "<div style=\"color: #635959;font-size: 12px;\">" + testEnvVariables + "</div>");
            extentPojo = new ExtentPojo();
            extentPojo.setExtentTest(extentTest);
            extentTestNode.set(extentTest);
        }
    }

    public static String creatFolder(String filePath, String folderName, String subfolderName) {
        String resultsPath = System.getProperty("user.dir") + "src/test/resources/";
        try {
            File file = new File(filePath + File.separator + folderName);
            if (!file.exists()) {
                file.mkdir();
            }
            if (subfolderName != null) {
                File subFile = new File(file.getPath() + File.separator + subfolderName);
                if (!subFile.exists()) {
                    subFile.mkdir();
                }
                resultsPath = file.getPath() + File.separator + subfolderName;
            } else {
                resultsPath = filePath + File.separator + folderName;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultsPath;

    }

    public static String getCurrentTimeStamp() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd-HHmmss");
        Calendar cal = Calendar.getInstance();
        return dateFormat.format(cal.getTime());
    }

    public static String getCurrentDate() {
        SimpleDateFormat Date = new SimpleDateFormat("d-MMM-YYYY");
        LocalDate date = LocalDate.now();
        return Date.format(date);
    }
}
