
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Usuario;

public class Controlador_usuario {
    
    //metodo para Iniciar Sesion
    public boolean loginUser(Usuario objeto){
        boolean respuesta = false;
        Connection cn= Conexion.conectar();
        String sql="select usuario, password from tb_usuarios where usuario = '" +objeto.getUsuario()+"' and password = '"+objeto.getPassword()+"'";
        Statement st;
        try{
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                respuesta = true;
            }
        }catch (SQLException e){
            System.out.println("Error al iniciar seseión");
            JOptionPane.showMessageDialog(null, "Error al Iniciar Sesion");
        }
        return respuesta;
    }
}
