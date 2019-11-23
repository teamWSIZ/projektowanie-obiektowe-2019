package com.threads;

import javafx.scene.paint.Color;

import java.util.ArrayList;
import java.util.Random;

public class genV {
    private ArrayList<runningObject.angleSpeed> mAngleSpeedArray = new ArrayList<>();

    private static genV instance;
    public static genV getInstance(){
        if(instance==null)
            instance = new genV();

        return instance;
    }

    private genV(){
        mAngleSpeedArray.add((dt,V_a)->dt*V_a);
        mAngleSpeedArray.add((dt,V_a)->2*dt*V_a);
        mAngleSpeedArray.add((dt,V_a)->4*dt*V_a);
        mAngleSpeedArray.add((dt,V_a)->dt*V_a*V_a);
    }

    runningObject.angleSpeed getAngleSpeed(){

        Random random = new Random();
        return mAngleSpeedArray.get(random.nextInt(mAngleSpeedArray.size()));
    }

    Color getColor(){
        return Color.color(Math.random(),Math.random(),Math.random());
    }
}
