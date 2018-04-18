/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionglobalfoodtrading.Modelo;

import java.awt.Image;


public class Empleado_Directo extends Empleado {
    
    private String cod_Eps;
    private String nombre_eps;
    private String cod_pension;
    private String nombre_pension;
    private String num_bancario;
    private String aux_transport;
    private String cesantias;
    private String caja_compens;
    private String SENA;
    private int thm;
    private double valorhora;
    private String prima;
    private String pension;
    private String nomb_refe1;
    private String email_refe1;
    private String tel_refe1;
    private String cargo_refe1;
    private String direccion_refe1;
    private String nomb_refe2;
    private String email_refe2;
    private String tel_refe2;
    private String cargo_refe2;
    private String direccion_refe2;

    public Empleado_Directo() {
    }

    public Empleado_Directo(String cod_Eps, String nombre_eps, String cod_pension, String nombre_pension, String num_bancario, String aux_transport, String cesantias, String caja_compens, String SENA, int thm, double valorhora, String prima, String pension, String nomb_refe1, String email_refe1, String tel_refe1, String cargo_refe1, String direccion_refe1, String nomb_refe2, String email_refe2, String tel_refe2, String cargo_refe2, String direccion_refe2, String tipoid, String identificacion, String nombre, String apellido, String genero, String fecha_nac, String direccion, String fecha_contrat, String tel_fijo, String tel_movil, String est_civil, String email, String ciudad, String pais, String cargo, String provincia, double salario, String foto_perfil) {
        super(tipoid, identificacion, nombre, apellido, genero, fecha_nac, direccion, fecha_contrat, tel_fijo, tel_movil, est_civil, email, ciudad, pais, cargo, provincia, salario, foto_perfil);
        this.cod_Eps = cod_Eps;
        this.nombre_eps = nombre_eps;
        this.cod_pension = cod_pension;
        this.nombre_pension = nombre_pension;
        this.num_bancario = num_bancario;
        this.aux_transport = aux_transport;
        this.cesantias = cesantias;
        this.caja_compens = caja_compens;
        this.SENA = SENA;
        this.thm = thm;
        this.valorhora = valorhora;
        this.prima = prima;
        this.pension = pension;
        this.nomb_refe1 = nomb_refe1;
        this.email_refe1 = email_refe1;
        this.tel_refe1 = tel_refe1;
        this.cargo_refe1 = cargo_refe1;
        this.direccion_refe1 = direccion_refe1;
        this.nomb_refe2 = nomb_refe2;
        this.email_refe2 = email_refe2;
        this.tel_refe2 = tel_refe2;
        this.cargo_refe2 = cargo_refe2;
        this.direccion_refe2 = direccion_refe2;
    }

    

    public String getCod_Eps() {
        return cod_Eps;
    }

    public void setCod_Eps(String cod_Eps) {
        this.cod_Eps = cod_Eps;
    }

    public String getNombre_eps() {
        return nombre_eps;
    }

    public void setNombre_eps(String nombre_eps) {
        this.nombre_eps = nombre_eps;
    }

    public String getCod_pension() {
        return cod_pension;
    }

    public void setCod_pension(String cod_pension) {
        this.cod_pension = cod_pension;
    }

    public String getNombre_pension() {
        return nombre_pension;
    }

    public void setNombre_pension(String nombre_pension) {
        this.nombre_pension = nombre_pension;
    }

    public String getNum_bancario() {
        return num_bancario;
    }

    public void setNum_bancario(String num_bancario) {
        this.num_bancario = num_bancario;
    }

    public String getAux_transport() {
        return aux_transport;
    }

    public void setAux_transport(String aux_transport) {
        this.aux_transport = aux_transport;
    }

    public String getCesantias() {
        return cesantias;
    }

    public void setCesantias(String cesantias) {
        this.cesantias = cesantias;
    }

    public String getCaja_compens() {
        return caja_compens;
    }

    public void setCaja_compens(String caja_compens) {
        this.caja_compens = caja_compens;
    }

    public String getSENA() {
        return SENA;
    }

    public void setSENA(String SENA) {
        this.SENA = SENA;
    }

    public int getThm() {
        return thm;
    }

    public void setThm(int thm) {
        this.thm = thm;
    }

    public double getValorhora() {
        return valorhora;
    }

    public void setValorhora(double valorhora) {
        this.valorhora = valorhora;
    }

    public String getPrima() {
        return prima;
    }

    public void setPrima(String prima) {
        this.prima = prima;
    }

    public String getPension() {
        return pension;
    }

    public void setPension(String pension) {
        this.pension = pension;
    }

    public String getNomb_refe1() {
        return nomb_refe1;
    }

    public void setNomb_refe1(String nomb_refe1) {
        this.nomb_refe1 = nomb_refe1;
    }

    public String getEmail_refe1() {
        return email_refe1;
    }

    public void setEmail_refe1(String email_refe1) {
        this.email_refe1 = email_refe1;
    }

    public String getTel_refe1() {
        return tel_refe1;
    }

    public void setTel_refe1(String tel_refe1) {
        this.tel_refe1 = tel_refe1;
    }

    public String getCargo_refe1() {
        return cargo_refe1;
    }

    public void setCargo_refe1(String cargo_refe1) {
        this.cargo_refe1 = cargo_refe1;
    }

    public String getDireccion_refe1() {
        return direccion_refe1;
    }

    public void setDireccion_refe1(String direccion_refe1) {
        this.direccion_refe1 = direccion_refe1;
    }

    public String getNomb_refe2() {
        return nomb_refe2;
    }

    public void setNomb_refe2(String nomb_refe2) {
        this.nomb_refe2 = nomb_refe2;
    }

    public String getEmail_refe2() {
        return email_refe2;
    }

    public void setEmail_refe2(String email_refe2) {
        this.email_refe2 = email_refe2;
    }

    public String getTel_refe2() {
        return tel_refe2;
    }

    public void setTel_refe2(String tel_refe2) {
        this.tel_refe2 = tel_refe2;
    }

    public String getCargo_refe2() {
        return cargo_refe2;
    }

    public void setCargo_refe2(String cargo_refe2) {
        this.cargo_refe2 = cargo_refe2;
    }

    public String getDireccion_refe2() {
        return direccion_refe2;
    }

    public void setDireccion_refe2(String direccion_refe2) {
        this.direccion_refe2 = direccion_refe2;
    }

   
    
    
}
