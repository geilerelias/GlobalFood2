/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package aplicacionglobalfoodtrading.Modelo;


public class Producto {
    
    private String cod_prod;
    private String nombre_prod;
    private String fk_proveedor;
    private float prec_cost_prod;
    private float prec_cost_prod_dolar;
    private float prec_vent_prod;
    private float utilidad_prod;
    private String fk_categoria;
    private String fk_subcategoria;
    private String fk_bodega;
    private String se_vende_x;
    private int vende_contiene;
    private String se_Compra_x;
    private int compra_contiene;
    private String tipo_prod;
    private int esta_activo;
    private String fk_impuesto1;
    private int impuesto1_aplic_venta;
    private int impuesto1_aplic_compra;
    private String fk_impuesto2;
    private int impuesto2_aplic_venta;
    private int impuesto2_aplic_compra;
    private float precio_neto_prod;
    private float precio_mas_impuesto;

    public Producto() {
    }

    public Producto(String cod_prod, String nombre_prod, String fk_proveedor, float prec_cost_prod, float prec_cost_prod_dolar, float prec_vent_prod, float utilidad_prod, String fk_categoria, String fk_subcategoria, String fk_bodega, String se_vende_x, int vende_contiene, String se_Compra_x, int compra_contiene, String tipo_prod, int esta_activo, String fk_impuesto1, int impuesto1_aplic_venta, int impuesto1_aplic_compra, String fk_impuesto2, int impuesto2_aplic_venta, int impuesto2_aplic_compra, float precio_neto_prod, float precio_mas_impuesto) {
        this.cod_prod = cod_prod;
        this.nombre_prod = nombre_prod;
        this.fk_proveedor = fk_proveedor;
        this.prec_cost_prod = prec_cost_prod;
        this.prec_cost_prod_dolar = prec_cost_prod_dolar;
        this.prec_vent_prod = prec_vent_prod;
        this.utilidad_prod = utilidad_prod;
        this.fk_categoria = fk_categoria;
        this.fk_subcategoria = fk_subcategoria;
        this.fk_bodega = fk_bodega;
        this.se_vende_x = se_vende_x;
        this.vende_contiene = vende_contiene;
        this.se_Compra_x = se_Compra_x;
        this.compra_contiene = compra_contiene;
        this.tipo_prod = tipo_prod;
        this.esta_activo = esta_activo;
        this.fk_impuesto1 = fk_impuesto1;
        this.impuesto1_aplic_venta = impuesto1_aplic_venta;
        this.impuesto1_aplic_compra = impuesto1_aplic_compra;
        this.fk_impuesto2 = fk_impuesto2;
        this.impuesto2_aplic_venta = impuesto2_aplic_venta;
        this.impuesto2_aplic_compra = impuesto2_aplic_compra;
        this.precio_neto_prod = precio_neto_prod;
        this.precio_mas_impuesto = precio_mas_impuesto;
    }
    
    
    

    public String getCod_prod() {
        return cod_prod;
    }

    public void setCod_prod(String cod_prod) {
        this.cod_prod = cod_prod;
    }

    public String getNombre_prod() {
        return nombre_prod;
    }

    public void setNombre_prod(String nombre_prod) {
        this.nombre_prod = nombre_prod;
    }

    public String getFk_proveedor() {
        return fk_proveedor;
    }

    public void setFk_proveedor(String fk_proveedor) {
        this.fk_proveedor = fk_proveedor;
    }

    public float getPrec_cost_prod() {
        return prec_cost_prod;
    }

    public void setPrec_cost_prod(float prec_cost_prod) {
        this.prec_cost_prod = prec_cost_prod;
    }

    public float getPrec_cost_prod_dolar() {
        return prec_cost_prod_dolar;
    }

    public void setPrec_cost_prod_dolar(float prec_cost_prod_dolar) {
        this.prec_cost_prod_dolar = prec_cost_prod_dolar;
    }

    public float getPrec_vent_prod() {
        return prec_vent_prod;
    }

    public void setPrec_vent_prod(float prec_vent_prod) {
        this.prec_vent_prod = prec_vent_prod;
    }

    public float getUtilidad_prod() {
        return utilidad_prod;
    }

    public void setUtilidad_prod(float utilidad_prod) {
        this.utilidad_prod = utilidad_prod;
    }

    public String getFk_categoria() {
        return fk_categoria;
    }

    public void setFk_categoria(String fk_categoria) {
        this.fk_categoria = fk_categoria;
    }

    public String getFk_subcategoria() {
        return fk_subcategoria;
    }

    public void setFk_subcategoria(String fk_subcategoria) {
        this.fk_subcategoria = fk_subcategoria;
    }

    public String getFk_bodega() {
        return fk_bodega;
    }

    public void setFk_bodega(String fk_bodega) {
        this.fk_bodega = fk_bodega;
    }

    public String getSe_vende_x() {
        return se_vende_x;
    }

    public void setSe_vende_x(String se_vende_x) {
        this.se_vende_x = se_vende_x;
    }

    public int getVende_contiene() {
        return vende_contiene;
    }

    
    public String getSe_Compra_x() {
        return se_Compra_x;
    }

    public void setSe_Compra_x(String se_Compra_x) {
        this.se_Compra_x = se_Compra_x;
    }

    public int getCompra_contiene() {
        return compra_contiene;
    }


    public String getTipo_prod() {
        return tipo_prod;
    }

    public void setTipo_prod(String tipo_prod) {
        this.tipo_prod = tipo_prod;
    }

    public int getEsta_activo() {
        return esta_activo;
    }

    public void setEsta_activo(int esta_activo) {
        this.esta_activo = esta_activo;
    }

    public String getFk_impuesto1() {
        return fk_impuesto1;
    }

    public void setFk_impuesto1(String fk_impuesto1) {
        this.fk_impuesto1 = fk_impuesto1;
    }

    public int getImpuesto1_aplic_venta() {
        return impuesto1_aplic_venta;
    }

    public void setImpuesto1_aplic_venta(int impuesto1_aplic_venta) {
        this.impuesto1_aplic_venta = impuesto1_aplic_venta;
    }

    public int getImpuesto1_aplic_compra() {
        return impuesto1_aplic_compra;
    }

    public void setImpuesto1_aplic_compra(int impuesto1_aplic_compra) {
        this.impuesto1_aplic_compra = impuesto1_aplic_compra;
    }

    public String getFk_impuesto2() {
        return fk_impuesto2;
    }

    public void setFk_impuesto2(String fk_impuesto2) {
        this.fk_impuesto2 = fk_impuesto2;
    }

    public int getImpuesto2_aplic_venta() {
        return impuesto2_aplic_venta;
    }

    public void setImpuesto2_aplic_venta(int impuesto2_aplic_venta) {
        this.impuesto2_aplic_venta = impuesto2_aplic_venta;
    }

    public int getImpuesto2_aplic_compra() {
        return impuesto2_aplic_compra;
    }

    public void setImpuesto2_aplic_compra(int impuesto2_aplic_compra) {
        this.impuesto2_aplic_compra = impuesto2_aplic_compra;
    }

    public float getPrecio_neto_prod() {
        return precio_neto_prod;
    }

    public void setPrecio_neto_prod(float precio_neto_prod) {
        this.precio_neto_prod = precio_neto_prod;
    }

    public float getPrecio_mas_impuesto() {
        return precio_mas_impuesto;
    }

    public void setPrecio_mas_impuesto(float precio_mas_impuesto) {
        this.precio_mas_impuesto = precio_mas_impuesto;
    }

    public void setVende_contiene(int vende_contiene) {
        this.vende_contiene = vende_contiene;
    }

    public void setCompra_contiene(int compra_contiene) {
        this.compra_contiene = compra_contiene;
    }
    

    
}
