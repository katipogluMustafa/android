package com.meshale.mediaplayerapp;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private Button playButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = MediaPlayer.create( getApplicationContext(), R.raw.my_audio );

        mediaPlayer.setOnCompletionListener( mp->{
            int duration = mp.getDuration();
            String durationStr = String.valueOf(duration / 1000);

            Toast.makeText(this, ("Duration " + durationStr + " seconds"), Toast.LENGTH_LONG).show();
        });

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
        playButton.setText(getString(R.string.play));
    }

    public void playMusic(){
        if( mediaPlayer == null)
            return;

        mediaPlayer.start();
        playButton.setText(getString(R.string.pause));
    }

    @Override
    protected void onDestroy() {
        if( mediaPlayer != null && mediaPlayer.isPlaying() ){
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }

        super.onDestroy();
    }
}
