package com.example.audiovideoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private VideoView myVideoView;
    private Button btnPlayVideo;
    private MediaController mediaController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myVideoView = findViewById(R.id.myVideoView);
        btnPlayVideo = findViewById(R.id.btnPlayVideo);
        btnPlayVideo.setOnClickListener(MainActivity.this);

        mediaController = new MediaController(MainActivity.this);
    }

    @Override
    public void onClick(View v) {

        Uri videoUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.video);
        myVideoView.setVideoURI(videoUri);

        myVideoView.setMediaController(mediaController);
        mediaController.setAnchorView(myVideoView);

        myVideoView.start();
    }
}
