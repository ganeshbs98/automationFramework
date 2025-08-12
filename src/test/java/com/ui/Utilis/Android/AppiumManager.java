package com.ui.Utilis.Android;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;

public class AppiumManager {
    private AvailablePorts ap = new AvailablePorts();
    //    private PropertiesPojo propertiesPojo = new PropertiesPojo();
    private AppiumDriverLocalService service;
    private AppiumServiceBuilder builder;
    private DesiredCapabilities cap;

    public AppiumServiceBuilder startAppium() {
        try {
            cap = new DesiredCapabilities();
            cap.setCapability("noReset", "false");
            builder = new AppiumServiceBuilder();
            int Freeport = ap.getPort();
            builder.withIPAddress("0.0.0.0");
            builder.usingPort(Freeport);
            builder.withCapabilities(cap);
            builder.withArgument(GeneralServerFlag.SESSION_OVERRIDE);
            builder.withArgument(GeneralServerFlag.LOG_LEVEL, "error");
//        if(tEnv().getAppType().equalsIgnoreCase("AndroidBrowser")){
//            builder.withArgument(()-> "--allow-insecure", "chromedriver_autodownload");
//        }
            //if (tEnv().getAppType().equalsIgnoreCase("ios")) {
            // builder.withEnvironment(env);
            builder.usingDriverExecutable(new File("/Users/ganeshbs/.nvm/versions/node/v20.18.3/bin/node"));
            builder.withAppiumJS(new File("/Users/ganeshbs/.nvm/versions/node/v20.18.3/lib/node_modules/appium/build/lib/main.js"));

            //Start the server with the builder
            service = AppiumDriverLocalService.buildService(builder);
            service.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return builder;

    }
}
