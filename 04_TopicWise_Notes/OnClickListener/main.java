package com.example.myfirstapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextView;
    int clickCount = 0;
    boolean isVisible = false;

    private Button mButton;
    private Button mButton2;
    private Button mButton3;
    private Button mButton4;

    // This allows you to reuse the implementation
    private View.OnClickListener myOnClickListener= new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            clickCount++;

            if( clickCount >= 6)
                mTextView.setText(R.string.special_mode);
            else
                mTextView.setText(R.string.show_text);

            if( isVisible ){
                isVisible = false;
                mTextView.setVisibility(View.INVISIBLE);
            }else{
                isVisible = true;
                mTextView.setVisibility(View.VISIBLE);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* mButton by using Show Me method for action on click*/
        mButton = findViewById(R.id.mButton);
        mTextView = findViewById(R.id.mTextView);

        /* mButton2 by using setOnClickListener */
        mButton2 = findViewById(R.id.mButton2);
        mButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickCount++;

                if( clickCount >= 6)
                    mTextView.setText(R.string.special_mode);
                else
                    mTextView.setText(R.string.show_text);

                if( isVisible ){
                    isVisible = false;
                    mTextView.setVisibility(View.INVISIBLE);
                }else{
                    isVisible = true;
                    mTextView.setVisibility(View.VISIBLE);
                }
            }
        });

        /* mButton3 by using setOnClickListener and separating the implementation */

        mButton3 = findViewById(R.id.mButton3);
        mButton3.setOnClickListener(myOnClickListener);

        /* mButton4 by using a class that implements View.OnClickListener */

        mButton4 = findViewById(R.id.mButton4);
        mButton4.setOnClickListener( new AwesomeOnClickListener() );


    }

    public void ShowMe(View view){
        clickCount++;

        if( clickCount >= 6)
            mTextView.setText(R.string.special_mode);
        else
            mTextView.setText(R.string.show_text);

        if( isVisible ){
            isVisible = false;
            mTextView.setVisibility(View.INVISIBLE);
        }else{
            isVisible = true;
            mTextView.setVisibility(View.VISIBLE);
        }

    }

    class AwesomeOnClickListener implements View.OnClickListener{
        @Override
        public void onClick(View view){
            clickCount++;

            if( clickCount >= 6)
                mTextView.setText(R.string.special_mode);
            else
                mTextView.setText(R.string.show_text);

            if( isVisible ){
                isVisible = false;
                mTextView.setVisibility(View.INVISIBLE);
            }else{
                isVisible = true;
                mTextView.setVisibility(View.VISIBLE);
            }
        }
    }

}
