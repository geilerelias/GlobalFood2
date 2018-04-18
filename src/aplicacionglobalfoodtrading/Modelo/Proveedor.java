/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionglobalfoodtrading.Modelo;


public class Proveedor {
    
    private String codigo;
    private String nombre;
    private String pais;
    private String ciudad;
    private String cod_postal;
    private String provincia;
    private String direccion;
    private String telefono;
    private String movil;
    private String fax;
    private String email1;
    private String email2;
    private String fk_girnoneg;
    private String fk_tipo;
    private String nit;
    private String reg_empr;
    private int is_activo;
    private int impuesto_incl;
    private String vendedor;
    private String fk_categoria;
    private String imagen;

    public Proveedor() {
    }

    public Proveedor(String codigo, String nombre, String pais, String ciudad, String cod_postal, String provincia, String direccion, String telefono, String movil, String fax, String email1, String email2, String fk_girnoneg, String fk_tipo, String nit, String reg_empr, int is_activo, int impuesto_incl, String vendedor, String fk_categoria, String imagen) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.pais = pais;
        this.ciudad = ciudad;
        this.cod_postal = cod_postal;
        this.provincia = provincia;
        this.direccion = direccion;
        this.telefono = telefono;
        this.movil = movil;
        this.fax = fax;
        this.email1 = email1;
        this.email2 = email2;
        this.fk_girnoneg = fk_girnoneg;
        this.fk_tipo = fk_tipo;
        this.nit = nit;
        this.reg_empr = reg_empr;
        this.is_activo = is_activo;
        this.impuesto_incl = impuesto_incl;
        this.vendedor = vendedor;
        this.fk_categoria = fk_categoria;
        this.imagen = imagen;
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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getCiudad() {
        return ciudad;
    }

    public void setCiudad(String ciudad) {
        this.ciudad = ciudad;
    }

    public String getCod_postal() {
        return cod_postal;
    }

    public void setCod_postal(String cod_postal) {
        this.cod_postal = cod_postal;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getMovil() {
        return movil;
    }

    public void setMovil(String movil) {
        this.movil = movil;
    }

    public String getFax() {
        return fax;
    }

    public void setFax(String fax) {
        this.fax = fax;
    }

    public String getEmail1() {
        return email1;
    }

    public void setEmail1(String email1) {
        this.email1 = email1;
    }

    public String getEmail2() {
        return email2;
    }

    public void setEmail2(String email2) {
        this.email2 = email2;
    }

    public String getFk_girnoneg() {
        return fk_girnoneg;
    }

    public void setFk_girnoneg(String fk_girnoneg) {
        this.fk_girnoneg = fk_girnoneg;
    }

    public String getFk_tipo() {
        return fk_tipo;
    }

    public void setFk_tipo(String fk_tipo) {
        this.fk_tipo = fk_tipo;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getReg_empr() {
        return reg_empr;
    }

    public void setReg_empr(String reg_empr) {
        this.reg_empr = reg_empr;
    }

    public int getIs_activo() {
        return is_activo;
    }

    public void setIs_activo(int is_activo) {
        this.is_activo = is_activo;
    }

    public int getImpuesto_incl() {
        return impuesto_incl;
    }

    public void setImpuesto_incl(int impuesto_incl) {
        this.impuesto_incl = impuesto_incl;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getFk_categoria() {
        return fk_categoria;
    }

    public void setFk_categoria(String fk_categoria) {
        this.fk_categoria = fk_categoria;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    
    
    
    
}
