package com.example.video_cuoikhoa.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.example.video_cuoikhoa.R;

public class PlayVideo extends AppCompatActivity {
    VideoView videoView;
    Button btnfullman;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_video);

        final Intent intent = getIntent();
        final String value1 = intent.getStringExtra("URL");
      final String value2 = intent.getStringExtra("Title");
       // boolean value3 = intent.getBooleanExtra("Key_3", false);
        TextView textView = findViewById(R.id.tvtenvideo);
        textView.setText(value2);
        videoView = findViewById(R.id.videoview);
       videoView.setVideoPath(value1);
           videoView.setMediaController(new MediaController(PlayVideo.this));
        videoView.start();
        btnfullman = findViewById(R.id.btnfullman);
        btnfullman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1= new Intent(getBaseContext(), FullScreen.class);
                intent1.putExtra("URL", value1);
                intent1.putExtra("Title",value2);
                startActivity(intent1);
            }
        });


    }
}
