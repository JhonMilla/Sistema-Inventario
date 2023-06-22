
package modelo;

public class SalidaProductos {

    private int IDSALIDAPRODUCTO;
    private String CLIENTE;
    private String PRODUCTOS;
    private int CANTIDAD;
    private int ESTADO;

    public SalidaProductos() {
        this.IDSALIDAPRODUCTO = 0;
        this.CLIENTE = "";
        this.PRODUCTOS = "";
        this.CANTIDAD = 0;
        this.ESTADO = 0;
    }

    public SalidaProductos(int IDSALIDAPRODUCTO, String CLIENTE, String PRODUCTOS, int CANTIDAD, int ESTADO) {
        this.IDSALIDAPRODUCTO = IDSALIDAPRODUCTO;
        this.CLIENTE = CLIENTE;
        this.PRODUCTOS = PRODUCTOS;
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

    public String getPRODUCTOS() {
        return PRODUCTOS;
    }

    public void setPRODUCTOS(String PRODUCTOS) {
        this.PRODUCTOS = PRODUCTOS;
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
