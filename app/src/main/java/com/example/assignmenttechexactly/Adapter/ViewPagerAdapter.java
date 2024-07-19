package com.example.assignmenttechexactly.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.assignmenttechexactly.ui.application;
import com.example.assignmenttechexactly.ui.setting;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new application();
            case 1:
                return new setting();
            default:
                return new application();
        }
    }

    @Override
    public int getItemCount() {
        return 2; // Number of tabs
    }

}
