/*  
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml_multiplescreens;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Lajos
 */
public class MainMenuScreenController implements Initializable, setParent {

    ManagingScreens myController;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @Override
    public void setScreenParent(ManagingScreens screenParent) {
    
        myController = screenParent;
    
    }
    
    
    @FXML
    public void goToLogin(){
    
    myController.setScreen(ScreenFramework.screen1ID);
    
    }
    
    @FXML
    public void goToAlterData(){
    
    myController.setScreen(ScreenFramework.screen2ID);
    
    
    }
    
    
}
