
package modelo;

public class CategoriaRecursos {
    private int IDCATEGORIARECURSOS;
    private String NOMBRE;
    private int estado;
    
    public CategoriaRecursos(){
        this.IDCATEGORIARECURSOS= 0;
        this.NOMBRE = "";
        this.estado = 0;
    }

    public CategoriaRecursos(int IDCATEGORIARECURSOS, String NOMBRE, int estado) {
        this.IDCATEGORIARECURSOS = IDCATEGORIARECURSOS;
        this.NOMBRE = NOMBRE;
        this.estado = estado;
    }

    public int getIDCATEGORIARECURSOS() {
        return IDCATEGORIARECURSOS;
    }

    public void setIDCATEGORIARECURSOS(int IDCATEGORIARECURSOS) {
        this.IDCATEGORIARECURSOS = IDCATEGORIARECURSOS;
    }

    public String getNOMBRE() {
        return NOMBRE;
    }

    public void setNOMBRE(String NOMBRE) {
        this.NOMBRE = NOMBRE;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }     
}
