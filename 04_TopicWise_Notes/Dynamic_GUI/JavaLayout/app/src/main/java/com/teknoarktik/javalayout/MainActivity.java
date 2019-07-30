package com.teknoarktik.javalayout;

import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.TypedValue;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        configureLayout();
    }

    private void configureLayout() {
        Button myBtn = new Button(this);
        myBtn.setText( R.string.press_me_btn );
        myBtn.setBackgroundColor(Color.YELLOW);
        myBtn.setId(R.id.myButton);

        EditText txt = new EditText(this);
        txt.setTextColor(Color.WHITE);
        int px = convertToPx(200);
        txt.setWidth(px);
        txt.setId(R.id.myEditText);

        ConstraintLayout myLayout = new ConstraintLayout(this);
        myLayout.addView(myBtn);
        myLayout.addView(txt);
        myLayout.setBackgroundColor(Color.BLUE);
        setContentView(myLayout);


        ConstraintSet set = new ConstraintSet();

        // Create the constraints of the button or any constrain that needs to be inside of the layout that we'll attach to
        set.constrainHeight(myBtn.getId(), ConstraintSet.WRAP_CONTENT);
        set.constrainWidth(myBtn.getId(), ConstraintSet.WRAP_CONTENT);
        set.connect(myBtn.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT, 0);
        set.connect(myBtn.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT, 0);
        set.connect(myBtn.getId(), ConstraintSet.TOP, ConstraintSet.PARENT_ID, ConstraintSet.TOP, 0);
        set.connect(myBtn.getId(), ConstraintSet.BOTTOM, ConstraintSet.PARENT_ID, ConstraintSet.BOTTOM, 0);
        // Constraints for the EditText
        set.constrainHeight(txt.getId(), ConstraintSet.WRAP_CONTENT);
        set.constrainWidth(txt.getId(), ConstraintSet.WRAP_CONTENT);
        set.connect(txt.getId(), ConstraintSet.LEFT, ConstraintSet.PARENT_ID, ConstraintSet.LEFT);
        set.connect(txt.getId(), ConstraintSet.RIGHT, ConstraintSet.PARENT_ID, ConstraintSet.RIGHT);
        set.connect(txt.getId(), ConstraintSet.BOTTOM, myBtn.getId(), ConstraintSet.TOP, 70);
        // Attach the constraints into our layout
        set.applyTo(myLayout);

    }

    /**
     * Takes dp converts to px for the currently running device at runtime.
     * @param value dp format
     * @return px format
     */
    private int convertToPx(int value){
        int px = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, value, getResources().getDisplayMetrics() );
        return px;
    }
}
