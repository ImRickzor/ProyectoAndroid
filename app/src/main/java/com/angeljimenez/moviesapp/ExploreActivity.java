package com.angeljimenez.moviesapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.angeljimenez.moviesapp.adapter.ViewPagerAdapter;
import com.angeljimenez.moviesapp.fragments.Movies;
import com.angeljimenez.moviesapp.fragments.Profile;
import com.angeljimenez.moviesapp.fragments.Search;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

public class ExploreActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager2 viewPager2;
    ViewPagerAdapter viewPagerAdapter;
    TabItem tab1, tab2;

    BottomNavigationView bottomNavigationView;

    Movies Movies = new Movies();
    Search Search = new Search();
    Profile Profile = new Profile();
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.bottom_nav_menu, menu);
        return true;
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_explore);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager2 = findViewById(R.id.view_pager);
        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager2.setAdapter(viewPagerAdapter);

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        //getSupportFragmentManager().beginTransaction().replace(R.id.container,Movies).commit();

        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.Movies:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, Movies).commit();
                        //showMovies();
                        return true;
                    case R.id.Search:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, Search).commit();
                        //showSearch();
                        return true;
                    case R.id.Profile:
                        getSupportFragmentManager().beginTransaction().replace(R.id.container, Profile).commit();
                        //showMyMovies();
                        return true;
                }
                return false;
            }
        });

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        viewPager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                super.onPageSelected(position);
                tabLayout.getTabAt(position).select();
            }
        });
    }

    //private void showMovies() {startActivity(new Intent(this, ExploreActivity.class));}
    //private void showSearch() {
        //startActivity(new Intent(this, SearchActivity.class));
    }
   // private void showMyMovies() {
      //  startActivity(new Intent(this, MyMovies.class));
   // }



//}