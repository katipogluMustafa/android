package com.teknoarktik.inflaterplayground;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();

        Button addFirstBtn = findViewById(R.id.MainActivity_btn_addFirstFragment);
        addFirstBtn.setOnClickListener(v-> addFirstFragment());

        Button addSecondBtn = findViewById(R.id.MainActivity_btn_addSecondFragment);
        addSecondBtn.setOnClickListener(v-> addSecondFragment());

        Button removeFirstBtn = findViewById(R.id.MainActivity_btn_removeFirstFragment);
        removeFirstBtn.setOnClickListener(v-> removeFirstFragment());

        Button removeSecondBtn = findViewById(R.id.MainActivity_btn_removeSecondFragment);
        removeSecondBtn.setOnClickListener(v-> removeSecondFragment());

    }

    private void removeSecondFragment() {
        SecondFragment secondFragment = (SecondFragment) fragmentManager.findFragmentByTag("second_fragment");

        if( secondFragment != null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(secondFragment);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
            fragmentTransaction.commit();
        }
    }

    private void removeFirstFragment() {
        FirstFragment firstFragment = (FirstFragment) fragmentManager.findFragmentByTag("first_fragment");

        if( firstFragment != null){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.remove(firstFragment);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
            fragmentTransaction.commit();
        }
    }

    private void addSecondFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.MainActivity_container_frame,new SecondFragment(), "second_fragment");
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }

    private void addFirstFragment() {
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.MainActivity_container_frame,new FirstFragment(), "first_fragment");
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();
    }
}
