
package modelo;

public class Servicios {
    private int IDSERVICIOS;
    private String DNI;
    private String NOMBRE;
    private String APELLIDO;
    private String DIRECCION;
    private String TELEFONO;
    private String ESTADO;
    private int Stdo;
    
    public Servicios(){
        this.IDSERVICIOS = 0;
        this.DNI="";
        this.NOMBRE = "";
        this.APELLIDO = "";
        this.DIRECCION = "";
        this.TELEFONO = "";
        this.ESTADO = "";
        this.Stdo= 0;
    }

    public Servicios(int IDSERVICIOS, String DNI, String NOMBRE, String APELLIDO, String DIRECCION, String TELEFONO,
                    String ESTADO, int Stdo) {
        this.IDSERVICIOS = IDSERVICIOS;
        this.DNI = DNI;
        this.NOMBRE = NOMBRE;
        this.APELLIDO = APELLIDO;
        this.DIRECCION = DIRECCION;
        this.TELEFONO = TELEFONO;
        this.ESTADO = ESTADO;
        this.Stdo = Stdo;
    }

    public int getIDSERVICIOS() {
        return IDSERVICIOS;
    }

    public void setIDSERVICIOS(int IDSERVICIOS) {
        this.IDSERVICIOS = IDSERVICIOS;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }
    

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public String getAPELLIDO() {
        return APELLIDO;
    }

    public void setAPELLIDO(String APELLIDO) {
        this.APELLIDO = APELLIDO;
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

    public String getESTADO() {
        return ESTADO;
    }

    public void setESTADO(String ESTADO) {
        this.ESTADO = ESTADO;
    }

    public int getStdo() {
        return Stdo;
    }

    public void setStdo(int Stdo) {
        this.Stdo = Stdo;
    }  
}