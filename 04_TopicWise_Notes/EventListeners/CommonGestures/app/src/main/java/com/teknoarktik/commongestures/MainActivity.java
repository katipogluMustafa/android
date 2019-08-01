package com.teknoarktik.commongestures;

import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.TextView;


// We could've implemented this GestureDetectors as another class not as activity
public class MainActivity extends AppCompatActivity
                          implements GestureDetector.OnGestureListener,
                                     GestureDetector.OnDoubleTapListener{

    private TextView gestureText;
    private GestureDetectorCompat gestureDetectorCompact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gestureText = findViewById(R.id.gestureStatusText);

        this.gestureDetectorCompact = new GestureDetectorCompat(this,this);  // send context and OnGestureListener as params
        this.gestureDetectorCompact.setOnDoubleTapListener(this);                            // since we need this too, set additionally

    }





    /* GestureDetector.OnGestureListener */

    @Override
    public boolean onDown(MotionEvent e) {
        gestureText.setText("onDown");
        return false;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        gestureText.setText("onShowPress");
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        gestureText.setText("onSingleTapUp");
        return false;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        gestureText.setText("onScroll");
        return false;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        gestureText.setText("onLongPress");
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        gestureText.setText("onFling");
        return false;
    }




    /* GestureDetector.OnDoubleTapListener */

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        gestureText.setText("onSingleTapConfirmed");
        return false;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        gestureText.setText("onDoubleTap");
        return false;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        gestureText.setText("onDoubleTapEvent");
        return false;
    }

    //Note that many of these methods return true. This indicates to the Android
    //  Framework that the event has been consumed by the method and does not
    //  need to be passed to the next event handler in the stack.


    /*
     * To intercept touch events and to pass them through to
     * the GestureDetectorCompat instance, it is necessary
     * to override the onTouchEvent() method within the activity class and
     * implement it such that it calls the onTouchEvent() method of the
     * GestureDetectorCompat instance.
     */

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetectorCompact.onTouchEvent(event);
        // Be sure to call the superclass implementation
        return super.onTouchEvent(event);
    }
}
