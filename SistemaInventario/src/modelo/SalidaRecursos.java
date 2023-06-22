
package modelo;


public class SalidaRecursos {

    private int IDSALIDARECURSOS;
    private String EMPSERV;
    private String CODIGO;
    private String NOMBRE;
    private String RECURSO;
    private String DESCRIPCION;
    private String COLOR;
    private int CANTIDAD;
    private int CANTIDAD_DIS;
    private int ESTADO;

    public SalidaRecursos() {
        this.IDSALIDARECURSOS = 0;
        this.EMPSERV = "";
        this.CODIGO = "";
        this.NOMBRE = "";
        this.RECURSO = "";
        this.DESCRIPCION = "";
        this.COLOR="";
        this.CANTIDAD = 0;
        this.CANTIDAD_DIS=0;
        this.ESTADO = 0;
    }

    public SalidaRecursos(int IDSALIDARECURSOS, String EMPSERV, String CODIGO, String NOMBRE, String RECURSO, String DESCRIPCION, String COLOR, int CANTIDAD, int CANTIDAD_DIS, int ESTADO) {
        this.IDSALIDARECURSOS = IDSALIDARECURSOS;
        this.EMPSERV = EMPSERV;
        this.CODIGO = CODIGO;
        this.NOMBRE = NOMBRE;
        this.RECURSO = RECURSO;
        this.DESCRIPCION = DESCRIPCION;
        this.COLOR = COLOR;
        this.CANTIDAD = CANTIDAD;
        this.CANTIDAD_DIS = CANTIDAD_DIS;
        this.ESTADO = ESTADO;
    }

    public int getIDSALIDARECURSOS() {
        return IDSALIDARECURSOS;
    }

    public void setIDSALIDARECURSOS(int IDSALIDARECURSOS) {
        this.IDSALIDARECURSOS = IDSALIDARECURSOS;
    }

    public String getEMPSERV() {
        return EMPSERV;
    }

    public void setEMPSERV(String EMPSERV) {
        this.EMPSERV = EMPSERV;
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

    public String getRECURSO() {
        return RECURSO;
    }

    public void setRECURSO(String RECURSO) {
        this.RECURSO = RECURSO;
    }

    public String getDESCRIPCION() {
        return DESCRIPCION;
    }

    public void setDESCRIPCION(String DESCRIPCION) {
        this.DESCRIPCION = DESCRIPCION;
    }

    public String getCOLOR() {
        return COLOR;
    }

    public void setCOLOR(String COLOR) {
        this.COLOR = COLOR;
    }

    public int getCANTIDAD() {
        return CANTIDAD;
    }

    public void setCANTIDAD(int CANTIDAD) {
        this.CANTIDAD = CANTIDAD;
    }

    public int getCANTIDAD_DIS() {
        return CANTIDAD_DIS;
    }

    public void setCANTIDAD_DIS(int CANTIDAD_DIS) {
        this.CANTIDAD_DIS = CANTIDAD_DIS;
    }

    public int getESTADO() {
        return ESTADO;
    }

    public void setESTADO(int ESTADO) {
        this.ESTADO = ESTADO;
    }
    
}
