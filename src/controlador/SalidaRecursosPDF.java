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
import vista.InterSalidaRecursos;

/**
 *
 * @author Julio
 */
public class SalidaRecursosPDF {
    
  
    private String EMPSERV;
    private String RECURSO;
    private String CANTIDAD;
 
    private String fechaActual = "";
    private String nombreArchivoPDFSalidaRecursos = "";

    //metodo para obtener datos del cliente
    public void DatosSalidaRecursos(int IDSALIDARECURSOS) {
        Connection cn = Conexion.conectar();
        String sql = "select * from SALIRECTABLA where IDSALIDARECURSOS = '" + IDSALIDARECURSOS + "'";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                EMPSERV = rs.getString("EMPSERV");
                RECURSO = rs.getString("RECURSO");
                CANTIDAD =rs.getString("CANTIDAD");
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener datos: " + e);
        }
    }

    //metodo para generar la factura de venta
    public void generarReproteSalidaRecursosPDF() {
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

            nombreArchivoPDFSalidaRecursos = "Salida de " + RECURSO + ".pdf";

            FileOutputStream archivo;
            File file = new File("src/pdf/" + nombreArchivoPDFSalidaRecursos);
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
            String razon = "PICANTEEEEEEE";
            Encabezado.addCell("");//celda vacia
            Encabezado.addCell("RUC: " + ruc + "\nNOMBRE: " + nombre + "\nTELEFONO: " + telefono + "\nDIRECCION: " + direccion + "\nRAZON SOCIAL: " + razon);
            Encabezado.addCell(fecha);
            doc.add(Encabezado);

            //CUERPO
            Paragraph salida = new Paragraph();
            salida.add(Chunk.NEWLINE);//nueva linea
            salida.add("Salida de Recursos de Almacén: " + "\n\n");
            doc.add(salida );

            //DATOS DE la Salida
            PdfPTable tablasalida  = new PdfPTable(3);
            tablasalida.setWidthPercentage(100);
            tablasalida.getDefaultCell().setBorder(0);//quitar bordes
            //tamaño de las celdas
            float[] ColumnaCliente = new float[]{40f, 40f, 20f};
            tablasalida.setWidths(ColumnaCliente);
            tablasalida.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell salida1 = new PdfPCell(new Phrase("Emp/Serv: ", negrita));
            PdfPCell salida2 = new PdfPCell(new Phrase("Recurso: ", negrita));
            PdfPCell salida3 = new PdfPCell(new Phrase("Cantidad: ", negrita));

            //quitar bordes 
            salida1.setBorder(0);
            salida2.setBorder(0);
            salida3.setBorder(0);
            
            //agg celda a la tabla
            tablasalida.addCell(salida1);
            tablasalida.addCell(salida2);
            tablasalida.addCell(salida3);
            tablasalida.addCell(EMPSERV);
            tablasalida.addCell(RECURSO);
            tablasalida.addCell(CANTIDAD);
            
           
            //agregar al documento
           
 
            for(int i = 0; i < InterSalidaRecursos.jTable_SalidaRecursos.getRowCount(); i++){
                String EMPSERV = InterSalidaRecursos.jTable_SalidaRecursos.getValueAt(i, 1).toString();
                String RECURSO = InterSalidaRecursos.jTable_SalidaRecursos.getValueAt(i, 2).toString();
                String CANTIDAD = InterSalidaRecursos.jTable_SalidaRecursos.getValueAt(i, 3).toString();
                
                tablasalida.addCell(EMPSERV);
                tablasalida.addCell(RECURSO);
                tablasalida.addCell(CANTIDAD);
 
            }
            
            //agregar al documento
            doc.add(tablasalida);
             
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
