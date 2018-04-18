/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionglobalfoodtrading.Modelo;


public class Bodega {
    
    private String codigo;
    private String nombre_b;

    public Bodega() {
    }

    public Bodega(String codigo, String nombre_b) {
        this.codigo = codigo;
        this.nombre_b = nombre_b;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre_b() {
        return nombre_b;
    }

    public void setNombre_b(String nombre_b) {
        this.nombre_b = nombre_b;
    }
   
    
}
