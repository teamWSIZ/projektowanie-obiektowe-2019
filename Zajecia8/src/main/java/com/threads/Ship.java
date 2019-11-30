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

    double v = 0.1;

    private long dt(){
        long currentTime = System.currentTimeMillis();
        long time =  currentTime - lastTimePressed;
        lastTimePressed = currentTime;

        return time;
    }

    private double computeDistance(double dt){
        return v*dt;
    }

    EventHandler<KeyEvent> eventHandler = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            if(event.getCode()== KeyCode.LEFT){

                if(!left){
                    left = true;
                    lastTimePressed = System.currentTimeMillis();
                }else{
                    double dx = computeDistance(dt());
                    rect.setTranslateX(rect.getTranslateX()-dx);
                }

            }

            if(event.getCode()==KeyCode.RIGHT){

                if(!right){
                    right = true;
                    lastTimePressed = System.currentTimeMillis();
                }else{
                    double dx = computeDistance(dt());
                    rect.setTranslateX(rect.getTranslateX()+dx);
                }
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
