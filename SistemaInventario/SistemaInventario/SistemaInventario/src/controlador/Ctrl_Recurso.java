package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Recursos;

public class Ctrl_Recurso {
    public boolean guardar(Recursos objeto) {
        boolean respuesta = false;
        //Base de datos 
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("insert into tb_recursos values(?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setString(2, objeto.getCODIGO());
            consulta.setString(3, objeto.getNOMBRE());
            consulta.setInt(4, objeto.getIDCATEGORIARECURSO());
            consulta.setString(5, objeto.getDESCRIPCION());
            consulta.setString(6, objeto.getCOLOR());
            consulta.setInt(7, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al registrar recurso: " + e);

        }

        return respuesta;
    }

    public boolean actualizar(Recursos objeto, int IDRECURSO) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement("update tb_recursos set CODIGO= ?, NOMBRE= ?, IDCATEGORIARECURSOS = ?, COLOR= ?, DESCRIPCION = ?, Estado = ? where IDRECURSO ='" + IDRECURSO + "'");
            consulta.setString(1, objeto.getCODIGO());
            consulta.setString(2, objeto.getNOMBRE());
            consulta.setInt(3, objeto.getIDCATEGORIARECURSO());
            consulta.setString(4, objeto.getCOLOR());
            consulta.setString(5, objeto.getDESCRIPCION());
            consulta.setInt(6, objeto.getEstado());

            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al actualizar recurso: " + e);
        }
        return respuesta;
    }

    public boolean eliminar(int IDRECURSO) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {
            PreparedStatement consulta = cn.prepareStatement(
                    "delete from tb_recursos where IDRECURSO ='" + IDRECURSO + "'");
            consulta.executeUpdate();
            if (consulta.executeUpdate() > 0) {
                respuesta = true;
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al eliminar recurso: " + e);
        }
        return respuesta;
    }
    
    public DefaultTableModel buscarRecursos(String buscar){
        String [] nombresColumnas = {"N","CODIGO","NOMBRE","IDCATEGORIARECURSOS","DESCRIPCION","COLOR"};
        String [] registros = new String[6];
        DefaultTableModel modelo=new DefaultTableModel(null, nombresColumnas);
        String sql="SELECT * FROM tb_recursos WHERE IDRECURSO LIKE '%"+buscar+"%' OR NOMBRE LIKE '%" +buscar +"%'";
        Connection cn=null;
        ResultSet rs = null;
        PreparedStatement pst=null;
        try{
            cn=Conexion.conectar();
            pst=cn.prepareStatement(sql);
            rs=pst.executeQuery();
            while(rs.next()){
                registros[0] = rs.getString("IDRECURSO");
                registros[1] = rs.getString("CODIGO");
                registros[2] = rs.getString("NOMBRE");
                registros[3] = rs.getString("IDCATEGORIARECURSOS");
                registros[4] = rs.getString("DESCRIPCION");
                registros[5] = rs.getString("COLOR");
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
