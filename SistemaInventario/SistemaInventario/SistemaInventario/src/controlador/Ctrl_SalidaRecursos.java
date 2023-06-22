
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.SalidaRecursos;


public class Ctrl_SalidaRecursos {
    public boolean guardar(SalidaRecursos objeto) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("insert into SALIRECTABLA values(?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setString(2, objeto.getEMPSERV());
            consulta.setString(3, objeto.getRECURSO());
            consulta.setInt(4, objeto.getCANTIDAD());
            consulta.setInt(5, objeto.getESTADO());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar salida de recurso: " + e);
        }

        return respuesta;
    }
    
    public boolean existeSalidaRecursos(String SalidaRecursos) {
        boolean respuesta = false;
        String sql = "select EMPSERV from SALIRECTABLA where EMPSERV = '" + SalidaRecursos + "';";
        Statement st;

        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar Salida de Recurso: " + e);
        }
        return respuesta;
    }
     public boolean actualizar(SalidaRecursos objeto, int IDSALIDARECURSOS) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("update SALIRECTABLA set EMPSERV= ?, RECURSO = ?, CANTIDAD = ?,ESTADO= ? where IDSALIDARECURSOS ='" + IDSALIDARECURSOS + "'");
            consulta.setString(1, objeto.getEMPSERV());
            consulta.setString(2, objeto.getRECURSO());
            consulta.setInt(3, objeto.getCANTIDAD());
            consulta.setInt(4, objeto.getESTADO());
            
           
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar Salida de Recurso: " + e);
        }
        return respuesta;
    }
    public boolean eliminar(int IDSALIDARECURSOS) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "delete from SALIRECTABLA where IDSALIDARECURSOS ='" + IDSALIDARECURSOS + "'");
            consulta.executeUpdate();
           
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar Salida de recurso: " + e);
        }
        return respuesta;
    }
    
}
