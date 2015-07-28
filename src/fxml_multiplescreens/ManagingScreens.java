/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml_multiplescreens;

import java.util.HashMap;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.Timeline;
import javafx.beans.property.DoubleProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

/**
 *
 * @author Lajos
 */
public class ManagingScreens extends StackPane{
    
    //storing screens to be displayed
    private HashMap<String, Node> screens = new HashMap<>();
    
    public ManagingScreens(){
    
    super();
    }
    
    public void addScreen(String name, Node screen){
    
        screens.put(name, screen);
        
    }
    
    public Node getScreen(String name){
    
        return screens.get(name);
    
    }
    
    public boolean loadScreen(String name, String resource){
    
    try{
        
        FXMLLoader myLoader = new FXMLLoader(getClass().getResource(resource));
        Parent loadScreen = (Parent) myLoader.load();
        setParent myScreenController = ((setParent) myLoader.getController());
        myScreenController.setScreenParent(this);
        addScreen(name, loadScreen);
        return true;
    
    }catch(Exception e){
        System.out.println(e.getMessage());}
    return false;
    }
 
    public boolean setScreen(final String name){
    
        if (screens.get(name)!=null) {
            
            if(!getChildren().isEmpty()){
            
            cserebere(name);
            
            }else{
            
                getChildren().add(screens.get(name));
                
            }
            return true;
        }else{
            
            System.out.println("screen hasnt been loaded");
            return false;
            
        }
        
        
    }
    
    public void cserebere(String name){
    
        getChildren().remove(0);
        getChildren().add(0, screens.get(name));
    
    }
    
    public boolean unLoadScreen(String name){
    
        if (screens.remove(name)==null) {
            
            System.out.println("Screen didnt exist");
            return false;
        }else{
        
            return true;
        
        }
    
    }
    
}
