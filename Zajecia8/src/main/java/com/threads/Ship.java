package com.threads;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

class Ship{
    Rectangle rect = new Rectangle();
    Scene scene;
    double width;
    double height;

    double bottomMargin = 5;

    boolean left = false;
    boolean right = false;

    long lastTimePressed;

    double speed = 0.1;

    EventHandler<KeyEvent> eventHandler = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            if(event.getCode()== KeyCode.LEFT){
                System.out.println("left");
            }

            if(event.getCode()==KeyCode.RIGHT){
                System.out.println("right");
            }

            event.consume();
        }
    };

    EventHandler<KeyEvent> eventKeyReleased = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            if(event.getCode()== KeyCode.LEFT){
                left = false;
            }

            if(event.getCode()==KeyCode.RIGHT){
                right = false;
            }
        }
    };

    Ship(Group group, Scene scene, double width, double height){

        this.width = width;
        this.height = height;

        this.scene = scene;

        rect.setWidth(this.width);
        rect.setHeight(this.height);

        rect.setFill(Color.BLUE);

        group.getChildren().add(rect);

        redraw();

        scene.setOnKeyPressed(eventHandler);
        scene.setOnKeyReleased(eventKeyReleased);
    }

    public void redraw(){
        rect.setTranslateX(scene.getWidth()/2-width/2);
        rect.setTranslateY(scene.getHeight()-height-bottomMargin);
    }
}
