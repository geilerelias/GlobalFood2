/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionglobalfoodtrading.Modelo;

/**
 *
 * @author Ricardo Andres
 */
public class Subcategoria {
    private String fk_categoria;
    private String codigo;
    private String nombre;

    public Subcategoria() {
    }

    public Subcategoria(String fk_categoria, String codigo, String nombre) {
        this.fk_categoria = fk_categoria;
        this.codigo = codigo;
        this.nombre = nombre;
    }

    public String getFk_categoria() {
        return fk_categoria;
    }

    public void setFk_categoria(String fk_categoria) {
        this.fk_categoria = fk_categoria;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    
    
    
    
    
    
    
    
    
}
