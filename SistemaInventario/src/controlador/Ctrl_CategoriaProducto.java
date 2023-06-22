
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.CategoriaProducto;

public class Ctrl_CategoriaProducto {
    public boolean guardar(CategoriaProducto objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("insert into tb_categoria_producto values(?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setString(2, objeto.getNOMBRE());
            consulta.setInt(3, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar cartegoria: " + e);
        }

        return respuesta;
    }
    public boolean existeCategoriaProducto(String categoriaProducto) {
        boolean respuesta = false;
        String sql = "select nombre from tb_categoria_producto where NOMBRE = '" + categoriaProducto + "';";
        Statement st;

        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }

        } catch (SQLException e) {
            System.out.println("Error al consultar cartegoria: " + e);
        }
        return respuesta;
    }
    public boolean actualizar(CategoriaProducto objeto, int IDCATEGORIAPRODUCTO) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("update tb_categoria_producto set NOMBRE=? where IDCATEGORIAPRODUCTO ='" + IDCATEGORIAPRODUCTO + "'");
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
    public boolean eliminar(int IDCATEGORIAPRODUCTO) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement(
                    "delete from tb_categoria_producto where IDCATEGORIAPRODUCTO ='" + IDCATEGORIAPRODUCTO + "'");
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
