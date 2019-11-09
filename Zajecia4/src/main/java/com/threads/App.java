/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.threads;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

import java.util.ArrayList;

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

public class App extends Application {
    ArrayList<runningObject> objects = new ArrayList<>();

    Thread animation = new Thread(new Runnable() {
        @Override
        public void run() {
            while (true) {

                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        for (runningObject object : objects)
                            object.compute();
                    }
                });

                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    });

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.show();

        for(int i=0;i<1000;i++)
            objects.add(new runningObject(group));

        animation.start();

    }
}
