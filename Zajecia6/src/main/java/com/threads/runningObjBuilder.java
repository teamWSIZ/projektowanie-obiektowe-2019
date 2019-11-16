package com.threads;

import javafx.scene.Group;
import javafx.scene.paint.Color;

public class runningObjBuilder {
    Group group;
    Color color = Color.BLUE;
    double R = 5;

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

    public runningObject build(){
        return new runningObject(group,color,R);
    }
}
