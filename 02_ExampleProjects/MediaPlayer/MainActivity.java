package com.meshale.musicplayer;

import android.icu.text.SimpleDateFormat;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import java.util.Date;


public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private ImageView artistImage;
    private TextView leftTime;
    private TextView rightTime;
    private SeekBar seekBar;
    private Button prevBtn;
    private Button playBtn;
    private Button nextBtn;
    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupUI();
        seekBar.setMax( mediaPlayer.getDuration() );
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if( fromUser )
                    mediaPlayer.seekTo(progress);

                SimpleDateFormat dateFormat = new SimpleDateFormat("mm:ss");
                int currentPos = mediaPlayer.getCurrentPosition();
                int duration = mediaPlayer.getDuration();
                leftTime.setText( dateFormat.format( new Date(currentPos) ) );
                rightTime.setText(dateFormat.format( new Date(duration - currentPos ) ) );

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


    }

    public void setupUI(){
        mediaPlayer = MediaPlayer.create(getApplicationContext(), R.raw.epic);

        artistImage = findViewById(R.id.artistImage);
        leftTime = findViewById(R.id.leftTime);
        rightTime = findViewById(R.id.rightTime);
        seekBar = findViewById(R.id.seekBar);
        prevBtn = findViewById(R.id.prevBtn);
        playBtn = findViewById(R.id.playBtn);
        nextBtn = findViewById(R.id.nextBtn);

        View.OnClickListener onClickListener = v->{
            switch ( v.getId() ){
                case R.id.prevBtn:
                        backMusic();
                    break;
                case R.id.playBtn:
                    if( mediaPlayer.isPlaying() )
                        pauseMusic();
                    else
                        startMusic();
                    break;
                case R.id.nextBtn:
                        nextMusic();
                    break;

        }
        };

        prevBtn.setOnClickListener(onClickListener);
        playBtn.setOnClickListener(onClickListener);
        nextBtn.setOnClickListener(onClickListener);
    }


    public void pauseMusic(){
        if( mediaPlayer != null){
            mediaPlayer.pause();
            playBtn.setBackgroundResource(R.drawable.ic_play_button);
        }

    }

    public void startMusic(){
        if( mediaPlayer != null){
            mediaPlayer.start();
            mediaPlayer.setLooping(true);
            updateThread();
            playBtn.setBackgroundResource(R.drawable.ic_pause);
        }
    }

    public void backMusic(){
        if( mediaPlayer.isPlaying() )
            mediaPlayer.seekTo(0);
    }
    public void nextMusic(){
        if( mediaPlayer.isPlaying() )
            mediaPlayer.seekTo( mediaPlayer.getDuration() );
    }
    public void updateThread(){
        thread = new Thread(){
            @Override
            public void run() {

                try{

                    while(mediaPlayer != null && mediaPlayer.isPlaying()){
                        Thread.sleep(50);
                        runOnUiThread( ()->{
                            int newPos = mediaPlayer.getCurrentPosition();
                            int max = mediaPlayer.getDuration();
                            seekBar.setMax(max);
                            seekBar.setProgress(newPos);
                            // Update The Text
                            leftTime.setText(String.valueOf(new SimpleDateFormat("mm:ss").format( new Date( mediaPlayer.getCurrentPosition() ) ) ) );
                            rightTime.setText(String.valueOf(new SimpleDateFormat("mm:ss").format(new Date( mediaPlayer.getDuration() - mediaPlayer.getCurrentPosition() ) ) ) );

                        } );
                    }

                }catch (InterruptedException i){
                    i.printStackTrace();
                }

                super.run();
            }
        };
        thread.start();
    }

    @Override
    protected void onDestroy() {
        if( mediaPlayer != null && mediaPlayer.isPlaying() ) {
            mediaPlayer.stop();
            mediaPlayer.release();
            mediaPlayer = null;
        }

        thread.interrupt();
        thread = null;

        super.onDestroy();
    }
}
