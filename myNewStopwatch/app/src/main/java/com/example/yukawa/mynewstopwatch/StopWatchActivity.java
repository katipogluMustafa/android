package com.example.yukawa.mynewstopwatch;

import android.app.Activity;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class StopWatchActivity extends Activity {
    private boolean running = false;
    private int seconds = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stop_watch);
        if(savedInstanceState != null){
            running = savedInstanceState.getBoolean("running");
            seconds = savedInstanceState.getInt("seconds");
        }
        runTimer();
    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt("seconds",seconds);
        savedInstanceState.putBoolean("running",running);
    }
    private void runTimer(){
        final TextView timeView = findViewById(R.id.stopwatch_text);
        final Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                int hours = seconds / 3600;
                int minutes = ( seconds % 3600 ) / 60;
                int secs = seconds % 60;

                String time = String.format(Locale.getDefault(),"%02d:%02d:%02d",hours,minutes,secs);

                timeView.setText(time);

                if(running){
                    seconds++;
                }
                handler.postDelayed(this,1000);
            }
        },1000);
    }
//    public void runTimer(){
//        final TextView textView = findViewById(R.id.stopwatch_text);
//        final Handler handler = new Handler();
//        handler.postDelayed(new Runnable(){
//            @Override
//            public void run(){
//                int hours = seconds / 3600;
//                int mins = ( seconds % 3600 ) /60;
//                int sec  = seconds & 60;
//                String time = String.format(Locale.getDefault(),"%02d:%02d:%02d",hours,mins,sec);
//
//                textView.setText(time);
//
//                if(running){
//                    seconds++;
//                }
//                handler.postDelayed(this,1000);
//            }
//        },1000);
//    }

    public void startStopwatch(View view){
        running = true;
    }
    public void stopStopwatch(View view){
        running = false;
    }
    public void resetStopwatch(View view){
        seconds = 0;
        running = false;
    }
    public void reStartStopWatch(View view){
        seconds = 0;
        running = true;
    }
}
