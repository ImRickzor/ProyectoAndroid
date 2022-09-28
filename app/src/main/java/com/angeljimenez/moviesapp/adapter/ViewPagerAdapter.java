package com.angeljimenez.moviesapp.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.angeljimenez.moviesapp.fragments.MoviesTab;
import com.angeljimenez.moviesapp.fragments.UpperTabSelectionsFragment;

public class ViewPagerAdapter extends FragmentStateAdapter {
    public ViewPagerAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        switch (position) {
            case 0:
                return new MoviesTab();
            case 1:
                return new UpperTabSelectionsFragment();
            default:
                return new MoviesTab();
        }
    }

    @Override
    public int getItemCount() {
        return 2;
    }
}

