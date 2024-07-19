package com.example.assignmenttechexactly.model;

import com.example.assignmenttechexactly.utility.ApiResponse;

import retrofit2.Call;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiService {
    @POST("apps/list")
    Call<ApiResponse> getAppList(@Query("kid_id") int kidId);
}
