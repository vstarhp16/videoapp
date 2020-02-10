package com.example.video_cuoikhoa.Activity;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.app.Activity;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;


import com.example.video_cuoikhoa.Adapter.MainViewPager;

import com.example.video_cuoikhoa.Fragment.Fragment_Category;
import com.example.video_cuoikhoa.Fragment.Fragment_HotVideo;
import com.example.video_cuoikhoa.R;
import com.example.video_cuoikhoa.databinding.HotVideoFlagmentBinding;
import com.google.android.material.tabs.TabLayout;



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
        btnplay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://dzbbmecpa0hd2.cloudfront.net/video/original/2019/04/11/14/1554966002_de58c8a6be7d1046.mp4");
                videoView.setVideoURI(uri);
                videoView.setMediaController(new MediaController(MainActivity.this));
                videoView.start();
            }
        });
        init();


    }

    private void anhxa() {
        tabLayout = findViewById(R.id.tabLayout);
        viewPager = findViewById(R.id.viewPager);
        btnplay = findViewById(R.id.btnplay);
        videoView = findViewById(R.id.videoview);
    }

    private void init() {
        MainViewPager mainViewPager = new MainViewPager(getSupportFragmentManager());
        mainViewPager.addFragment(new Fragment_HotVideo(), "Hot Video");
        mainViewPager.addFragment(new Fragment_Category(), "Category");
        viewPager.setAdapter(mainViewPager);
        tabLayout.setupWithViewPager(viewPager);
    }
}
