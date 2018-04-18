/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionglobalfoodtrading.Controlador;

import aplicacionglobalfoodtrading.Modelo.Categoria_Proveedor;
import aplicacionglobalfoodtrading.Modelo.Giro_Negocio;
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
public class ControladorCategoria_Proveedor {
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

    public ControladorCategoria_Proveedor() {
    }

   
    
    public void Conectar() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_gft", "root", "");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar BD");
        }
    }
    
    public int RegistrarCategoriaProveedor(Categoria_Proveedor cp) {
        int exi = 0;
        String sql = "INSERT INTO `Categoria_Proveedor`(`descripcion`) VALUES ('"+cp.getDescripcion()+"')";
        try {
            Conectar();
            //System.out.println(sql);
            System.out.println(sql);
            st = con.createStatement();
            st.execute(sql);
            exi = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador _ de Categoria de Proveedor", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
            exi = 0;
        }

        return exi;

    }
    
    public ArrayList<Categoria_Proveedor> ListadoCategoriaProveedor() {
        ArrayList<Categoria_Proveedor> Listacp = new ArrayList();
        try {
            Conectar();
            String sql = "Select * from categoria_proveedor order by indice";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Categoria_Proveedor cp = new Categoria_Proveedor();
                cp.setIndice(rs.getInt(1));
                cp.setDescripcion(rs.getString(2));
                Listacp.add(cp);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador _ de Categoria de Proveedor", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
        }
        return Listacp;
    }
    
    
    public Categoria_Proveedor CategoriaProveedorxCodigo(String cod) {
        Categoria_Proveedor cp = null;
        for (Categoria_Proveedor c : this.ListadoCategoriaProveedor()) {
            if (cp.getDescripcion().equalsIgnoreCase(cod)) {
                cp = c;
            }
        }
        return cp;
    }
    
    
//    public int Modificar(Giro_Negocio g){
//        int exi;
//         String sql = "UPDATE g_negocio SET descripcion = '"+g.getDescripcion()+"' where indice = "+g.getIndice()+"";
//        try {
//            Conectar();
//            //System.out.println(sql);
//            st = con.createStatement();
//            st.execute(sql);
//            exi = 1;
//        } catch (SQLException ex) {
//            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador _ Giro", "Error", JOptionPane.ERROR_MESSAGE);
//            // System.out.println(sql);
//            exi = 0;
//        }
//        return exi;
//    }
    
    
    
    
    
    public int EliminarCateGoriaProveedor(Categoria_Proveedor c){
        int exi;
         String sql = " DELETE FROM categoria_proveedor WHERE indice = "+c.getIndice()+"";
        try {
            Conectar();
            //System.out.println(sql);
            st = con.createStatement();
            st.execute(sql);
            exi = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador _ Categoria Proveedor", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
            exi = 0;
        }
        return exi;     
    }
    
}
