
package modelo;

public class Proveedores {
    private int IDPROVEEDORES;
    private String RUC;
    private String NOMBRE;
    private String DIRECCION;
    private String TELEFONO;
    private int IDCATEGORIARECURSO;
    private String ESTADO;
    private String CALIFICACION;
    private int Stdo;
    
    public Proveedores(){
        this.IDPROVEEDORES = 0;
        this.RUC="";
        this.NOMBRE = "";
        this.DIRECCION = "";
        this.TELEFONO = "";
        this.IDCATEGORIARECURSO=0;
        this.ESTADO = "";
        this.CALIFICACION = "";
        this.Stdo= 0;
    }

    public Proveedores(int IDPROVEEDORES, String RUC, String NOMBRE, String DIRECCION, String TELEFONO, int IDCATEGORIARECURSO, String ESTADO, String CALIFICACION, int Stdo) {
        this.IDPROVEEDORES = IDPROVEEDORES;
        this.RUC = RUC;
        this.NOMBRE = NOMBRE;
        this.DIRECCION = DIRECCION;
        this.TELEFONO = TELEFONO;
        this.IDCATEGORIARECURSO = IDCATEGORIARECURSO;
        this.ESTADO = ESTADO;
        this.CALIFICACION = CALIFICACION;
        this.Stdo = Stdo;
    }

    public int getIDPROVEEDORES() {
        return IDPROVEEDORES;
    }

    public void setIDPROVEEDORES(int IDPROVEEDORES) {
        this.IDPROVEEDORES = IDPROVEEDORES;
    }

    public String getRUC() {
        return RUC;
    }

    public void setRUC(String RUC) {
        this.RUC = RUC;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getDIRECCION() {
        return DIRECCION;
    }

    public void setDIRECCION(String DIRECCION) {
        this.DIRECCION = DIRECCION;
    }

    public String getTELEFONO() {
        return TELEFONO;
    }

    public void setTELEFONO(String TELEFONO) {
        this.TELEFONO = TELEFONO;
    }

    public int getIDCATEGORIARECURSO() {
        return IDCATEGORIARECURSO;
    }

    public void setIDCATEGORIARECURSO(int IDCATEGORIARECURSO) {
        this.IDCATEGORIARECURSO = IDCATEGORIARECURSO;
    }

    public String getESTADO() {
        return ESTADO;
    }

    public void setESTADO(String ESTADO) {
        this.ESTADO = ESTADO;
    }

    public String getCALIFICACION() {
        return CALIFICACION;
    }

    public void setCALIFICACION(String CALIFICACION) {
        this.CALIFICACION = CALIFICACION;
    }

    public int getStdo() {
        return Stdo;
    }

    public void setStdo(int Stdo) {
        this.Stdo = Stdo;
    }

    
}