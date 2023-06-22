/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JInternalFrame.java to edit this template
 */
package vista;

import conexion.Conexion;
import controlador.Ctrl_Producto;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Producto;

/**
 *
 * @author julio
 */
public class InterProducto extends javax.swing.JInternalFrame {

    int obtenerIDCATEGORIAPRODUCTOCombo =0;
    public InterProducto() {
        initComponents();
        this.setSize(new Dimension(400, 340));
        this.setTitle("Registrar Producto");
        this.CargarComboCategoriasProducto();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txt_NOMBRE = new javax.swing.JTextField();
        txt_COLOR = new javax.swing.JTextField();
        txt_TALLA = new javax.swing.JTextField();
        txt_PRECIO = new javax.swing.JTextField();
        jComboBox_CATEGORIA = new javax.swing.JComboBox<>();
        jButton_REGISTRAR = new javax.swing.JButton();
        txt_CODIGO = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMinimumSize(new java.awt.Dimension(100, 36));
        setName(""); // NOI18N
        setPreferredSize(new java.awt.Dimension(400, 336));
        addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                formAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jLabel1.setText("Registrar Producto");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nombre:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 90, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Categoría:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 90, 20));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Color:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 150, 90, 20));

        jLabel7.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Talla:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 180, 90, 20));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Precio de venta:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 210, 120, 20));
        getContentPane().add(txt_NOMBRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 90, 200, -1));
        getContentPane().add(txt_COLOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 150, 200, -1));
        getContentPane().add(txt_TALLA, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 180, 200, -1));
        getContentPane().add(txt_PRECIO, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 210, 200, -1));

        jComboBox_CATEGORIA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione Categoría" }));
        getContentPane().add(jComboBox_CATEGORIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 120, 200, -1));

        jButton_REGISTRAR.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jButton_REGISTRAR.setText("REGISTRAR");
        jButton_REGISTRAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_REGISTRARActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_REGISTRAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, 110, 30));
        getContentPane().add(txt_CODIGO, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 200, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setText("Codigo:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(73, 60, 60, -1));

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_formAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_formAncestorAdded

    private void jButton_REGISTRARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_REGISTRARActionPerformed
        Producto producto = new Producto();
        Ctrl_Producto controlProducto = new Ctrl_Producto();
        String categoria = "";
        categoria = jComboBox_CATEGORIA.getSelectedItem().toString().trim();
        if (txt_CODIGO.getText().equals("") ||txt_NOMBRE.getText().equals("") || txt_COLOR.getText().equals("") || 
                txt_TALLA.getText().equals("") || txt_PRECIO.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
            
        } else{
            if (categoria.equalsIgnoreCase("Seleccione categoria:")) {
                        JOptionPane.showMessageDialog(null, "Seleccione categoria");
                    } else {
                        try {
                            producto.setCODIGO(txt_CODIGO.getText().trim());
                            producto.setNOMBRE(txt_NOMBRE.getText().trim());     
                            this.IdCategoriaProducto();
                            producto.setIDCATEGORIAPRODUCTO(obtenerIDCATEGORIAPRODUCTOCombo);
                            producto.setCOLOR(txt_COLOR.getText().trim());
                            producto.setTALLA(txt_TALLA.getText().trim());
                            String precioTXT = "";
                            double Precio = 0.0;
                            precioTXT = txt_PRECIO.getText().trim();
                            boolean aux = false;
                            for (int i = 0; i < precioTXT.length(); i++) {
                                if (precioTXT.charAt(i) == ',') {
                                    String precioNuevo = precioTXT.replace(",", ".");
                                    Precio = Double.parseDouble(precioNuevo);
                                    aux = true;
                                }
                            }
                            //evaluar la condicion
                            if (aux == true) {
                                producto.setPRECIO(Precio);
                            } else {
                                Precio = Double.parseDouble(precioTXT);
                                producto.setPRECIO(Precio);
                            }
                            producto.setEstado(1);

                            if (controlProducto.guardar(producto)) {
                                JOptionPane.showMessageDialog(null, "Registro Guardado");
                                //CARGARCATEGORIAS
                                this.CargarComboCategoriasProducto();
                             
                                this.Limpiar();
                            } else {
                                JOptionPane.showMessageDialog(null, "Error al Guardar");
                            }

                        } catch (HeadlessException | NumberFormatException e) {
                            System.out.println("Error en: " + e);
                        }
                    }
            
        }
            
    }//GEN-LAST:event_jButton_REGISTRARActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_REGISTRAR;
    private javax.swing.JComboBox<String> jComboBox_CATEGORIA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txt_CODIGO;
    private javax.swing.JTextField txt_COLOR;
    private javax.swing.JTextField txt_NOMBRE;
    private javax.swing.JTextField txt_PRECIO;
    private javax.swing.JTextField txt_TALLA;
    // End of variables declaration//GEN-END:variables

     private void Limpiar() {
        txt_CODIGO.setText("");
        txt_NOMBRE.setText("");
        txt_COLOR.setText("");
        txt_TALLA.setText("");
        txt_PRECIO.setText("");
    }
     
     
     private void CargarComboCategoriasProducto() {
        Connection cn = Conexion.conectar();
        String sql = "select * from tb_categoria_producto";
        Statement st;

        try {

            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            jComboBox_CATEGORIA.removeAllItems();
            jComboBox_CATEGORIA.addItem("Seleccione categoria:");
            while (rs.next()) {
                jComboBox_CATEGORIA.addItem(rs.getString("NOMBRE"));
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("Error al cargar categorias");
        }
    }
    private int IdCategoriaProducto() {
        String sql = "select * from tb_categoria_producto where NOMBRE = '" + this.jComboBox_CATEGORIA.getSelectedItem() + "'";
        Statement st;
        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                obtenerIDCATEGORIAPRODUCTOCombo = rs.getInt("IDCATEGORIAPRODUCTO");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener IDCATEGORIAPRODUCTO");
        }
        return obtenerIDCATEGORIAPRODUCTOCombo;
    }


}


