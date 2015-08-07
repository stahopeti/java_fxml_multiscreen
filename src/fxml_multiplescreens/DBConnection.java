/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml_multiplescreens;


import java.sql.*;

/**
 *
 * @author Lajos
 */
public class DBConnection {
    
    private Connection con;
    private Statement st;
    private ResultSet rt;
    
    private String placeOfBirthDT;
    private String cityDT;
    private String addressDT;
    private String emailAddressDT;
    private int yearOfBirthDT;
    private int phoneNumberDT;
    private int postalNumberDT;
    
    public DBConnection(){
    try{
    
    Class.forName("com.mysql.jdbc.Driver");
    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/othello_db","root","");
    st = con.createStatement();
    
    }catch(Exception ex){
    
        System.out.println("Error: "+ ex);
    
        }
    
    }
    
    
    public void addUser(String name, String pw){
    try{
    
        String update = "INSERT INTO player_information(id, name,password) VALUES (12 , '"+name+"' , '"+pw+"')";
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
    
    public void getUser(String userName){
    try{
    
        String query = "SELECT * FROM player_information WHERE name ='"+ userName+ "'";
        rt = st.executeQuery(query);
        System.out.println("Data:");
        while(rt.next()){
        
            System.out.println("\nnév: " + rt.getString("name") + "\nszül.hely: " + rt.getString("placeOfBirth") + "\nszül.év: " + rt.getString("yearOfBirth")
            + "\nir.szám: " + rt.getString("postalNumber") + "\nváros: " + rt.getString("city"));
        
            
            
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
    
    public boolean loginCheck(String name, String pw){
    
        boolean valid_data=false;
                
    try{
        
        System.out.println("checkplayername  név: " + name + " jelszó: " + pw);
        
        int i = 0;
        rt = null;    
        String query = "SELECT * FROM player_information WHERE name COLLATE Latin1_General_CS = '" + name + 
                "' AND password COLLATE Latin1_General_CS = '" + pw + "'";
        rt = st.executeQuery(query);
             
        
        while(rt.next()){

            i++;
        
        }
        
        
        if(i==0){
            
            System.out.println("az RT-ben nincs semmi");
            
        }
        
        if(i==1){
            
            valid_data = true;
            
        }
    
    }catch(Exception ex){
        
        System.out.println(ex);
        valid_data = false;
        
    }
    
    return valid_data;
    
    }
}
