package com.threads;

import javafx.scene.paint.Color;

public class genV {
    private static genV instance;
    public static genV getInstance(){
        if(instance==null)
            instance = new genV();

        return instance;
    }

    private genV(){

    }

    Color getColor(){
        return Color.color(Math.random(),Math.random(),Math.random());
    }
}
