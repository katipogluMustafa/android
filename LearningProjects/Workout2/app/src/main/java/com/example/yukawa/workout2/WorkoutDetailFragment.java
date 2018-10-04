package com.example.yukawa.workout2;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WorkoutDetailFragment extends Fragment {
    private long workoutId;

    public WorkoutDetailFragment() {
        // Required empty public constructor
    }
    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        if(savedInstanceState == null){
            StopwatchFragment stopwatchFragment = new StopwatchFragment();
            FragmentTransaction ft = getChildFragmentManager().beginTransaction();
            ft.add(R.id.stopwatch_container,stopwatchFragment);
            ft.addToBackStack(null);
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }else{
            workoutId = savedInstanceState.getLong(DetailActivity.EXTRA_WORKOUT_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }
    @Override
    public void onStart(){
        super.onStart();
        View view = getView();
        if(view != null){
            Workout workout = Workout.workouts[(int)workoutId];

            TextView title = view.findViewById(R.id.title);
            title.setText( workout.getName() );

            TextView description = view.findViewById(R.id.description);
            description.setText( workout.getDescription() );
        }
    }

    public void setWorkout(long id){
        this.workoutId = id;
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putLong(DetailActivity.EXTRA_WORKOUT_ID, workoutId);
    }
}
