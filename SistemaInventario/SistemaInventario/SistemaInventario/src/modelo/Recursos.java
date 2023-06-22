
package modelo;

public class Recursos {
    private int IDRECURSO;
    private String CODIGO;
    private String NOMBRE;
    private int IDCATEGORIARECURSO;
    private String DESCRIPCION;
    private String COLOR;
    private int estado;    
    
    public Recursos(){
        this.CODIGO = "";
        this.IDRECURSO = 0;
        this.NOMBRE = "";
        this.IDCATEGORIARECURSO = 0;
        this.COLOR = "";
        this.DESCRIPCION = "";
        this.estado = 0;
    }

    public Recursos(int IDRECURSO, String CODIGO, String NOMBRE, int IDCATEGORIARECURSO, String DESCRIPCION, String COLOR, int estado) {
        this.IDRECURSO = IDRECURSO;
        this.CODIGO = CODIGO;
        this.NOMBRE = NOMBRE;
        this.IDCATEGORIARECURSO = IDCATEGORIARECURSO;
        this.DESCRIPCION = DESCRIPCION;
        this.COLOR = COLOR;
        this.estado = estado;
    }

    public int getIDRECURSO() {
        return IDRECURSO;
    }

    public void setIDRECURSO(int IDRECURSO) {
        this.IDRECURSO = IDRECURSO;
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

    public int getIDCATEGORIARECURSO() {
        return IDCATEGORIARECURSO;
    }

    public void setIDCATEGORIARECURSO(int IDCATEGORIARECURSO) {
        this.IDCATEGORIARECURSO = IDCATEGORIARECURSO;
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

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }      
    
}
