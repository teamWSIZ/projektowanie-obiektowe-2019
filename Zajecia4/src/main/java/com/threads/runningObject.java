package com.threads;

import javafx.scene.Group;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

class runningObject extends Circle {
    double angle;
    double r;
    double V_r = 10;
    double V_a = 0;
    double dt = 0.1;
    double x_0 = 250;
    double y_0 = 250;

    runningObject(Group group) {
        group.getChildren().add(this);

        angle = Math.random()*360;

        setRadius(5);
        setFill(Color.BLUE);

        compute();
    }

    public void compute() {
        r += dt * V_r;

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
