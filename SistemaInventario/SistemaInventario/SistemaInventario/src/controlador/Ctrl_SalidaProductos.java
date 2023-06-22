
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.SalidaProductos;


public class Ctrl_SalidaProductos {
    public boolean guardar(SalidaProductos objeto) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("insert into SALIPRODTABLA values(?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setString(2, objeto.getCLIENTE());
            consulta.setString(3, objeto.getPRODUCTOS());
            consulta.setInt(4, objeto.getCANTIDAD());
            consulta.setInt(5, objeto.getESTADO());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar salida de Producto: " + e);
        }

        return respuesta;
    }
    
    public boolean existeSalidaProductos(String SalidaProductos) {
        boolean respuesta = false;
        String sql = "select CLIENTE from SALIPRODTABLA where CLIENTE = '" + SalidaProductos + "';";
        Statement st;

        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar Salida de Productos: " + e);
        }
        return respuesta;
    }
     public boolean actualizar(SalidaProductos objeto, int IDSALIDAPRODUCTOS) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("update SALIPRODTABLA set CLIENTE= ?, PRODUCTO = ?, CANTIDAD = ?,ESTADO= ? where IDSALIDAPRODUCTOS ='" + IDSALIDAPRODUCTOS + "'");
            consulta.setString(1, objeto.getCLIENTE());
            consulta.setString(2, objeto.getPRODUCTOS());
            consulta.setInt(3, objeto.getCANTIDAD());
            consulta.setInt(4, objeto.getESTADO());
            
           
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar Salida de Producto: " + e);
        }
        return respuesta;
    }
    public boolean eliminar(int IDSALIDAPRODUCTOS) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "delete from SALIPRODTABLA where IDSALIDAPRODUCTOS ='" + IDSALIDAPRODUCTOS + "'");
            consulta.executeUpdate();
           
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar Salida de Producto: " + e);
        }
        return respuesta;
    }
    
}
