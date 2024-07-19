package com.example.assignmenttechexactly.model;

import com.google.gson.annotations.SerializedName;

public class AppModel {
    @SerializedName("app_id")
    private int appId;

    @SerializedName("fk_kid_id")
    private int kidId;

    @SerializedName("kid_profile_image")
    private String kidProfileImage;

    @SerializedName("app_name")
    private String appName;

    @SerializedName("app_icon")
    private String appIcon;

    @SerializedName("app_package_name")
    private String appPackageName;

    @SerializedName("status")
    private String status;

    public int getAppId() {
        return appId;
    }

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public int getKidId() {
        return kidId;
    }

    public void setKidId(int kidId) {
        this.kidId = kidId;
    }

    public String getKidProfileImage() {
        return kidProfileImage;
    }

    public void setKidProfileImage(String kidProfileImage) {
        this.kidProfileImage = kidProfileImage;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }

    public String getAppIcon() {
        return appIcon;
    }

    public void setAppIcon(String appIcon) {
        this.appIcon = appIcon;
    }

    public String getAppPackageName() {
        return appPackageName;
    }

    public void setAppPackageName(String appPackageName) {
        this.appPackageName = appPackageName;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
