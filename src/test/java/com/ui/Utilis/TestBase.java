package com.ui.Utilis;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ui.PojoClasses.*;
import com.ui.Utilis.Android.AppiumManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.*;
import org.testng.xml.XmlTest;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Properties;


public class TestBase extends Browser {
    Logger logger = LoggerUtility.getLogger(this.getClass());


    public WebDriver driver;
    public AndroidDriver androidDriver;
    public IOSDriver iosDriver;

    public TestBase() {
        if (browser() != null) {
            this.driver = browser();
        } else if (android() != null) {
            this.androidDriver = android();
        } else {
            this.iosDriver = ios();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    //    public WebDriver getDriver() {
//        return driver;
//    }
//
    public void setDriver(WebDriver driver) {
        this.driver = driver;
    }

    public AndroidDriver getAndroidDriver() {
        return androidDriver;
    }

    //
    public void setAndroidDriver(AndroidDriver androidDriver) {
        this.androidDriver = androidDriver;
    }

    public IOSDriver getIosDriver() {
        return iosDriver;
    }

    public void setIosDriver(IOSDriver iosDriver) {
        this.iosDriver = iosDriver;
    }

    @BeforeSuite
    public void reportInitalisation(ITestContext iTestContext, XmlTest xmlTest) {
        propertiesPojo=setProperties();
        intialiseExtentReport(iTestContext, xmlTest);
    }

    @BeforeClass(alwaysRun = true)
    protected void beforeTest(ITestContext context, XmlTest xmlTest) {
        logger.info("Setting up the test environment");
        createExtentClassName(xmlTest);
    }

    @BeforeTest
    protected void testBaseInitialisation(ITestContext context, XmlTest xmlTest, Method method) {
        String[] suitename = context.getSuite().getName().split("\\|");
        mobileApps= Arrays.asList(propertiesPojo.getMobile_Apps().split(","));
        webApps = Arrays.asList(propertiesPojo.getWeb_Apps().split(","));
        if (platformType == null) {
            System.out.println(suitename[1]);
            platformType = suitename[1];
        }
        logger.info("loading and setting the remote env json");
        RemoteEnvPojo tRemoteEnv = JsonUtility.readJson("/tenv/remote-env.json", RemoteEnvPojo.class);
        logger.info("loading and setting the Test env json");
        TestEnvPojo tLocalEnv = JsonUtility.readJson("/tenv/test-env.json", TestEnvPojo.class);
        envThreadLocal.set(new TestEnv());
        tEnv().setExecution_type(tRemoteEnv.getExecution_type());
        tEnv().setGrid_execution_local(tRemoteEnv.getGrid_execution_local());
        tEnv().setInitialSelfHeal(tRemoteEnv.getInitialSelfHeal());
        tEnv().setMailPassword(tEnv().getMailPassword());
        tEnv().setHealingToggle(tRemoteEnv.getHealingToggle());
        tEnv().setHealingMatchScore(tRemoteEnv.getHealingMatchScore());
        tEnv().setJenkins_execution(tRemoteEnv.getJenkins_execution());
        tEnv().setAppType("Android");

        if (tLocalEnv.getWeb() != null) {
            tEnv().setWebSystemOS(tLocalEnv.getWeb().getSystemOS());
            tEnv().setWebSystemOSVersion(tLocalEnv.getWeb().getSystemOsVersion());
            tEnv().setWebBrowser(tLocalEnv.getWeb().getBrowser());
            tEnv().setWebHeadless(tLocalEnv.getWeb().getHeadless());
            tEnv().setWebBrowserVersion(tLocalEnv.getWeb().getBrowserVersion());
            tEnv().setWebUrl(tLocalEnv.getWeb().getWebUrl());
            tEnv().setWebBuildNumber(tLocalEnv.getWeb().getBuildNumber());
            tEnv().setWebNetworkLogs(tLocalEnv.getWeb().getNetworkLgs());
            tEnv().setApiEnvType(tLocalEnv.getApi().getEnv_Type());
            envtype = tEnv().getApiEnvType();
        }
        if (context.getSuite().getParameter("url") != null) {
            tEnv().setWebUrl(context.getSuite().getParameter("url"));
            System.out.println(tEnv().getWebUrl());
        }
    }

    @BeforeMethod(alwaysRun = true)
    public void setUp(ITestContext context, XmlTest xmlTest, Method method) {
        logger.info("creating the Browser Instance");
        if (!platformType.equalsIgnoreCase("Web")) {
            remoteMobileInit(context,xmlTest);
        } else {
            remoteBrowserInit(context, xmlTest);
        }
        logger.info("Setting up the test method: " + method.getName());
        createExtentMethod(context, xmlTest, method.getName());
    }


    protected void remoteBrowserInit(ITestContext context, XmlTest xmlTest) {
        try {
//            if (webApps.contains(tEnv().getTestType()) && appType.equalsIgnoreCase("web")) {
                tEnv().setElementLocator("Web");
                createBrowserInstance(context, xmlTest);
//            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//
//
    protected void remoteMobileInit(ITestContext context, XmlTest xmlTest) {
        try {

//            if (mobileApps.contains(tEnv().getTestType()) && !appType.equalsIgnoreCase("web")) {
                if (!tEnv().getExecution_type().equalsIgnoreCase("remote")) {
                    AppiumManager appiumManager = new AppiumManager();
                    appiumManager.startAppium();
//                }
                if (tEnv().getAppType().equalsIgnoreCase("Android")) {
                    tEnv().setElementLocator("Android");
                    AndroidNative(context, xmlTest);

                }
                if (tEnv().getAppType().equalsIgnoreCase("AndroidBrowser")) {
                    tEnv().setElementLocator("Web");
                    AndroidNative(context, xmlTest);

                }
                if (tEnv().getAppType().equalsIgnoreCase("ios")) {
                    tEnv().setElementLocator("IOS");
                    iosNative(context, xmlTest);

                }
                if (tEnv().getAppType().equalsIgnoreCase("iOSBrowser")) {
                    tEnv().setElementLocator("Web");
                    iosNative(context, xmlTest);

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    @AfterSuite
    public void afterSuite() {
        // You can add final report cleanup or closure here if needed
    }

    private void intialiseExtentReport(ITestContext iTestContext, XmlTest xmlTest) {
        extent = new ExtentReports();
        ExtentSparkReporter sparkFail = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/" + iTestContext.getSuite().getName() + "_Fail.html").filter().statusFilter().as(new Status[]{Status.FAIL}).apply();
        ExtentSparkReporter sparkAll = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/" + iTestContext.getSuite().getName() + ".html");
        sparkFail.config().setReportName(iTestContext.getSuite().getName());
        sparkFail.config().setTimelineEnabled(false);
        sparkAll.config().setReportName(iTestContext.getSuite().getName());
        sparkAll.config().setTimelineEnabled(false);
        extent.attachReporter(sparkAll, sparkFail);

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

    public void createExtentMethod(ITestContext context, XmlTest xmlTest, String method) {
        if (extent != null) {
            if (extentClassNode.get() == null) {
                createExtentClassName(xmlTest);
            }
            if (extentClassNode.get() != null) {
                extentMethodNode.set(extentClassNode.get().createNode(method));
            }
            if (tEnv().getContext().getIncludedGroups().length > 0) {
                for (String cat : context.getIncludedGroups()) {
                    extentClassNode.get().assignCategory(cat);
                }
            }
        }
    }

    public void extentFlush() {
        if (extent != null) {
            try {
                extent.flush();
            } catch (ConcurrentModificationException c) {
                try {
                    Thread.sleep(1000);
                    extent.flush();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    public void createExtentTest(String name, String desc) {
        if (extent != null) {
            if (extentPojo == null) {
                extentPojo = new ExtentPojo();
            }
            extentPojo.setExtentTest(extent.createTest(name, desc));
            extentTestNode.set(extentPojo.getExtentTest());
        }
    }

    public synchronized PropertiesPojo setProperties() {
        try {
            Properties testConfig = propertyUtility.readProperties("Configuration/testconfig.properties");
            propertiesPojo.setMobile_Apps(testConfig.getProperty("Mobile_Apps"));
            propertiesPojo.setWeb_APPS(testConfig.getProperty("Web_Apps"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        return propertiesPojo;
    }


}
