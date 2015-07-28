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
public class AlterDataScreenController implements Initializable, setParent {

    ManagingScreens myController;
    
    String placeOfBirth;
    String city;
    String address;
    String emailAddress;
    int yearOfBirth;
    int phoneNumber;
    int postalNumber;
    
    
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
    private void goToScreen1(ActionEvent e){
    
        myController.setScreen(ScreenFramework.screen1ID);
    
    }
    
    @FXML 
    private void goToMain(ActionEvent e){
    
        myController.setScreen(ScreenFramework.screen3ID);
    
    }
    
    private void alterData(){
    
        DBConnection connect = new DBConnection();
//        connect.alterData();
        
        
    
    }
    
}
