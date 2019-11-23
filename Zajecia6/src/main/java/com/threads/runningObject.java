package com.threads;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

class runningObject extends Circle {
    @FunctionalInterface
    public interface angleSpeed{
        //dt*V_a;
        double compute(double dt, double va);
    }

    angleSpeed mLambdaAngleSpeed = null;

    double angle;
    double r;
    double V_r = 10;
    double V_a = 10;
    double dt = 0.1;
    double x_0 = 250;
    double y_0 = 250;

    runningObject(Group group, Color color, double R, angleSpeed va) {
        group.getChildren().add(this);

        mLambdaAngleSpeed = va;

        angle = Math.random()*360;
        V_r = V_r+Math.random()*10;

        setRadius(R);

        setFill(color);

        compute();
    }

    public void compute() {
        r += dt * V_r;
        angle+=mLambdaAngleSpeed.compute(dt,V_a);

        double x = x_0 + r*Math.cos(Math.toRadians(angle));
        double y = y_0 + r*Math.sin(Math.toRadians(angle));

        if (x < 0 || x > 500 || y < 0 || y > 500) {
            r = 0;
            x = x_0;
            y = y_0;
        }

        setTranslateX(x);
        setTranslateY(y);
    }
}
