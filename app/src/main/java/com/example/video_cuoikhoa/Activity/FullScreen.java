package com.example.video_cuoikhoa.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import com.example.video_cuoikhoa.R;

public class FullScreen extends AppCompatActivity {
    VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen);
        Intent intent1 =getIntent();
        String value3 = intent1.getStringExtra("URL");
      //  String value4 = intent1.getStringExtra("Title");
        videoView = findViewById(R.id.fullman);
        videoView.setVideoPath(value3);
        videoView.setMediaController(new MediaController(FullScreen.this));
        videoView.start();
    }
}
