package com.threads;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class runningObjBuilder {
    Group group;
    Color color = Color.BLUE;
    double R = 5;

    runningObject.angleSpeed mLambdaAngleSpeed = (dt,V_a)->dt*V_a;

    public runningObjBuilder(Group group){
        this.group = group;
    }

    runningObjBuilder setColor(Color color){
        this.color = color;
        return this;
    }

    runningObjBuilder setRadius(double R){
        this.R = R;
        return this;
    }

    runningObjBuilder setAngleSpeed(runningObject.angleSpeed speed){
        this.mLambdaAngleSpeed = speed;
        return this;
    }

    public runningObject build(){
        return new runningObject(group,color,R,mLambdaAngleSpeed);
    }
}
