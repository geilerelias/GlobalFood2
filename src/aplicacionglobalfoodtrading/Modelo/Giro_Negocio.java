/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionglobalfoodtrading.Modelo;

/**
 *
 * @author Ricardo Carmona
 */
public class Giro_Negocio {
    private String indice;
    private String descripcion;

    public Giro_Negocio() {
    }

    public Giro_Negocio(String indice, String descripcion) {
        this.indice = indice;
        this.descripcion = descripcion;
    }

    public String getIndice() {
        return indice;
    }

    public void setIndice(String indice) {
        this.indice = indice;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    
    
}
