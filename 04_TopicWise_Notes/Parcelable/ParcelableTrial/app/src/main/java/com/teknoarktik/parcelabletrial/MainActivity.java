package com.teknoarktik.parcelabletrial;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static final String HOUSEKEY = "TheHouse";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn = findViewById(R.id.button);
        btn.setOnClickListener( v-> launchDetailsActivity());

    }

    private void launchDetailsActivity(){

        ArrayList<String> owners = new ArrayList<>(Arrays.asList("Mustafa", "Ahmet", "Yusuf"));

        House house1 = new House(10000, "Istanbul", true,  owners);

        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(HOUSEKEY, house1);
        startActivity(intent);
    }
}
