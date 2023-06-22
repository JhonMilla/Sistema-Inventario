/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author julio
 */
public class Producto {
    private int IDPRODUCTO;
    private String CODIGO;
    private String NOMBRE;
    private int IDCATEGORIAPRODUCTO;
    private String COLOR;
    private String TALLA;
    private double PRECIO;
    private int estado;
    
    
    public Producto(){
        this.IDPRODUCTO = 0;
        this.CODIGO = "";
        this.NOMBRE = "";
        this.IDCATEGORIAPRODUCTO = 0;
        this.COLOR = "";
        this.TALLA = "";
        this.PRECIO = 0.0;
        this.estado = 0;
    }

    public Producto(int IDPRODUCTO, String CODIGO, String NOMBRE, int IDCATEGORIAPRODUCTO, String COLOR, String TALLA, double PRECIO, int estado) {
        this.IDPRODUCTO = IDPRODUCTO;
        this.CODIGO = CODIGO;
        this.NOMBRE = NOMBRE;
        this.IDCATEGORIAPRODUCTO = IDCATEGORIAPRODUCTO;
        this.COLOR = COLOR;
        this.TALLA = TALLA;
        this.PRECIO = PRECIO;
        this.estado = estado;
    }

    public int getIDPRODUCTO() {
        return IDPRODUCTO;
    }

    public void setIDPRODUCTO(int IDPRODUCTO) {
        this.IDPRODUCTO = IDPRODUCTO;
    }

    public String getCODIGO() {
        return CODIGO;
    }

    public void setCODIGO(String CODIGO) {
        this.CODIGO = CODIGO;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public int getIDCATEGORIAPRODUCTO() {
        return IDCATEGORIAPRODUCTO;
    }

    public void setIDCATEGORIAPRODUCTO(int IDCATEGORIAPRODUCTO) {
        this.IDCATEGORIAPRODUCTO = IDCATEGORIAPRODUCTO;
    }

    public String getCOLOR() {
        return COLOR;
    }

    public void setCOLOR(String COLOR) {
        this.COLOR = COLOR;
    }

    public String getTALLA() {
        return TALLA;
    }

    public void setTALLA(String TALLA) {
        this.TALLA = TALLA;
    }

    public double getPRECIO() {
        return PRECIO;
    }

    public void setPRECIO(double PRECIO) {
        this.PRECIO = PRECIO;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
        
}
    
 
    
