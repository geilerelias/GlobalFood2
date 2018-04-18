/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionglobalfoodtrading.Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;


public class Conexion {
    private Connection conn;
    public Conexion() {
    }
    
    public void Conectar(){
    Connection con = null; 
    try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_gft","root","");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
           JOptionPane.showMessageDialog(null,"Error al conectar BD");
        }
    }
}
