package vista;

import conexion.Conexion;
import controlador.Ctrl_CategoriaRecursos;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import modelo.CategoriaRecursos;

/**
 *
 * @author ediso
 */
public class InterGestionarCategoriaRecursos extends javax.swing.JInternalFrame {

    private int IDCATEGORIARECURSOS;

    public InterGestionarCategoriaRecursos() {
        initComponents();
        this.setSize(new Dimension(600, 400));
        this.setTitle("Gestionar Categorias Recursos");
        //Cargar tabla
        this.CargarTablaCategoriasRecursos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_categoriasRecursos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton_actualizar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_NOMBRE = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Administrar Categorias Recursos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 10, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_categoriasRecursos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable_categoriasRecursos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 330, 230));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 350, 250));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_actualizar.setBackground(new java.awt.Color(51, 204, 0));
        jButton_actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_actualizar.setText("Actualizar");
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, 20));

        jButton_eliminar.setBackground(new java.awt.Color(255, 51, 51));
        jButton_eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 90, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 60, 130, 80));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("Nombre:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, -1, -1));

        txt_NOMBRE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_NOMBRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 170, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, 190, 80));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
        if (!txt_NOMBRE.getText().isEmpty()) {
            CategoriaRecursos categoriaRecursos = new CategoriaRecursos();
            Ctrl_CategoriaRecursos controlCategoriaRecursos = new Ctrl_CategoriaRecursos();

            categoriaRecursos.setNOMBRE(txt_NOMBRE.getText().trim());
            if (controlCategoriaRecursos.actualizar(categoriaRecursos, IDCATEGORIARECURSOS)) {
                JOptionPane.showMessageDialog(null, "Categoria Recursos Actulizada");
                txt_NOMBRE.setText("");
                this.CargarTablaCategoriasRecursos();
            } else {
                JOptionPane.showMessageDialog(null, "Error al actualizar Categoria");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una categoria");
        }
    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
        if (!txt_NOMBRE.getText().isEmpty()) {
            CategoriaRecursos categoriaRecursos = new CategoriaRecursos();
            Ctrl_CategoriaRecursos controlCategoriaRecursos = new Ctrl_CategoriaRecursos();

            categoriaRecursos.setNOMBRE(txt_NOMBRE.getText().trim());
            if (!controlCategoriaRecursos.eliminar(IDCATEGORIARECURSOS)) {
                JOptionPane.showMessageDialog(null, "Categoria Eliminada");
                txt_NOMBRE.setText("");
                this.CargarTablaCategoriasRecursos();
            } else {
                JOptionPane.showMessageDialog(null, "Error al Eliminar Categoria");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Seleccione una categoria");
        }
    }//GEN-LAST:event_jButton_eliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_categoriasRecursos;
    private javax.swing.JTextField txt_NOMBRE;
    // End of variables declaration//GEN-END:variables

    /*
     * *****************************************************
     * metodo para mostrar todos las categorias registradas
     * *****************************************************
     */
    private void CargarTablaCategoriasRecursos() {
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "select IDCATEGORIARECURSOS, NOMBRE, ESTADO from tb_categoria_recursos";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterGestionarCategoriaRecursos.jTable_categoriasRecursos = new JTable(model);
            InterGestionarCategoriaRecursos.jScrollPane1.setViewportView(InterGestionarCategoriaRecursos.jTable_categoriasRecursos);

            model.addColumn("IDCATEGORIARECURSOS");
            model.addColumn("NOMBRE");
            model.addColumn("ESTADO");

            while (rs.next()) {
                Object fila[] = new Object[3];
                for (int i = 0; i < 3; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla categorias: " + e);
        }
        jTable_categoriasRecursos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_categoriasRecursos.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    IDCATEGORIARECURSOS = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosCategoriaRecursosSeleccionada(IDCATEGORIARECURSOS);
                }
            }
        });      
    }
    private void EnviarDatosCategoriaRecursosSeleccionada(int IDCATEGORIARECURSOS) {
        try {
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement(
                    "select * from tb_categoria_recursos where IDCATEGORIARECURSOS = '" + IDCATEGORIARECURSOS + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txt_NOMBRE.setText(rs.getString("NOMBRE"));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar categoria: " + e);
        }
    }
       

}
