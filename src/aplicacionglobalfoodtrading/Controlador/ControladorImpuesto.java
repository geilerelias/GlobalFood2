/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionglobalfoodtrading.Controlador;

import aplicacionglobalfoodtrading.Modelo.Impuesto;
import aplicacionglobalfoodtrading.Modelo.OtroImp;
import aplicacionglobalfoodtrading.Modelo.Unidad;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Ricardo Andres
 */
public class ControladorImpuesto {
    
    
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

    public ControladorImpuesto() {
    }
    
    
    public void Conectar() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_gft", "root", "");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar BD");
        }
    }
    
    public int RegistrarImpuesto(Impuesto i) {
        int exi = 0;
        String sql = "INSERT INTO impuesto (abreviatura,descripcion,valor) values ('" + i.getAbreviatura() + "','" + i.getDescripcion() +"',"+i.getValor()+")";
        try {
            Conectar();
            //System.out.println(sql);
            System.out.println(sql);
            st = con.createStatement();
            st.execute(sql);
            exi = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador _ de Impuesto", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
            exi = 0;
        }
        
        return exi;
        
    }
    
    public ArrayList<Impuesto> ListadoImpuesto() {
        ArrayList<Impuesto> ListaImp = new ArrayList();
        try {
            Conectar();
            String sql = "Select * from impuesto order by abreviatura";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Impuesto i = new Impuesto();
                i.setAbreviatura(rs.getString(1));
                i.setDescripcion(rs.getString(2));
                i.setValor(rs.getFloat(3));
                ListaImp.add(i);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador _ de OtroImpuesto", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
        }
        return ListaImp;
    }
    
    public Impuesto RetornarImpuestoxCod(String cod){
        Impuesto imp = null;
        for(Impuesto i : this.ListadoImpuesto()){
            if(cod.equals(i.getAbreviatura())){
                imp = i;
            }
        }
        return imp;
    }
    
  
    public int ModificarImpuesto(Impuesto i){
        int exi;
         String sql = "UPDATE impuesto SET descripcion = '"+i.getDescripcion()+"', valor = "+i.getValor()+" where abreviatura = '"+i.getAbreviatura()+"'";
        try {
            Conectar();
            //System.out.println(sql);
            st = con.createStatement();
            st.execute(sql);
            exi = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador _ impuesto", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
            exi = 0;
        }
        return exi;
    }  
    
    
    public int EliminarImpuesto(String cod){
        int exi;
         String sql = " DELETE FROM impuesto WHERE abreviatura = '"+cod+"'";
        try {
            Conectar();
            //System.out.println(sql);
            st = con.createStatement();
            st.execute(sql);
            exi = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador _ impuesto", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
            exi = 0;
        }
        return exi;     
    }
    
    
    
    
    public float RetornarValorxAbrev(String abrev){
        float valor = 0;
        for(Impuesto i : this.ListadoImpuesto()){
            
            if(i.getAbreviatura().equalsIgnoreCase(abrev)){
                valor = i.getValor();
            }
           
        }
        
        return valor;
    }
           
  
    
}
