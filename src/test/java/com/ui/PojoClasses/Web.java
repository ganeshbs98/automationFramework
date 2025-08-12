package com.ui.PojoClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Web {

    @SerializedName("system_os")
    @Expose
    private String systemOS;
    @SerializedName("system_os_version")
    @Expose
    private String systemOsVersion;
    @SerializedName("browser")
    @Expose
    private String browser;
    @SerializedName("headless")
    @Expose
    private String headless;
    @SerializedName("browser_version")
    @Expose
    private String browserVersion;
    @SerializedName("url")
    @Expose
    private String webUrl;
    @SerializedName("build_number")
    @Expose
    private String buildNumber;
    @SerializedName("network_logs")
    @Expose
    private Boolean networkLgs;


    public String getSystemOS() {
        return systemOS;
    }

    public void setSystemOS(String systemOS) {
        this.systemOS = systemOS;
    }

    public String getSystemOsVersion() {
        return systemOsVersion;
    }

    public void setSystemOsVersion(String systemOsVersion) {
        this.systemOsVersion = systemOsVersion;
    }

    public String getBrowser() {
        return browser;
    }

    public void setBrowser(String browser) {
        this.browser = browser;
    }

    public String getHeadless() {
        return headless;
    }

    public void setHeadless(String headless) {
        this.headless = headless;
    }

    public String getBrowserVersion() {
        return browserVersion;
    }

    public void setBrowserVersion(String browserVersion) {
        this.browserVersion = browserVersion;
    }

    public String getWebUrl() {
        return webUrl;
    }

    public void setWebUrl(String webUrl) {
        this.webUrl = webUrl;
    }

    public String getBuildNumber() {
        return buildNumber;
    }

    public void setBuildNumber(String buildNumber) {
        this.buildNumber = buildNumber;
    }

    public Boolean getNetworkLgs() {
        return networkLgs;
    }

    public void setNetworkLgs(boolean networkLgs) {
        this.networkLgs = networkLgs;
    }
}
