/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionglobalfoodtrading.Controlador;

import aplicacionglobalfoodtrading.Modelo.Giro_Negocio;
import aplicacionglobalfoodtrading.Modelo.Proveedor;
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
 * @author Ricardo Carmona
 */
public class Controlador_Giro_Negocio {
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

    public Controlador_Giro_Negocio() {
    }
    
    
    public void Conectar() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_gft", "root", "");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar BD");
        }
    }
    
    public int RegistrarGiro_Negocio(Giro_Negocio g) {
        int exi = 0;
        String sql = "INSERT INTO `g_negocio`(`descripcion`) VALUES ('"+g.getDescripcion()+"')";
        try {
            Conectar();
            //System.out.println(sql);
            System.out.println(sql);
            st = con.createStatement();
            st.execute(sql);
            exi = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador _ de Giro Negocio", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
            exi = 0;
        }

        return exi;

    }
    
    public ArrayList<Giro_Negocio> ListadoGiro() {
        ArrayList<Giro_Negocio> ListaG = new ArrayList();
        try {
            Conectar();
            String sql = "Select * from g_negocio order by indice";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Giro_Negocio g = new Giro_Negocio();
                g.setIndice(String.valueOf(rs.getInt(1)));
                g.setDescripcion(rs.getString(2));
                ListaG.add(g);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador _ de Giro Negocio", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
        }
        return ListaG;
    }
    
    
    public Giro_Negocio GiroxCodigo(String cod) {
        Giro_Negocio g = null;
        for (Giro_Negocio gi : this.ListadoGiro()) {
            if (gi.getDescripcion().equalsIgnoreCase(cod)) {
                g = gi;
            }
        }
        return g;
    }
    
    
    public int ModificarGiro(Giro_Negocio g){
        int exi;
         String sql = "UPDATE g_negocio SET descripcion = '"+g.getDescripcion()+"' where indice = "+g.getIndice()+"";
        try {
            Conectar();
            //System.out.println(sql);
            st = con.createStatement();
            st.execute(sql);
            exi = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador _ Giro", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
            exi = 0;
        }
        return exi;
    }
    
    
    
    
    
    public int EliminarGiro(Giro_Negocio g){
        int exi;
         String sql = " DELETE FROM g_negocio WHERE indice = "+g.getIndice()+"";
        try {
            Conectar();
            //System.out.println(sql);
            st = con.createStatement();
            st.execute(sql);
            exi = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador _ Giro Negocio", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
            exi = 0;
        }
        return exi;     
    }
    
    
}
