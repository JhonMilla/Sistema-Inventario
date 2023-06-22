
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Proveedores;

public class Ctrl_Proveedores {
    public boolean guardar(Proveedores objeto) {
        boolean respuesta = false;
        Connection cn = conexion.Conexion.conectar();
        try {
            
             PreparedStatement consulta = cn.prepareStatement("insert into tb_proveedores values(?,?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setString(2, objeto.getNOMBRE());
            consulta.setString(3, objeto.getRUC());
            consulta.setString(4, objeto.getDIRECCION());
            consulta.setString(5, objeto.getTELEFONO());
            consulta.setInt(6, objeto.getIDCATEGORIARECURSO());
            consulta.setString(7, objeto.getESTADO());
            consulta.setString(8, objeto.getCALIFICACION());
            consulta.setInt(9, objeto.getStdo());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }

            cn.close();
             } catch (SQLException e) {
            System.out.println("Error al guardar Proveedores: " + e);
        }

        return respuesta;
    }
     public boolean actualizar(Proveedores objeto, int IDPROVEEDORES) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("update tb_proveedores set NOMBRE = ?, RUC = ?,DIRECCION = ?, TELEFONO = ?, IDCATEGORIARECURSOS = ?, ESTADO = ?, CALIFICACION = ?, Stdo= ? where IDPROVEEDORES ='" + IDPROVEEDORES + "'");
            consulta.setString(1, objeto.getNOMBRE());
            consulta.setString(2, objeto.getRUC());
            consulta.setString(3, objeto.getDIRECCION());
            consulta.setString(4, objeto.getTELEFONO());
            consulta.setInt(5, objeto.getIDCATEGORIARECURSO());
            consulta.setString(6, objeto.getESTADO());
            consulta.setString(7, objeto.getCALIFICACION());
            consulta.setInt(8, objeto.getStdo());
         
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar Proveedores: " + e);
        }
        return respuesta;
    }
    public boolean eliminar(int IDPROVEEDORES) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "delete from tb_proveedores where IDPROVEEDORES ='" + IDPROVEEDORES + "'");
            consulta.executeUpdate();
           
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar Proveedores: " + e);
        }
        return respuesta;
    }
    
    public DefaultTableModel buscarProveedor(String buscar){
        String [] nombresColumnas = {"N","Nombre","RUC","Direccion","Telefono","IDCATEGORIARECURSOS","Estado","Calificacion"};
        String [] registros = new String[9];
        DefaultTableModel modelo=new DefaultTableModel(null, nombresColumnas);
        String sql="SELECT * FROM tb_proveedores WHERE IDPROVEEDORES LIKE '%"+buscar+"%' OR NOMBRE LIKE '%" +buscar +"%'";
        Connection cn=null;
        ResultSet rs = null;
        PreparedStatement pst=null;
        try{
            cn=Conexion.conectar();
            pst=cn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                registros[0] = rs.getString("IDPROVEEDORES");
                registros[1] = rs.getString("NOMBRE");
                registros[2] = rs.getString("RUC");
                registros[3] = rs.getString("DIRECCION");
                registros[4] = rs.getString("TELEFONO");
                registros[5] = rs.getString("IDCATEGORIARECURSOS");
                registros[6] = rs.getString("ESTADO");
                registros[7] = rs.getString("CALIFICACION");
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
