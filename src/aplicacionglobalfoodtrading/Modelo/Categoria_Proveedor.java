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
public class Categoria_Proveedor {
    private int indice;
    private String descripcion;

    public Categoria_Proveedor() {
    }

    public Categoria_Proveedor(int indice, String descripcion) {
        this.indice = indice;
        this.descripcion = descripcion;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

}
