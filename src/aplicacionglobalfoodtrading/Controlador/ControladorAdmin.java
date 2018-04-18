/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionglobalfoodtrading.Controlador;

import aplicacionglobalfoodtrading.Modelo.Admin;
import aplicacionglobalfoodtrading.Modelo.Bodega;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControladorAdmin {

    private static Connection con;
    private static ResultSet rs;
    private static Statement st;

    public static Connection getCon() {
        return con;
    }

    public static void setCon(Connection aCon) {
        con = aCon;
    }

    public static ResultSet getRs() {
        return rs;
    }

    public void Conectar() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_gft", "root", "");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar BD");
        }
    }

    public static void setRs(ResultSet aRs) {
        rs = aRs;
    }

    public static Statement getSt() {
        return st;
    }

    public static void setSt(Statement aSt) {
        st = aSt;
    }

    public ControladorAdmin() {
    }

    public ArrayList<Admin> ListadoAdmin() {
        ArrayList<Admin> Listad = new ArrayList();
        try {
            Conectar();
            String sql = "Select * from admin order by user";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Admin a = new Admin();
                a.setAdmin(rs.getString(1));
                a.setPass(rs.getString(2));
                Listad.add(a);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador _ de Admin", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
        }
        return Listad;
    }
    
    public int ModificarContraseña(String nuevapass){
        int exi = 0;
        try {
            Conectar();
            String sql = "UPDATE `admin` SET `pass`= '"+nuevapass+"' WHERE user = 'crisas'";
            st = con.createStatement();
            //rs = st.executeQuery(sql);
           if(st.executeUpdate(sql)>0){
               exi = 1;
           }else{
               exi = 0;
           }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador _ de Admin", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
        }
        
        return exi;
    }
    
    public int ValidarAcceso(String user,String pass){
        int existe = 0;
        for(Admin a : ListadoAdmin()){
            if(a.getAdmin().equals(user) && a.getPass().equals(pass)){
                existe = 1;
            }
        }
        
        return existe;
        
    }

   
    
   
    
    
}
