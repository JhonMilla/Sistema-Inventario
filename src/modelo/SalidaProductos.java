
package modelo;

public class SalidaProductos {

    private int IDSALIDAPRODUCTO;
    private String CLIENTE;
    private String CODIGO;
    private String NOMBRE;
    private String PRODUCTOS;
    private String COLOR;
    private String TALLA;
    private int CANTIDAD_DIS;
    private int CANTIDAD;
    private int ESTADO;

    public SalidaProductos() {
        this.IDSALIDAPRODUCTO = 0;
        this.CLIENTE = "";
        this.CODIGO = "";
        this.NOMBRE = "";
        this.PRODUCTOS = "";
        this.COLOR = "";
        this.TALLA = "";
        this.CANTIDAD_DIS = 0;
        this.CANTIDAD = 0;
        this.ESTADO = 0;
    }

    public SalidaProductos(int IDSALIDAPRODUCTO, String CLIENTE, String CODIGO, String NOMBRE, String PRODUCTOS, String COLOR, String TALLA, int CANTIDAD_DIS, int CANTIDAD, int ESTADO) {
        this.IDSALIDAPRODUCTO = IDSALIDAPRODUCTO;
        this.CLIENTE = CLIENTE;
        this.CODIGO = CODIGO;
        this.NOMBRE = NOMBRE;
        this.PRODUCTOS = PRODUCTOS;
        this.COLOR = COLOR;
        this.TALLA = TALLA;
        this.CANTIDAD_DIS = CANTIDAD_DIS;
        this.CANTIDAD = CANTIDAD;
        this.ESTADO = ESTADO;
    }

    public int getIDSALIDAPRODUCTO() {
        return IDSALIDAPRODUCTO;
    }

    public void setIDSALIDAPRODUCTO(int IDSALIDAPRODUCTO) {
        this.IDSALIDAPRODUCTO = IDSALIDAPRODUCTO;
    }

    public String getCLIENTE() {
        return CLIENTE;
    }

    public void setCLIENTE(String CLIENTE) {
        this.CLIENTE = CLIENTE;
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

    public String getPRODUCTOS() {
        return PRODUCTOS;
    }

    public void setPRODUCTOS(String PRODUCTOS) {
        this.PRODUCTOS = PRODUCTOS;
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

    public int getCANTIDAD_DIS() {
        return CANTIDAD_DIS;
    }

    public void setCANTIDAD_DIS(int CANTIDAD_DIS) {
        this.CANTIDAD_DIS = CANTIDAD_DIS;
    }

    public int getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(int CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public int getESTADO() {
        return ESTADO;
    }

    public void setESTADO(int ESTADO) {
        this.ESTADO = ESTADO;
    }   
    
}
