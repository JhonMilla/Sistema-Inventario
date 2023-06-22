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
import vista.InterSalidaProductos;

/**
 *
 * @author Julio
 */
public class SalidaProductoPDF{
    
  
    private String CODIGO;
    private String CLIENTE;
    private String NOMBRE;
    private String PRODU;
    private String CANTIDAD;
    private String CANTDIS;
    private String COLOR;
    private String TALLA;
   
    
    private String fechaActual = "";
    private String nombreArchivoPDFSalidaProducto = "";

    //metodo para obtener datos del cliente
    public void DatosSalidaProducto(int IDSALIDAPRODUCTOS) {
        Connection cn = Conexion.conectar();
        String sql = "select * from SALIPRODTABLA where IDSALIDAPRODUCTOS = '" + IDSALIDAPRODUCTOS + "'";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                CODIGO = rs.getString("CODIGO");
                CLIENTE = rs.getString("CLIENTE");
                NOMBRE = rs.getString("NOMBRE");
                PRODU = rs.getString("PRODUCTO");
                CANTIDAD =rs.getString("CANTIDAD");
                CANTDIS = rs.getString("CANTIDAD_DIS");
                COLOR = rs.getString("COLOR");
                TALLA = rs.getString("TALLA");
                
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener datos: " + e);
        }
    }

    //metodo para generar la factura de venta
    public void generarReporteSalidaProductoPDF() {
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

            nombreArchivoPDFSalidaProducto = "Salida Producto" + fechaNueva + ".pdf";

            FileOutputStream archivo;
            File file = new File("src/pdf/" + nombreArchivoPDFSalidaProducto);
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

            String ruc = "0987654321001";
            String nombre = "Fantasma Cooporation";
            String telefono = "0987654321";
            String direccion = "Tamarindo City";
            String razon = "PICANTEEEEE";
            Encabezado.addCell("");//celda vacia
            Encabezado.addCell("RUC: " + ruc + "\nNOMBRE: " + nombre + "\nTELEFONO: " + telefono + "\nDIRECCION: " + direccion + "\nRAZON SOCIAL: " + razon);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);

            //CUERPO
            Paragraph salidaprod = new Paragraph();
            salidaprod.add(Chunk.NEWLINE);//nueva linea
            salidaprod.add("Salida de producto de Almacén: " + "\n\n");
            doc.add(salidaprod);

            //DATOS DE la Salida
            PdfPTable tablasalidaprod  = new PdfPTable(8);
            tablasalidaprod.setWidthPercentage(100);
            tablasalidaprod.getDefaultCell().setBorder(0);//quitar bordes
            //tamaño de las celdas
            float[] ColumnaSalProd = new float[]{12f, 12f, 12f, 13f, 12f, 13f,13f,13f };
            tablasalidaprod.setWidths(ColumnaSalProd);
            tablasalidaprod.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell salida1 = new PdfPCell(new Phrase("Código: ", negrita));
            PdfPCell salida2 = new PdfPCell(new Phrase("Cliente: ", negrita));
            PdfPCell salida3 = new PdfPCell(new Phrase("Nombre: ", negrita));
            PdfPCell salida4 = new PdfPCell(new Phrase("Producto: ", negrita));
            PdfPCell salida5 = new PdfPCell(new Phrase("Cantidad: ", negrita));
            PdfPCell salida6 = new PdfPCell(new Phrase("Cantidad Disponible: ", negrita));
            PdfPCell salida7 = new PdfPCell(new Phrase("Color: ", negrita));
            PdfPCell salida8 = new PdfPCell(new Phrase("Talla: ", negrita));

            //quitar bordes 
            salida1.setBorder(0);
            salida2.setBorder(0);
            salida3.setBorder(0);
            salida4.setBorder(0);
            salida5.setBorder(0);
            salida6.setBorder(0);
            salida7.setBorder(0);
            salida8.setBorder(0);
            
            //agg celda a la tabla
            tablasalidaprod.addCell(salida1);
            tablasalidaprod.addCell(salida2);
            tablasalidaprod.addCell(salida3);
            tablasalidaprod.addCell(salida4);
            tablasalidaprod.addCell(salida5);
            tablasalidaprod.addCell(salida6);
            tablasalidaprod.addCell(salida7);
            tablasalidaprod.addCell(salida8);
            
            
            

            
           
            //agregar al documento
           
 
            for(int i = 0; i < InterSalidaProductos.jTable_SalidaProducto.getRowCount(); i++){
                String CODIGO = InterSalidaProductos.jTable_SalidaProducto.getValueAt(i, 2).toString();
                String CLIENTE = InterSalidaProductos.jTable_SalidaProducto.getValueAt(i, 1).toString();
                String NOMBRE = InterSalidaProductos.jTable_SalidaProducto.getValueAt(i, 3).toString();
                String PRODU = InterSalidaProductos.jTable_SalidaProducto.getValueAt(i, 4).toString();
                String CANTIDAD = InterSalidaProductos.jTable_SalidaProducto.getValueAt(i, 8).toString();
                String CANTDIS = InterSalidaProductos.jTable_SalidaProducto.getValueAt(i, 7).toString();
                String COLOR = InterSalidaProductos.jTable_SalidaProducto.getValueAt(i, 5).toString();
                String TALLA = InterSalidaProductos.jTable_SalidaProducto.getValueAt(i, 6).toString();
                
                tablasalidaprod.addCell(CODIGO);
                tablasalidaprod.addCell(CLIENTE);
                tablasalidaprod.addCell(NOMBRE);
                tablasalidaprod.addCell(PRODU);
                tablasalidaprod.addCell(CANTIDAD);
                tablasalidaprod.addCell(CANTDIS);
                tablasalidaprod.addCell(COLOR);
                tablasalidaprod.addCell(TALLA);
 
            }
            
            //agregar al documento
            doc.add(tablasalidaprod);
             
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
