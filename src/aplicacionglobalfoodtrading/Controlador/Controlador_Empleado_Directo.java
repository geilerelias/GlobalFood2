/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionglobalfoodtrading.Controlador;

import aplicacionglobalfoodtrading.Modelo.Empleado_Directo;
import java.awt.Image;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Controlador_Empleado_Directo {

    private static Connection con;
    private static ResultSet rs;
    private static Statement st;

    public Controlador_Empleado_Directo() {
    }

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

    public void Conectar() {

        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_gft", "root", "");
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al conectar BD");
        }
    }

    public int RegistrarEmpleadoDirecto(Empleado_Directo ed) {
        //String sql = "INSERT INTO emp_direc('tipoid', 'identificacion', 'nombre', 'apellido', 'genero', 'fechanac', 'pais', 'ciudad', 'provincia', 'direccion', 'telmovil', 'telfijo', 'email', 'estcivil', 'cargo', 'banco', 'salario', 'htm', 'valorhora', 'fechaingre', 'auxtransp', 'cesantias', 'primas', 'pension', 'cajacomp', 'codeps', 'nombeps', 'codpension', 'nombpension', 'ref1nomb', 'ref1email', 'ref1movil', 'ref1cargo', 'ref2nomb', 'ref2email', 'ref2movil', 'ref2cargo', 'imagen') VALUES ('" + ed.getTipoid() + "','" + ed.getIdentificacion() + "','" + ed.getNombre() + "','" + ed.getApellido() + "','" + ed.getGenero() + "','" + ed.getFecha_nac() + "','" + ed.getPais() + "','" + ed.getCiudad() + "','" + ed.getProvincia() + "','" + ed.getDireccion() + "','" + ed.getTel_movil() + "','" + ed.getTel_fijo() + "','" + ed.getEmail() + "','" + ed.getEst_civil() + "','" + ed.getCargo() + "','" + ed.getNum_bancario() + "'," + ed.getSalario() + "," + ed.getThm() + "," + ed.getValorhora() + ",'" + ed.getFecha_contrat() + "','" + ed.getAux_transport() + "','" + ed.getCesantias() + "','" + ed.getPrima() + "','" + ed.getPension() + "','" + ed.getCaja_compens() + "','" + ed.getCod_Eps() + "','" + ed.getNombre_eps() + "','" + ed.getCod_pension() + "','" + ed.getNombre_pension() + "','" + ed.getNomb_refe1() + "','" + ed.getEmail_refe1() + "','" + ed.getDireccion_refe1() + "','" + ed.getCargo_refe1() + "','" + ed.getNomb_refe2() + "','" + ed.getEmail_refe2() + "','" + ed.getDireccion_refe2() + "','" + ed.getCargo_refe2() + "','null')";
        int exito = 0;
        String sql = "INSERT INTO emp_direc VALUES ('" + ed.getTipoid() + "','" + ed.getIdentificacion() + "','" + ed.getNombre() + "','" + ed.getApellido() + "','" + ed.getGenero() + "','" + ed.getFecha_nac() + "','" + ed.getPais() + "','" + ed.getCiudad() + "','" + ed.getProvincia() + "','" + ed.getDireccion() + "','" + ed.getTel_movil() + "','" + ed.getTel_fijo() + "','" + ed.getEmail() + "','" + ed.getEst_civil() + "','" + ed.getCargo() + "','" + ed.getNum_bancario() + "'," + ed.getSalario() + "," + ed.getThm() + "," + ed.getValorhora() + ",'" + ed.getFecha_contrat() + "','" + ed.getAux_transport() + "','" + ed.getCesantias() + "','" + ed.getPrima() + "','" + ed.getPension() + "','" + ed.getCaja_compens() + "','" + ed.getCod_Eps() + "','" + ed.getNombre_eps() + "','" + ed.getCod_pension() + "','" + ed.getNombre_pension() + "','" + ed.getNomb_refe1() + "','" + ed.getEmail_refe1() + "','" + ed.getDireccion_refe1() + "','" + ed.getCargo_refe1() + "','" + ed.getNomb_refe2() + "','" + ed.getEmail_refe2() + "','" + ed.getDireccion_refe2() + "','" + ed.getCargo_refe2() + "','" + ed.getFoto_perfil() + "')";

        try {

            Conectar();

            //System.out.println(sql);
            st = con.createStatement();
            st.execute(sql);
            exito = 1;
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage() + " en el Controlador", "Error", JOptionPane.ERROR_MESSAGE);
            // System.out.println(sql);
            exito = 0;
        }

        return exito;
    }

    public ArrayList<Empleado_Directo> ListaEmpleadosDirectos() {

        ArrayList<Empleado_Directo> led = new ArrayList();
        try {
            Conectar();
            String sql = "Select * from emp_direc order by apellido";
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Empleado_Directo ed = new Empleado_Directo();
                ed.setTipoid(rs.getString("tipoid"));
                ed.setIdentificacion(rs.getString("identificacion"));
                ed.setNombre(rs.getString("nombre"));
                ed.setApellido(rs.getString("apellido"));
                ed.setGenero(rs.getString("genero"));
                ed.setFecha_nac(rs.getString("fechanac"));
                ed.setPais(rs.getString("pais"));
                ed.setCiudad(rs.getString("ciudad"));
                ed.setProvincia(rs.getString("provincia"));
                ed.setDireccion(rs.getString("direccion"));
                ed.setTel_movil(rs.getString("telmovil"));
                ed.setTel_fijo(rs.getString("telfijo"));
                ed.setEmail(rs.getString("email"));
                ed.setEst_civil(rs.getString("estcivil"));
                ed.setCargo(rs.getString("cargo"));
                ed.setNum_bancario(rs.getString("banco"));
                ed.setSalario(rs.getDouble("salario"));
                ed.setThm(rs.getInt("htm"));
                ed.setValorhora(rs.getDouble("valorhora"));
                ed.setFecha_contrat(rs.getString("fechaingre"));
                ed.setAux_transport(rs.getString("auxtransp"));
                ed.setCesantias(rs.getString("cesantias"));
                ed.setPrima(rs.getString("primas"));
                ed.setPension(rs.getString("pension"));
                ed.setCaja_compens(rs.getString("cajacomp"));
                ed.setCod_Eps(rs.getString("codeps"));
                ed.setNombre_eps(rs.getString("nombeps"));
                ed.setCod_pension(rs.getString("codpension"));
                ed.setNombre_pension(rs.getString("nombpension"));
                ed.setNomb_refe1(rs.getString("ref1nomb"));
                ed.setEmail_refe1(rs.getString("ref1email"));
                ed.setDireccion_refe1(rs.getString("ref1movil"));
                ed.setCargo_refe1(rs.getString("ref1cargo"));
                ed.setNomb_refe2(rs.getString("ref2nomb"));
                ed.setEmail_refe2(rs.getString("ref2email"));
                ed.setDireccion_refe2(rs.getString("ref2movil"));
                ed.setCargo_refe2(rs.getString("ref2cargo"));
                ed.setFoto_perfil("imagen");
                led.add(ed);
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el controlador " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return led;
    }

    public Blob retornarBlob(String cod) {
        Blob b = null;
        try {
            Conectar();
            String sql = "Select imagen from emp_direc where identificacion = '" + cod + "'";
            st = con.createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                b = rs.getBlob(1);
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el controlador " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return b;
    }

    public ArrayList<Empleado_Directo> ListaEmpleadosDirectosOrderByIdentificacion(String pal) {

        ArrayList<Empleado_Directo> led = new ArrayList();
        try {
            Conectar();
            String sql = "Select * from emp_direc where identificacion like '%" + pal + "%' order by identificacion";
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Empleado_Directo ed = new Empleado_Directo();
                ed.setTipoid(rs.getString("tipoid"));
                ed.setIdentificacion(rs.getString("identificacion"));
                ed.setNombre(rs.getString("nombre"));
                ed.setApellido(rs.getString("apellido"));
                ed.setGenero(rs.getString("genero"));
                ed.setFecha_nac(rs.getString("fechanac"));
                ed.setPais(rs.getString("pais"));
                ed.setCiudad(rs.getString("ciudad"));
                ed.setProvincia(rs.getString("provincia"));
                ed.setDireccion(rs.getString("direccion"));
                ed.setTel_movil(rs.getString("telmovil"));
                ed.setTel_fijo(rs.getString("telfijo"));
                ed.setEmail(rs.getString("email"));
                ed.setEst_civil(rs.getString("estcivil"));
                ed.setCargo(rs.getString("cargo"));
                ed.setNum_bancario(rs.getString("banco"));
                ed.setSalario(rs.getDouble("salario"));
                ed.setThm(rs.getInt("htm"));
                ed.setValorhora(rs.getDouble("valorhora"));
                ed.setFecha_contrat(rs.getString("fechaingre"));
                ed.setAux_transport(rs.getString("auxtransp"));
                ed.setCesantias(rs.getString("cesantias"));
                ed.setPrima(rs.getString("primas"));
                ed.setPension(rs.getString("pension"));
                ed.setCaja_compens(rs.getString("cajacomp"));
                ed.setCod_Eps(rs.getString("codeps"));
                ed.setNombre_eps(rs.getString("nombeps"));
                ed.setCod_pension(rs.getString("codpension"));
                ed.setNombre_pension(rs.getString("nombpension"));
                ed.setNomb_refe1(rs.getString("ref1nomb"));
                ed.setEmail_refe1(rs.getString("ref1email"));
                ed.setDireccion_refe1(rs.getString("ref1movil"));
                ed.setCargo_refe1(rs.getString("ref1cargo"));
                ed.setNomb_refe2(rs.getString("ref2nomb"));
                ed.setEmail_refe2(rs.getString("ref2email"));
                ed.setDireccion_refe2(rs.getString("ref2movil"));
                ed.setCargo_refe2(rs.getString("ref2cargo"));
                ed.setFoto_perfil(rs.getString("imagen"));
                led.add(ed);
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el controlador " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return led;
    }

    public ArrayList<Empleado_Directo> ListaEmpleadosDirectosOrderByPais(String pal) {

        ArrayList<Empleado_Directo> led = new ArrayList();
        try {
            Conectar();
            String sql = "Select * from emp_direc where pais like '%" + pal + "%'  order by pais";
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Empleado_Directo ed = new Empleado_Directo();
                ed.setTipoid(rs.getString("tipoid"));
                ed.setIdentificacion(rs.getString("identificacion"));
                ed.setNombre(rs.getString("nombre"));
                ed.setApellido(rs.getString("apellido"));
                ed.setGenero(rs.getString("genero"));
                ed.setFecha_nac(rs.getString("fechanac"));
                ed.setPais(rs.getString("pais"));
                ed.setCiudad(rs.getString("ciudad"));
                ed.setProvincia(rs.getString("provincia"));
                ed.setDireccion(rs.getString("direccion"));
                ed.setTel_movil(rs.getString("telmovil"));
                ed.setTel_fijo(rs.getString("telfijo"));
                ed.setEmail(rs.getString("email"));
                ed.setEst_civil(rs.getString("estcivil"));
                ed.setCargo(rs.getString("cargo"));
                ed.setNum_bancario(rs.getString("banco"));
                ed.setSalario(rs.getDouble("salario"));
                ed.setThm(rs.getInt("htm"));
                ed.setValorhora(rs.getDouble("valorhora"));
                ed.setFecha_contrat(rs.getString("fechaingre"));
                ed.setAux_transport(rs.getString("auxtransp"));
                ed.setCesantias(rs.getString("cesantias"));
                ed.setPrima(rs.getString("primas"));
                ed.setPension(rs.getString("pension"));
                ed.setCaja_compens(rs.getString("cajacomp"));
                ed.setCod_Eps(rs.getString("codeps"));
                ed.setNombre_eps(rs.getString("nombeps"));
                ed.setCod_pension(rs.getString("codpension"));
                ed.setNombre_pension(rs.getString("nombpension"));
                ed.setNomb_refe1(rs.getString("ref1nomb"));
                ed.setEmail_refe1(rs.getString("ref1email"));
                ed.setDireccion_refe1(rs.getString("ref1movil"));
                ed.setCargo_refe1(rs.getString("ref1cargo"));
                ed.setNomb_refe2(rs.getString("ref2nomb"));
                ed.setEmail_refe2(rs.getString("ref2email"));
                ed.setDireccion_refe2(rs.getString("ref2movil"));
                ed.setCargo_refe2(rs.getString("ref2cargo"));
                //ed.setFoto_perfil((Image)rs.getBlob(37));
                led.add(ed);
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el controlador " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return led;
    }

    public ArrayList<Empleado_Directo> ListaEmpleadosDirectosOrderByCargo(String pal) {

        ArrayList<Empleado_Directo> led = new ArrayList();
        try {
            Conectar();
            String sql = "Select * from emp_direc where cargo like '%" + pal + "%' order by cargo";
            st = con.createStatement();
            rs = st.executeQuery(sql);

            while (rs.next()) {
                Empleado_Directo ed = new Empleado_Directo();
                ed.setTipoid(rs.getString("tipoid"));
                ed.setIdentificacion(rs.getString("identificacion"));
                ed.setNombre(rs.getString("nombre"));
                ed.setApellido(rs.getString("apellido"));
                ed.setGenero(rs.getString("genero"));
                ed.setFecha_nac(rs.getString("fechanac"));
                ed.setPais(rs.getString("pais"));
                ed.setCiudad(rs.getString("ciudad"));
                ed.setProvincia(rs.getString("provincia"));
                ed.setDireccion(rs.getString("direccion"));
                ed.setTel_movil(rs.getString("telmovil"));
                ed.setTel_fijo(rs.getString("telfijo"));
                ed.setEmail(rs.getString("email"));
                ed.setEst_civil(rs.getString("estcivil"));
                ed.setCargo(rs.getString("cargo"));
                ed.setNum_bancario(rs.getString("banco"));
                ed.setSalario(rs.getDouble("salario"));
                ed.setThm(rs.getInt("htm"));
                ed.setValorhora(rs.getDouble("valorhora"));
                ed.setFecha_contrat(rs.getString("fechaingre"));
                ed.setAux_transport(rs.getString("auxtransp"));
                ed.setCesantias(rs.getString("cesantias"));
                ed.setPrima(rs.getString("primas"));
                ed.setPension(rs.getString("pension"));
                ed.setCaja_compens(rs.getString("cajacomp"));
                ed.setCod_Eps(rs.getString("codeps"));
                ed.setNombre_eps(rs.getString("nombeps"));
                ed.setCod_pension(rs.getString("codpension"));
                ed.setNombre_pension(rs.getString("nombpension"));
                ed.setNomb_refe1(rs.getString("ref1nomb"));
                ed.setEmail_refe1(rs.getString("ref1email"));
                ed.setDireccion_refe1(rs.getString("ref1movil"));
                ed.setCargo_refe1(rs.getString("ref1cargo"));
                ed.setNomb_refe2(rs.getString("ref2nomb"));
                ed.setEmail_refe2(rs.getString("ref2email"));
                ed.setDireccion_refe2(rs.getString("ref2movil"));
                ed.setCargo_refe2(rs.getString("ref2cargo"));
                ed.setFoto_perfil(rs.getString("imagen"));
                led.add(ed);
            }
            con.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error en el controlador " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

        return led;
    }

    public char ExisteEmpleado(String id) {
        char existe = 'n';
        for (Empleado_Directo ed : this.ListaEmpleadosDirectos()) {
            if (ed.getIdentificacion().equals(id)) {
                existe = 's';
            }
        }

        return existe;
    }

    public Empleado_Directo Empleadoxid(String id) {
        char existe = 'n';
        Empleado_Directo edi = new Empleado_Directo();
        for (Empleado_Directo ed : this.ListaEmpleadosDirectos()) {
            if (ed.getIdentificacion().equals(id)) {
                existe = 's';
                edi = ed;
            }
        }

        if (existe == 's') {
            return edi;
        } else {
            return null;
        }
    }

    public int EliminarEmpleadoDirec(String id) {
        int exito = 0;
        try {
            Conectar();
            st = con.createStatement();
            String sql = "delete from emp_direc where identificacion = '" + id + "'";
            //st.execute(sql);
            //exito = 1;
            if (st.executeUpdate(sql) > 0) {
                exito = 1;
            } else {
                exito = 0;
            }

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            exito = 0;
        }
        return exito;
    }

    public int ActualizarEmpleadoDirec(String id, Empleado_Directo ed) {
        String sql = "UPDATE `emp_direc` SET `tipoid`='" + ed.getTipoid() + "',`identificacion`='" + ed.getIdentificacion() + "',`nombre`='" + ed.getNombre() + "',`apellido`='" + ed.getApellido() + "',`genero`='" + ed.getGenero() + "',`fechanac`='" + ed.getFecha_nac() + "',`pais`='" + ed.getPais() + "',`ciudad`='" + ed.getCiudad() + "',`provincia`='" + ed.getProvincia() + "',`direccion`='" + ed.getDireccion() + "',`telmovil`='" + ed.getTel_movil() + "',`telfijo`='" + ed.getTel_fijo() + "',`email`='" + ed.getEmail() + "',`estcivil`='" + ed.getEst_civil() + "',`cargo`='" + ed.getCargo() + "',`banco`='" + ed.getNum_bancario() + "',`salario`='" + ed.getSalario() + "',`htm`=" + ed.getThm() + ",`valorhora`=" + ed.getValorhora() + ",`fechaingre`='" + ed.getFecha_contrat() + "',`auxtransp`='" + ed.getAux_transport() + "',`cesantias`='" + ed.getCesantias() + "',`primas`='" + ed.getPrima() + "',`pension`='" + ed.getPension() + "',`cajacomp`='" + ed.getPension() + "',`codeps`='" + ed.getCod_Eps() + "',`nombeps`='" + ed.getNombre_eps() + "',`codpension`='" + ed.getCod_pension() + "',`nombpension`='" + ed.getNombre_pension() + "',`ref1nomb`='" + ed.getNomb_refe1() + "',`ref1email`='" + ed.getEmail_refe1() + "',`ref1movil`='" + ed.getDireccion_refe1() + "',`ref1cargo`='" + ed.getCargo_refe1() + "',`ref2nomb`='" + ed.getNomb_refe2() + "',`ref2email`='" + ed.getEmail_refe2() + "',`ref2movil`='" + ed.getDireccion_refe2() + "',`ref2cargo`='" + ed.getCargo_refe2() + "', imagen = '" + ed.getFoto_perfil() + "' WHERE identificacion = '" + id + "'";
        String sql2 = "UPDATE `emp_direc` SET `tipoid`='" + ed.getTipoid() + "',`identificacion`='" + ed.getIdentificacion() + "',`nombre`='" + ed.getNombre() + "',`apellido`='" + ed.getApellido() + "',`genero`='" + ed.getGenero() + "',`fechanac`='" + ed.getFecha_nac() + "',`pais`='" + ed.getPais() + "',`ciudad`='" + ed.getCiudad() + "',`provincia`='" + ed.getProvincia() + "',`direccion`='" + ed.getDireccion() + "',`telmovil`='" + ed.getTel_movil() + "',`telfijo`='" + ed.getTel_fijo() + "',`email`='" + ed.getEmail() + "',`estcivil`='" + ed.getEst_civil() + "',`cargo`='" + ed.getCargo() + "',`banco`='" + ed.getNum_bancario() + "',`salario`='" + ed.getSalario() + "',`htm`=" + ed.getThm() + ",`valorhora`=" + ed.getValorhora() + ",`fechaingre`='" + ed.getFecha_contrat() + "',`auxtransp`='" + ed.getAux_transport() + "',`cesantias`='" + ed.getCesantias() + "',`primas`='" + ed.getPrima() + "',`pension`='" + ed.getPension() + "',`cajacomp`='" + ed.getPension() + "',`codeps`='" + ed.getCod_Eps() + "',`nombeps`='" + ed.getNombre_eps() + "',`codpension`='" + ed.getCod_pension() + "',`nombpension`='" + ed.getNombre_pension() + "',`ref1nomb`='" + ed.getNomb_refe1() + "',`ref1email`='" + ed.getEmail_refe1() + "',`ref1movil`='" + ed.getDireccion_refe1() + "',`ref1cargo`='" + ed.getCargo_refe1() + "',`ref2nomb`='" + ed.getNomb_refe2() + "',`ref2email`='" + ed.getEmail_refe2() + "',`ref2movil`='" + ed.getDireccion_refe2() + "',`ref2cargo`='" + ed.getCargo_refe2() + "', imagen = 'null' WHERE identificacion = '" + id + "'";

        //System.out.println(sql);
        Conectar();
        int exi = 0;
        try {
            st = con.createStatement();
            System.out.println(sql2);
            // st.execute(sql);
            //exi = 1;
            if (st.executeUpdate(sql) > 0) {
                exi = 1;
            } else {
                exi = 0;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage());
            exi = 0;
        }
        return exi;
    }

}
