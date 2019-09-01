package codigo_de_barras;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode128;
import com.itextpdf.text.pdf.Barcode39;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Hermann
 */
public class Codigo_de_Barras {
    public static void main(String[] args) {
        try {
            Document doc = new Document();
            PdfWriter pdf = PdfWriter.getInstance(doc, new FileOutputStream("codigos.pdf"));
            doc.open();
            
            //codigo 39
            Barcode39 code = new Barcode39();
            code.setCode("1234567890");
            Image img = code.createImageWithBarcode(pdf.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);
            
            doc.add(img);
            doc.add(new Paragraph(" "));
            // --------------------------------------------------
            
            //codigo 128
            Barcode128 code128 = new Barcode128();
            code128.setCode("1234567890");
            Image img128 = code128.createImageWithBarcode(pdf.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);
            img128.scalePercent(200);
            doc.add(img128);
            
            //----------------------------------------------------
            doc.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Codigo_de_Barras.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Codigo_de_Barras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
