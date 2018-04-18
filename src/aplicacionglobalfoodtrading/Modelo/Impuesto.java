/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionglobalfoodtrading.Modelo;


public class Impuesto {
    
    private String abreviatura;
    private String descripcion;
    private float valor;

    public Impuesto() {
    }

    public Impuesto(String abreviatura, String descripcion, float valor) {
        this.abreviatura = abreviatura;
        this.descripcion = descripcion;
        this.valor = valor;
    }

    public String getAbreviatura() {
        return abreviatura;
    }

    public void setAbreviatura(String abreviatura) {
        this.abreviatura = abreviatura;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }
    

}
