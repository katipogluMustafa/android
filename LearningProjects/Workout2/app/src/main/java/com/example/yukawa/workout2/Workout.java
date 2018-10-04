package com.example.yukawa.workout2;

public class Workout {
    private String name;
    private String description;

    public static final Workout[] workouts = {
            new Workout("The Limb loosener","5 handstand push-ups......"),
            new Workout("Core Agony","100 push-ups...."),
            new Workout("The Wimp Special","5 pull-ups...."),
            new Workout("Strength and Length","500 meter...."),
    };

    private Workout(String name, String description){
        this.name = name;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
