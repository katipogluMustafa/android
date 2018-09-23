package com.example.yukawa.starbuzz;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinkCategoryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);

        //Add array of elements to the listview
        ArrayAdapter<Drink> arrayAdapter = new ArrayAdapter<>(DrinkCategoryActivity.this,android.R.layout.simple_list_item_1,Drink.drinks);

        ListView categoryList =  findViewById(R.id.list_drinks);
        categoryList.setAdapter(arrayAdapter);

        //Create Listener

        AdapterView.OnItemClickListener itemClickListener = new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id){
                //Pass the drink the user clicked on  to DrinkActivity
                Intent intent = new Intent(DrinkCategoryActivity.this, DrinkActivity.class);
                intent.putExtra(DrinkActivity.EXTRA_DRINK_ID, (int)id);
                startActivity(intent);
            }
        };

        categoryList.setOnItemClickListener(itemClickListener);

    }
}
