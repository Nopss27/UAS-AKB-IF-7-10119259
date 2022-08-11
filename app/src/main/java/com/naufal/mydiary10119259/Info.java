package com.naufal.mydiary10119259;

/*
* Naufal Daffa Ilyasa
* 10119259
* IF7
* */

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class Info extends AppCompatActivity {

    ViewPager2 viewPager2;
    ArrayList<ViewPagerItem> viewPagerItemArrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        viewPager2 = findViewById(R.id.viewPager);
        int[] images = {R.drawable.javalogo2,R.drawable.application,R.drawable.info};
        String[] heading = {"Pembuatan Aplikasi","Menu Aplikasi","Info Menu"};
        String[] desc = {getString(R.string.a_desc),getString(R.string.b_desc),getString(R.string.c_desc)};

        viewPagerItemArrayList = new ArrayList<>();

        for (int i =0; i< images.length ; i++){
            ViewPagerItem viewPagerItem = new ViewPagerItem(images[i],heading[i],desc[i]);
            viewPagerItemArrayList.add(viewPagerItem);

        }

        VPAdapter vpAdapter = new VPAdapter(viewPagerItemArrayList);

        viewPager2.setAdapter(vpAdapter);

        viewPager2.setClipToPadding(false);

        viewPager2.setClipChildren(false);

        viewPager2.setOffscreenPageLimit(2);

        viewPager2.getChildAt(0).setOverScrollMode(View.OVER_SCROLL_NEVER);

        //
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // note selected
        bottomNavigationView.setSelectedItemId(R.id.info);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext()
                                ,Profile.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.note:
                        startActivity(new Intent(getApplicationContext()
                                ,NewNotes.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.info:
                        return true;
                }
                return false;
            }
        });
    }
}