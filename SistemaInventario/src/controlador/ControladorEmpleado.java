package controlador;

import conexion.Conexion;
import modelo.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ControladorEmpleado {

    public boolean guardar(Empleado objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("insert into tb_empleado values(?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setString(2, objeto.getNombre());
            consulta.setString(3, objeto.getApellido());
            consulta.setString(4, objeto.getDni());
            consulta.setString(5, objeto.getTelefono());
            consulta.setString(6, objeto.getDireccion());
            consulta.setString(7, objeto.getCargo());
            consulta.setInt(8, objeto.getEstado());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al guardar empleado: " + e);
        }
        return respuesta;
    }

    public boolean existeEmpleado(String dni) {
        boolean respuesta = false;
        String sql = "select DNI from tb_empleado where DNI = '" + dni + "';";
        Statement st;
        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                respuesta = true;
            }
        } catch (SQLException e) {
            System.out.println("Error al consultar empleado: " + e);
        }
        return respuesta;
    }

    public boolean actualizar(Empleado objeto, int idEmpleado) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("update tb_empleado set nombre=?, apellido = ?, DNI = ?, telefono= ?, direccion = ?, cargo= ?, estado = ? where idEmpleado ='" + idEmpleado + "'");
            consulta.setString(1, objeto.getNombre());
            consulta.setString(2, objeto.getApellido());
            consulta.setString(3, objeto.getDni());
            consulta.setString(4, objeto.getTelefono());
            consulta.setString(5, objeto.getDireccion());
            consulta.setString(6, objeto.getCargo());
            consulta.setInt(7, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar empleado: " + e);
        }
        return respuesta;
    }

    public boolean eliminar(int idEmpleado) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "delete from tb_empleado where idEmpleado ='" + idEmpleado + "'");
            consulta.executeUpdate();

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar empleado: " + e);
        }
        return respuesta;
    }
    
    public DefaultTableModel buscarEmpleado(String buscar){
        String [] nombresColumnas = {"N","Nombre","Apellido","DNI","Telefono","Direccion","Cargo"};
        String [] registros = new String[7];
        DefaultTableModel modelo=new DefaultTableModel(null, nombresColumnas);
        String sql="SELECT * FROM tb_empleado WHERE idEmpleado LIKE '%"+buscar+"%' OR nombre LIKE '%" +buscar +"%'";
        Connection cn=null;
        ResultSet rs = null;
        PreparedStatement pst=null;
        try{
            cn=Conexion.conectar();
            pst=cn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                registros[0] = rs.getString("idEmpleado");
                registros[1] = rs.getString("nombre");
                registros[2] = rs.getString("apellido");
                registros[3] = rs.getString("DNI");
                registros[4] = rs.getString("direccion");
                registros[5] = rs.getString("telefono");
                registros[6] = rs.getString("cargo");
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
