package vista;

import conexion.Conexion;
import controlador.ControladorCliente;
import controlador.Ctrl_Producto;
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
import modelo.Producto;

public class InterGestionarProducto extends javax.swing.JInternalFrame {

    private int IDPRODUCTO; //usar metodo actualizar
    int obtenerIDCATEGORIAPRODUCTOCombo = 0;

    public InterGestionarProducto() {
        initComponents();
        this.setSize(new Dimension(900, 500));
        this.setTitle("Gestionar Productos");
        //Cargar tabla
        this.CargarTablaProductos();
        this.CargarComboCategoriasProducto();

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable_productos = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jButton_actualizar = new javax.swing.JButton();
        jButton_eliminar = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        txt_NOMBRE = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txt_COLOR = new javax.swing.JTextField();
        txt_TALLA = new javax.swing.JTextField();
        jComboBox_CATEGORIA = new javax.swing.JComboBox<>();
        txt_PRECIO = new javax.swing.JTextField();
        txt_buscar = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        txt_CODIGO = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel_wallpaper = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Gestionar Productos");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 20, -1, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable_productos.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable_productos);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 710, 250));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 50, 730, 270));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton_actualizar.setBackground(new java.awt.Color(51, 204, 0));
        jButton_actualizar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_actualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Actualizar.jpg"))); // NOI18N
        jButton_actualizar.setText("Actualizar");
        jButton_actualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_actualizarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_actualizar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 130, -1));

        jButton_eliminar.setBackground(new java.awt.Color(255, 51, 51));
        jButton_eliminar.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton_eliminar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/Eliminar.jpg"))); // NOI18N
        jButton_eliminar.setText("Eliminar");
        jButton_eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton_eliminarActionPerformed(evt);
            }
        });
        jPanel2.add(jButton_eliminar, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 70, 130, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 50, 150, 270));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel2.setText("Nombre:");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 90, -1));

        txt_NOMBRE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_NOMBRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 10, 170, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel4.setText("Precio:");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 40, 90, -1));

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("Color:");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 40, 90, -1));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Talla:");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(590, 10, 90, -1));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("Categoria:");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 10, 90, -1));

        txt_COLOR.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_COLOR, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 40, 170, -1));

        txt_TALLA.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_TALLA, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 10, 170, -1));

        jComboBox_CATEGORIA.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jComboBox_CATEGORIA.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Seleccione categoria:", "Item 2", "Item 3", "Item 4" }));
        jPanel3.add(jComboBox_CATEGORIA, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 10, 170, -1));

        txt_PRECIO.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(txt_PRECIO, new org.netbeans.lib.awtextra.AbsoluteConstraints(690, 40, 170, -1));

        txt_buscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_buscarActionPerformed(evt);
            }
        });
        txt_buscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_buscarKeyReleased(evt);
            }
        });
        jPanel3.add(txt_buscar, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 40, 170, -1));

        jLabel8.setFont(new java.awt.Font("Calisto MT", 1, 14)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel8.setText("Buscar:");
        jPanel3.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 40, 70, -1));
        jPanel3.add(txt_CODIGO, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 70, 170, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("Codigo:");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 70, 70, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 870, 100));
        getContentPane().add(jLabel_wallpaper, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 890, 470));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton_actualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_actualizarActionPerformed
        Producto producto = new Producto();
        Ctrl_Producto controlProducto = new Ctrl_Producto();
        String categoria = "";
        categoria = jComboBox_CATEGORIA.getSelectedItem().toString().trim();
        if (txt_CODIGO.getText().equals("") || txt_NOMBRE.getText().equals("") || txt_COLOR.getText().equals("")
                || txt_TALLA.getText().equals("") || txt_PRECIO.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Complete todos los campos");
        } else {
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
                    ////////////////////////////////////

                    if (controlProducto.actualizar(producto, IDPRODUCTO)) {
                        JOptionPane.showMessageDialog(null, "Registro Actualizado");
                        //CARGARCATEGORIAS
                        this.CargarComboCategoriasProducto();
                        this.CargarTablaProductos();
                        this.Limpiar();

                    } else {
                        JOptionPane.showMessageDialog(null, "Error al Actualizar");
                    }

                } catch (HeadlessException | NumberFormatException e) {
                    System.out.println("Error en: " + e);
                }
            }
        }

    }//GEN-LAST:event_jButton_actualizarActionPerformed

    private void jButton_eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton_eliminarActionPerformed
        Ctrl_Producto controlProducto = new Ctrl_Producto();
        if (IDPRODUCTO == 0) {
            JOptionPane.showMessageDialog(null, "¡Seleccione un Producto!");
        } else {
            if (!controlProducto.eliminar(IDPRODUCTO)) {
                JOptionPane.showMessageDialog(null, "¡Producto Eliminado!");
                this.CargarTablaProductos();
                this.CargarComboCategoriasProducto();
                this.Limpiar();
            } else {
                JOptionPane.showMessageDialog(null, "¡Error al eliminar producto!");
            }
        }
    }//GEN-LAST:event_jButton_eliminarActionPerformed

    private void txt_buscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_buscarKeyReleased
        BuscarProducto(txt_buscar.getText());
    }//GEN-LAST:event_txt_buscarKeyReleased

    private void txt_buscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_buscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_buscarActionPerformed


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
    private javax.swing.JLabel jLabel_wallpaper;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    public static javax.swing.JScrollPane jScrollPane1;
    public static javax.swing.JTable jTable_productos;
    private javax.swing.JTextField txt_CODIGO;
    private javax.swing.JTextField txt_COLOR;
    private javax.swing.JTextField txt_NOMBRE;
    private javax.swing.JTextField txt_PRECIO;
    private javax.swing.JTextField txt_TALLA;
    private javax.swing.JTextField txt_buscar;
    // End of variables declaration//GEN-END:variables

    private void Limpiar() {
        txt_CODIGO.setText("");
        txt_NOMBRE.setText("");   
        jComboBox_CATEGORIA.setSelectedItem("Seleccione categoria:");
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

    String NombreCategoriaProducto = "";
    double precio = 0.0;

    private void CargarTablaProductos() {
        Connection con = Conexion.conectar();
        DefaultTableModel model = new DefaultTableModel();
        String sql = "select p.IDPRODUCTO, p.CODIGO, p.NOMBRE, c.NOMBRE, p.COLOR, p.TALLA, p.PRECIO, p.ESTADO from tb_producto As p, tb_categoria_producto As c where p.IDCATEGORIAPRODUCTO = c.IDCATEGORIAPRODUCTO;";
        Statement st;
        try {
            st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            InterGestionarProducto.jTable_productos = new JTable(model);
            InterGestionarProducto.jScrollPane1.setViewportView(InterGestionarProducto.jTable_productos);

            model.addColumn("N°");//ID
            model.addColumn("CODIGO");
            model.addColumn("NOMBRE");
            model.addColumn("CATEGORIA");
            model.addColumn("COLOR");
            model.addColumn("TALLA");
            model.addColumn("PRECIO");
            model.addColumn("ESTADO");

            while (rs.next()) {

                precio = rs.getDouble("PRECIO");

                Object fila[] = new Object[8];
                for (int i = 0; i < 8; i++) {
                    fila[i] = rs.getObject(i + 1);
                }
                model.addRow(fila);
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al llenar la tabla productos: " + e);
        }
        //evento para obtener campo al cual el usuario da click
        //y obtener la interfaz que mostrara la informacion general
        jTable_productos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int fila_point = jTable_productos.rowAtPoint(e.getPoint());
                int columna_point = 0;

                if (fila_point > -1) {
                    IDPRODUCTO = (int) model.getValueAt(fila_point, columna_point);
                    EnviarDatosProductoSeleccionado(IDPRODUCTO);//metodo
                }
            }
        });
    }

    private void EnviarDatosProductoSeleccionado(int IDPRODUCTO) {
        try {
            Connection con = Conexion.conectar();
            PreparedStatement pst = con.prepareStatement(
                    "select * from tb_producto where IDPRODUCTO = '" + IDPRODUCTO + "'");
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                txt_CODIGO.setText(rs.getString("CODIGO"));
                txt_NOMBRE.setText(rs.getString("NOMBRE"));
                int idCatePro = rs.getInt("IDCATEGORIAPRODUCTO");
                jComboBox_CATEGORIA.setSelectedItem(relacionarCategoria(idCatePro));
                txt_COLOR.setText(rs.getString("COLOR"));
                txt_TALLA.setText(rs.getString("TALLA"));
                txt_PRECIO.setText(rs.getString("PRECIO"));
            }
            con.close();
        } catch (SQLException e) {
            System.out.println("Error al seleccionar producto: " + e);
        }
    }

    private String relacionarCategoria(int IDCATEGORIAPRODUCTO) {

        String sql = "select NOMBRE from tb_categoria_producto where IDCATEGORIAPRODUCTO = '" + IDCATEGORIAPRODUCTO + "'";
        Statement st;
        try {
            Connection cn = Conexion.conectar();
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                NombreCategoriaProducto = rs.getString("NOMBRE");
            }
            cn.close();

        } catch (SQLException e) {
            System.out.println("¡Error al obtener el id de la categoria!");
        }
        return NombreCategoriaProducto;
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
    
    public void BuscarProducto(String buscar){
        Ctrl_Producto ctrl_Producto=new Ctrl_Producto();
        DefaultTableModel modelo=ctrl_Producto.buscarProducto(buscar);
        jTable_productos.setModel(modelo);
    }
}
