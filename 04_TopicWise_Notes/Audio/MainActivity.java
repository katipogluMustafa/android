package com.meshale.mediaplayerapp;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private Button playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create( getApplicationContext(), R.raw.my_audio );

        playButton = findViewById(R.id.playButton);

        playButton.setOnClickListener( v->{
            if( mediaPlayer.isPlaying() )
                pauseMusic();
            else
                playMusic();
        });
    }

    public void pauseMusic(){
        if( mediaPlayer == null)
            return;

        mediaPlayer.pause();
        playButton.setText("Play");
    }

    public void playMusic(){
        if( mediaPlayer == null)
            return;

        mediaPlayer.start();
        playButton.setText("Pause");
    }

}
