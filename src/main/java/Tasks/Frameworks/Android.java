//package Tasks.Frameworks;
//
//import io.appium.java_client.remote.MobileCapabilityType;
//import org.openqa.selenium.MutableCapabilities;
//import org.testng.ITestContext;
//import org.testng.xml.XmlTest;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class Android extends MobaileBase{
//
//    public  void androidNative(ITestContext iTestContext, XmlTest xmlTest) {
//        MutableCapabilities androidCaps=new MutableCapabilities();
//        HashMap<String, Object> browserstackOptions = new HashMap<>();
//        try{
//            androidCaps.setCapability(MobileCapabilityType.PLATFORM_NAME,"Android");
//            androidCaps.setCapability(MobileCapabilityType.DEVICE_NAME,"device name from suite or in tenv");
//            androidCaps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"platform version from suite or in tenv");
//
//            if(true){
//                browserstackOptions.put("projectName",iTestContext.getSuite().getName());
//                browserstackOptions.put("buildName",iTestContext.getSuite().getName());
//                browserstackOptions.put("sessionName",xmlTest.getName());
//                browserstackOptions.put("appiumVersion","2.0.1");
//                browserstackOptions.put("realMobile", "true"); // Use a real device on BrowserStack
//                browserstackOptions.put("debug", "true");
//                browserstackOptions.put("consoleLogs", true);
////                browserstackOptions.put("Device Orientation","landscape");
//                browserstackOptions.put("acceptInsecureCerts", "true");
//                browserstackOptions.put("appProfiling", true);
//                HashMap<String, Boolean> networkLogsOptions = new HashMap<>();
//                networkLogsOptions.put("captureContent", true);
//                androidCaps.setCapability("browserstack.networkLogs", true);
//                androidCaps.setCapability("browserstack.networkLogsOptions", networkLogsOptions);
//                androidCaps.setCapability("browserstack.realMobileInteraction", "true");
//
//                if (tEnv().getNetworkProfile() != null) {
//                    androidCaps.setCapability("browserstack.networkProfile", tEnv().getNetworkProfile());
//                }
//                if (tEnv().getCustomNetwork() != null) {
//                    androidCaps.setCapability("browserstack.customNetwork", tEnv().getCustomNetwork());
//                }
//                androidCaps.setCapability("autoAcceptAlerts", true);
//                androidCaps.setCapability("unicodeKeyboard", true);
//                androidCaps.setCapability("resetKeyboard", true);
//                if (tEnv().getDeviceLocation() != null && tEnv().getDeviceLocation().equalsIgnoreCase("false")) {
//                    deviceLocation = false;
//                }
//                androidCaps.setCapability("autoGrantPermissions", deviceLocation);
//                browserstackOptions.put("idleTimeout", "600");
//                browserstackOptions.put("autoWait", "50");
//                browserstackOptions.put("appiumLogs", "true");
//                browserstackOptions.put("interactiveDebugging", "true");
//
//                if (tEnv().getGps_location() != null) {
//                    browserstackOptions.put("gpsLocation", tEnv().getGps_location());
//                }
//
//                if (tEnv().getBrowserstack_midSessionInstallApps() != null) {
//                    try {
//                        String obj[] = tEnv().getBrowserstack_midSessionInstallApps().split(",", 3);
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
//                                logStepAction("No valid BS apppaths param provided for browserstack_midSessionInstallApps");
//                        }
//                    } catch (Exception e) {
//                        hardFail(e + "\nNote : In case of multiple app BS paths, use commas(,) to separate. Maximum 3 apps allowed to install mid session by BS");
//                    }
//                }
//
//                browserstackOptions.put()
//
//            }
//
//
//        }catch (Exception e){
//            handleError(e.getMessage(), e);
//        }
//
//    }
//}
