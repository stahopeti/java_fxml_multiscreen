/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fxml_multiplescreens;

/**
 *
 * @author Lajos
 */
public class BackendLogic {
    
    
    public void bejelentkezo(String nev, String jelszo){
    
        System.out.println("Név: " + nev +"\nJelszó: " + jelszo);
    
    }
    
    public void bckndGetPlayers(){
    
        DBConnection connect = new DBConnection();
//        connect.getPlayer();
    
    
    }
   
    public void bckndAddUser(String name, String pw){
    
        DBConnection connect = new DBConnection();
        connect.addUser(name, pw);
    
    }
    
    public boolean signInNameCheck(String name, String pw){
    
        boolean valid_signin;
        
        
    DBConnection connect = new DBConnection();
    valid_signin = connect.loginCheck(name, pw);
    
    if(valid_signin){ 
        System.out.println("\nSikeres bejelentkezés!\n\n");
        return true;
    
    }else{
        System.out.println("\nSikertelen bejelentkezés!\n\n");
        return false;
    }
    
    }
}
