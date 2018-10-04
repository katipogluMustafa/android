package com.example.yukawa.layoutexamples;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CharSequence text = "Waiting for your orders Sir...";
        if(savedInstanceState != null){
            text = "Welcome Back Sir, What Else would you like to take ?";
        }else{
            text = "I'm waiting for your orders Sir...";
        }
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(this,text,duration);
        toast.show();

    }
    public void onClickSend(View view){
        Intent intent = new Intent(this,successfulOrderActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt("done",1);
    }
}
