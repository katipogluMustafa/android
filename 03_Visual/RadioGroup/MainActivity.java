package com.meshale.rndm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {
    private RadioGroup radioGroup;
    private RadioButton radioButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                radioButton = findViewById(checkedId);
                switch(radioButton.getId()){
                    case R.id.noBtn:
                        Log.d("Deneme", "No!!");
                        break;
                    case R.id.yesBtn:
                        Log.d("Deneme", "Yes!!");
                        break;
                    case R.id.maybeBtn:
                        Log.d("Deneme", "Maybe...");
                        break;
                }
            }
        });
    }
}