
package modelo;

public class Cliente {
    //Atributos
    private int idCliente;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String direccion;
    private String tipo;
    private String Estado;
    private int Stdo;

    //Constructor
    public Cliente() {
        this.idCliente = 0;
        this.nombre = "";
        this.apellido = "";
        this.dni = "";
        this.telefono = "";
        this.direccion = "";
        this.tipo = "";
        this.Estado = "";
        this.Stdo = 0;
    }

    //Constructor sobrecargado
    public Cliente(int idCliente, String nombre, String apellido, String dni, String telefono, String direccion, String tipo, String Estado, int Stdo) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.tipo = tipo;
        this.Estado = Estado;
        this.Stdo = Stdo;
    }
    
    //Metodo get y set
    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getEstado() {
        return Estado;
    }

    public void setEstado(String Estado) {
        this.Estado = Estado;
    }

    public int getStdo() {
        return Stdo;
    }

    public void setStdo(int Stdo) {
        this.Stdo = Stdo;
    }
        
}


