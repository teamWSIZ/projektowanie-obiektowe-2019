package com.threads;

import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;

class ShipBuilder{
    Scene scene;
    Group group;
    double width = 100;
    double height = 40;
    Image image = null;

    ShipBuilder addImage(Image image){
        this.image = image;
        return this;
    }

    ShipBuilder(Group group, Scene scene){
        this.group = group;
        this.scene = scene;
    }

    Ship build(){
        return new Ship(group, scene,width,height);
    }
}
