/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml_multiplescreens;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Lajos
 */
public class LoginScreenController implements Initializable, setParent {

    ManagingScreens myController;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    
    public void setScreenParent(ManagingScreens screenParent){
    
        myController = screenParent;
    
    }
    
    @FXML
    private void goToScreen2(ActionEvent e){
    
        myController.setScreen(ScreenFramework.screen2ID);
    
    }
    
    @FXML 
    private void goToMain(ActionEvent e){
    
        myController.setScreen(ScreenFramework.screen3ID);
    
    }
    
    
    
}