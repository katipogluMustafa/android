package com.example.yukawa.mymessenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ReceiveMessageActivity extends Activity {
    public static final String EXTRA_MESSAGE = "msg";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);

        Intent intent = getIntent();
        String string = intent.getStringExtra(EXTRA_MESSAGE);

        TextView textView = findViewById(R.id.message);
        textView.setText(string);
     }


}
