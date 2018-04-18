/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionglobalfoodtrading.Modelo;

import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Admin {
  //  MessageDigest md = new MessageDigest();
    private String admin;
    private String pass;

    public Admin() {
    }

    public Admin(String admin, String pass) {
        this.admin = admin;
        this.pass = pass;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
    
  
    
    
    
    
    
}
