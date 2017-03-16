package com.example.alanflores.archivosmultimedia;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.MediaController;
import android.widget.TextView;

import java.io.IOException;

public class AudioActivity extends AppCompatActivity {

    ImageButton buttonPlay, buttonPause, buttonStop;
    private TextView textEstado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_audio);

        textEstado = (TextView) findViewById(R.id.text_estado);

        buttonPlay = (ImageButton) findViewById(R.id.button_play);
        buttonPause = (ImageButton) findViewById(R.id.button_pause);
        buttonStop = (ImageButton) findViewById(R.id.button_stop);

        final MediaPlayer mediaPlayer = MediaPlayer.create(getApplicationContext(),R.raw.sound);

        mediaPlayer.start();
        textEstado.setText("Reproduciendo musica");


        buttonPlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    textEstado.setText("Musica en pausa");
                }else{
                    mediaPlayer.start();
                    textEstado.setText("Reproduciendo musica");
                }
            }
        });

        buttonPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    textEstado.setText("Musica en pausa");
                }
            }
        });

        buttonStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mediaPlayer.isPlaying()){
                    //mediaPlayer.stop();
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);

                    textEstado.setText("Musica detenida");
                    /*try{
                        mediaPlayer.prepare();

                    }catch (IOException ex){
                        ex.printStackTrace();
                    }*/
                }
            }
        });
    }
}
