package com.example.assignmenttechexactly.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.widget.TextView;

import com.example.assignmenttechexactly.Adapter.ViewPagerAdapter;
import com.example.assignmenttechexactly.R;
import com.example.assignmenttechexactly.viewmodel.MainViewModel;
import com.google.android.material.tabs.TabLayout;
import com.google.android.material.tabs.TabLayoutMediator;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager2 viewPager;
    private MainViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Initialize ViewModel
        viewModel = new ViewModelProvider(this).get(MainViewModel.class);

        // Initialize views
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        // Set up ViewPager2 with an adapter
        ViewPagerAdapter adapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(adapter);

        // Connect the TabLayout with the ViewPager2
        new TabLayoutMediator(tabLayout, viewPager,
                (tab, position) -> {
                    switch (position) {
                        case 0:
                            tab.setText("Application");
                            break;
                        case 1:
                            tab.setText("Settings");
                            break;
                    }
                }).attach();

        // Observe LiveData from ViewModel
        viewModel.getStatusLiveData().observe(this, status -> {
            // Update UI or perform actions based on status changes
            // Example: update status TextView
            TextView statusTextView = findViewById(R.id.status);
            statusTextView.setText(status);
        });
    }

    }
