/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionglobalfoodtrading.Controlador;

import aplicacionglobalfoodtrading.Modelo.Bodega;
import aplicacionglobalfoodtrading.Modelo.Categoria;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class ControladorBodega {
    
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

    public ControladorBodega() {
    }
    
    
    public void Conectar() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_gft", "root", "");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar BD");
        }
    }
    
    
    public int RegistrarBodega(Bodega b) {
        int exi = 0;
        String sql = "INSERT INTO bodega (Codigo,nombre_bod) values ('" + b.getCodigo() + "','" + b.getNombre_b() + "')";
        try {
            Conectar();
            //System.out.println(sql);
            System.out.println(sql);
            st = con.createStatement();
            st.execute(sql);
            exi = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador _ de Bodega", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
            exi = 0;
        }
        
        return exi;
        
    }
    
    public ArrayList<Bodega> ListadoBodegas() {
        ArrayList<Bodega> Listab = new ArrayList();
        try {
            Conectar();
            String sql = "Select * from bodega order by nombre_bod";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Bodega b = new Bodega();
                b.setCodigo(rs.getString(1));
                b.setNombre_b(rs.getString(2));
                Listab.add(b);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador _ de bodega", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
        }
        return Listab;
    }
    
    public Bodega RetornarBodegaxCod(String cod){
        Bodega bod = null;
        for(Bodega b : this.ListadoBodegas()){
            if(cod.equals(b.getCodigo())){
                bod = b;
            }
        }
        return bod;
    }
    
    public int ModificarBodega(Bodega b){
        int exi;
         String sql = "UPDATE bodega SET nombre_bod = '"+b.getNombre_b()+"' where codigo = '"+b.getCodigo()+"'";
        try {
            Conectar();
            //System.out.println(sql);
            st = con.createStatement();
            st.execute(sql);
            exi = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador _ bodega", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
            exi = 0;
        }
        return exi;
    }
    
     public int EliminarCategoria(String cod){
        int exi;
         String sql = " DELETE FROM bodega WHERE codigo = '"+cod+"'";
        try {
            Conectar();
            //System.out.println(sql);
            st = con.createStatement();
            st.execute(sql);
            exi = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador _ bodega", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
            exi = 0;
        }
        return exi;     
    }
    
     public String RetornarCodigoBodegaxNom(String nom){
        Bodega bod = null;
        for(Bodega b : this.ListadoBodegas()){
            if(nom.equals(b.getNombre_b())){
                bod = b;
            }
        }
        return bod.getCodigo();
    }
    
    
}
