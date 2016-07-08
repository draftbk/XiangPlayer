package com.example.slf.xiangplayer;

import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private VideoView videoView;
    private TextView tv1,tv2;
    private boolean first_touch=true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv1= (TextView) findViewById(R.id.tv1);
        tv2= (TextView) findViewById(R.id.tv2);
        videoView= (VideoView) findViewById(R.id.videoView);
        Log.d("test", "1");
        Log.d("test", getPackageName());
        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.play);
        videoView.setVideoURI(uri);
       // videoView.setVideoURI(Uri.parse("http://115.28.18.171/nothing_1/play.mp4"));
        videoView.setMediaController(new MediaController(this));
        MediaController mc = new MediaController(this);
        mc.setVisibility(View.INVISIBLE);
        videoView.setMediaController(mc);
        videoView.setZOrderOnTop(true);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                videoView.seekTo(10);
//                videoView.start();
            }
        });
        Log.d("test", "2");
        videoView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (first_touch){

                    videoView.start();
                    first_touch=false;
                }
                AlphaAnimation alp = new AlphaAnimation(1.0f,0.0f);
                alp.setDuration(1500);
                tv1.setAnimation(alp);
                tv2.setAnimation(alp);

                alp.setAnimationListener(new Animation.AnimationListener() {

                    public void onAnimationStart(Animation animation) {

                    }

                    public void onAnimationRepeat(Animation animation) {

                    }

                    public void onAnimationEnd(Animation animation) {
                        tv1.setVisibility(View.INVISIBLE);
                        tv2.setVisibility(View.INVISIBLE);
                    }
                });


                return false;
            }
        });
    }

    @Override
    public void onClick(View v) {
        Log.d("test","3");
        switch (v.getId()){
            case R.id.videoView:
                Log.d("test", "这里");

                break;
        }
    }
}
