
package modelo;

public class CategoriaProducto {
    private int IDCATEGORIAPRODUCTO;
    private String NOMBRE;
    private int estado;
    
    
    public CategoriaProducto(){
        this.IDCATEGORIAPRODUCTO= 0;
        this.NOMBRE = "";
        this.estado = 0;
    }

    public CategoriaProducto(int IDCATEGORIAPRODUCTO, String NOMBRE, int estado) {
        this.IDCATEGORIAPRODUCTO = IDCATEGORIAPRODUCTO;
        this.NOMBRE = NOMBRE;
        this.estado = estado;
    }

    public int getIDCATEGORIAPRODUCTO() {
        return IDCATEGORIAPRODUCTO;
    }

    public void setIDCATEGORIAPRODUCTO(int IDCATEGORIAPRODUCTO) {
        this.IDCATEGORIAPRODUCTO = IDCATEGORIAPRODUCTO;
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
