/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.threads;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


class Ship{
    Rectangle rect = new Rectangle();
    Scene scene;
    double width;
    double height;

    double bottomMargin = 5;

    Ship(Group group, Scene scene, double width, double height){

        this.width = width;
        this.height = height;

        this.scene = scene;

        rect.setWidth(this.width);
        rect.setHeight(this.height);

        rect.setFill(Color.BLUE);

        group.getChildren().add(rect);

        redraw();
    }
    public void redraw(){
        rect.setTranslateX(scene.getWidth()/2-width/2);
        rect.setTranslateY(scene.getHeight()-height-bottomMargin);
    }
}

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.show();

        Ship ship = new Ship(group,scene,50,20);
    }
}
