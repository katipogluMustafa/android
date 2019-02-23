package com.example.meterstoinches;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    // 1 Meters 39.701 in

    Button convert;
    TextView result;
    EditText input;

    View.OnClickListener converter = new View.OnClickListener(){
       @Override
       public void onClick(View view){

           String in = input.getText().toString();
           if( in.equals(""))
                result.setText(R.string.emptyInput);
           else
               try {
                   double meters = Double.parseDouble(in);
                   double inches = meters * 39.701;
                   String out = String.format(Locale.US, "%.3f inc", inches);
                   result.setText( out );
                   result.setTextColor(Color.MAGENTA);
               }catch(NumberFormatException e){
                   result.setText(R.string.format_error);
               }catch(Exception e){
                   result.setText(R.string.error);
               }

           result.setVisibility(View.VISIBLE);
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        convert = findViewById(R.id.convertID);
        result  = findViewById(R.id.resultID);
        input   = findViewById(R.id.metersEditText);

        convert.setText(R.string.convert_btn);
        convert.setOnClickListener(converter);


    }
}
