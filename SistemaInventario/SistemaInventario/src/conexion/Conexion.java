
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {
    
    //Conexion local
    public static Connection conectar(){
        try{
            Connection cn = DriverManager.getConnection("jdbc:mysql://localhost/bd_sistema_inventario","root","admin123");
            return cn;
        }catch(SQLException e){
            System.out.println("Error en la conexion local: "+e);   
        }
        return null;
    }
    
}
