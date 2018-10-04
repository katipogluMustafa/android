package com.example.yukawa.mymessenger;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateMessageActivity extends Activity {

    public void onSendMessage(View view){
        EditText messageView = findViewById(R.id.message);
        String messageText = messageView.getText().toString();

        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT,messageText);

        String title = getString(R.string.chooser);
        Intent chosenIntent = Intent.createChooser(intent,title);

        startActivity(chosenIntent);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
    }
}
