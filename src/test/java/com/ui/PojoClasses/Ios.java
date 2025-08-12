package com.ui.PojoClasses;

import com.google.gson.JsonObject;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Ios {
    @SerializedName("bundleid")
    @Expose
    private String bundleId;
    @SerializedName("udid")
    @Expose
    private String udid;
    @SerializedName("device")
    @Expose
    private String device;
    @SerializedName("os")
    @Expose
    private String OS;
    @SerializedName("region_ios_devices")
    @Expose
    private JsonObject regionIosDevices;

    public String getBundleId() {
        return bundleId;
    }

    public void setBundleId(String bundleId) {
        this.bundleId = bundleId;
    }

    public String getUdid() {
        return udid;
    }

    public void setUdid(String udid) {
        this.udid = udid;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getOS() {
        return OS;
    }

    public void setOS(String OS) {
        this.OS = OS;
    }

    public JsonObject getRegionIosDevices() {
        return regionIosDevices;
    }

    public void setRegionIosDevices(JsonObject regionIosDevices) {
        this.regionIosDevices = regionIosDevices;
    }
}
