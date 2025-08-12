package com.ui.Utilis.Android;

import com.ui.Utilis.Initializers;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.MutableCapabilities;
import org.testng.ITestContext;
import org.testng.xml.XmlTest;

import java.net.URL;
import java.util.HashMap;

public class Android extends Initializers {
    protected static ThreadLocal<AndroidDriver> androidDriverThreadLocal = new ThreadLocal<>();
    private static final String ANDROID = "Android";
    public static final String executionType = "local";

    protected void createAndroidInstance(ITestContext iTestContext, XmlTest xmlTest) {
        MutableCapabilities androidcaps = new MutableCapabilities();
        HashMap<String, Object> browserstackOptions = new HashMap<String, Object>();
        try {
            if (executionType.equalsIgnoreCase("remote")) {
                if (iTestContext.getSuite().getParameter("AppType").equalsIgnoreCase("AndroidBrowser")) {
                    browserstackOptions.put("os_version", xmlTest.getParameter("os_version"));
                    browserstackOptions.put("device", xmlTest.getParameter("device"));
                    androidcaps.setCapability("autoAcceptAlerts", true);
                    androidcaps.setCapability("unicodeKeyboard", true);
                    androidcaps.setCapability("resetKeyboard", true);
                    androidcaps.setCapability("autoGrantPermissions", true);
                    androidcaps.setCapability("browserVersion", xmlTest.getParameter("browserVersion"));
                } else {
                    androidcaps.setCapability(MobileCapabilityType.PLATFORM_NAME, tEnv().getAndroidOSVersion().trim());
                    androidcaps.setCapability(MobileCapabilityType.DEVICE_NAME, tEnv().getAndroidDevice().trim());
                    androidcaps.setCapability(MobileCapabilityType.APP, xmlTest.getParameter("appPath").trim());
                    browserstackOptions.put("buildName", xmlTest.getParameter("buildName").trim());
                }
                browserstackOptions.put("projectName", iTestContext.getSuite().getName());
                browserstackOptions.put("sessionName", xmlTest.getName() + "_" + iTestContext.getCurrentXmlTest().getName());
                browserstackOptions.put("appiumVersion", "2.0.1");
                browserstackOptions.put("realMobile", "true");
                browserstackOptions.put("acceptInsecureCerts", "true");
                browserstackOptions.put("appProfiling", true);
                HashMap<String, Boolean> networkLogsOptions = new HashMap<>();
                networkLogsOptions.put("captureContent", true);
                androidcaps.setCapability("browserstack.networkLogs", true);
                androidcaps.setCapability("browserstack.networkLogsOptions", networkLogsOptions);
                androidcaps.setCapability("browserstack.realMobileInteraction", "true");
                if (xmlTest.getParameter("networkProfile") != null) {
                    androidcaps.setCapability("browserstack.networkProfile", xmlTest.getParameter("networkProfile"));
                }
                String location = iTestContext.getSuite().getParameter("location");
                if (location.equalsIgnoreCase("AUS")) {
                    location = "AU";
                } else if (location.equalsIgnoreCase("IRE")) {
                    location = "IE";
                } else if (location.equalsIgnoreCase("USA")) {
                    location = "US";
                } else if (location.equalsIgnoreCase("UK") || location.equalsIgnoreCase("GT")) {
                    location = "GB";
                }
                androidcaps.setCapability("autoAcceptAlerts", true);
                androidcaps.setCapability("unicodeKeyboard", true);
                androidcaps.setCapability("resetKeyboard", true);
                androidcaps.setCapability("autoGrantPermissions", true);
                browserstackOptions.put("geoLocation", location);
                String midSessionInstallApps = xmlTest.getParameter("midSessionInstallApps");
                if (midSessionInstallApps != null) {
                    try {
                        String[] obj = midSessionInstallApps.split(",", 3);
                        switch (obj.length) {
                            case 1:
                                browserstackOptions.put("midSessionInstallApps", new String[]{obj[0].trim()});
                                break;
                            case 2:
                                browserstackOptions.put("midSessionInstallApps", new String[]{obj[0].trim(), obj[1].trim()});
                                break;
                            case 3:
                                browserstackOptions.put("midSessionInstallApps", new String[]{obj[0].trim(), obj[1].trim(), obj[2].trim()});
                                break;
                            case 0:
                                System.out.println("No valid BS apppaths param provided for browserstack_midSessionInstallApps");
                        }
                    } catch (Exception e) {
                        throw new RuntimeException(e + "\nNote : In case of multiple app BS paths, use commas(,) to separate. Maximum 3 apps allowed to install mid session by BS");
                    }
                }
                if (iTestContext.getSuite().getParameter("ProductName").equalsIgnoreCase("digitalBoard")) {
                    browserstackOptions.put("deviceOrientation", "landscape");
                }
                browserstackOptions.put("idleTimeout", "600");
                browserstackOptions.put("interactiveDebugging", "true");
                browserstackOptions.put("debug", "true");
                browserstackOptions.put("appiumLogs", "true");
                browserstackOptions.put("autoWait", "50");
                androidcaps.setCapability("bstack:options", browserstackOptions);
                androidDriverThreadLocal.set(new AndroidDriver(new URL("https://hub-cloud.browserstack.com/wd/hub"), androidcaps));
            } else {
                androidcaps.setCapability(MobileCapabilityType.PLATFORM_NAME, ANDROID);
                androidcaps.setCapability(MobileCapabilityType.DEVICE_NAME, "emulator-5554");
                androidcaps.setCapability(MobileCapabilityType.PLATFORM_VERSION, "15");
//                androidcaps.setCapability(MobileCapabilityType.APP, iTestContext.getSuite().getParameter("appPath").trim());
//                androidcaps.setCapability(MobileCapabilityType.APP, "");
                androidcaps.setCapability("automationName", "uiautomator2");
                androidcaps.setCapability("autoAcceptAlerts", true);
                androidcaps.setCapability("appPackage", tEnv().getAndroidAppPackage());
                androidcaps.setCapability("appActivity", tEnv().getAndroidAppActivity());
                if (iTestContext.getSuite().getParameter("ProductName").equalsIgnoreCase("digitalBoard")) {
                    androidcaps.setCapability("deviceOrientation", "landscape");
                }
                if (xmlTest.getParameter("AppType").equalsIgnoreCase("AndroidBrowser")) {
                    androidcaps.setCapability(MobileCapabilityType.BROWSER_NAME, "Chrome");

                }
                androidcaps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "10000");
                if (iTestContext.getSuite().getParameter("resetApp") != null && iTestContext.getSuite().getParameter("resetApp").equalsIgnoreCase("FullReset")) {// reinstall new client version
                    androidcaps.setCapability(MobileCapabilityType.FULL_RESET, true);
                    androidcaps.setCapability(MobileCapabilityType.NO_RESET, false);

                } else if (iTestContext.getSuite().getParameter("resetApp") != null && iTestContext.getSuite().getParameter("resetApp").equalsIgnoreCase("fastReset")) {// clears cache without reinstall
                    androidcaps.setCapability(MobileCapabilityType.NO_RESET, false);
                    androidcaps.setCapability(MobileCapabilityType.FULL_RESET, false);
                } else {

//                        logger.info("  AndroidDriver DO NORMAL start");
                    androidcaps.setCapability(MobileCapabilityType.FULL_RESET, false);
                    androidcaps.setCapability(MobileCapabilityType.NO_RESET, true);

                }
                androidDriverThreadLocal.set(new AndroidDriver(new URL(tEnv().getAppiumURL()),androidcaps));

            }
//            android().manage().timeouts().implicitlyWait(Duration.ofSeconds(8));
//            android().manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
//            tEnv().setDeviceDimension(android().manage().window().getSize());
//            String AndroidType = "Native App";
//            if (tEnv().getAppType().equalsIgnoreCase("AndroidBrowser")) {
//                android().navigate().to(tEnv().getWebUrl());
//                AndroidType = tEnv().getWebBrowser() + " Browser on " + tEnv().getWebBrowserVersion();
//            }
//            logger.info("*****************************************");
//            logger.info("Android " + AndroidType + " Launched Successfully in Device " + tEnv().getAndroidDevice());
//            logger.info("*****************************************");
//            long endTime = System.currentTimeMillis();
//            logger.info("Time Taken to Launch " + AndroidType + " App: : " + cUtils().getRunDuration(startTime, endTime));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static AndroidDriver android() {
        return androidDriverThreadLocal.get();
    }


}

