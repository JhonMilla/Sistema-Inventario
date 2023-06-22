/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controlador;

import vista.InterCliente;
import vista.InterEmpleado;
import vista.InterProducto;

/**
 *
 * @author GIGABYTE
 */
public class ImagenFondo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        new InterCliente().setVisible(true);
        new InterEmpleado().setVisible(true);
        new InterProducto().setVisible(true);
    }
//        jl1.setSize(btn_ventas.getWidth()*3, btn_ventas.getHeight());
//        
//        ImageIcon ii = new ImageIcon(getClass().getResource("/imagenes/matixayoutube.png"));
//        Icon i = new ImageIcon(ii.getImage().getScaledInstance(jl1.getWidth(), jl1.getHeight(), Image.SCALE_DEFAULT));
//
//        jl1.setIcon(i);      
//    
}