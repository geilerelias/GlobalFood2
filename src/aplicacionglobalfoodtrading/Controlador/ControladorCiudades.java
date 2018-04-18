/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionglobalfoodtrading.Controlador;

import aplicacionglobalfoodtrading.Modelo.Ciudad;
import aplicacionglobalfoodtrading.Modelo.Conexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author Ricardo Andres
 */
public class ControladorCiudades {

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

    public ControladorCiudades() {
    }

    public void Conectar() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_gft", "root", "");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar BD");
        }
    }

    public ArrayList<Ciudad> ListaCiudadxPais(String codpais) throws SQLException{
        ArrayList<Ciudad> Lc = new ArrayList();
        Conectar();
        String Sql = "Select * from ciudades where Paises_Codigo ='"+codpais+"' order by Ciudad";
        try {
            st = con.createStatement();
            rs = st.executeQuery(Sql);
            
            
            while(rs.next()){
                Ciudad c = new Ciudad();
                c.setIdciudad(rs.getString("idCiudades"));
                c.setCiudad(rs.getString("Ciudad"));
                c.setFk_pais(rs.getString("Paises_Codigo"));
                Lc.add(c);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        

        return Lc;
    }

    public ArrayList<Ciudad> ListaCiudades() throws SQLException{
        ArrayList<Ciudad> Lc = new ArrayList();
        Conectar();
        String Sql = "Select * from ciudades";
        try {
            st = con.createStatement();
            rs = st.executeQuery(Sql);
            
            
            while(rs.next()){
                Ciudad c = new Ciudad();
                c.setIdciudad(rs.getString("idCiudades"));
                c.setCiudad(rs.getString("Ciudad"));
                c.setFk_pais(rs.getString("Paises_Codigo"));
                Lc.add(c);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
        }
        

        return Lc;
    }
    
}
