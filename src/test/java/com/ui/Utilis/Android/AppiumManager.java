package com.ui.Utilis.Android;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;

public class AppiumManager {
    private AvailablePorts ap = new AvailablePorts();
    private AppiumDriverLocalService service;
    private AppiumServiceBuilder builder;
    private DesiredCapabilities cap;

    // Change the return type to AppiumDriverLocalService
    public AppiumDriverLocalService startAppium() {
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
            builder.usingDriverExecutable(new File("/Users/ganeshbs/.nvm/versions/node/v20.18.3/bin/node"));
            builder.withAppiumJS(new File("/Users/ganeshbs/.nvm/versions/node/v20.18.3/lib/node_modules/appium/build/lib/main.js"));

            // Start the server with the builder
            service = AppiumDriverLocalService.buildService(builder);
            service.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // Return the running service instance that has the URL
        return service;
    }

}