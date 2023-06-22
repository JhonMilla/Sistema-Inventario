/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author XIOMARA
 */
public class IngresoRecursos {
    
    private int IDINGRESORECURSOS;
    private String PROVEEDOR;
    private String CODIGO;
    private String NOMBRE;
    private String RECURSO;
    private String DESCRIPCION;
    private String COLOR;
    private int CANTIDAD;
    private int ESTADO;

    public IngresoRecursos() {
        this.IDINGRESORECURSOS = 0;
        this.PROVEEDOR = "";
        this.CODIGO ="";
        this.NOMBRE ="";
        this.RECURSO = "";
        this.DESCRIPCION = "";
        this.COLOR = "";
        this.CANTIDAD = 0;
        this.ESTADO = 0;
    }

    public IngresoRecursos(int IDINGRESORECURSOS, String PROVEEDOR, String CODIGO, String NOMBRE, String RECURSO, String DESCRIPCION, String COLOR, int CANTIDAD, int ESTADO) {
        this.IDINGRESORECURSOS = IDINGRESORECURSOS;
        this.PROVEEDOR = PROVEEDOR;
        this.CODIGO = CODIGO;
        this.NOMBRE = NOMBRE;
        this.RECURSO = RECURSO;
        this.DESCRIPCION = DESCRIPCION;
        this.COLOR = COLOR;
        this.CANTIDAD = CANTIDAD;
        this.ESTADO = ESTADO;
    }

    public int getIDINGRESORECURSOS() {
        return IDINGRESORECURSOS;
    }

    public void setIDINGRESORECURSOS(int IDINGRESORECURSOS) {
        this.IDINGRESORECURSOS = IDINGRESORECURSOS;
    }

    public String getPROVEEDOR() {
        return PROVEEDOR;
    }

    public void setPROVEEDOR(String PROVEEDOR) {
        this.PROVEEDOR = PROVEEDOR;
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

    public int getESTADO() {
        return ESTADO;
    }

    public void setESTADO(int ESTADO) {
        this.ESTADO = ESTADO;
    }
    
     
    
 }
