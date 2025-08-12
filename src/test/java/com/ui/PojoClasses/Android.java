package com.ui.PojoClasses;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Android {
    @SerializedName("app_package")
    @Expose
    private String appPackage;
    @SerializedName("app_activity")
    @Expose
    private String appactivity;
    @SerializedName("device")
    @Expose
    private String device;
    @SerializedName("os")
    @Expose
    private String os;
    @SerializedName("region_android_devices")
    @Expose
    private JsonObject regionandroiddevices;


    public String getAppPackage() {
        return appPackage;
    }

    public void setAppPackage(String appPackage) {
        this.appPackage = appPackage;
    }

    public String getAppactivity() {
        return appactivity;
    }

    public void setAppactivity(String appactivity) {
        this.appactivity = appactivity;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getOs() {
        return os;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public JsonObject getRegionandroiddevices() {
        return regionandroiddevices;
    }

    public void setRegionandroiddevices(JsonObject regionandroiddevices) {
        this.regionandroiddevices = regionandroiddevices;
    }
}
