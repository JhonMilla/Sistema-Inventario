
package vista;

import conexion.Conexion;
import controlador.Ctrl_Proveedores;
import java.awt.Dimension;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import modelo.Proveedores;


public class InterProveedores extends javax.swing.JInternalFrame {

    int obtenerIDCATEGORIARECURSOSCombo =0;
    public InterProveedores() {
        initComponents();
        this.setSize(new Dimension(400, 313));
        this.setTitle("Registrar Proveedores");
        this.CargarComboCategoriasRecursos();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_RUC = new javax.swing.JTextField();
        txt_DIRECCION = new javax.swing.JTextField();
        txt_TELEFONO = new javax.swing.JTextField();
        txt_ESTADO = new javax.swing.JTextField();
        jButton_Guardar = new javax.swing.JButton();
        txt_NOMBRE = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jComboBox_CATEGORIA = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        txt_CALIFICACION = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("sansserif", 1, 18)); // NOI18N
        jLabel1.setText("Proveedores");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 0, -1, -1));

        jLabel2.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("RUC:");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 60, 70, -1));

        jLabel3.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Empresa:");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 30, 70, 20));

        jLabel5.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Dirección:");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 90, 90, -1));

        jLabel6.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Teléfono:");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 120, 70, -1));

        jLabel7.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Estado:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 80, -1));
        getContentPane().add(txt_RUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 170, -1));
        getContentPane().add(txt_DIRECCION, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 170, -1));
        getContentPane().add(txt_TELEFONO, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 120, 170, -1));
        getContentPane().add(txt_ESTADO, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 180, 170, -1));

        jButton_Guardar.setFont(new java.awt.Font("sansserif", 1, 14)); // NOI18N
        jButton_Guardar.setText("GUARDAR");
        jButton_Guardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_GuardarActionPerformed(evt);
            }
        });
        getContentPane().add(jButton_Guardar, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 250, 100, 30));
        getContentPane().add(txt_NOMBRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 30, 170, -1));

        jLabel8.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel8.setText("Materia Prima:");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 150, -1, -1));

        jComboBox_CATEGORIA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione:", "Item 1", "Item 2", "Item 3", "Item 4" }));
        getContentPane().add(jComboBox_CATEGORIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 150, 170, 20));

        jLabel10.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel10.setText("Calificación:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 210, 90, -1));
        getContentPane().add(txt_CALIFICACION, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 210, 170, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_GuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_GuardarActionPerformed

        Proveedores proveedores = new Proveedores();
        Ctrl_Proveedores controlProveedores = new Ctrl_Proveedores();
        String categoria = "";
        categoria = jComboBox_CATEGORIA.getSelectedItem().toString().trim();
        if (txt_NOMBRE.getText().equals("") || txt_RUC.getText().equals("") || txt_DIRECCION.getText().equals("") 
            || txt_TELEFONO.getText().equals("") || txt_ESTADO.getText().equals("")|| txt_CALIFICACION.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
        } else {
            try {
                proveedores.setNOMBRE(txt_NOMBRE.getText().trim());
                proveedores.setRUC(txt_RUC.getText().trim());
                proveedores.setDIRECCION(txt_DIRECCION.getText().trim());
                proveedores.setTELEFONO(txt_TELEFONO.getText().trim());
                this.IdCategoriaRecursos();
                proveedores.setIDCATEGORIARECURSO(obtenerIDCATEGORIARECURSOSCombo);
                proveedores.setESTADO(txt_ESTADO.getText().trim());
                proveedores.setCALIFICACION(txt_CALIFICACION.getText().trim());
                proveedores.setStdo(1);

                if (controlProveedores.guardar(proveedores)) {
                    JOptionPane.showMessageDialog(null, "Registro Guardado");                   
                    this.Limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Guardar");
                }

            } catch (HeadlessException | NumberFormatException e) {
                System.out.println("Error en: " + e);
            }
        }
    }//GEN-LAST:event_jButton_GuardarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_Guardar;
    private javax.swing.JComboBox<String> jComboBox_CATEGORIA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField txt_CALIFICACION;
    private javax.swing.JTextField txt_DIRECCION;
    private javax.swing.JTextField txt_ESTADO;
    private javax.swing.JTextField txt_NOMBRE;
    private javax.swing.JTextField txt_RUC;
    private javax.swing.JTextField txt_TELEFONO;
    // End of variables declaration//GEN-END:variables

    private void Limpiar() {
        txt_NOMBRE.setText("");
        txt_RUC.setText("");
        txt_DIRECCION.setText("");
        txt_TELEFONO.setText("");
        jComboBox_CATEGORIA.setSelectedItem("Seleccione:");  
        txt_ESTADO.setText("");
        txt_CALIFICACION.setText("");       
    }
    
    private void CargarComboCategoriasRecursos() {
        Connection cn = Conexion.conectar();
        String sql = "select * from tb_categoria_recursos";
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
    private int IdCategoriaRecursos() {
        String sql = "select * from tb_categoria_recursos where NOMBRE = '" + this.jComboBox_CATEGORIA.getSelectedItem() + "'";
        Statement st;
        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                obtenerIDCATEGORIARECURSOSCombo = rs.getInt("IDCATEGORIARECURSOS");
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener IDCATEGORIARECURSOS");
        }
        return obtenerIDCATEGORIARECURSOSCombo;
    }
}
