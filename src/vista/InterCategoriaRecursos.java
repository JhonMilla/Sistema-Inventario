
package vista;

import controlador.Ctrl_CategoriaRecursos;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import modelo.CategoriaRecursos;

/**
     * @autor Xiomara
     */

public class InterCategoriaRecursos extends javax.swing.JInternalFrame {

    /**
     * Creates new form InterCategoriaProducto
     */
    public InterCategoriaRecursos() {
        initComponents();
        this.setSize(new Dimension(400, 350));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_NOMBRE = new javax.swing.JTextField();
        jButton_GUARDAR = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(400, 200));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setText("Categoría Materia Prima");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 10, -1, -1));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Nombre:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 50, 69, -1));
        getContentPane().add(txt_NOMBRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 50, 170, -1));

        jButton_GUARDAR.setBackground(new java.awt.Color(0, 102, 255));
        jButton_GUARDAR.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButton_GUARDAR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Registrar.jpg"))); // NOI18N
        jButton_GUARDAR.setText("GUARDAR");
        jButton_GUARDAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GUARDARActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_GUARDAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 120, 140, 40));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_GUARDARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GUARDARActionPerformed
        CategoriaRecursos categoriaRecursos = new CategoriaRecursos();
        Ctrl_CategoriaRecursos controlCategoriaRecursos = new Ctrl_CategoriaRecursos();

        //validamos camoos vacios
        if (txt_NOMBRE.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Complete  todos los campos");
        } else {
            if (!controlCategoriaRecursos.existeCategoriaRecursos(txt_NOMBRE.getText().trim())) {
                categoriaRecursos.setNOMBRE(txt_NOMBRE.getText().trim());
                categoriaRecursos.setEstado(1);
                if (controlCategoriaRecursos.guardar(categoriaRecursos)) {
                    JOptionPane.showMessageDialog(null, "Registro Guardado");
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Guardar");
                }
            } else {
                JOptionPane.showMessageDialog(null, "La Categoria ya esta registrada en la Base de Datos");
            }
        }
        //limpiar campo
        txt_NOMBRE.setText("");
        
        
    }//GEN-LAST:event_jButton_GUARDARActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_GUARDAR;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JTextField txt_NOMBRE;
    // End of variables declaration//GEN-END:variables
}
