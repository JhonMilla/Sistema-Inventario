
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.IngresoRecursos;     

public class Ctrl_IngresoRecursos {
  public boolean guardar(IngresoRecursos objeto) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            
            PreparedStatement consulta = cn.prepareStatement("insert into INGRECUTABLA values(?,?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setString(2, objeto.getPROVEEDOR());
            consulta.setString(3, objeto.getCODIGO());
            consulta.setString(4, objeto.getNOMBRE());
            consulta.setString(5, objeto.getRECURSO());
            consulta.setString(6, objeto.getDESCRIPCION());
            consulta.setString(7, objeto.getCOLOR());
            consulta.setInt(8, objeto.getCANTIDAD());
            consulta.setInt(9, objeto.getESTADO());
            
             if (consulta.executeUpdate() > 0) {
                 respuesta = true;
             }
             cn.close();
                
        } catch (SQLException e) {
            System.out.println("Error al guardar ingreso de recurso: " + e);
        }
        return respuesta;
        
     }
        
         public boolean existeIngresoRecursos(String IngresoRecursos) {
        boolean respuesta = false;
        String sql = "select PROVEEDOR from INGRECUTABLA where PROVEEDOR = '" + IngresoRecursos + "';";
        Statement st;

        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
                
                }

        } catch (SQLException e) {
            System.out.println("Error al consultar Ingreso de Recurso: " + e);
        }
        return respuesta;
    }
     public boolean actualizar(IngresoRecursos objeto, int IDINGRESORECURSOS) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try{
            
            PreparedStatement consulta = cn.prepareStatement("update INGRECUTABLA set PROVEEDOR= ?, CODIGO=?, NOMBRE=?, RECURSO = ?, DESCRIPCION = ?, COLOR = ?, CANTIDAD = ?, ESTADO= ? where IDINGRESORECURSOS ='" + IDINGRESORECURSOS + "'");
            consulta.setString(1, objeto.getPROVEEDOR());
            consulta.setString(2, objeto.getCODIGO());
            consulta.setString(3, objeto.getNOMBRE());
            consulta.setString(4, objeto.getRECURSO());
            consulta.setString(5, objeto.getDESCRIPCION());
            consulta.setString(6, objeto.getCOLOR());
            consulta.setInt(7, objeto.getCANTIDAD());
            consulta.setInt(8, objeto.getESTADO());
            
           
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
        }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar Ingreso de Recurso: " + e);
        }
        return respuesta;
    }
    public boolean eliminar(int IDINGRESORECURSOS) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "delete from INGRECUTABLA where IDINGRESORECURSOS ='" + IDINGRESORECURSOS + "'");
            consulta.executeUpdate();
           
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar Ingreso de recurso: " + e);
        }
        return respuesta;
    }
    
    public IngresoRecursos BuscarRecur(String CODIGO){
        IngresoRecursos ingresorecurso = new IngresoRecursos();
        String sql = "SELECT * FROM tb_recursos WHERE CODIGO = ?";
        Statement st;
        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            if (rs.next()) {
                ingresorecurso.setNOMBRE(rs.getString("NOMBRE"));
                ingresorecurso.setDESCRIPCION(rs.getString("DESCRIPCION"));
                ingresorecurso.setCOLOR(rs.getString("COLOR"));
                
            }
        } catch (SQLException e) {
            System.out.println(e.toString());
        }
        return ingresorecurso;
    }
  
}
