
package modelo;


public class SalidaRecursos {

    private int IDSALIDARECURSOS;
    private String EMPSERV;
    private String RECURSO;
    private String COLOR;
    private int CANTIDAD;
    private int STOCK;
    private int ESTADO;

    public SalidaRecursos() {
        this.IDSALIDARECURSOS = 0;
        this.EMPSERV = "";
        this.RECURSO = "";
        this.COLOR="";
        this.CANTIDAD = 0;
        this.STOCK=0;
        this.ESTADO = 0;
    }

    public SalidaRecursos(int IDSALIDARECURSOS, String EMPSERV, String RECURSO, String COLOR, int CANTIDAD, int STOCK, int ESTADO) {
        this.IDSALIDARECURSOS = IDSALIDARECURSOS;
        this.EMPSERV = EMPSERV;
        this.RECURSO = RECURSO;
        this.COLOR = COLOR;
        this.CANTIDAD = CANTIDAD;
        this.STOCK = STOCK;
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

    public String getRECURSO() {
        return RECURSO;
    }

    public void setRECURSO(String RECURSO) {
        this.RECURSO = RECURSO;
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

    public int getSTOCK() {
        return STOCK;
    }

    public void setSTOCK(int STOCK) {
        this.STOCK = STOCK;
    }

    public int getESTADO() {
        return ESTADO;
    }

    public void setESTADO(int ESTADO) {
        this.ESTADO = ESTADO;
    }

    
    

}
