/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionglobalfoodtrading.Modelo;


public class Ciudad {
    private String idciudad;
    private String ciudad;
    private String fk_pais;

    public Ciudad() {
    }

    public Ciudad(String idciudad, String ciudad, String fk_pais) {
        this.idciudad = idciudad;
        this.ciudad = ciudad;
        this.fk_pais = fk_pais;
    }

    public String getIdciudad() {
        return idciudad;
    }

    public void setIdciudad(String idciudad) {
        this.idciudad = idciudad;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getFk_pais() {
        return fk_pais;
    }

    public void setFk_pais(String fk_pais) {
        this.fk_pais = fk_pais;
    }
    
    
    
    
}
