
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.IngresoProducto;

public class Ctrl_IngresoProducto {
    public boolean guardar(IngresoProducto objeto) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("insert into INGPRODTABLA values(?,?,?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setString(2, objeto.getEMPSERV());            
            consulta.setString(3, objeto.getCODIGO());
            consulta.setString(4, objeto.getNOMBRE());
            consulta.setString(5, objeto.getPRODUCTO());
            consulta.setString(6, objeto.getCOLOR());
            consulta.setString(7, objeto.getTALLA());
            consulta.setInt(8, objeto.getCANTIDAD());
            consulta.setInt(9, objeto.getCANTIDADDEFECTUOSA());
            consulta.setInt(10, objeto.getESTADO());
      

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar ingreso de producto: " + e);
        }

        return respuesta;
    }
    
    public boolean existeIngresoProducto(String IngresoProducto) {
        boolean respuesta = false;
        String sql = "select EMPSERV from INGPRODTABLA where EMPSERV = '" + IngresoProducto + "';";
        Statement st;

        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar Ingreso de producto: " + e);
        }
        return respuesta;
    }
     public boolean actualizar(IngresoProducto objeto, int IDINGRESOPRODUCTO) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("update INGPRODTABLA set EMPSERV= ?, CODIGO = ?, NOMBRE = ?, PRODUCTO = ?, COLOR = ?, TALLA = ?, CANTIDAD = ?, CANTIDADDEFECTUOSA= ? , ESTADO = ? where IDINGRESOPRODUCTO ='" + IDINGRESOPRODUCTO + "'");
            consulta.setString(1, objeto.getEMPSERV());
            consulta.setString(2, objeto.getCODIGO());
            consulta.setString(3, objeto.getNOMBRE());
            consulta.setString(4, objeto.getPRODUCTO());
            consulta.setString(5, objeto.getCOLOR());
            consulta.setString(6, objeto.getTALLA());
            consulta.setInt(7, objeto.getCANTIDAD());
            consulta.setInt(8, objeto.getCANTIDADDEFECTUOSA());
            consulta.setInt(9, objeto.getESTADO());
            
           
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar Ingreso de Productos: " + e);
        }
        return respuesta;
    }
    public boolean eliminar(int IDINGRESOPRODUCTO) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "delete from INGPRODTABLA where IDINGRESOPRODUCTO ='" + IDINGRESOPRODUCTO + "'");
            consulta.executeUpdate();
           
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar Ingreso de Producto: " + e);
        }
        return respuesta;
    }
    
}
