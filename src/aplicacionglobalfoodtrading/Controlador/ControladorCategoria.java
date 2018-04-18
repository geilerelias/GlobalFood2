/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionglobalfoodtrading.Controlador;

import aplicacionglobalfoodtrading.Modelo.Categoria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControladorCategoria {
    
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
    
    public ControladorCategoria() {
    }
    
    public void Conectar() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_gft", "root", "");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar BD");
        }
    }
    
    public int RegistrarCategoria(Categoria c) {
        int exi = 0;
        String sql = "INSERT INTO categoria (codigo,nombre) values ('" + c.getCodigo() + "','" + c.getCategoria() + "')";
        try {
            Conectar();
            //System.out.println(sql);
            System.out.println(sql);
            st = con.createStatement();
            st.execute(sql);
            exi = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
            exi = 0;
        }
        
        return exi;
        
    }
    
    public ArrayList<Categoria> ListadoCategorias() {
        ArrayList<Categoria> Listac = new ArrayList();
        try {
            Conectar();
            String sql = "Select * from categoria order by nombre";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Categoria c = new Categoria();
                c.setCodigo(rs.getString(1));
                c.setCategoria(rs.getString(2));
                Listac.add(c);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
        }
        return Listac;
    }
    
    
    public Categoria RetornarCategoriaxCod(String cod){
        Categoria ca = null;
        for(Categoria c : this.ListadoCategorias()){
            if(cod.equals(c.getCodigo())){
                ca = c;
            }
        }
        return ca;
    }
    
    public int ModificarCategoria(Categoria c){
        int exi;
         String sql = "UPDATE CATEGORIA SET nombre = '"+c.getCategoria()+"' where codigo = '"+c.getCodigo()+"'";
        try {
            Conectar();
            //System.out.println(sql);
            st = con.createStatement();
            st.execute(sql);
            exi = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
            exi = 0;
        }
        return exi;
    }
    
    public int EliminarCategoria(String cod){
        int exi;
         String sql = " DELETE FROM CATEGORIA WHERE codigo = '"+cod+"'";
        try {
            Conectar();
            //System.out.println(sql);
            st = con.createStatement();
            st.execute(sql);
            exi = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
            exi = 0;
        }
        return exi;     
    }
    
    
    public String ObtenerCodigoCategoriaxNombre(String nom){
        
        Categoria ca = null;
        for(Categoria c : this.ListadoCategorias()){
            if(nom.equals(c.getCategoria())){
                ca = c;
            }
        }
        return ca.getCodigo();
    }
            
 
}
