package vista;

import conexion.Conexion;
import controlador.ControladorCliente;
import controlador.Ctrl_Proveedores;
import java.awt.Dimension;
import java.awt.HeadlessException;
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
import modelo.Proveedores;

public class InterGestionarProveedores extends javax.swing.JInternalFrame {

    private int IDPROVEEDORES; //usar metodo actualizar
    int obtenerIDCATEGORIARECURSOSCombo = 0;
    
    public InterGestionarProveedores() {
        initComponents();
        this.setSize(new Dimension(900, 500));
        this.setTitle("Gestionar Proveedores");
        //Cargar tabla
        this.CargarTablaProveedores();
        this.CargarComboCategoriasRecurso();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_Proveedores = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton_actualizar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_RUC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txt_NOMBRE = new javax.swing.JTextField();
        txt_TELEFONO = new javax.swing.JTextField();
        txt_ESTADO = new javax.swing.JTextField();
        txt_DIRECCION = new javax.swing.JTextField();
        txt_buscar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jComboBox_CATEGORIA = new javax.swing.JComboBox<>();
        jLabel7 = new javax.swing.JLabel();
        txt_CALIFICACION = new javax.swing.JTextField();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Gestionar Proveedores");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_Proveedores.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_Proveedores);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 710, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 730, 270));

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
        jPanel2.add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, -1, -1));

        jButton_eliminar.setBackground(new java.awt.Color(255, 51, 51));
        jButton_eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, 90, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 130, 270));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("RUC:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, -1));

        txt_RUC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_RUC, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 170, -1));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Empresa:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 90, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Estado:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 90, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Dirección:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 90, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Teléfono:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 90, -1));

        txt_NOMBRE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_NOMBRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 170, -1));

        txt_TELEFONO.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_TELEFONO, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 170, -1));

        txt_ESTADO.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_ESTADO, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 170, -1));

        txt_DIRECCION.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_DIRECCION, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 170, -1));

        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
            }
        });
        jPanel3.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 70, 170, -1));

        jLabel8.setFont(new java.awt.Font("Calisto MT", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Buscar:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 70, 70, -1));

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Materia Prima:");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 70, 100, -1));

        jComboBox_CATEGORIA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(jComboBox_CATEGORIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 170, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setText("Calificación:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 40, 80, -1));
        jPanel3.add(txt_CALIFICACION, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 40, 170, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 870, 100));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 890, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
        Proveedores proveedores = new Proveedores();
        Ctrl_Proveedores controlProveedores = new Ctrl_Proveedores();
        String categoria = "";
        categoria = jComboBox_CATEGORIA.getSelectedItem().toString().trim();
        if (txt_NOMBRE.getText().equals("") || txt_RUC.getText().equals("")
                || txt_DIRECCION.getText().equals("") || txt_TELEFONO.getText().equals("") || txt_ESTADO.getText().equals("")|| txt_CALIFICACION.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
        } else {
            try {
                proveedores.setNOMBRE(txt_NOMBRE.getText().trim());
                proveedores.setRUC(txt_RUC.getText().trim());
                proveedores.setDIRECCION(txt_DIRECCION.getText().trim());
                proveedores.setTELEFONO(txt_TELEFONO.getText().trim());
                this.IdCategoriaRecurso();
                proveedores.setIDCATEGORIARECURSO(obtenerIDCATEGORIARECURSOSCombo);
                proveedores.setESTADO(txt_ESTADO.getText().trim());
                proveedores.setCALIFICACION(txt_CALIFICACION.getText().trim());
                proveedores.setStdo(1);

                if (controlProveedores.actualizar(proveedores,IDPROVEEDORES)) {
                    JOptionPane.showMessageDialog(null, "Registro Actualizado");
                    //CARGARServicios
                    this.CargarTablaProveedores();
                    this.Limpiar();
                } else {
                    JOptionPane.showMessageDialog(null, "Error al Actualizar");
                }

            } catch (HeadlessException | NumberFormatException e) {
                System.out.println("Error en: " + e);
            }
        }
    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
        Ctrl_Proveedores controlProveedores = new Ctrl_Proveedores();
        if (IDPROVEEDORES == 0) {
            JOptionPane.showMessageDialog(null, "¡Seleccione un Proveedores!");
        } else {
            if (!controlProveedores.eliminar(IDPROVEEDORES)) {
                JOptionPane.showMessageDialog(null, "¡Proveedor Eliminado!");
                this.CargarTablaProveedores();
                this.Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "¡Error al eliminar proveedores!");
            }
        }
    }//GEN-LAST:event_jButton_eliminarActionPerformed

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
        BuscarProveedores(txt_buscar.getText());
    }//GEN-LAST:event_txt_buscarKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton_actualizar;
    private javax.swing.JButton jButton_eliminar;
    private javax.swing.JComboBox<String> jComboBox_CATEGORIA;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_Proveedores;
    private javax.swing.JTextField txt_CALIFICACION;
    private javax.swing.JTextField txt_DIRECCION;
    private javax.swing.JTextField txt_ESTADO;
    private javax.swing.JTextField txt_NOMBRE;
    private javax.swing.JTextField txt_RUC;
    private javax.swing.JTextField txt_TELEFONO;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables

    private void Limpiar() {
        txt_RUC.setText("");
        txt_NOMBRE.setText("");
        txt_DIRECCION.setText("");
        txt_TELEFONO.setText("");
        jComboBox_CATEGORIA.setSelectedItem("Seleccione:");
        txt_ESTADO.setText("");
        txt_CALIFICACION.setText("");
    }
    
    String NombreCategoriaRecurso = "";
    
    private void CargarComboCategoriasRecurso() {
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
      
    private void CargarTablaProveedores() {
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "select p.IDPROVEEDORES, p.NOMBRE, c.NOMBRE, p.RUC, p.DIRECCION, p.TELEFONO, p.ESTADO, p.CALIFICACION, p.Stdo from tb_proveedores As p, tb_categoria_recursos As c where p.IDCATEGORIARECURSOS = c.IDCATEGORIARECURSOS";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterGestionarProveedores.jTable_Proveedores = new JTable(model);
            InterGestionarProveedores.jScrollPane1.setViewportView(InterGestionarProveedores.jTable_Proveedores);

            model.addColumn("N°");//ID
            model.addColumn("NOMBRE");
            model.addColumn("RUC");
            model.addColumn("DIRECCION");
            model.addColumn("TELEFONO");
            model.addColumn("CATEGORIA");
            model.addColumn("ESTADO");
            model.addColumn("CALIFICACION");
            model.addColumn("Stdo");

            while (rs.next()) {

                Object fila[] = new Object[9];
                for (int i = 0; i < 9; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla Proveedores: " + e);
        }
        //evento para obtener campo al cual el usuario da click
        //y obtener la interfaz que mostrara la informacion general
        jTable_Proveedores.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_Proveedores.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    IDPROVEEDORES = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosProveedoresSeleccionado(IDPROVEEDORES);//metodo
                }
            }
        });
    }

    private void EnviarDatosProveedoresSeleccionado(int IDPROVEEDORES) {
        try {
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement(
                    "select * from tb_proveedores where IDPROVEEDORES = '" + IDPROVEEDORES + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txt_NOMBRE.setText(rs.getString("NOMBRE"));
                txt_RUC.setText(rs.getString("RUC"));
                txt_DIRECCION.setText(rs.getString("DIRECCION"));
                txt_TELEFONO.setText(rs.getString("TELEFONO"));
                int idCateRec = rs.getInt("IDCATEGORIARECURSOS");
                jComboBox_CATEGORIA.setSelectedItem(relacionarCategoria(idCateRec));
                txt_ESTADO.setText(rs.getString("ESTADO"));
                txt_CALIFICACION.setText(rs.getString("CALIFICACION"));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar Proveedores: " + e);
        }
    }
    
    public void BuscarProveedores(String buscar){
        Ctrl_Proveedores ctrl_Proveedores =new Ctrl_Proveedores();
        DefaultTableModel modelo=ctrl_Proveedores.buscarProveedor(buscar);
        jTable_Proveedores.setModel(modelo);
    }
    
    private String relacionarCategoria(int IDCATEGORIARECURSOS) {

        String sql = "select NOMBRE from tb_categoria_recursos where IDCATEGORIARECURSOS = '" + IDCATEGORIARECURSOS + "'";
        Statement st;
        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                NombreCategoriaRecurso = rs.getString("NOMBRE");
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("¡Error al obtener el id de la categoria!");
        }
        return NombreCategoriaRecurso;
    }

    /**
     *
     * Metodo para obtener id categoria
     */
    private int IdCategoriaRecurso() {
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
