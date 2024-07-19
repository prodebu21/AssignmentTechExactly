package com.example.assignmenttechexactly.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.assignmenttechexactly.Adapter.ItemAdapter;
import com.example.assignmenttechexactly.model.AppModel;
import com.example.assignmenttechexactly.model.AppViewModel;
import com.example.assignmenttechexactly.R;

import java.util.ArrayList;
import java.util.List;


public class application extends Fragment {

    private AppViewModel appViewModel;
    private ItemAdapter itemAdapter;
    private List<AppModel> appList = new ArrayList<>();
    private EditText searchEditText;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_application, container, false);

        searchEditText = view.findViewById(R.id.searchEditText);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        itemAdapter = new ItemAdapter(getContext(), appList);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(itemAdapter);

        // Initialize the ViewModel
        appViewModel = new ViewModelProvider(this).get(AppViewModel.class);
        appViewModel.init(378);
        appViewModel.getAppList().observe(getViewLifecycleOwner(), new Observer<List<AppModel>>() {
            @Override
            public void onChanged(List<AppModel> apps) {
                appList.clear();
                if (apps != null) {
                    appList.addAll(apps);
                }
                itemAdapter.setItems(appList);
            }
        });

        // Implement search functionality
        searchEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filter(s.toString());
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) { }

            @Override
            public void afterTextChanged(Editable s) { }
        });

        return view;
    }

    private void filter(String text) {
        List<AppModel> filteredList = new ArrayList<>();
        for (AppModel item : appList) {
            if (item.getAppName().toLowerCase().startsWith(text.toLowerCase())) {
                filteredList.add(item);
            }
        }
        itemAdapter.setItems(filteredList);
    }}