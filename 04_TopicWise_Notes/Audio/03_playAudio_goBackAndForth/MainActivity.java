package com.meshale.mediaplayerapp;

import android.annotation.SuppressLint;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private Button playButton;
    private SeekBar seekBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        seekBar = findViewById(R.id.seekBar);

        mediaPlayer = MediaPlayer.create( getApplicationContext(), R.raw.my_audio );
        seekBar.setMax( mediaPlayer.getDuration() );

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if( fromUser )
                    mediaPlayer.seekTo( progress );
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

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
