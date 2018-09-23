package com.example.yukawa.sendmessage;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class sendMessageActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_message);
    }
    public void onClickSend(View view){
        EditText editText = findViewById(R.id.message);
        String message = editText.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,message);

        Intent chosenIntent = Intent.createChooser(intent,"Send Message via...");
        startActivity(chosenIntent);
    }
}
