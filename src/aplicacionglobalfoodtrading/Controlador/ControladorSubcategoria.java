/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionglobalfoodtrading.Controlador;

import aplicacionglobalfoodtrading.Modelo.Categoria;
import aplicacionglobalfoodtrading.Modelo.Subcategoria;
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
public class ControladorSubcategoria {
    
    
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

    public ControladorSubcategoria() {
    }
    

 public void Conectar() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_gft", "root", "");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar BD");
        }
    }


 public int RegistrarSubcategoria(Subcategoria s) {
        int exi = 0;
        String sql = "INSERT INTO subcategoria (fk_categoria,codigo,nombre) values ('" + s.getFk_categoria() + "','" + s.getCodigo() +"','"+s.getNombre()+"')";
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
 
  public ArrayList<Subcategoria> ListadoSubcategorias() {
        ArrayList<Subcategoria> Listas = new ArrayList();
        try {
            Conectar();
            String sql = "Select * from subcategoria order by nombre";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Subcategoria s = new Subcategoria();
                s.setFk_categoria(rs.getString(3));
                s.setCodigo(rs.getString(1));
                s.setNombre(rs.getString(2));
                Listas.add(s);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
        }
        return Listas;
    }
  
  
      
    public Subcategoria RetornarSubcategoriaxCod(String cod){
        Subcategoria ca = null;
        for(Subcategoria c : this.ListadoSubcategorias()){
            if(cod.equals(c.getCodigo())){
                ca = c;
            }
        }
        return ca;
    }
  
   public int ModificarSubcategoria(Subcategoria s){
        int exi;
         String sql = "UPDATE subcategoria SET nombre = '"+s.getNombre()+"', codigo = '"+s.getCodigo()+"', fk_categoria = '"+s.getFk_categoria()+" where codigo = '"+s.getCodigo()+"'";
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

    public int EliminarSubcategoria(String cod){
        int exi;
         String sql = " DELETE FROM subcategoria WHERE codigo = '"+cod+"'";
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
   
   public String ObtenerCodigoSubcategoriaxNombre(String nom){
        
        Subcategoria ca = null;
        for(Subcategoria c : this.ListadoSubcategorias()){
            if(nom.equals(c.getNombre())){
                ca = c;
            }
        }
        return ca.getCodigo();
    }
   
   
}
