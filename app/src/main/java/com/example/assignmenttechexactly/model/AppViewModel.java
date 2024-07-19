package com.example.assignmenttechexactly.model;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.assignmenttechexactly.model.AppModel;
import com.example.assignmenttechexactly.repository.AppRepository;

import java.util.List;

public class AppViewModel extends ViewModel {
    private MutableLiveData<List<AppModel>> appList;
    private AppRepository appRepository;

    public void init(int kidId) {
        if (appList != null) {
            return;
        }
        appRepository = AppRepository.getInstance();
        appList = appRepository.getAppList(kidId);
    }

    public LiveData<List<AppModel>> getAppList() {
        return appList;
    }
}
