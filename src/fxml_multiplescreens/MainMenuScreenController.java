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
import javafx.animation.FadeTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * FXML Controller class
 *
 * @author Lajos
 */

public class MainMenuScreenController implements Initializable, setParent {

    ManagingScreens myController;

    private static String userNameString;
    private static String passwordString;
    
    //Loginsscreen
    
    @FXML Button buttonLI;
    @FXML Button buttonLO;
        
    @FXML private TextField userNameREG; 
    @FXML private PasswordField pwREG;   
    
    @FXML private TextField userNameLI;
    @FXML private PasswordField pwLI;
    
    //Loginsscreen
    
//    
//    @FXML Tab adatmodTAB;
//    @FXML Tab adatlapTAB;
//    
//    @FXML GridPane adatlapAnchor;
//    @FXML AnchorPane adatmodAnchor;
    
    @FXML private TextField userName; 
    @FXML private PasswordField pw;   
    
    @FXML Label userNameLabel;
    @FXML Label userNameLabel1;
    @FXML Label userNameLabel2;
    
    
    //adatmódosítás
    
    @FXML TextField placeOfBirth = new TextField();
    @FXML TextField city = new TextField();
    @FXML TextField address = new TextField();
    @FXML TextField emailAddress = new TextField();
    @FXML TextField yearOfBirth = new TextField();
    @FXML TextField phoneNumber = new TextField();
    @FXML TextField postalNumber = new TextField();
    
    //adatlap
    
    @FXML VBox vBoxDATA;
    
    @FXML Label placeOfBirthDT = new Label();
    @FXML Label cityDT = new Label();
    @FXML Label addressDT = new Label();
    @FXML Label emailAddressDT = new Label();
    @FXML Label yearOfBirthDT = new Label();
    @FXML Label phoneNumberDT = new Label();
    @FXML Label postalNumberDT = new Label();
    
    //textek
    
    private String placeOfBirthDTt;
    private String cityDTt;
    private String addressDTt;
    private String emailAddressDTt;
    private String yearOfBirthDTt;
    private String phoneNumberDTt;
    private String postalNumberDTt;
    
    
    Button btnForAlteringData;
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO    
        buttonLO.setOpacity(0);
//        adatlapAnchor.setOpacity(0);
        vBoxDATA.setOpacity(0);
    }  
    
    public TextField getUserName() {
        return userNameLI;
    }

    public PasswordField getPw() {
        return pwLI;
    }
    
    @FXML
    public void refreshDataSheet(){
        
        try{
    
            System.out.println("Ez az amit kap a refreshDataSheet: " + userNameString );
            
        Connection con;
        Statement st;
        ResultSet rt;
        Class.forName("com.mysql.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/othello_db","root","");
        st = con.createStatement();
        
        String query = "SELECT * FROM player_information WHERE name='" + userNameString +"'";
        rt = st.executeQuery(query);
        while(rt.next()){
        
            System.out.println("\nnév: " + rt.getString("name") + "\nszül.hely: "
                    + rt.getString("placeOfBirth") + "\nszül.év: " + rt.getString("yearOfBirth")
            + "\nir.szám: " + rt.getString("postalNumber") + "\nváros: " + rt.getString("city"));
            
            

        
            placeOfBirthDTt = rt.getString("placeOfBirth");
            yearOfBirthDTt = rt.getString("yearOfBirth");
            postalNumberDTt = rt.getString("postalNumber");
            cityDTt = rt.getString("city");
            addressDTt = rt.getString("address");
            phoneNumberDTt = rt.getString("phoneNumber");
            emailAddressDTt = rt.getString("emailAddress");
            
           
            
            placeOfBirthDT.setText((placeOfBirthDTt));
            System.out.println("placeofbirth label: "+placeOfBirthDT.getText());
            yearOfBirthDT.setText((yearOfBirthDTt));
            postalNumberDT.setText((postalNumberDTt));
            cityDT.setText((cityDTt));
            addressDT.setText((addressDTt));
            phoneNumberDT.setText((phoneNumberDTt));
            emailAddressDT.setText((emailAddressDTt));
            
            placeOfBirth.setText(placeOfBirthDTt);
            System.out.println("placeofbirth textfield: "+placeOfBirth.getText());
            yearOfBirth.setText(yearOfBirthDTt);
            postalNumber.setText(postalNumberDTt);
            city.setText(cityDTt);
            address.setText(addressDTt);
            phoneNumber.setText(phoneNumberDTt);
            emailAddress.setText(emailAddressDTt);
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
        
        
        userNameLabel.setText("goToAlteren túl vagyunk");
        BackendLogic bcknd = new BackendLogic();
        
        if(bcknd.signInNameCheck(userNameString, passwordString)){
        
        userNameLabel.setText(userNameString);
            userNameLabel1.setText(userNameString);
            userNameLabel2.setText(userNameString);
        
        System.out.println("Felhasználónév: "+userNameString+"\nJelszó: "+passwordString);
//        goToAlter();
        FadeTransition ft = new FadeTransition(Duration.millis(1000), buttonLO);
        ft.setFromValue(0);
        ft.setToValue(1.0);
        ft.play();
        
        
        }
        else{userNameLabel.setText("sikertelen bejelentkezés");}
        
        
    }
    
    @FXML
    public void logout(){
        
        userName.setText("");
        pw.setText("");
        
        userNameString = "";
        passwordString = "";
//        
        refreshDataSheet();
//        
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
//            
            userNameLabel.setText("Sikeresen kijelentkezett!");
            
            userNameLabel1.setText("Sikeresen kijelentkezett!");
            
            userNameLabel2.setText("Sikeresen kijelentkezett!");
            
            backToLogin();
    
    }
    
    @FXML 
    private void goToAlter(){
    
        myController.setScreen(ScreenFramework.screen2ID);
    }
        
    @FXML   
    private void backToLogin(){
    
        myController.setScreen(ScreenFramework.screen1ID);
    
    }
    
    @FXML
    private void alterData(){
    
        
        
        
        DBConnection connect = new DBConnection();
        connect.alterData(userNameString, placeOfBirth.getText(), city.getText(), address.getText(),
                emailAddress.getText(), Integer.parseInt(yearOfBirth.getText()),
                Integer.parseInt(phoneNumber.getText()), Integer.parseInt(postalNumber.getText()));
        
        refreshDataSheet();

//        System.out.println(placeOfBirth.getText() + "\n" + yearOfBirth.getText() + "\n"+ postalNumber.getText()
//                + "\n"+ city.getText() + "\n"+ address.getText() + "\n"
//                + phoneNumber.getText() + "\n" + emailAddress.getText() );
//        
    }
    
    @FXML
    private void registration(){
    
    BackendLogic bcknd = new BackendLogic();
    bcknd.bckndAddUser(
            
            userNameREG.getText()
            
            ,
            
            pwREG.getText()
    
    );
    
    }

    @FXML
    private void showData(){
    
        FadeTransition ft = new FadeTransition(Duration.millis(1000), vBoxDATA);
        ft.setFromValue(0);
        ft.setToValue(1.0);
        ft.play();
        
        refreshDataSheet();
        

    
    }
}
