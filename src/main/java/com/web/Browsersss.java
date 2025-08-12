//package com.web;
//
//import com.reports.Initializers;
//import io.github.bonigarcia.wdm.WebDriverManager;
//import org.openqa.selenium.MutableCapabilities;
//import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.openqa.selenium.firefox.FirefoxOptions;
//import org.openqa.selenium.ie.InternetExplorerDriver;
//import org.openqa.selenium.ie.InternetExplorerOptions;
//import org.openqa.selenium.remote.DesiredCapabilities;
//import org.openqa.selenium.remote.RemoteWebDriver;
//import org.openqa.selenium.safari.SafariDriver;
//import org.openqa.selenium.safari.SafariOptions;
//import org.testng.ITestContext;
//import org.testng.xml.XmlTest;
//
//import java.net.MalformedURLException;
//import java.net.URL;
//import java.time.Duration;
//import java.util.Arrays;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class Browser extends Initalizers {
//    private String browserType = "chrome";
//    private String executionType = "local";
//
//    protected void createInstance(ITestContext context, XmlTest xmlTest) {
//
//        executionType=tEnv().getExecutionType();
//        switch (browserType) {
//            case "chrome":
//                try {
//                    if (executionType.equalsIgnoreCase("local")) {
//                        WebDriverManager.chromedriver().setup();
//                        Map<String, Object> prefs = new HashMap<String, Object>();
//                        Map<String, Object> profile = new HashMap<String, Object>();
//                        Map<String, Object> contentSettings = new HashMap<String, Object>();
//                        ChromeOptions options = new ChromeOptions();
//                        options.addArguments("--disable-notifications");
//                        options.addArguments("--start-maximized");
//                        options.addArguments("disable-geolocation");
//                        options.addArguments("--disable-popup-blocking");
//                        options.addArguments("--disable-web-security");
//                        options.addArguments("--remote-allow-origins=*");
//                        contentSettings.put("geolocations", 1);
//                        contentSettings.put("notifications", 1);
//                        webdriverLocalThreadLocal.set(new ChromeDriver(options));
//
//                    } else {
//                        remoteExecution(context, xmlTest);
//                    }
//                } catch (Exception en) {
//                    en.printStackTrace();
//                }
//                break;
//            case "firefox":
//                try {
//                    if (executionType.equalsIgnoreCase("local")) {
//                        WebDriverManager.firefoxdriver().setup();
//                        FirefoxOptions options = new FirefoxOptions();
//                        Map<String, Object> prefs = new HashMap<String, Object>();
//                        Map<String, Object> profile = new HashMap<String, Object>();
//                        Map<String, Object> contentSettings = new HashMap<String, Object>();
//                        // SET CHROME OPTIONS
//                        // 0 - Default, 1 - Allow, 2 - Block
//                        contentSettings.put("geolocation", 1);
//                        contentSettings.put("notifications", 1);
//                        profile.put("managed_default_content_settings", contentSettings);
//                        prefs.put("profile", profile);
//                        options.setCapability("prefs", prefs);
//
////                        if (tEnv().getWebHeadless().equalsIgnoreCase("true")) {
////                            options.addArguments("--headless=new");
////                        }
//
////                        if(grid_execution_local.equalsIgnoreCase("true")){
////                            webDriverThreadLocal.set(new RemoteWebDriver(new URL(grid_Hub_IP),options));
////                        }else {
//                        webdriverLocalThreadLocal.set(new FirefoxDriver(options));
////                        }
//                    } else {
//                        remoteExecution(context, xmlTest);
//                    }
////                    launchURL(context);
//                } catch (Exception sn) {
////                    captureException(sn);
//                    //hardFail("Firefox Session Not created !!");
//                }
//                break;
//            case "safari":
//                try {
//                    if (executionType.equalsIgnoreCase("local")) {
//                        SafariOptions options = new SafariOptions();
//                        options.setAutomaticInspection(true);
//
//
////                        if(grid_execution_local.equalsIgnoreCase("true")){
////                            webDriverThreadLocal.set(new RemoteWebDriver(new URL(grid_Hub_IP),options));
////                        }else {
//                        webdriverLocalThreadLocal.set(new SafariDriver(options));
////                        }
//                    } else {
//                        remoteExecution(context, xmlTest);
//                    }
////                    launchURL(context);
//                } catch (Exception sn) {
////                    captureException(sn);
//                    //hardFail("Safari Session Not created !!");
//                }
//                break;
//            case "edge":
//                try {
//                    if (executionType.equalsIgnoreCase("local")) {
//                        EdgeOptions options = new EdgeOptions();
//                        //options.setAutomaticInspection(true);
////                        if (grid_execution_local.equalsIgnoreCase("true")) {
////                            webDriverThreadLocal.set(new RemoteWebDriver(new URL(grid_Hub_IP), options));
////                        } else {
//                        webdriverLocalThreadLocal.set(new EdgeDriver());
////                        }
//                    } else {
//                        remoteExecution(context, xmlTest);
//                    }
////                    launchURL(context);
//                } catch (Exception sn) {
////                    captureException(sn);
//                    sn.printStackTrace();
//                    //hardFail("Chrome Session Not created !!");
//                }
//                break;
//            case "opera":
//                try {
//                    if (executionType.equalsIgnoreCase("local")) {
////                        OperaOptions options = new OperaOptions();
////                        //options.setAutomaticInspection(true);
////                        if(grid_execution_local.equalsIgnoreCase("true")){
////                            webDriverThreadLocal.set(new RemoteWebDriver(new URL(grid_Hub_IP), options));
////                        }else {
////                            webDriverThreadLocal.set(new OperaDriver());
////                        }
////                        tEnv().getWebBrowser();
//                    } else {
//                        remoteExecution(context, xmlTest);
//                    }
//                } catch (Exception sn) {
////                    captureException(sn);
//                    sn.printStackTrace();
//                    //hardFail("Chrome Session Not created !!");
//                }
//                break;
//            case "ie":
//                try {
//                    if (executionType.equalsIgnoreCase("local")) {
//                        InternetExplorerOptions options = new InternetExplorerOptions();
//                        options.waitForUploadDialogUpTo(Duration.ofSeconds(2));
////                        if (grid_execution_local.equalsIgnoreCase("true")) {
////                            webDriverThreadLocal.set(new RemoteWebDriver(new URL(grid_Hub_IP), options));
////                        } else {
////                            webDriverThreadLocal.set(new InternetExplorerDriver());
////                        }
//                    } else {
//                        remoteExecution(context, xmlTest);
//                    }
//
//                } catch (Exception sn) {
////                    captureException(sn);
//                    sn.printStackTrace();
//                    //hardFail("Chrome Session Not created !!");
//                }
//                break;
//        }
//
//    }
//
//    private void remoteExecution(ITestContext context, XmlTest xmlTest) throws MalformedURLException {
//        DesiredCapabilities capabilities = new DesiredCapabilities();
////        capabilities.setCapability("browserName", browser);
////        capabilities.setCapability("browserVersion", browserVersion);
//        HashMap<String, Object> ltOptions = new HashMap<String, Object>();
//        ltOptions.put("username", "ganeshbs");
//        ltOptions.put("accessKey", "LT_uF8LYxNvsTqcxpqsmUDTGN17w67L2p9l59JKK993eHIOC0B");
//        ltOptions.put("build", "Selenium 4");
//        ltOptions.put("name", xmlTest.getName());
//        ltOptions.put("selenium_version", "4.0.0");
//        ltOptions.put("w3c", true);
//        ltOptions.put("console", true);
//        ltOptions.put("network", true);
//        ltOptions.put("devicelog", true);
//        ltOptions.put("terminal", true);
//        ltOptions.put("video", true);
//        ltOptions.put("debug", true);
//        ltOptions.put("visual", true);
//        capabilities.setCapability("LT:Options", ltOptions);
////        ltOptions.put("geoLocation",location);
//        ChromeOptions options = new ChromeOptions();
//        Map<String, Object> prefs = new HashMap<String, Object>();
//        Map<String, Object> profile = new HashMap<String, Object>();
//        Map<String, Object> contentSettings = new HashMap<String, Object>();
//        contentSettings.put("geolocation", 1);
//        contentSettings.put("notifications", 1);
//        profile.put("managed_default_content_settings", contentSettings);
//        prefs.put("profile", profile);
//        options.setExperimentalOption("prefs", prefs);
//        options.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
//        options.addArguments("--disable-popup-blocking");
//        options.addArguments("--disable-web-security");
//        webdriverLocalThreadLocal.set(new RemoteWebDriver(new URL("https://hub.lambdatest.com/wd/hub"), capabilities));
//        String sessionId = browser().getSessionId().toString();
//        System.out.println(sessionId);
//
//    }
//
//
//}
