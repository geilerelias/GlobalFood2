/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionglobalfoodtrading.Controlador;

import aplicacionglobalfoodtrading.Modelo.Bodega;
import aplicacionglobalfoodtrading.Modelo.Proveedor;
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
public class ControladorProveedor {

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

    public ControladorProveedor() {
    }

    public void Conectar() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_gft", "root", "");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar BD");
        }
    }

    public int RegistrarProveedor(Proveedor p) {
        int exi = 0;
        String sql = "INSERT INTO `proveedor`(`codigo`, `nombre`, `pais`, `ciudad`, `provincia`, `cod_postal`, `direccion`, `telefono`, `movil`, `fax`, `email_1`, `email_2`, `fk_giro_neg`, `fk_tipo`, `NIT`, `reg_Empr`, `is_activo`, `imp_incl`, `vendedor`, `fk_categoria`, `imagen`) VALUES ('" + p.getCodigo() + "','" + p.getNombre() + "','" + p.getPais() + "','" + p.getCiudad() + "','" + p.getProvincia() + "','" + p.getCod_postal() + "','" + p.getDireccion() + "','" + p.getTelefono() + "','" + p.getMovil() + "','" + p.getFax() + "','" + p.getEmail1() + "','" + p.getEmail2() + "','" + p.getFk_girnoneg() + "','" + p.getFk_tipo() + "','" + p.getNit() + "','" + p.getReg_empr() + "','" + p.getIs_activo() + "," + p.getImpuesto_incl() + ",'" + p.getVendedor() + "','" + p.getFk_categoria() + "','"+p.getImagen()+"')";
      String sql2 = "INSERT INTO `proveedor`(`codigo`, `nombre`, `pais`, `ciudad`, `provincia`, `cod_postal`, `direccion`, `telefono`, `movil`, `fax`, `email_1`, `email_2`, `fk_giro_neg`, `fk_tipo`, `NIT`, `reg_Empr`, `is_activo`, `imp_incl`, `vendedor`, `fk_categoria`, `imagen`) VALUES ('" + p.getCodigo() + "','" + p.getNombre() + "','" + p.getPais() + "','" + p.getCiudad() + "','" + p.getProvincia() + "','" + p.getCod_postal() + "','" + p.getDireccion() + "','" + p.getTelefono() + "','" + p.getMovil() + "','" + p.getFax() + "','" + p.getEmail1() + "','" + p.getEmail2() + "','" + p.getFk_girnoneg() + "','" + p.getFk_tipo() + "','" + p.getNit() + "','" + p.getReg_empr() + "'," + p.getIs_activo() + "," + p.getImpuesto_incl() + ",'" + p.getVendedor() + "','" + p.getFk_categoria() + "','null')";
      String sql3 = "INSERT INTO `proveedor` VALUES ('" + p.getCodigo() + "','" + p.getNombre() + "','" + p.getPais() + "','" + p.getCiudad() + "','" + p.getProvincia() + "','" + p.getCod_postal() + "','" + p.getDireccion() + "','" + p.getTelefono() + "','" + p.getMovil() + "','" + p.getFax() + "','" + p.getEmail1() + "','" + p.getEmail2() + "','" + p.getFk_girnoneg() + "','" + p.getFk_tipo() + "','" + p.getNit() + "','" + p.getReg_empr() + "'," + p.getIs_activo() + "," + p.getImpuesto_incl() + ",'" + p.getVendedor() + "','" + p.getFk_categoria() + "','"+p.getImagen()+"')";

        try {
            Conectar();
            //System.out.println(sql);
            System.out.println(sql2);
            st = con.createStatement();
            st.execute(sql3);
            exi = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador _ de Proveedor", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
            exi = 0;
        }

        return exi;

    }

    public ArrayList<Proveedor> ListadoProveedores() {
        ArrayList<Proveedor> ListaP = new ArrayList();
        try {
            Conectar();
            String sql = "Select * from Proveedor order by nombre";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Proveedor p = new Proveedor();
                p.setCodigo(rs.getString(1));
                p.setNombre(rs.getString(2));
                p.setPais(rs.getString(3));
                p.setCiudad(rs.getString(4));
                p.setProvincia(rs.getString(5));
                p.setCod_postal(rs.getString(6));
                p.setDireccion(rs.getString(7));
                p.setTelefono(rs.getString(8));
                p.setMovil(rs.getString(9));
                p.setFax(rs.getString(10));
                p.setEmail1(rs.getString(11));
                p.setEmail2(rs.getString(12));
                p.setFk_girnoneg(rs.getString(13));
                p.setFk_tipo(rs.getString(14));
                p.setNit(rs.getString(15));
                p.setReg_empr(rs.getString(16));
                p.setIs_activo(rs.getInt(17));
                p.setImpuesto_incl(rs.getInt(18));
                p.setVendedor(rs.getString(19));
                p.setFk_categoria(rs.getString(20));
                p.setImagen(rs.getString(21));
                ListaP.add(p);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador _ de Proveedor", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
        }
        return ListaP;
    }

    public Proveedor ProvedorxCodigo(String cod) {
        Proveedor prov = null;
        for (Proveedor p : this.ListadoProveedores()) {
            if (p.getCodigo().equalsIgnoreCase(cod)) {
                prov = p;
            }
        }
        return prov;
    }
    
    
    public int EliminarProveedor(String cod){
        int exi;
         String sql = " DELETE FROM proveedor WHERE codigo = '"+cod+"'";
        try {
            Conectar();
            //System.out.println(sql);
            st = con.createStatement();
           // st.execute(sql);
           // exi = 1;
            if(st.executeUpdate(sql)>0){
            exi = 1;    
            }else{
                exi = 0;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador _ Proveedor", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
            exi = 0;
        }
        return exi;     
    }
    
    public int ModificarProveedor(Proveedor p) {
        int exi = 0;
        String sql = "UPDATE `proveedor` SET `nombre`='"+p.getNombre()+"',"+"`pais`='"+p.getPais()+"',"+"`ciudad`='"+p.getCiudad()+"',"+"`provincia`='"+p.getProvincia()+"',"+"`cod_postal`='"+p.getCod_postal()+"',"+"`direccion`='"+p.getDireccion()+"',"+"`telefono`='"+p.getTelefono()+"',"+"`movil`='"+p.getDireccion()+"',"+"`fax`='"+p.getFax()+"',"+"`email_1`='"+p.getEmail1()+"',"+"`email_2`='"+p.getEmail2()+"',"+"`fk_giro_neg`='"+p.getFk_girnoneg()+"',"+"`fk_tipo`='"+p.getFk_tipo()+"',"+"`NIT`='"+p.getNit()+"',"+"`reg_Empr`='"+p.getReg_empr()+"',"+"`is_activo`="+p.getIs_activo()+","+"`imp_incl`="+p.getImpuesto_incl()+","+"`vendedor`='"+p.getVendedor()+"',"+"`fk_categoria`='"+p.getFk_categoria()+"',"+"`imagen`='"+p.getImagen()+"' WHERE codigo = '"+p.getCodigo()+"'";
      String sql2 = "UPDATE `proveedor` SET `nombre`='"+p.getNombre()+"',"+"`pais`='"+p.getPais()+"',"+"`ciudad`='"+p.getCiudad()+"',"+"`provincia`='"+p.getProvincia()+"',"+"`cod_postal`='"+p.getCod_postal()+"',"+"`direccion`='"+p.getDireccion()+"',"+"`telefono`='"+p.getTelefono()+"',"+"`movil`='"+p.getDireccion()+"',"+"`fax`='"+p.getFax()+"',"+"`email_1`='"+p.getEmail1()+"',"+"`email_2`='"+p.getEmail2()+"',"+"`fk_giro_neg`='"+p.getFk_girnoneg()+"',"+"`fk_tipo`='"+p.getFk_tipo()+"',"+"`NIT`='"+p.getNit()+"',"+"`reg_Empr`='"+p.getReg_empr()+"',"+"`is_activo`="+p.getIs_activo()+","+"`imp_incl`="+p.getImpuesto_incl()+","+"`vendedor`='"+p.getVendedor()+"',"+"`fk_categoria`='"+p.getFk_categoria()+"',"+"`imagen`='"+"null"+"' WHERE codigo = '"+p.getCodigo()+"'";
     // String sql3 = "INSERT INTO `proveedor` VALUES ('" + p.getCodigo() + "','" + p.getNombre() + "','" + p.getPais() + "','" + p.getCiudad() + "','" + p.getProvincia() + "','" + p.getCod_postal() + "','" + p.getDireccion() + "','" + p.getTelefono() + "','" + p.getMovil() + "','" + p.getFax() + "','" + p.getEmail1() + "','" + p.getEmail2() + "','" + p.getFk_girnoneg() + "','" + p.getFk_tipo() + "','" + p.getNit() + "','" + p.getReg_empr() + "'," + p.getIs_activo() + "," + p.getImpuesto_incl() + ",'" + p.getVendedor() + "','" + p.getFk_categoria() + "','"+p.getImagen()+"')";
        System.out.println(sql2);
        try {
            Conectar();
            //System.out.println(sql);
            System.out.println(sql2);
            st = con.createStatement();
            //st.execute(sql);
           // exi = 1;
            if(st.executeUpdate(sql)>0){
            exi = 1;    
            }else{
                exi = 0;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador _ de Proveedor", "Error", JOptionPane.ERROR_MESSAGE);
            System.out.println(sql2);
            exi = 0;
        }

        return exi;

    }
    
    public String CodigoProveedorXNombre(String nombre){
        String prov = "";
        for (Proveedor p : this.ListadoProveedores()) {
            if (p.getNombre().equalsIgnoreCase(nombre)) {
                prov = p.getCodigo();
            }
        }
        return prov;
    }
    
    
    

}
