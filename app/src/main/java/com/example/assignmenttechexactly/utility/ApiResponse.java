package com.example.assignmenttechexactly.utility;

import com.example.assignmenttechexactly.model.AppModel;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApiResponse {
    @SerializedName("success")
    private boolean success;

    @SerializedName("data")
    private Data data;

    @SerializedName("message")
    private String message;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class Data {
        @SerializedName("app_list")
        private List<AppModel> appList;

        @SerializedName("usage_access")
        private int usageAccess;

        public List<AppModel> getAppList() {
            return appList;
        }

        public void setAppList(List<AppModel> appList) {
            this.appList = appList;
        }

        public int getUsageAccess() {
            return usageAccess;
        }

        public void setUsageAccess(int usageAccess) {
            this.usageAccess = usageAccess;
        }
    }
}
