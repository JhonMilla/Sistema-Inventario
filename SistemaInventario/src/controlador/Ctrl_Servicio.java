/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import modelo.Servicios;

/**
 *
 * @author julio
 */
public class Ctrl_Servicio {
    public boolean guardar(Servicios objeto) {
        boolean respuesta = false;
        Connection cn = Conexion.conectar();
        try {

            PreparedStatement consulta = cn.prepareStatement("insert into tb_servicio values(?,?,?,?,?,?,?,?)");
            consulta.setInt(1, 0);//id
            consulta.setString(2, objeto.getDNI());
            consulta.setString(3, objeto.getNOMBRE());
            consulta.setString(4, objeto.getAPELLIDO());
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

            PreparedStatement consulta = cn.prepareStatement("update tb_servicio set DNI = ?, NOMBRE = ?, APELLIDO= ?, DIRECCION = ?, TELEFONO = ?, ESTADO =?, Stdo = ? where IDSERVICIOS ='" + IDSERVICIOS + "'");
            consulta.setString(1, objeto.getDNI());
            consulta.setString(2, objeto.getNOMBRE());
            consulta.setString(3, objeto.getAPELLIDO());
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
      
    
    
    
}
