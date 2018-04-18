/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionglobalfoodtrading.Controlador;

import aplicacionglobalfoodtrading.Modelo.Empleado_Indirecto;
import aplicacionglobalfoodtrading.Modelo.Producto;
import aplicacionglobalfoodtrading.Vista.Empleado_IndirectoVista;
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
public class Controlador_Empleado_Indirecto {

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

    public Controlador_Empleado_Indirecto() {
    }

    public void Conectar() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_gft", "root", "");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar BD");
        }
    }

    public int RegistrarEmpleadoIndirecto(Empleado_Indirecto ei) {
        int exi = 0;
        String sql2 = "INSERT INTO `Empleado_Indirecto`(`tipo_id`, `identificacion`, `nombres`, `apellidos`, `fecha_nac`, `telefono`, `correo`, `cargo`, `direccion`, `pais`, `ciudad`, `fecha_contratacion`, `salario`, `genero`, `imagen`) VALUES ('" + ei.getTipo_id() + "','" + ei.getIdentificacion() + "','" + ei.getNombres() + "','" + ei.getApellidos() + "','" + ei.getFecha_nac() + "','" + ei.getTelefono() + "','" + ei.getCorreo() + "','" + ei.getCargo() + "','" + ei.getDireccion() + "','" + ei.getPais() + "','" + ei.getCiudad() + "','" + ei.getFecha_contratacion() + "','" + ei.getSalario() + "','" + ei.getGenero() + "','" + "null" + "')";

        String sql = "INSERT INTO `Empleado_Indirecto`(`tipo_id`, `identificacion`, `nombres`, `apellidos`, `fecha_nac`, `telefono`, `correo`, `cargo`, `direccion`, `pais`, `ciudad`, `fecha_contratacion`, `salario`, `genero`, `imagen`) VALUES ('" + ei.getTipo_id() + "','" + ei.getIdentificacion() + "','" + ei.getNombres() + "','" + ei.getApellidos() + "','" + ei.getFecha_nac() + "','" + ei.getTelefono() + "','" + ei.getCorreo() + "','" + ei.getCargo() + "','" + ei.getDireccion() + "','" + ei.getPais() + "','" + ei.getCiudad() + "','" + ei.getFecha_contratacion() + "','" + ei.getSalario() + "','" + ei.getGenero() + "','" + ei.getImagen() + "')";
        try {
            Conectar();
            //System.out.println(sql);
            System.out.println(sql2);
            st = con.createStatement();
            if (st.executeUpdate(sql) > 0) {
                exi = 1;
            } else {
                exi = 0;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador Empleado _ Indirecto", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
            exi = 0;
        }

        return exi;

    }

    public ArrayList<Empleado_Indirecto> ListadoEmpleadosIndirectos() {

        ArrayList<Empleado_Indirecto> listaei = new ArrayList();

        try {
            Conectar();
            String sql = "SELECT * FROM `Empleado_Indirecto` order by apellidos";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                Empleado_Indirecto ei = new Empleado_Indirecto();
                ei.setTipo_id(rs.getString(1));
                ei.setIdentificacion(rs.getString(2));
                ei.setNombres(rs.getString(3));
                ei.setApellidos(rs.getString(4));
                ei.setFecha_nac(rs.getString(5));
                ei.setTelefono(rs.getString(6));
                ei.setCorreo(rs.getString(7));
                ei.setCargo(rs.getString(8));
                ei.setDireccion(rs.getString(9));
                ei.setPais(rs.getString(10));
                ei.setCiudad(rs.getString(11));
                ei.setFecha_contratacion(rs.getString(12));
                ei.setSalario(rs.getString(13));
                ei.setGenero(rs.getString(14));
                ei.setImagen(rs.getString(15));
                listaei.add(ei);
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador Producto", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
        }
        return listaei;

    }

    public Empleado_Indirecto RetornarEmpleadoIndirectoXCodigo(String cod) {

        Empleado_Indirecto ei = null;

        for (Empleado_Indirecto e : this.ListadoEmpleadosIndirectos()) {
            if (e.getIdentificacion().equals(cod)) {
                ei = e;
            }
        }

        return ei;
    }

    public int EliminarEmpleadoIndirecto(String cod) {
        int exi = 0;
        String sql = "DELETE FROM `Empleado_Indirecto` WHERE `identificacion` = '" + cod + "'";
        try {
            Conectar();
            //System.out.println(sql);
            //System.out.println(sql);
            st = con.createStatement();
            if (st.executeUpdate(sql) > 0) {
                exi = 1;
            } else {
                exi = 0;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador Empleado _ Indirecto", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
            exi = 0;
        }

        return exi;

    }

    public int ModificarEmpleadoIndirecto(Empleado_Indirecto e) {
        int exi = 0;
        String sql = "UPDATE `Empleado_Indirecto` SET `tipo_id`='" + e.getTipo_id() + "',`nombres`='" + e.getNombres() + "',`apellidos`='" + e.getApellidos() + "',`fecha_nac`='" + e.getFecha_nac() + "',`telefono`='" + e.getTelefono() + "',`correo`='" + e.getCorreo() + "',`cargo`='" + e.getCargo() + "',`direccion`='" + e.getDireccion() + "',`pais`='" + e.getPais() + "',`ciudad`='" + e.getCiudad() + "',`fecha_contratacion`='" + e.getFecha_contratacion() + "',`salario`='" + e.getSalario() + "',`genero`='" + e.getGenero() + "',`imagen`='" + e.getImagen() + "' WHERE  `identificacion` = '" + e.getIdentificacion() + "'";
        try {
            Conectar();
            //System.out.println(sql);
            //System.out.println(sql);
            st = con.createStatement();
            if (st.executeUpdate(sql) > 0) {
                exi = 1;
            } else {
                exi = 0;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador Empleado _ Indirecto", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
            exi = 0;
        }

        return exi;

    }

}
