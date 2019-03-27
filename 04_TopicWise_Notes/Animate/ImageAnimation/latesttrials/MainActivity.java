package com.meshale.latesttrials;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.AnimationDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imageView;
    private AnimationDrawable batAnime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.batId);
        imageView.setBackgroundResource(R.drawable.bat_anim);

        batAnime = (AnimationDrawable) imageView.getBackground();

    }

    /**
     * Called when a touch screen event was not handled by any of the views
     * under it.  This is most useful to process touch events that happen
     * outside of your window bounds, where there is no view to receive it.
     *
     * @param event The touch screen event being processed.
     * @return Return true if you have consumed the event, false if you haven't.
     * The default implementation always returns false.
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        batAnime.start();

        Handler handler = new Handler();
        handler.postDelayed( ()-> batAnime.stop(),5000);

        return super.onTouchEvent(event);
    }
}
