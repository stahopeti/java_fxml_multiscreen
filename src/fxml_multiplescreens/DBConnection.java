/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml_multiplescreens;


import java.sql.*;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

/**
 *
 * @author Lajos
 */
public class DBConnection {
    
    private Connection con;
    private Statement st;
    private ResultSet rt;
    
    @FXML TextField placeOfBirthDT;
    @FXML TextField cityDT;
    @FXML TextField addressDT;
    @FXML TextField emailAddressDT;
    @FXML TextField yearOfBirthDT;
    @FXML TextField phoneNumberDT;
    @FXML TextField postalNumberDT;
    
    public DBConnection(){
    try{
    
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/othello_db","root","");
    st = con.createStatement();
    
    }catch(Exception ex){
    
        System.out.println("Error: "+ ex);
    
        }
    
    }
    
    
    public void addPlayer(String name, String pw){
    try{
    
        String update = "INSERT INTO player_information(name,password) VALUES ('"+name+"','"+pw+"')";
        st.executeUpdate(update);
        
        String query = "select * from player_information";
        rt = st.executeQuery(query);
        System.out.println("Data:");
        while(rt.next()){
        
            System.out.println("név: " + rt.getString("name") + " jelszó: "+ rt.getString("password")
                    + "\nszületett: " + rt.getString("placeOfBirth") +  rt.getString("yearOfBirth") + "-ban/ben\n" );
        
        }
    }catch(Exception ex){
    
        System.out.println(ex);
    
    }
    
    }
    
    public void getPlayer(String userName){
    try{
    
        String query = "SELECT * FROM player_information WHERE name ='"+ userName+ "'";
        rt = st.executeQuery(query);
        System.out.println("Data:");
        while(rt.next()){
        
            System.out.println("\nnév: " + rt.getString("name") + "\nszül.hely: " + rt.getString("placeOfBirth") + "\nszül.év: " + rt.getString("yearOfBirth")
            + "\nir.szám: " + rt.getString("postalNumber") + "\nváros: " + rt.getString("city"));
        
            placeOfBirthDT.setText(rt.getString(userName));
            
        }
    }catch(Exception ex){
    
        System.out.println(ex);
    
    }
    
    }
    
    
    public void alterData(String userName, String placeOfBirth, String city, String address,
            String emailAddress, int yearOfBirth, int phoneNumber, int postalNumber){
    
    try{
        System.out.println("DBCONNECTION: \n");
        
         System.out.println(placeOfBirth + "\n" + yearOfBirth + "\n"+ postalNumber
                + "\n"+ city + "\n"+ address + "\n"
                + phoneNumber + "\n" + emailAddress );
        
        
       
        rt = null;
       String query = "UPDATE player_information "
                + "SET placeOfBirth = '"+placeOfBirth+"', city ='" +city + "',"
                + "address ='"+ address+"', emailAddress = '" + emailAddress+"',"
                + "yearOfBirth ="+yearOfBirth+",phoneNumber ="+phoneNumber+","
                + "postalNumber = "+postalNumber
                + " WHERE name = '"+userName+"'";
                
                ;
        
        st.executeUpdate(query);
       
        System.out.println("update maybe executed");
        
    }catch(Exception ex){
    
        System.out.println(ex);
        
    
    }
        
    
    }
    
    public boolean checkPlayerName(String name, String pw){
    
        boolean valid_data=false;
        
    try{
    
        rt = null;    
        String query = "SELECT password FROM player_information WHERE name LIKE '" + name + "' AND password LIKE '" + pw + "'";
        rt = st.executeQuery(query);
        if(rt!=null){
            valid_data = true;
        }
    
    }catch(Exception ex){
        
        System.out.println(ex);
        valid_data = false;
    }
    
    return valid_data;
    }
}
