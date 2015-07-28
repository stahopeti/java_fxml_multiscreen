/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml_multiplescreens;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Lajos
 */
public class ScreenFramework extends Application {
    
    public static String screen1ID = "bejelentkező";
    public static String screen1FILE = "LoginScreen.fxml";
    public static String screen2ID = "adatmódosítás";
    public static String screen2FILE = "AlterDataScreen.fxml";
    public static String screen3ID = "főmenü";
    public static String screen3FILE = "MainMenuScreen.fxml";
    
    
    
    @Override
    public void start(Stage primaryStage) {
    
        ManagingScreens mainContainer = new ManagingScreens();
        
        mainContainer.loadScreen(ScreenFramework.screen1ID, ScreenFramework.screen1FILE);
        mainContainer.loadScreen(ScreenFramework.screen2ID, ScreenFramework.screen2FILE);
        mainContainer.loadScreen(ScreenFramework.screen3ID, ScreenFramework.screen3FILE);
        
        mainContainer.setScreen(ScreenFramework.screen3ID);
        
        Group root = new Group();
        root.getChildren().addAll(mainContainer);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
        
        
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
