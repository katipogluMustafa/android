package com.example.randomcolors;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Button btn;
    private View back;
    private Random random;
    private View.OnClickListener listener = new View.OnClickListener(){
        @Override
        public void onClick(View view){
            back.setBackgroundColor( Color.rgb( random.nextInt(256), random.nextInt(256), random.nextInt(256) ) );
            Log.d("Click","Try Me!");
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn = findViewById(R.id.btn);
        back = findViewById(R.id.Back);
        random = new Random();

        btn.setOnClickListener(listener);

    }
}
