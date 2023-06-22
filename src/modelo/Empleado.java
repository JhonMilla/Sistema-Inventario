package modelo;


public class Empleado {
        //Atributos
    private int idEmpleado;
    private String nombre;
    private String apellido;
    private String dni;
    private String telefono;
    private String direccion;
    private String cargo;
    private int estado;

    //Constructor
    public Empleado() {
        this.idEmpleado = 0;
        this.nombre = "";
        this.apellido = "";
        this.dni = "";
        this.telefono = "";
        this.direccion = "";
        this.cargo = "";
        this.estado = 0;
    }

    //Constructor sobrecargado
    public Empleado(int idEmpleado, String nombre, String apellido, String cedula, String telefono, String direccion, String cargo, int estado) {
        this.idEmpleado = idEmpleado;
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        this.telefono = telefono;
        this.direccion = direccion;
        this.cargo= cargo;
        this.estado = estado;
    }

    //metodos set and get
    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
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
    
    public String getCargo(){
        return cargo;
    }
    public void setCargo(String cargo){
        this.cargo= cargo;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}


