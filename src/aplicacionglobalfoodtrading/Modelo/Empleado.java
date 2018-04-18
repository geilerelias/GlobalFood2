/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionglobalfoodtrading.Modelo;

import java.awt.Image;


public class Empleado {
    
    private String tipoid;
    private String identificacion;
    private String nombre;
    private String apellido;
    private String genero;
    private String fecha_nac;
    private String direccion;
    private String fecha_contrat;        
    private String tel_fijo;
    private String tel_movil;
    private String est_civil;
    private String email;
    private String ciudad;
    private String pais;
    private String cargo;
    private String provincia;
    private double salario;
    private String foto_perfil;

    public Empleado() {
    }

    public Empleado(String tipoid, String identificacion, String nombre, String apellido, String genero, String fecha_nac, String direccion, String fecha_contrat, String tel_fijo, String tel_movil, String est_civil, String email, String ciudad, String pais, String cargo, String provincia, double salario, String foto_perfil) {
        this.tipoid = tipoid;
        this.identificacion = identificacion;
        this.nombre = nombre;
        this.apellido = apellido;
        this.genero = genero;
        this.fecha_nac = fecha_nac;
        this.direccion = direccion;
        this.fecha_contrat = fecha_contrat;
        this.tel_fijo = tel_fijo;
        this.tel_movil = tel_movil;
        this.est_civil = est_civil;
        this.email = email;
        this.ciudad = ciudad;
        this.pais = pais;
        this.cargo = cargo;
        this.provincia = provincia;
        this.salario = salario;
        this.foto_perfil = foto_perfil;
    }

   

    public String getTipoid() {
        return tipoid;
    }

    public void setTipoid(String tipoid) {
        this.tipoid = tipoid;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFecha_nac() {
        return fecha_nac;
    }

    public void setFecha_nac(String fecha_nac) {
        this.fecha_nac = fecha_nac;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getFecha_contrat() {
        return fecha_contrat;
    }

    public void setFecha_contrat(String fecha_contrat) {
        this.fecha_contrat = fecha_contrat;
    }

    public String getTel_fijo() {
        return tel_fijo;
    }

    public void setTel_fijo(String tel_fijo) {
        this.tel_fijo = tel_fijo;
    }

    public String getTel_movil() {
        return tel_movil;
    }

    public void setTel_movil(String tel_movil) {
        this.tel_movil = tel_movil;
    }

    public String getEst_civil() {
        return est_civil;
    }

    public void setEst_civil(String est_civil) {
        this.est_civil = est_civil;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getFoto_perfil() {
        return foto_perfil;
    }

    public void setFoto_perfil(String foto_perfil) {
        this.foto_perfil = foto_perfil;
    }

    
  
    
    
}
