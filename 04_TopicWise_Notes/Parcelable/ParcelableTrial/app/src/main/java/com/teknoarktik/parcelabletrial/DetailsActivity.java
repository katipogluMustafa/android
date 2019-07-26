package com.teknoarktik.parcelabletrial;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import java.util.Locale;

public class DetailsActivity extends AppCompatActivity {
    private House house;
    private static final String HOUSEKEY = "TheHouse";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        house = getIntent().getParcelableExtra(HOUSEKEY);

        if( house != null )
            showHouseDetails();

    }

    private void showHouseDetails(){
        TextView price = findViewById(R.id.price);
        TextView location = findViewById(R.id.location);
        TextView isNear = findViewById(R.id.isNear);

        price.setText( String.format( Locale.ENGLISH,"%d", house.getPrice() ) );
        location.setText( house.getLocation() );
        isNear.setText( house.isNearSchool() ? "Near" : "Not Near");

    }
}
