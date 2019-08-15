package com.teknoarktik.inflaterplayground;


import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;


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

        Button replaceFirstBtn = findViewById(R.id.MainActivity_btn_replaceFirstFragment);
        replaceFirstBtn.setOnClickListener( v-> replaceWithSecondFragment());

        Button replaceSecondBtn = findViewById(R.id.MainActivity_btn_replaceSecondFragment);
        replaceSecondBtn.setOnClickListener(v-> replaceWithFirstFragment());

        Button attachFirst = findViewById(R.id.MainActivity_btn_attachFirstFragment);
        attachFirst.setOnClickListener(v->attachFirstFragment());

        Button detachFirst = findViewById(R.id.MainActivity_btn_detachFirstFragment);
        detachFirst.setOnClickListener(v->detachFirstFragment());

        Button attachSecond = findViewById(R.id.MainActivity_btn_attachSecondFragment);
        attachSecond.setOnClickListener(v->attachSecondFragment());

        Button detachSecond = findViewById(R.id.MainActivity_btn_detachSecondFragment);
        detachSecond.setOnClickListener(v->detachSecondFragment());

        Button showFirst = findViewById(R.id.MainActivity_btn_showFirstFragment);
        showFirst.setOnClickListener(v->showFirstFragment());

        Button hideFirst = findViewById(R.id.MainActivity_btn_hideFirstFragment);
        hideFirst.setOnClickListener(v->hideFirstFragment());

        Button showSecond = findViewById(R.id.MainActivity_btn_showSecondFragment);
        showSecond.setOnClickListener(v->showSecondFragment());

        Button hideSecond = findViewById(R.id.MainActivity_btn_hideSecondFragment);
        hideSecond.setOnClickListener(v->hideSecondFragment());
    }


    private void showFirstFragment() {
        FirstFragment firstFragment = (FirstFragment) fragmentManager.findFragmentByTag("first_fragment");
        if( firstFragment != null ){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.show(firstFragment);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        }else
            Toast.makeText(this,"First Fragment Does Not Exist!", Toast.LENGTH_SHORT).show();
    }

    private void hideFirstFragment() {
        FirstFragment firstFragment = (FirstFragment) fragmentManager.findFragmentByTag("first_fragment");
        if( firstFragment != null ){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.hide(firstFragment);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        }else
            Toast.makeText(this,"First Fragment Does Not Exist!", Toast.LENGTH_SHORT).show();
    }

    private void showSecondFragment() {
        SecondFragment secondFragment = (SecondFragment) fragmentManager.findFragmentByTag("second_fragment");
        if( secondFragment != null ){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.show(secondFragment);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        }else
            Toast.makeText(this,"Second Fragment Does Not Exist!", Toast.LENGTH_SHORT).show();
    }

    private void hideSecondFragment() {
        SecondFragment secondFragment = (SecondFragment) fragmentManager.findFragmentByTag("second_fragment");
        if( secondFragment != null ){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.hide(secondFragment);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        }else
            Toast.makeText(this,"Second Fragment Does Not Exist!", Toast.LENGTH_SHORT).show();
    }

    private void detachFirstFragment() {
        FirstFragment firstFragment = (FirstFragment) fragmentManager.findFragmentByTag("first_fragment");
        if( firstFragment != null ){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.detach(firstFragment);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        }else
            Toast.makeText(this,"First Fragment does not exist", Toast.LENGTH_SHORT).show();
    }

    private void detachSecondFragment() {
        SecondFragment secondFragment = (SecondFragment) fragmentManager.findFragmentByTag("second_fragment");
        if( secondFragment != null ){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.detach(secondFragment);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        }else
            Toast.makeText(this,"Second Fragment does not exist", Toast.LENGTH_SHORT).show();
    }

    private void attachFirstFragment() {
        FirstFragment firstFragment = (FirstFragment) fragmentManager.findFragmentByTag("first_fragment");
        if( firstFragment != null ){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.attach(firstFragment);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        }else
            Toast.makeText(this,"First Fragment does not exist", Toast.LENGTH_SHORT).show();
    }

    private void attachSecondFragment() {
        SecondFragment secondFragment = (SecondFragment) fragmentManager.findFragmentByTag("second_fragment");
        if( secondFragment != null ){
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.attach(secondFragment);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        }else
            Toast.makeText(this,"Second Fragment does not exist", Toast.LENGTH_SHORT).show();
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

    private void replaceWithFirstFragment() {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            FirstFragment firstFragment = new FirstFragment();
            fragmentTransaction.replace(R.id.MainActivity_container_frame, firstFragment, "first_fragment");
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
    }

    private void replaceWithSecondFragment() {
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            SecondFragment secondFragment = new SecondFragment();
            fragmentTransaction.replace(R.id.MainActivity_container_frame, secondFragment, "second_fragment");
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
    }
}
