package com.ui.Utilis;

import com.ui.PojoClasses.TestEnv;
import com.ui.Utilis.Android.Android;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.HasDevTools;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.safari.SafariOptions;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.xml.XmlTest;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class Browser extends Android {
    Logger logger=LoggerUtility.getLogger(this.getClass());
    private String browserType = "chrome";
    private String executionType = "local";
    protected void  createBrowserInstance(ITestContext iTestContext,XmlTest xmlTest) {
        String browserName = tEnv().getWebBrowser();
        if (browserName == null) {
            browserName = "chrome"; // Default browser
        }
        switch (browserName.toLowerCase()) {
            case "chrome":
                if (tEnv().getExecution_type().equalsIgnoreCase("local")) {
                    WebDriverManager.chromedriver().setup();
                    Map<String, Object> prefs = new HashMap<>();
                    Map<String, Object> profile = new HashMap<>();
                    Map<String, Object> contentSettings = new HashMap<>();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
//                    options.addArguments("--disable-notifications");
                    options.addArguments("-disable-geolocation");
                    options.addArguments("--disable-popup-blocking");
                    options.addArguments("--disable-web-security");
                    // SET CHROME OPTIONS
                    // 0 - Default, 1 - Allow, 2 - Block|
                    contentSettings.put("geolocation", 1);
                    contentSettings.put("notifications", 1);
                    profile.put("manage-default-content-settings=", contentSettings);
                    if (xmlTest.getParameter("headless") != null && tEnv().getWebHeadless().equalsIgnoreCase("true")) {
                        options.addArguments("--headless=new");
                    }
                    prefs.put("profile", profile);
                    options.setExperimentalOption("prefs", prefs);
                    logger.info("creating the local Browser Instance");
                    webDriverThreadLocal.set(new ChromeDriver(options));
                } else {
                    logger.info("Executing the remote instance");
                    remoteExecution(iTestContext, xmlTest);
                }
                launchURL(iTestContext);
                break;
            case "firefox":
                if (tEnv().getExecution_type().equalsIgnoreCase("local")) {
                    WebDriverManager.firefoxdriver().setup();
                    Map<String, Object> prefs = new HashMap<>();
                    Map<String, Object> profile = new HashMap<>();
                    Map<String, Object> contentSettings = new HashMap<>();
                    FirefoxOptions options = new FirefoxOptions();
                    options.addArguments("-private");                         // Private mode
                    options.addArguments("--headless");                       // Headless mode
                    options.addArguments("--width=1920");
                    options.addArguments("--height=1080");
                    options.addPreference("dom.webnotifications.enabled", false);  // Disable notifications
                    options.addPreference("geo.enabled", false);                   // Disable geolocation
                    options.addPreference("network.proxy.type", 0);                // No proxy

                    options.addArguments("--remote-allow-origins=*");
//                    options.addArguments("--disable-notifications");
                    options.addArguments("disbale-web-security");
                    // SET CHROME OPTIONS
                    // 0 - Default, 1 - Allow, 2 - Block|
                    contentSettings.put("geolocation", 1);
                    contentSettings.put("notifications", 1);
                    profile.put("manage-default-content-settings=", contentSettings);
                    if (xmlTest.getParameter("headless") != null && tEnv().getWebHeadless().equalsIgnoreCase("true")) {
                        options.addArguments("--headless=new");
                    }
                    webDriverThreadLocal.set(new FirefoxDriver(options));
                } else {
                    remoteExecution(iTestContext, xmlTest);
                }
                break;
            case "edge":
                if (tEnv().getExecution_type().equalsIgnoreCase("local")) {
                    WebDriverManager.chromedriver().setup();
                    Map<String, Object> prefs = new HashMap<>();
                    Map<String, Object> profile = new HashMap<>();
                    Map<String, Object> contentSettings = new HashMap<>();
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--remote-allow-origins=*");
//                    options.addArguments("--disable-notifications");
                    options.addArguments("-disable-geolocation");
                    options.addArguments("--disable-popup-blocking");
                    options.addArguments("--disable-web-security");
                    // SET CHROME OPTIONS
                    // 0 - Default, 1 - Allow, 2 - Block|
                    contentSettings.put("geolocation", 1);
                    contentSettings.put("notifications", 1);
                    profile.put("manage-default-content-settings", contentSettings);
                    if (xmlTest.getParameter("headless") != null && tEnv().getWebHeadless().equalsIgnoreCase("true")) {
                        options.addArguments("--headless=new");
                    }
                    webDriverThreadLocal.set(new ChromeDriver(options));
                } else {
                    remoteExecution(iTestContext, xmlTest);
                }
                break;
            case "safari":
                if (executionType.equalsIgnoreCase("local")) {
                    WebDriverManager.safaridriver().setup();
                    Map<String, Object> prefs = new HashMap<>();
                    Map<String, Object> profile = new HashMap<>();
                    Map<String, Object> contentSettings = new HashMap<>();
                    SafariOptions options = new SafariOptions();
                    options.setAutomaticInspection(false);
                    options.setAutomaticProfiling(false);
                    webDriverThreadLocal.set(new SafariDriver(options));
                } else {
                    remoteExecution(iTestContext, xmlTest);
                }
            default:
                throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }


    }

    private static void remoteExecution(ITestContext iTestContext, XmlTest xmlTest) {
        try {
            MutableCapabilities caps = new MutableCapabilities();
            HashMap<String, Object> browserStackOptions = new HashMap<>();
            caps.setCapability("browserName", tEnv().getWebBrowser());
            browserStackOptions.put("browserVersion", tEnv().getWebBrowserVersion());
            browserStackOptions.put("sessionName", xmlTest.getName() + " - " + iTestContext.getCurrentXmlTest().getName());
            browserStackOptions.put("debug", "true");
            HashMap<String, Boolean> networkLogsOptions = new HashMap<>();
            networkLogsOptions.put("captureContent", true);
            browserStackOptions.put("networkLogsOptions", networkLogsOptions);
            browserStackOptions.put("networkLogs", "true");
            browserStackOptions.put("video", "true");

            browserStackOptions.put("consoleLogs", "errors");
            browserStackOptions.put("idleTimeout", "600");
            browserStackOptions.put("autoWait", "30");
            if (tEnv().getGps_location() != null) {
                browserStackOptions.put("gpsLocation", tEnv().getGps_location());
            }


            String location = tEnv().getApiCountry();
            if (location.equalsIgnoreCase("AUS")) {
                location = "AU";
            } else if (location.equalsIgnoreCase("IRE")) {
                location = "IE";
            } else if (location.equalsIgnoreCase("UK") || location.equalsIgnoreCase("GT")) {
                location = "GB";
            }
            if (tEnv().getGeoLocation() != null) {
                location = tEnv().getGeoLocation();
            }
            browserStackOptions.put("geoLocation", location);
            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            options.addArguments("--disable-notifications");
            options.addArguments("-disable-geolocation");
            options.addArguments("--disable-popup-blocking");
            options.addArguments("disbale-web-security");
            HashMap<String, Object> contentSettings = new HashMap<>();
            HashMap<String, Object> profile = new HashMap<>();
            HashMap<String, Object> prefs = new HashMap<>();
            // SET CHROME OPTIONS
            // 0 - Default, 1 - Allow, 2 - Block|
            contentSettings.put("geolocation", 1);
            contentSettings.put("notifications", 1);
            profile.put("manage-default-content-settings=", contentSettings);
            options.setExperimentalOption("profile", profile);

            caps.setCapability("bstack:options", browserStackOptions);
            caps.setCapability(ChromeOptions.CAPABILITY, options);
            caps.setCapability("browserstack:ie:enablePopups", "true");

            webDriverThreadLocal.set(new RemoteWebDriver(new URL("https://hub-cloud.browserstack.com/wd/hub"), caps));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void launchURL(ITestContext context) {
        try {
            if ((tEnv().getWebUrl() == null) || (tEnv().getWebUrl().isEmpty())) {
                Assert.fail("Please provide webURL in TestEnvironment File");
            } else {
                browser().manage().window().maximize();
                if (!context.getSuite().getName().contains("adhoc")) {
                    browser().get(tEnv().getWebUrl());
                    browser().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    browser().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
                } else {
//                    logger.warn("Default URL is not loaded as It is adhoc task. please use navigateToUrl in your method level");
                }
            }
        } catch (Exception e) {
//            captureException(e);
//            hardFail("Unable to Launch Browser");
        }
    }

//    protected void closeMobileClassLevel() {
//        if (mobileApps.contains(tEnv().getTestType().toLowerCase()) && !appType.equalsIgnoreCase("web")) {
//            try {
////                if (ios() != null) {
////                    JavascriptExecutor jse = ios();
////                    if (executionType.equalsIgnoreCase("remote")) {
////                        getBSVideoSession();
////                        if (classFailAnalysisThread.get() != null) {
////                            if (classFailAnalysisThread.get().size() > 0) {
////                                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"Check Assertions in Report\"}}");
////                            }
////                        } else {
////                            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"NA\"}}");
////                        }
////
////                    }
//                ios().quit();
////                    logger.info("IOS App Quit Successful");
////            }
//            } catch (Exception e) {
////                captureException(e);
////                logger.error("The IOS App session does not exist or App already closed or crashed");
//            }
//            try {
//                if (android() != null) {
//                    JavascriptExecutor jse = android();
////                    if (executionType.equalsIgnoreCase("remote")) {
////                        getBSVideoSession();
////                        if (classFailAnalysisThread.get() != null) {
////                            if (classFailAnalysisThread.get().size() > 0) {
////                                jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"failed\", \"reason\": \"Check Assertions in Report\"}}");
////                            }
////                        } else {
////                            jse.executeScript("browserstack_executor: {\"action\": \"setSessionStatus\", \"arguments\": {\"status\": \"passed\", \"reason\": \"NA\"}}");
////                        }
////                    }
//                    android().quit();
////                    logger.info("Android App Quit Successful");
//                }
//            } catch (Exception e) {
////                captureException(e);
////                logger.error("The Android App session does not exist or App already closed or crashed");
//            }
//
////        if (!executionType.equalsIgnoreCase("remote")) {
////            try {
////                AppiumManager appiumManager = new AppiumManager();
////                appiumManager.stopAppium();
////            } catch (Exception e) {
////                captureException(e);
////            }
////        }
//        }
//    }
//
    protected void closeWebClassLevel() {
        try {
            logger.info("closing the browser session");
            browser().quit();
        } catch (
                Exception e) {
            e.printStackTrace();
        }
    }
}


