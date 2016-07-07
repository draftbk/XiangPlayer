package com.example.slf.xiangplayer;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView= (VideoView) findViewById(R.id.videoView);
        Log.d("test", "1");
        Log.d("test", getPackageName());
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.play);
        videoView.setVideoURI(uri);
       // videoView.setVideoURI(Uri.parse("http://115.28.18.171/nothing_1/play.mp4"));
        videoView.setMediaController(new MediaController(this));
        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
                videoView.start();
            }
        });
        Log.d("test", "2");
    }

    @Override
    public void onClick(View v) {
        Log.d("test","3");
        switch (v.getId()){
            case R.id.videoView:
                Log.d("test","这里");

                break;
        }
    }
}
