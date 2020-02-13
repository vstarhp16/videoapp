package com.example.video_cuoikhoa.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.app.Activity;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;


import com.example.video_cuoikhoa.Adapter.ListAdapter;
import com.example.video_cuoikhoa.Adapter.MainViewPager;

import com.example.video_cuoikhoa.Data.ItemHotVideo;
import com.example.video_cuoikhoa.Fragment.Fragment_Category;
import com.example.video_cuoikhoa.Fragment.Fragment_Home;
import com.example.video_cuoikhoa.Fragment.Fragment_HotVideo;
import com.example.video_cuoikhoa.R;
import com.example.video_cuoikhoa.databinding.HotVideoFlagmentBinding;
import com.google.android.material.tabs.TabLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;


public class MainActivity extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    ActionBar actionBar;
    HotVideoFlagmentBinding binding;
    Button btnplay;
    VideoView videoView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        actionBar = getSupportActionBar();

        anhxa();
        init();


    }

    private void anhxa() {
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);

        videoView = findViewById(R.id.videoview);
    }

    private void init() {
        MainViewPager mainViewPager = new MainViewPager(getSupportFragmentManager());
        //mainViewPager.addFragment(new Fragment_Home(), "Home");
        mainViewPager.addFragment(new Fragment_HotVideo(), "Hot Video");
        mainViewPager.addFragment(new Fragment_Category(), "Category");




        viewPager.setAdapter(mainViewPager);
        tabLayout.setupWithViewPager(viewPager);
    }
}
