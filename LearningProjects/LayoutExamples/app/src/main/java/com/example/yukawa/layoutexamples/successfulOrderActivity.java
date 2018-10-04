package com.example.yukawa.layoutexamples;

import android.app.Activity;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class successfulOrderActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_successful_order);

        CharSequence charSequence="All the servers allocated to serve you sir!";
        int duration = Toast.LENGTH_LONG;
        Toast toast = Toast.makeText(this,charSequence,duration);
        toast.show();
        CharSequence charSequence1 = "In a few mins your order will be served...";
        toast = Toast.makeText(this,charSequence1,duration);
        toast.show();
    }
    public void onClickNewOrder(View view){
        super.onBackPressed();
    }
}
