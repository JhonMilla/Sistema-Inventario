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
import vista.InterIngresoRecurso;

/**
 *
 * @author Julio
 */
public class IngresoMateriaPrimaPDF {
    
  
    private String NOMBRE;
    private String MATPRIMA;
    private String CANTIDAD;
    private String COLOR;
    private String PROVEEDOR;
    private String DESCRIPCION;
    
    private String fechaActual = "";
    private String nombreArchivoPDFIngresoMateriaPrima = "";

    //metodo para obtener datos del cliente
    public void DatosSalidaRecursos(int IDINGRESORECURSOS) {
        Connection cn = Conexion.conectar();
        String sql = "select * from INGRERECUTABLA where IDINGRESORECURSOS = '" + IDINGRESORECURSOS + "'";
        Statement st;
        try {
            st = cn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                NOMBRE = rs.getString("NOMBRE");
                MATPRIMA = rs.getString("RECURSO");
                CANTIDAD =rs.getString("CANTIDAD");
                COLOR = rs.getString("COLOR");
                PROVEEDOR = rs.getString("PROVEEDOR");
                DESCRIPCION = rs.getString("DESCRIPCION");
                
            }
            cn.close();
        } catch (SQLException e) {
            System.out.println("Error al obtener datos: " + e);
        }
    }

    //metodo para generar la factura de venta
    public void generarReporteIngresoMateriaPrimaPDF() {
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

            nombreArchivoPDFIngresoMateriaPrima = "Ingreso de " + MATPRIMA + ".pdf";

            FileOutputStream archivo;
            File file = new File("src/pdf/" + nombreArchivoPDFIngresoMateriaPrima);
            archivo = new FileOutputStream(file);

            Document doc = new Document();
            PdfWriter.getInstance(doc, archivo);
            doc.open();

            Image img = Image.getInstance("src/img/logo.png");
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
            Paragraph ingresomat = new Paragraph();
            ingresomat.add(Chunk.NEWLINE);//nueva linea
            ingresomat.add("Ingreso de Materia Prima de Almacén: " + "\n\n");
            doc.add(ingresomat );

            //DATOS DE la Salida
            PdfPTable tablaingresomat  = new PdfPTable(6);
            tablaingresomat.setWidthPercentage(100);
            tablaingresomat.getDefaultCell().setBorder(0);//quitar bordes
            //tamaño de las celdas
            float[] ColumnaIngMat = new float[]{16f, 16f, 16f, 16f, 16f, 20f };
            tablaingresomat.setWidths(ColumnaIngMat);
            tablaingresomat.setHorizontalAlignment(Element.ALIGN_LEFT);
            PdfPCell salida1 = new PdfPCell(new Phrase("Nombre: ", negrita));
            PdfPCell salida2 = new PdfPCell(new Phrase("MateriaPrima: ", negrita));
            PdfPCell salida3 = new PdfPCell(new Phrase("Cantidad: ", negrita));
            PdfPCell salida4 = new PdfPCell(new Phrase("Color: ", negrita));
            PdfPCell salida5 = new PdfPCell(new Phrase("Proveedor: ", negrita));
            PdfPCell salida6 = new PdfPCell(new Phrase("Descripción: ", negrita));

            //quitar bordes 
            salida1.setBorder(0);
            salida2.setBorder(0);
            salida3.setBorder(0);
            salida4.setBorder(0);
            salida5.setBorder(0);
            salida6.setBorder(0);
            
            //agg celda a la tabla
            tablaingresomat.addCell(salida1);
            tablaingresomat.addCell(salida2);
            tablaingresomat.addCell(salida3);
            tablaingresomat.addCell(salida4);
            tablaingresomat.addCell(salida5);
            tablaingresomat.addCell(salida6);
            
            tablaingresomat.addCell(NOMBRE);
            tablaingresomat.addCell(MATPRIMA);
            tablaingresomat.addCell(CANTIDAD);
            tablaingresomat.addCell(COLOR);
            tablaingresomat.addCell(PROVEEDOR);
            tablaingresomat.addCell(DESCRIPCION);
            
            
           
            //agregar al documento
           
 
            for(int i = 0; i < InterIngresoRecurso.jTable_IngresoRecursos.getRowCount(); i++){
                String NOMBRE = InterIngresoRecurso.jTable_IngresoRecursos.getValueAt(i, 3).toString();
                String MATPRIMA = InterIngresoRecurso.jTable_IngresoRecursos.getValueAt(i, 4).toString();
                String CANTIDAD = InterIngresoRecurso.jTable_IngresoRecursos.getValueAt(i, 7).toString();
                String COLOR = InterIngresoRecurso.jTable_IngresoRecursos.getValueAt(i, 6).toString();
                String PROVEEDOR = InterIngresoRecurso.jTable_IngresoRecursos.getValueAt(i, 1).toString();
                String DESCRIPCION = InterIngresoRecurso.jTable_IngresoRecursos.getValueAt(i, 5).toString();
                
                tablaingresomat.addCell(NOMBRE);
                tablaingresomat.addCell(MATPRIMA);
                tablaingresomat.addCell(CANTIDAD);
                tablaingresomat.addCell(COLOR);
                tablaingresomat.addCell(PROVEEDOR);
                tablaingresomat.addCell(DESCRIPCION);
 
            }
            
            //agregar al documento
            doc.add(tablaingresomat);
             
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

