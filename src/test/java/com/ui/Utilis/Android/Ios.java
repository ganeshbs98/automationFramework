//package com.ui.Utilis;
//
//import io.appium.java_client.ios.IOSDriver;
//import io.appium.java_client.remote.MobileCapabilityType;
//import org.openqa.selenium.MutableCapabilities;
//import org.testng.ITestContext;
//import org.testng.xml.XmlTest;
//
//import javax.swing.text.MutableAttributeSet;
//import java.net.URL;
//import java.time.Duration;
//import java.util.HashMap;
//
//public class Ios extends intializers {
//    private static final String IOS = "IOS";
//    public static String executionType = "local";
//    MutableCapabilities iosCaps = new MutableCapabilities();
//    HashMap<String, Object> browserstackOptions = new HashMap<>();
//
//    protected void iosNative(ITestContext context, XmlTest xmlTest) {
//        try {
//            if (executionType.equalsIgnoreCase("remote")) {
//                if (context.getSuite().getParameter("AppType").equalsIgnoreCase("iOSBrowser")) {
//                    browserstackOptions.put("os_version", xmlTest.getParameter("os_version"));
//                    browserstackOptions.put("deviceName", xmlTest.getParameter("device"));
//                    iosCaps.setCapability(MobileCapabilityType.BROWSER_NAME, context.getSuite().getParameter("browserName").trim());
//                    iosCaps.setCapability(MobileCapabilityType.BROWSER_VERSION, context.getSuite().getParameter("browserVersion").trim());
//                    browserstackOptions.put("buildName", xmlTest.getParameter("buildName").trim());
//                } else {
//                    iosCaps.setCapability(MobileCapabilityType.PLATFORM_NAME, xmlTest.getParameter("os_version").trim());
//                    iosCaps.setCapability(MobileCapabilityType.DEVICE_NAME, xmlTest.getParameter("device").trim());
//                    iosCaps.setCapability(MobileCapabilityType.APP, xmlTest.getParameter("appPath").trim());
//                    browserstackOptions.put("buildName", xmlTest.getParameter("buildName").trim());
//                }
//                browserstackOptions.put("debug", "true");
//                browserstackOptions.put("projectName", context.getSuite().getName());
//                browserstackOptions.put("sessionName", xmlTest.getName() + "_" + context.getCurrentXmlTest().getName());
//                browserstackOptions.put("appiumVersion", "2.0.1");
//                browserstackOptions.put("realMobile", "true");
//                browserstackOptions.put("interactive", true);
//
//                iosCaps.setCapability("autoAcceptALerts", true);
//                iosCaps.setCapability("unicodeKeyboard", true);
//                iosCaps.setCapability("resetKeyboard", true);
//                iosCaps.setCapability("autoGrantPermissions", true);
//
//                HashMap<String, Boolean> networkLogsOptions = new HashMap<>();
//                networkLogsOptions.put("captureContent", true);
//                iosCaps.setCapability("browserstack.networkLogs", true);
//                iosCaps.setCapability("browserstack.networkLogsOptions", networkLogsOptions);
//                browserstackOptions.put("networkProfile", "reset");
//
//                String midSessionInstallApps = xmlTest.getParameter("midSessionInstallApps");
//                if (midSessionInstallApps != null) {
//                    try {
//                        String[] obj = midSessionInstallApps.split(",", 3);
//                        switch (obj.length) {
//                            case 1:
//                                browserstackOptions.put("midSessionInstallApps", new String[]{obj[0].trim()});
//                                break;
//                            case 2:
//                                browserstackOptions.put("midSessionInstallApps", new String[]{obj[0].trim(), obj[1].trim()});
//                                break;
//                            case 3:
//                                browserstackOptions.put("midSessionInstallApps", new String[]{obj[0].trim(), obj[1].trim(), obj[2].trim()});
//                                break;
//                            case 0:
//                                System.out.println("No valid BS apppaths param provided for browserstack_midSessionInstallApps");
//                        }
//                    } catch (Exception e) {
//                        throw new RuntimeException(e + "\nNote : In case of multiple app BS paths, use commas(,) to separate. Maximum 3 apps allowed to install mid session by BS");
//                    }
//                }
//                browserstackOptions.put("idleTimeout", "600");
//                browserstackOptions.put("autoWait", "50");
//                browserstackOptions.put("appiumLogs", "true");
//                browserstackOptions.put("interactiveDebugging", "true");
//                String location = context.getSuite().getParameter("location");
//                if (location.equalsIgnoreCase("AUS")) {
//                    location = "AU";
//                } else if (location.equalsIgnoreCase("IRE")) {
//                    location = "IE";
//                } else if (location.equalsIgnoreCase("USA")) {
//                    location = "US";
//                } else if (location.equalsIgnoreCase("UK") || location.equalsIgnoreCase("GT")) {
//                    location = "GB";
//                }
//                iosDriverThreadLocal.set(new IOSDriver(new URL("https://hub-cloud.browserstack.com/wd/hub"), iosCaps));
//                browserstackOptions.put("geoLocation", location);
//                iosCaps.setCapability("bstack:options", browserstackOptions);
//            } else {
//
//                if (context.getSuite().getParameter("AppType").equalsIgnoreCase("iOSBrowser")) {
//                    iosCaps.setCapability(MobileCapabilityType.BROWSER_NAME, "Safari");
//                    iosCaps.setCapability(MobileCapabilityType.BROWSER_VERSION, context.getSuite().getParameter("browserVersion").trim());
//
//                }
//
//                iosCaps.setCapability(MobileCapabilityType.DEVICE_NAME, context.getSuite().getParameter("device").trim());
//                iosCaps.setCapability(MobileCapabilityType.PLATFORM_VERSION, context.getSuite().getParameter("os_version").trim());
//                iosCaps.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest");
//                iosCaps.setCapability(MobileCapabilityType.PLATFORM_NAME, IOS);
//                iosCaps.setCapability(MobileCapabilityType.APP, context.getSuite().getParameter("appPath").trim());
//
//                iosCaps.setCapability("autoAcceptAlerts", true);
//                iosCaps.setCapability("unicodeKeyboard", true);
//                iosCaps.setCapability("resetKeyboard", true);
//                iosCaps.setCapability("autoGrantPermissions", true);
//                iosCaps.setCapability("autoDismissAlerts", true);
//                iosCaps.setCapability("useFirstMatch", true);
//                iosCaps.setCapability("skipLogCapture", false);
//                iosCaps.setCapability("showIOSLog", true);
//                iosCaps.setCapability("interKeyDelay", 50);
//                iosCaps.setCapability("nativeInstrumentsLib", false);
//                iosCaps.setCapability("showXcodeLog", false);
//                iosCaps.setCapability("waitForQuiescence", false);
//                iosCaps.setCapability("useJSONSource", false);
//                iosCaps.setCapability("includeNonModalElements", true);
//                iosCaps.setCapability("snapshotTimeout", 1);
////               iosCaps.setCapability("bundleId", tEnv().getIosBundleId());
//                iosDriverThreadLocal.set(new IOSDriver(new URL("appium url"), iosCaps));
//
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//    }
//
//    public static IOSDriver ios() {
//        return iosDriverThreadLocal.get();
//    }
//
//}
