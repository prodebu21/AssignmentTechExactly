package com.example.assignmenttechexactly.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class MainViewModel extends ViewModel {
    private MutableLiveData<String> statusLiveData = new MutableLiveData<>();

    public LiveData<String> getStatusLiveData() {
        // Simulate data loading or provide actual data here
        statusLiveData.setValue("Connected");
        return statusLiveData;
    }
}
