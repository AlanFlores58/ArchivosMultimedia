package com.example.alanflores.archivosmultimedia;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.io.IOException;

public class VideoActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private SurfaceHolder surfaceHolder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);

        Uri myUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.vid);
        mediaPlayer = new MediaPlayer();
        mediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mediaPlayer.setLooping(false);

        try{
            mediaPlayer.setDataSource(getApplicationContext(),myUri);
        }catch (IOException e){
            e.printStackTrace();
        }

        SurfaceView surfaceView = (SurfaceView) findViewById(R.id.surface);

        surfaceHolder = surfaceView.getHolder();
        surfaceHolder.setKeepScreenOn(true);

        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                mediaPlayer.setDisplay(surfaceHolder);
                try{
                    mediaPlayer.prepare();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                mediaPlayer.start();
            }

            @Override
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i, int i1, int i2) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {

            }
        });
    }
}
