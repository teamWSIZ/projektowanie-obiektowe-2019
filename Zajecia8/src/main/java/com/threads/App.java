/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package com.threads;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Group group = new Group();
        Scene scene = new Scene(group, 500, 500);

        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
