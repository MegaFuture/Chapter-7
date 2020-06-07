package com.bytedance.videoplayer;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {
    private VideoView videoView;
//    private int playProgress = 0;
//    private boolean isPlaying = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        videoView = findViewById(R.id.video);
        Intent intent = getIntent();
        Uri uri = intent.getData();
        videoView.setVideoURI(uri);

        MediaController mediaController = new MediaController(this);
        videoView.setMediaController(mediaController);
        mediaController.setMediaPlayer(videoView);

        videoView.start();
    }

    /*
    @Override
    protected void onPause(){
        super.onPause();
        playProgress = videoView.getCurrentPosition();
        isPlaying = videoView.isPlaying();
    }

    @Override
    protected void onResume(){
        super.onResume();
        videoView.seekTo(playProgress);
        if (isPlaying)
            videoView.start();
    }

    @Override
    protected void onSaveInstanceState(@Nullable Bundle state){
        if ( state != null ){
            state.putInt("playProgress", playProgress);
            state.putBoolean("isPlaying", isPlaying);
        }
        super.onSaveInstanceState(state);
    }

    @Override
    protected void onRestoreInstanceState(@Nullable Bundle state) {
        super.onRestoreInstanceState(state);
        if (state != null) {
            int temp_PP = state.getInt("playProgress");
            boolean temp_IP = state.getBoolean("isPlaying");
            playProgress = temp_PP;
            videoView.seekTo(temp_PP);
            isPlaying = temp_IP;
            if (isPlaying)
                videoView.start();
        }
    }*/
}
