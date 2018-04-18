/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionglobalfoodtrading.Controlador;

import aplicacionglobalfoodtrading.Modelo.Categoria;
import aplicacionglobalfoodtrading.Modelo.Producto;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class ControladorProducto {
    
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

    public ControladorProducto() {
        
    }
    
    
    public void Conectar() {
        
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_gft", "root", "");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar BD");
        }
    }
    
    public int RegistrarProducto(Producto p) {
        int exi = 0;
        String sql = "INSERT INTO `producto`(`cod_prod`, `nombre_prod`, `fk_proveedor`, `prec_cost_prod`, `prec_cost_prod_dolar`, `prec_vent_prod`, `utilidad_prod`, `fk_categoria`, `fk_subcategoria`, `fk_bodega`, `se_vende_x`, `vende_contiene`, `se_Compra_x`, `compra_contiene`, `tipo_prod`, `esta_activo`, `fk_impuesto1`, `impuesto1_aplic_venta`, `impuesto1_aplic_compra`, `fk_impuesto2`, `impuesto2_aplic_venta`, `impuesto2_aplic_compra`, `precio_neto_prod`, `precio_mas_impuesto`) VALUES ('"+p.getCod_prod()+"','"+p.getNombre_prod()+"','"+p.getFk_proveedor()+"',"+p.getPrec_cost_prod()+","+p.getPrec_cost_prod_dolar()+","+p.getPrec_vent_prod()+","+p.getUtilidad_prod()+",'"+p.getFk_categoria()+"','"+p.getFk_subcategoria()+"','"+p.getFk_bodega()+"','"+p.getSe_vende_x()+"',"+p.getVende_contiene()+",'"+p.getSe_Compra_x()+"',"+p.getCompra_contiene()+",'"+p.getTipo_prod()+"',"+p.getEsta_activo()+",'"+p.getFk_impuesto1()+"',"+p.getImpuesto1_aplic_venta()+","+p.getImpuesto1_aplic_compra()+",'"+p.getFk_impuesto2()+"',"+p.getImpuesto2_aplic_venta()+","+p.getImpuesto2_aplic_compra()+","+p.getPrecio_neto_prod()+","+p.getPrecio_mas_impuesto()+")";
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
    
     public ArrayList<Producto> ListadoProductos() {
        ArrayList<Producto> Listap = new ArrayList();
        try {
            Conectar();
            String sql = "Select * from Producto order by nombre_prod";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Producto p = new Producto();
                p.setCod_prod(rs.getString(1));
                p.setNombre_prod(rs.getString(2));
                p.setFk_proveedor(rs.getString(3));
                p.setPrec_cost_prod(rs.getFloat(4));
                p.setPrec_cost_prod_dolar(rs.getFloat(5));
                p.setPrec_vent_prod(rs.getFloat(6));
                p.setUtilidad_prod(rs.getFloat(7));
                p.setFk_categoria(rs.getString(8));
                p.setFk_subcategoria(rs.getString(9));
                p.setFk_bodega(rs.getString(10));
                p.setSe_vende_x(rs.getString(11));
                p.setVende_contiene(rs.getInt(12));
                p.setSe_Compra_x(rs.getString(13));
                p.setCompra_contiene(rs.getInt(14));
                p.setTipo_prod(rs.getString(15));
                p.setEsta_activo(rs.getInt(16));
                p.setFk_impuesto1(rs.getString(17));
                p.setImpuesto1_aplic_venta(rs.getInt(18));
                p.setImpuesto1_aplic_compra(rs.getInt(19));
                p.setFk_impuesto2(rs.getString(20));
                p.setImpuesto2_aplic_venta(rs.getInt(21));
                p.setImpuesto2_aplic_compra(rs.getInt(22));
                p.setPrecio_neto_prod(rs.getFloat(23));
                p.setPrecio_mas_impuesto(rs.getFloat(24));
                Listap.add(p);
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador Producto", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
        }
        return Listap;
    }
    
    public Producto RetornarProductoxCod(String cod){
        Producto prod  = null;
        for(Producto p : this.ListadoProductos()){
            if(cod.equals(p.getCod_prod())){
                prod = p;
            }
        }
        return prod;
    }
    
    
    public int ModificarProducto(Producto p) {
        int exi = 0;
        
        String sql = "UPDATE `producto` SET `nombre_prod`='"+p.getNombre_prod()+"',`fk_proveedor`='"+p.getFk_proveedor()+"',`prec_cost_prod`="+p.getPrec_cost_prod()+",`prec_cost_prod_dolar`="+p.getPrec_cost_prod_dolar()+",`prec_vent_prod`="+p.getPrec_vent_prod()+",`utilidad_prod`="+p.getUtilidad_prod()+",`fk_categoria`='"+p.getFk_categoria()+"',`fk_subcategoria`='"+p.getFk_subcategoria()+"',`fk_bodega`='"+p.getFk_bodega()+"',`se_vende_x`='"+p.getSe_vende_x()+"',`vende_contiene`="+p.getVende_contiene()+",`se_Compra_x`='"+p.getSe_Compra_x()+"',`compra_contiene`="+p.getCompra_contiene()+",`tipo_prod`='"+p.getTipo_prod()+"',`esta_activo`="+p.getEsta_activo()+",`fk_impuesto1`='"+p.getFk_impuesto1()+"',`impuesto1_aplic_venta`="+p.getImpuesto1_aplic_venta()+",`impuesto1_aplic_compra`="+p.getImpuesto1_aplic_compra()+",`fk_impuesto2`='"+p.getFk_impuesto2()+"',`impuesto2_aplic_venta`="+p.getImpuesto1_aplic_venta()+",`impuesto2_aplic_compra`="+p.getImpuesto2_aplic_compra()+",`precio_neto_prod`="+p.getPrec_cost_prod()+",`precio_mas_impuesto`="+p.getPrecio_mas_impuesto()+" WHERE cod_prod = '"+p.getCod_prod()+"'";
        try {
            Conectar();
            //System.out.println(sql);
            System.out.println(sql);
            st = con.createStatement();
            //st.execute(sql);
             if(st.executeUpdate(sql)>0){
               exi = 1;    
            }else{
                exi = 0;
            }
            
           // exi = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
            exi = 0;
        }
        
        return exi;
        
    }
    
    
    
    
    
    public int EliminarProducto(String cod){
        int exi=0;
         String sql = " DELETE FROM PRODUCTO WHERE cod_prod = '"+cod+"'";
        try {
            Conectar();
            //System.out.println(sql);
            st = con.createStatement();
            //st.execute(sql);
            if(st.executeUpdate(sql)>0){
            exi = 1;    
            }else{
                exi = 0;
            }
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador_ Producto", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
            exi = 0;
        }
        return exi;     
    }
    
    
    
    
}
