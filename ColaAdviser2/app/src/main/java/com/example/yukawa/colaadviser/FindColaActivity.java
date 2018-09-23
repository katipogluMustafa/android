package com.example.yukawa.colaadviser;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class FindColaActivity extends Activity {
        private ColaExpert colaExpert = new ColaExpert();

    public void onClickFindCola(View view){
        TextView brands = findViewById(R.id.brands);
        Spinner spinner = findViewById(R.id.color);
        String colaType = String.valueOf(spinner.getSelectedItem());

        List<String> whatWeHave = colaExpert.getBrands(colaType);
        StringBuilder x = new StringBuilder();

        for(String s : whatWeHave){
            x.append(s).append("\n");
        }
        brands.setText(x);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_cola);
    }

}
