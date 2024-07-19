package com.example.assignmenttechexactly.repository;

import androidx.lifecycle.MutableLiveData;

import com.example.assignmenttechexactly.utility.ApiResponse;
import com.example.assignmenttechexactly.model.ApiService;
import com.example.assignmenttechexactly.model.AppModel;
import com.example.assignmenttechexactly.network.RetrofitClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AppRepository {
    private static AppRepository instance;
    private ApiService apiService;

    private AppRepository() {
        apiService = RetrofitClient.getApiService();
    }

    public static synchronized AppRepository getInstance() {
        if (instance == null) {
            instance = new AppRepository();
        }
        return instance;
    }

    public MutableLiveData<List<AppModel>> getAppList(int kidId) {
        MutableLiveData<List<AppModel>> appList = new MutableLiveData<>();
        apiService.getAppList(kidId).enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    appList.setValue(response.body().getData().getAppList());
                }
            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                // Handle failure
            }
        });
        return appList;
    }
}
