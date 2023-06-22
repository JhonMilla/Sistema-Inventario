package modelo;


public class IngresoProducto {
    
    private int IDINGRESOPRODUCTO;
    private String CODIGO;
    private String EMPSERV;
    private String PRODUCTO;
    private String COLOR;
    private String TALLA;
    private int CANTIDAD;
    private int CANTIDADDEFECTUOSA;
    private int ESTADO;

    public IngresoProducto() {
        this.IDINGRESOPRODUCTO = 0;
        this.CODIGO= "";
        this.EMPSERV= "";
        this.PRODUCTO = "";
        this.COLOR = "";
        this.TALLA="";
        this.CANTIDAD = 0;
        this.CANTIDADDEFECTUOSA = 0;
        this.ESTADO = 0;

    }

    public IngresoProducto(int IDINGRESOPRODUCTO, String CODIGO, String EMPSERV, String PRODUCTO, String COLOR, String TALLA, int CANTIDAD, int CANTIDADDEFECTUOSA, int ESTADO) {
        this.IDINGRESOPRODUCTO = IDINGRESOPRODUCTO;
        this.CODIGO = CODIGO;
        this.EMPSERV = EMPSERV;
        this.PRODUCTO = PRODUCTO;
        this.COLOR = COLOR;
        this.TALLA = TALLA;
        this.CANTIDAD = CANTIDAD;
        this.CANTIDADDEFECTUOSA = CANTIDADDEFECTUOSA;
        this.ESTADO = ESTADO;
    }

    public int getIDINGRESOPRODUCTO() {
        return IDINGRESOPRODUCTO;
    }

    public void setIDINGRESOPRODUCTO(int IDINGRESOPRODUCTO) {
        this.IDINGRESOPRODUCTO = IDINGRESOPRODUCTO;
    }

    public String getCODIGO() {
        return CODIGO;
    }

    public void setCODIGO(String CODIGO) {
        this.CODIGO = CODIGO;
    }

    public String getEMPSERV() {
        return EMPSERV;
    }

    public void setEMPSERV(String EMPSERV) {
        this.EMPSERV = EMPSERV;
    }

    public String getPRODUCTO() {
        return PRODUCTO;
    }

    public void setPRODUCTO(String PRODUCTO) {
        this.PRODUCTO = PRODUCTO;
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

    public int getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(int CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public int getCANTIDADDEFECTUOSA() {
        return CANTIDADDEFECTUOSA;
    }

    public void setCANTIDADDEFECTUOSA(int CANTIDADDEFECTUOSA) {
        this.CANTIDADDEFECTUOSA = CANTIDADDEFECTUOSA;
    }

    public int getESTADO() {
        return ESTADO;
    }

    public void setESTADO(int ESTADO) {
        this.ESTADO = ESTADO;
    }
    
    
    
}


