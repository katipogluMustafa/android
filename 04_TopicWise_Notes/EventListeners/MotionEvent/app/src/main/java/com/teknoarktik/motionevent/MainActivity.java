package com.teknoarktik.motionevent;

import android.annotation.SuppressLint;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("ClickableViewAccessibility")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ConstraintLayout layout = findViewById(R.id.activity_motion_event);
        layout.setOnTouchListener( new ConstraintLayout.OnTouchListener(){

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                handleTouch(event);
                return false;
            }

        });

    }

    private void handleTouch(MotionEvent event) {
        TextView textView1 = findViewById(R.id.textView1);
        TextView textView2 = findViewById(R.id.textView2);

        int pointerCount = event.getPointerCount();         // identifying how many pointers are currently active on the view

        for(int i = 0; i < pointerCount; i++){              // perform a set of tasks for each active pointer.
            int x = (int)event.getX(i);
            int y = (int)event.getY(i);
            int id = event.getPointerId(i);
            int action = event.getActionMasked();
            int actionIndex = event.getActionIndex();
            String actionString;

            switch (action){
                case MotionEvent.ACTION_DOWN:
                    actionString = "DOWN";
                    break;
                case MotionEvent.ACTION_UP:
                    actionString = "UP";
                    break;
                case MotionEvent.ACTION_POINTER_DOWN:
                    actionString = "PTR DOWN";
                    break;
                case MotionEvent.ACTION_POINTER_UP:
                    actionString = "PTR UP";
                    break;
                case MotionEvent.ACTION_MOVE:
                    actionString = "MOVE";
                    break;
                default:
                    actionString = "";
            }

            String touchStatus = "Action:" + actionString + " Index: " + actionIndex + " ID: " + id + " X: " + x + " Y: " + y;
            if( id == 0 )
                textView1.setText(touchStatus);
            else
                textView2.setText(touchStatus);
        }
    }
}
