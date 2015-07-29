/*  
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml_multiplescreens;

import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Lajos
 */
public class MainMenuScreenController implements Initializable, setParent {

    ManagingScreens myController;

    private String userNameString = "";
    private String passwordString;
    
    @FXML private TextField userName;
    @FXML private PasswordField pw;
    
    @FXML Label userNameLabel;
    @FXML TextField placeOfBirth;
    @FXML TextField city;
    @FXML TextField address;
    @FXML TextField emailAddress;
    @FXML TextField yearOfBirth;
    @FXML TextField phoneNumber;
    @FXML TextField postalNumber;
    
    private String placeOfBirthDTt= "kutya";
    private String cityDTt;
    private String addressDTt;
    private String emailAddressDTt;
    private String yearOfBirthDTt;
    private String phoneNumberDTt;
    private String postalNumberDTt;
    
    @FXML Label placeOfBirthDT;
    @FXML Label cityDT;
    @FXML Label addressDT;
    @FXML Label emailAddressDT;
    @FXML Label yearOfBirthDT;
    @FXML Label phoneNumberDT;
    @FXML Label postalNumberDT;
    
    Button btnForAlteringData;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
//        placeOfBirth.setText("Születési hely");
        userNameLabel.setText(userNameString);
        
    }  
    
    public TextField getUserName() {
        return userName;
    }

    public PasswordField getPw() {
        return pw;
    }
    
    public void refreshDataSheet(){
        
        try{
    
        Connection con;
        Statement st;
        ResultSet rt;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/othello_db","root","");
        st = con.createStatement();
        
        String query = "SELECT * FROM player_information WHERE name='" + userNameString +"'";
        rt = st.executeQuery(query);
        while(rt.next()){
        
            System.out.println("\nnév: " + rt.getString("name") + "\nszül.hely: " + rt.getString("placeOfBirth") + "\nszül.év: " + rt.getString("yearOfBirth")
            + "\nir.szám: " + rt.getString("postalNumber") + "\nváros: " + rt.getString("city"));
            
            
            placeOfBirthDT.setText(rt.getString("placeOfBirth"));
            yearOfBirthDT.setText(rt.getString("yearOfBirth"));
            postalNumberDT.setText(rt.getString("postalNumber"));
            cityDT.setText(rt.getString("city"));
            addressDT.setText(rt.getString("address"));
            phoneNumberDT.setText(rt.getString("phoneNumber"));
            emailAddressDT.setText(rt.getString("emailAddress"));
        
            placeOfBirthDTt = rt.getString("placeOfBirth");
            yearOfBirthDTt = rt.getString("yearOfBirth");
            postalNumberDTt = rt.getString("postalNumber");
            cityDTt = rt.getString("city");
            addressDTt = rt.getString("address");
            phoneNumberDTt = rt.getString("phoneNumber");
            emailAddressDTt = rt.getString("emailAddress");
            
        }
        
        con.close();
    
    }catch(Exception ex){
    
        System.out.println("Error: "+ ex);
    
        }
    
    }
    
    @Override
    public void setScreenParent(ManagingScreens screenParent) {
    
        myController = screenParent;
    
    }
        
    @FXML
    public void login(){
    
        userNameString = userName.getText();
        passwordString = pw.getText();
        
        userNameLabel.setText(userNameString);
        System.out.println("Felhasználónév: "+userNameString+"\nJelszó: "+passwordString);
        
        refreshDataSheet();
        
        placeOfBirth.setText(placeOfBirthDTt);
        yearOfBirth.setText(yearOfBirthDTt);
        postalNumber.setText(postalNumberDTt);
        city.setText(cityDTt);
        address.setText(addressDTt);
        phoneNumber.setText(phoneNumberDTt);
        emailAddress.setText(emailAddressDTt);
    }
    
    @FXML
    public void logout(){
        
        userName.setText("");
        pw.setText("");
        
        userNameString = null;
        passwordString = null;
        
        refreshDataSheet();
        
            placeOfBirthDT.setText("");
            yearOfBirthDT.setText("");
            postalNumberDT.setText("");
            cityDT.setText("");
            addressDT.setText("");
            phoneNumberDT.setText("");
            emailAddressDT.setText("");
        
            placeOfBirth.setText("");
            yearOfBirth.setText("");
            postalNumber.setText("");
            city.setText("");
            address.setText("");
            phoneNumber.setText("");
            emailAddress.setText("");
            
            userNameLabel.setText("");
        
    
    }
    
    @FXML
    public void goToAlterData(){
    
    myController.setScreen(ScreenFramework.screen2ID);
    
    
    }
    
    @FXML
    private void alterData(){
    
        
        
        
        DBConnection connect = new DBConnection();
        connect.alterData(userNameString, placeOfBirth.getText(), city.getText(), address.getText(),
                emailAddress.getText(), Integer.parseInt(yearOfBirth.getText()), Integer.parseInt(phoneNumber.getText()), Integer.parseInt(postalNumber.getText()));

        refreshDataSheet();
//        System.out.println(placeOfBirth.getText() + "\n" + yearOfBirth.getText() + "\n"+ postalNumber.getText()
//                + "\n"+ city.getText() + "\n"+ address.getText() + "\n"
//                + phoneNumber.getText() + "\n" + emailAddress.getText() );
//        
    }
    
    
}
