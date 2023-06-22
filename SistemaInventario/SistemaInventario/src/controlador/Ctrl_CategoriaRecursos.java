
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.CategoriaRecursos;

public class Ctrl_CategoriaRecursos {
    public boolean guardar(CategoriaRecursos objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("insert into tb_categoria_recursos values(?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setString(2, objeto.getNOMBRE());
            consulta.setInt(3, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar categoria: " + e);
        }

        return respuesta;
    }
    public boolean existeCategoriaRecursos(String CategoriaRecursos) {
        boolean respuesta = false;
        String sql = "select nombre from tb_categoria_recursos where NOMBRE = '" + CategoriaRecursos + "';";
        Statement st;

        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar categoria: " + e);
        }
        return respuesta;
    }
    public boolean actualizar(CategoriaRecursos objeto, int IDCATEGORIARECURSOS) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("update tb_categoria_recursos set NOMBRE=? where IDCATEGORIARECURSOS ='" + IDCATEGORIARECURSOS + "'");
            consulta.setString(1, objeto.getNOMBRE());
           
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al actualizar categoria: " + e);
        }

        return respuesta;
    }
    public boolean eliminar(int IDCATEGORIARECURSOS) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement(
                    "delete from tb_categoria_recursos where IDCATEGORIARECURSOS ='" + IDCATEGORIARECURSOS + "'");
            consulta.executeUpdate();
           
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al eliminar categoria: " + e);
        }

        return respuesta;
    }
    
}
