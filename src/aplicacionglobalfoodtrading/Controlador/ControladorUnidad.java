/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionglobalfoodtrading.Controlador;

import aplicacionglobalfoodtrading.Modelo.Bodega;
import aplicacionglobalfoodtrading.Modelo.Unidad;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ControladorUnidad {
    
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

    public static void setRs(ResultSet aRs) {
        rs = aRs;
    }

    public static Statement getSt() {
        return st;
    }

    public static void setSt(Statement aSt) {
        st = aSt;
    }

    public ControladorUnidad() {
    }
    
    
    
    public void Conectar() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_gft", "root", "");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar BD");
        }
    }
    
    
    public int RegistrarUnidad(Unidad u) {
        int exi = 0;
        String sql = "INSERT INTO UNIDAD (abreviatura,descripcion) values ('" + u.getAbreviatura() + "','" + u.getDescripcion() + "')";
        try {
            Conectar();
            //System.out.println(sql);
            System.out.println(sql);
            st = con.createStatement();
            st.execute(sql);
            exi = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador _ de Unidad", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
            exi = 0;
        }
        
        return exi;
        
    }
    public ArrayList<Unidad> ListadoUnidad() {
        ArrayList<Unidad> Listau = new ArrayList();
        try {
            Conectar();
            String sql = "Select * from unidad order by abreviatura";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Unidad u = new Unidad();
                u.setAbreviatura(rs.getString(1));
                u.setDescripcion(rs.getString(2));
                Listau.add(u);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador _ de Unidad", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
        }
        return Listau;
    }
  
    public Unidad RetornarUnidadxCod(String cod){
        Unidad un = null;
        for(Unidad u : this.ListadoUnidad()){
            if(cod.equals(u.getAbreviatura())){
                un = u;
            }
        }
        return un;
    }
    public int ModificarUnidad(Unidad u){
        int exi;
         String sql = "UPDATE Unidad SET descripcion = '"+u.getDescripcion()+"' where abreviatura = '"+u.getAbreviatura()+"'";
        try {
            Conectar();
            //System.out.println(sql);
            st = con.createStatement();
            st.execute(sql);
            exi = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador _ Unidad", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
            exi = 0;
        }
        return exi;
    }
    
    
    public int EliminarUnidad(String cod){
        int exi;
         String sql = " DELETE FROM unidad WHERE abreviatura = '"+cod+"'";
        try {
            Conectar();
            //System.out.println(sql);
            st = con.createStatement();
            st.execute(sql);
            exi = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador _ unidad", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
            exi = 0;
        }
        return exi;     
    }
    
    
}
