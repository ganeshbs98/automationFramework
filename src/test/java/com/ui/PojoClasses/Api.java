package com.ui.PojoClasses;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Api {
    @SerializedName("URI")
    @Expose
    private String uri;
    @SerializedName("partnerURI")
    @Expose
    private String partner_uri;
    @SerializedName("version")
    @Expose
    private String Version;
    @SerializedName("envType")
    @Expose
    private String env_Type;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getPartner_uri() {
        return partner_uri;
    }

    public void setPartner_uri(String partner_uri) {
        this.partner_uri = partner_uri;
    }

    public String getVersion() {
        return Version;
    }

    public void setVersion(String version) {
        Version = version;
    }

    public String getEnv_Type() {
        return env_Type;
    }

    public void setEnv_Type(String env_Type) {
        this.env_Type = env_Type;
    }
}
