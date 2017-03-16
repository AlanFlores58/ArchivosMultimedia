package com.example.alanflores.archivosmultimedia;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoViewActivity extends AppCompatActivity {

    private VideoView videoView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view);
        Uri myUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.vid);

        videoView = (VideoView) findViewById(R.id.videoview_video);
        videoView.setVideoURI(myUri);

        videoView.setMediaController(new MediaController(this));
        videoView.start();
        videoView.requestFocus();
    }
}
