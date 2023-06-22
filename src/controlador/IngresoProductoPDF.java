package controlador;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import conexion.Conexion;
import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import vista.InterIngresoProducto;

/**
 *
 * @author julio
 */
public class IngresoProductoPDF {
    private String RESPONSABLE;
    private String CODIGO;
    private String NOMBRE;
    private String PRODUCTO;
    private String COLOR;
    private String TALLA;
    private String CANTIDAD;
    private String CANTDEFECT;
    
    private String fechaActual = "";
    private String nombreArchivoPDFIngresoProducto = "";

    //metodo para obtener datos del cliente
    public void DatosIngresoProducto(int IDINGRESOPRODUCTO) {
        Connection cn = Conexion.conectar();
        String sql = "select * from INGPRODTABLA where IDINGRESOPRODUCTO = '" + IDINGRESOPRODUCTO + "'";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                RESPONSABLE = rs.getString("EMPSERV");
                CODIGO = rs.getString("CODIGO");
                NOMBRE = rs.getString("NOMBRE");
                PRODUCTO = rs.getString("PRODUCTO");
                COLOR = rs.getString("COLOR");
                TALLA = rs.getString("TALLA");
                CANTIDAD =rs.getString("CANTIDAD");
                CANTDEFECT =rs.getString("CANTIDADDEFECTUOSA");                              
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener datos: " + e);
        }
    }

    //metodo para generar la factura de venta
    public void generarReporteIngresoProductoPDF() {
        try {

            //cargar la fecha actual
            Date date = new Date();
            fechaActual = new SimpleDateFormat("yyyy/MM/dd").format(date);
            //cambiar el formato de la fecha de / a _
            String fechaNueva = "";
            for (int i = 0; i < fechaActual.length(); i++) {
                if (fechaActual.charAt(i) == '/') {
                    fechaNueva = fechaActual.replace("/", "_");
                }
            }

            nombreArchivoPDFIngresoProducto = "Ingreso de Producto" + fechaNueva + ".pdf";

            FileOutputStream archivo;
            File file = new File("src/pdf/" + nombreArchivoPDFIngresoProducto);
            archivo = new FileOutputStream(file);

            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();

            Image img = Image.getInstance("src/img/logo.jpg");
            Paragraph fecha = new Paragraph();
            Font negrita = new Font(Font.FontFamily.TIMES_ROMAN, 12, Font.BOLD, BaseColor.BLUE);
            fecha.add(Chunk.NEWLINE); //agregar nueva linea
            fecha.add("Reporte: 001" + "\nFecha: " + fechaActual + "\n\n");

            PdfPTable Encabezado = new PdfPTable(4);
            Encabezado.setWidthPercentage(100);
            Encabezado.getDefaultCell().setBorder(0);//quitar el borde de la tabla
            //tamaño de las celdas
            float[] ColumnaEncabezado = new float[]{20f, 30f, 70f, 40f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);
            //agregar celdas
            
            Encabezado.addCell(img);
            String dueño="Milla Congo Cesar Augusto";
            String ruc = "10098851505";
            String nombre = "Josmay";
            String direccion = "Mz. A Lt. 20 Otr. Prog. de Viv. Residencial Las Delicias - Puente Piedra";
            String telefono = "955560790";
            Encabezado.addCell("");//celda vacia
            Encabezado.addCell("DE: "+ dueño + "\nRUC: " + ruc + "\nNOMBRE: " + nombre + "\nTELEFONO: " + telefono + "\nDIRECCION: " + direccion);
            Encabezado.addCell("R.U.C. N:°"+ruc+"\nGUIA DE REMISION"+"\nREMITENTE");
            doc.add(Encabezado);

            //CUERPO
            PdfPTable Cuerpo = new PdfPTable(4);
            Cuerpo.setWidthPercentage(100);
            Cuerpo.getDefaultCell().setBorder(0);
            float[] ColumnaCuerpo = new float[]{20f, 30f, 70f, 40f};
            Encabezado.setWidths(ColumnaEncabezado);
            Encabezado.setHorizontalAlignment(Element.ALIGN_LEFT);


            //DATOS DE la Salida
            PdfPTable tablaingresoprod  = new PdfPTable(8);
            tablaingresoprod.setWidthPercentage(100);
            tablaingresoprod.getDefaultCell().setBorder(7);
            //tamaño de las celdas
            float[] ColumnaIngProd = new float[]{20f, 16f, 16f, 16f, 16f, 16f, 16f, 18f};
            tablaingresoprod.setWidths(ColumnaIngProd);
            tablaingresoprod.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell ingreso1 = new PdfPCell(new Phrase("Responsable: ", negrita));
            PdfPCell ingreso2 = new PdfPCell(new Phrase("Codigo: ", negrita));
            PdfPCell ingreso3 = new PdfPCell(new Phrase("Nombre: ", negrita));
            PdfPCell ingreso4 = new PdfPCell(new Phrase("Producto: ", negrita));
            PdfPCell ingreso5 = new PdfPCell(new Phrase("Color: ", negrita));
            PdfPCell ingreso6 = new PdfPCell(new Phrase("Talla: ", negrita));
            PdfPCell ingreso7 = new PdfPCell(new Phrase("Cantidad: ", negrita));
            PdfPCell ingreso8 = new PdfPCell(new Phrase("Cantidad Defectuosa: ", negrita));

            //quitar bordes 
            ingreso1.setBorder(5);
            ingreso2.setBorder(5);
            ingreso3.setBorder(5);
            ingreso4.setBorder(5);
            ingreso5.setBorder(5);
            ingreso6.setBorder(5);
            ingreso7.setBorder(5);
            ingreso8.setBorder(7);
            
            //agg celda a la tabla
            tablaingresoprod.addCell(ingreso1);
            tablaingresoprod.addCell(ingreso2);
            tablaingresoprod.addCell(ingreso3);
            tablaingresoprod.addCell(ingreso4);
            tablaingresoprod.addCell(ingreso5);
            tablaingresoprod.addCell(ingreso6);
            tablaingresoprod.addCell(ingreso7);
            tablaingresoprod.addCell(ingreso8);
            
            //agregar al documento
            for(int i = 0; i < InterIngresoProducto.jTable_IngresoProductos.getRowCount(); i++){
                String RESPONSABLE = InterIngresoProducto.jTable_IngresoProductos.getValueAt(i, 1).toString();
                String CODIGO = InterIngresoProducto.jTable_IngresoProductos.getValueAt(i, 2).toString();
                String NOMBRE = InterIngresoProducto.jTable_IngresoProductos.getValueAt(i, 3).toString();
                String PRODUCTO = InterIngresoProducto.jTable_IngresoProductos.getValueAt(i, 4).toString();
                String COLOR = InterIngresoProducto.jTable_IngresoProductos.getValueAt(i, 5).toString();
                String TALLA = InterIngresoProducto.jTable_IngresoProductos.getValueAt(i, 6).toString();
                String CANTIDAD = InterIngresoProducto.jTable_IngresoProductos.getValueAt(i, 7).toString();
                String CANTDEFECT = InterIngresoProducto.jTable_IngresoProductos.getValueAt(i, 8).toString();
                
                tablaingresoprod.addCell(RESPONSABLE);
                tablaingresoprod.addCell(CODIGO);
                tablaingresoprod.addCell(NOMBRE);
                tablaingresoprod.addCell(PRODUCTO);
                tablaingresoprod.addCell(COLOR);
                tablaingresoprod.addCell(TALLA);
                tablaingresoprod.addCell(CANTIDAD);
                tablaingresoprod.addCell(CANTDEFECT);
 
            }
            
            //agregar al documento
            doc.add(tablaingresoprod);
             
            //Mensaje
            Paragraph mensaje = new Paragraph();
            mensaje.add(Chunk.NEWLINE);
            mensaje.add("¡Reporte Generado!");
            mensaje.setAlignment(Element.ALIGN_CENTER);
            doc.add(mensaje);
           
            //cerrar el documento y el archivo
            doc.close();
            archivo.close();
           
            //abrir el documento al ser generado automaticamente
            Desktop.getDesktop().open(file);            
            
        } catch (DocumentException | IOException e) {
            System.out.println("Error en: " + e);
        }
    }
    
}
