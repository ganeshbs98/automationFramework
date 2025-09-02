package com.ui.Utilis.Android;

import com.ui.Utilis.Initializers;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;
import org.testng.ITestContext;
import org.testng.xml.XmlTest;

import java.net.URL;
import java.time.Duration;
import java.util.HashMap;

public class Ios extends Initializers {
    private static final String IOS = "iOS";
    public static String executionType = "local";

    protected void iosNative(ITestContext context, XmlTest xmlTest) {
        IOSDriver driver = null;
        try {
            XCUITestOptions iosCaps = new XCUITestOptions();
            HashMap<String, Object> browserstackOptions = new HashMap<>();

            if (executionType.equalsIgnoreCase("remote")) {
                if (context.getSuite().getParameter("AppType").equalsIgnoreCase("iOSBrowser")) {
                    browserstackOptions.put("os_version", xmlTest.getParameter("os_version"));
                    browserstackOptions.put("deviceName", xmlTest.getParameter("device"));
                    iosCaps.setCapability("browserName", context.getSuite().getParameter("browserName").trim());
                    iosCaps.setCapability("browserVersion", context.getSuite().getParameter("browserVersion").trim());
                    browserstackOptions.put("buildName", xmlTest.getParameter("buildName").trim());
                } else {
                    iosCaps.setPlatformVersion(xmlTest.getParameter("os_version").trim());
                    iosCaps.setDeviceName(xmlTest.getParameter("device").trim());
                    iosCaps.setApp(xmlTest.getParameter("appPath").trim());
                    browserstackOptions.put("buildName", xmlTest.getParameter("buildName").trim());
                }
                browserstackOptions.put("debug", "true");
                browserstackOptions.put("projectName", context.getSuite().getName());
                browserstackOptions.put("sessionName", xmlTest.getName() + "_" + context.getCurrentXmlTest().getName());
                browserstackOptions.put("appiumVersion", "2.0.1");
                browserstackOptions.put("realMobile", "true");
                browserstackOptions.put("interactive", true);

                iosCaps.setCapability("autoAcceptALerts", true);
                iosCaps.setCapability("unicodeKeyboard", true);
                iosCaps.setCapability("resetKeyboard", true);
                iosCaps.setCapability("autoGrantPermissions", true);

                HashMap<String, Boolean> networkLogsOptions = new HashMap<>();
                networkLogsOptions.put("captureContent", true);
                iosCaps.setCapability("browserstack.networkLogs", true);
                iosCaps.setCapability("browserstack.networkLogsOptions", networkLogsOptions);
                browserstackOptions.put("networkProfile", "reset");

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
                browserstackOptions.put("idleTimeout", "600");
                browserstackOptions.put("autoWait", "50");
                browserstackOptions.put("appiumLogs", "true");
                browserstackOptions.put("interactiveDebugging", "true");
                String location = context.getSuite().getParameter("location");
                if (location.equalsIgnoreCase("AUS")) {
                    location = "AU";
                } else if (location.equalsIgnoreCase("IRE")) {
                    location = "IE";
                } else if (location.equalsIgnoreCase("USA")) {
                    location = "US";
                } else if (location.equalsIgnoreCase("UK") || location.equalsIgnoreCase("GT")) {
                    location = "GB";
                }
                URL remoteUrl = new URL("https://hub-cloud.browserstack.com/wd/hub");
                browserstackOptions.put("geoLocation", location);
                iosCaps.setCapability("bstack:options", browserstackOptions);
                iosDriverThreadLocal.set(new IOSDriver(remoteUrl, iosCaps));
            } else { // Local execution
                iosCaps.setPlatformName(IOS);
                iosCaps.setDeviceName(context.getSuite().getParameter("device").trim());
                iosCaps.setPlatformVersion(context.getSuite().getParameter("os_version").trim());
                iosCaps.setAutomationName("XCUITest");
                iosCaps.setApp(context.getSuite().getParameter("appPath").trim());

                if (context.getSuite().getParameter("AppType").equalsIgnoreCase("iOSBrowser")) {
                    iosCaps.setCapability("browserName", "Safari");
                    iosCaps.setCapability("browserVersion", context.getSuite().getParameter("browserVersion").trim());
                }

                iosCaps.setCapability("autoAcceptAlerts", true);
                iosCaps.setCapability("unicodeKeyboard", true);
                iosCaps.setCapability("resetKeyboard", true);
                iosCaps.setCapability("autoGrantPermissions", true);
                iosCaps.setCapability("autoDismissAlerts", true);
                iosCaps.setCapability("useFirstMatch", true);
                iosCaps.setCapability("skipLogCapture", false);
                iosCaps.setCapability("showIOSLog", true);
                iosCaps.setCapability("interKeyDelay", 50);
                iosCaps.setCapability("nativeInstrumentsLib", false);
                iosCaps.setCapability("showXcodeLog", false);
                iosCaps.setCapability("waitForQuiescence", false);
                iosCaps.setCapability("useJSONSource", false);
                iosCaps.setCapability("includeNonModalElements", true);
                iosCaps.setCapability("snapshotTimeout", 1);

                driver = new IOSDriver(new URL(tEnv().getAppiumURL()), iosCaps);
                iosDriverThreadLocal.set(driver);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}