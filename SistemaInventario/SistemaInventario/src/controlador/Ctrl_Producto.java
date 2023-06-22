package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Producto;

public class Ctrl_Producto {

    public boolean guardar(Producto objeto) {
        boolean respuesta = false;
        //Base de datos 
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("insert into tb_producto values(?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setString(2, objeto.getCODIGO());
            consulta.setString(3, objeto.getNOMBRE());
            consulta.setInt(4, objeto.getIDCATEGORIAPRODUCTO());
            consulta.setString(5, objeto.getCOLOR());
            consulta.setString(6, objeto.getTALLA());
            consulta.setDouble(7, objeto.getPRECIO());
            consulta.setInt(8, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al registrar producto: " + e);
        }

        return respuesta;
    }

    public boolean actualizar(Producto objeto, int IDPRODUCTO) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("update tb_producto set CODIGO= ?, NOMBRE= ?, IDCATEGORIAPRODUCTO = ?, COLOR= ?, TALLA = ?, PRECIO = ?, estado = ? where IDPRODUCTO ='" + IDPRODUCTO + "'");
            consulta.setString(1, objeto.getNOMBRE());
            consulta.setString(2, objeto.getNOMBRE());
            consulta.setInt(3, objeto.getIDCATEGORIAPRODUCTO());
            consulta.setString(4, objeto.getCOLOR());
            consulta.setString(5, objeto.getTALLA());
            consulta.setDouble(6, objeto.getPRECIO());
            consulta.setInt(7, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar producto: " + e);
        }
        return respuesta;
    }

    public boolean eliminar(int IDPRODUCTO) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "delete from tb_producto where IDPRODUCTO ='" + IDPRODUCTO + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar producto: " + e);
        }
        return respuesta;
    }
    
    public DefaultTableModel buscarProducto(String buscar){
        String [] nombresColumnas = {"N","CODIGO","NOMBRE","IDCATEGORIAPRODUCTO","COLOR","TALLA","PRECIO"};
        String [] registros = new String[8];
        DefaultTableModel modelo=new DefaultTableModel(null, nombresColumnas);
        String sql="SELECT * FROM tb_producto WHERE IDPRODUCTO LIKE '%"+buscar+"%' OR NOMBRE LIKE '%" +buscar +"%'";
        Connection cn=null;
        ResultSet rs = null;
        PreparedStatement pst=null;
        try{
            cn=Conexion.conectar();
            pst=cn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                registros[0] = rs.getString("IDPRODUCTO");
                registros[1] = rs.getString("CODIGO");
                registros[2] = rs.getString("NOMBRE");
                registros[3] = rs.getString("IDCATEGORIAPRODUCTO");
                registros[4] = rs.getString("COLOR");
                registros[5] = rs.getString("TALLA");
                registros[6] = rs.getString("PRECIO");
                modelo.addRow(registros);             
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al conectar."+e.getMessage());
        }
        finally{
            try{
                if(rs!=null) rs.close();
                if(pst!=null) pst.close();
                if(cn!=null) cn.close();
            }catch(SQLException e){
                JOptionPane.showMessageDialog(null, e);
            }
        }
        return modelo;
    }
}
