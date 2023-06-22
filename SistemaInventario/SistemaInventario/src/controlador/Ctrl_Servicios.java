
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Servicios;

public class Ctrl_Servicios {
    public boolean guardar(Servicios objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("insert into tb_servicio values(?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setString(2, objeto.getNOMBRE());
            consulta.setString(3, objeto.getAPELLIDO());
            consulta.setString(4, objeto.getDNI());
            consulta.setString(5, objeto.getDIRECCION());
            consulta.setString(6, objeto.getTELEFONO());
            consulta.setString(7, objeto.getESTADO());
            consulta.setInt(8, objeto.getStdo());
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al guardar Servicio: " + e);
        }

        return respuesta;
    }
     public boolean actualizar(Servicios objeto, int IDSERVICIOS) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("update tb_servicio set NOMBRE = ?, APELLIDO = ?, DNI= ?, DIRECCION= ?, TELEFONO = ?, ESTADO = ?, Stdo= ? where IDSERVICIOS ='" + IDSERVICIOS + "'");
            consulta.setString(1, objeto.getNOMBRE());
            consulta.setString(2, objeto.getAPELLIDO());
            consulta.setString(3, objeto.getDNI());
            consulta.setString(4, objeto.getDIRECCION());
            consulta.setString(5, objeto.getTELEFONO());
            consulta.setString(6, objeto.getESTADO());
            consulta.setInt(7, objeto.getStdo());
           
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar Servicios: " + e);
        }
        return respuesta;
    }
    public boolean eliminar(int IDSERVICIOS) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "delete from tb_servicio where IDSERVICIOS ='" + IDSERVICIOS + "'");
            consulta.executeUpdate();
           
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar Servicio: " + e);
        }
        return respuesta;
    }
    
    public DefaultTableModel buscarServicios(String buscar){
        String [] nombresColumnas = {"N","Nombre","Apellido","DNI","Direccion","Telefono","Estado"};
        String [] registros = new String[7];
        DefaultTableModel modelo=new DefaultTableModel(null, nombresColumnas);
        String sql="SELECT * FROM tb_servicio WHERE IDSERVICIOS LIKE '%"+buscar+"%' OR NOMBRE LIKE '%" +buscar +"%'";
        Connection cn=null;
        ResultSet rs = null;
        PreparedStatement pst=null;
        try{
            cn=Conexion.conectar();
            pst=cn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                registros[0] = rs.getString("IDSERVICIOS");
                registros[1] = rs.getString("NOMBRE");
                registros[2] = rs.getString("APELLIDO");
                registros[3] = rs.getString("DNI");
                registros[4] = rs.getString("DIRECCION");
                registros[5] = rs.getString("TELEFONO");
                registros[6] = rs.getString("ESTADO");
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
