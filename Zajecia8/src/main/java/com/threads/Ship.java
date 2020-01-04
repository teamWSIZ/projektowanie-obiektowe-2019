package com.threads;

import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

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

    TranslateTransition tt = new TranslateTransition();

    private long dt(){
        long currentTime = System.currentTimeMillis();
        long time =  currentTime - lastTimePressed;
        lastTimePressed = currentTime;

        return time;
    }

    private double computeDistance(double x,double dt){
        return ShipEquations.speedX(x,0,scene.getWidth())*dt;
    }

    EventHandler<KeyEvent> eventHandler = new EventHandler<KeyEvent>() {
        @Override
        public void handle(KeyEvent event) {
            if(event.getCode()== KeyCode.LEFT){

                if(!left){
                    left = true;
                    lastTimePressed = System.currentTimeMillis();
                }else{
                    double dt = dt();
                    double x = getShipCenter();

                    double dx = computeDistance(x-width/2,dt);

                    tt.stop();
                    tt.setFromX(rect.getTranslateX());

                    double newX = rect.getTranslateX()-dx;

                    if(newX>0) {

                        tt.setToX(rect.getTranslateX() - dx);
                        tt.setDuration(Duration.millis(dt));
                        tt.setNode(rect);
                        tt.play();
                    }

                }

            }

            if(event.getCode()==KeyCode.RIGHT){

                if(!right){
                    right = true;
                    lastTimePressed = System.currentTimeMillis();
                }else{
                    double dt = dt();
                    double x = getShipCenter();
                    double dx = computeDistance(x,dt);

                    tt.stop();
                    tt.setFromX(rect.getTranslateX());

                    double newX = rect.getTranslateX()-dx;

                    if(newX<scene.getWidth()/2+width) {
                        tt.setToX(rect.getTranslateX() + dx);
                        tt.setDuration(Duration.millis(dt));
                        tt.setNode(rect);
                        tt.play();
                    }else{
                        tt.setToX(scene.getWidth()-width);
                        tt.setDuration(Duration.millis(dt));
                        tt.setNode(rect);
                        tt.play();
                    }
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

    private double getShipCenter(){

        return rect.getTranslateX() + width/2;
    }
}
