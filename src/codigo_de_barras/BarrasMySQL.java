package codigo_de_barras;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.Barcode39;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.logging.Level;
import java.util.logging.Logger;
import conexion.ConexionBD;
import java.sql.SQLException;

public class BarrasMySQL {
    public static void main(String args[]) throws SQLException{
        
        PreparedStatement ps;
        ResultSet res;
        Connection con;
        Image img;
        
        ConexionBD cox = new ConexionBD();
        con = cox.getConexion();
        
        
        try {
            ps = con.prepareStatement("SELECT * FROM form_data");
            res = ps.executeQuery();
            
            
            Document doc = new Document();
            PdfWriter pdf = PdfWriter.getInstance(doc, new FileOutputStream("codx.pdf"));
            doc.open();
            
            //codigo 39
            Barcode39 code = new Barcode39();
            while(res.next()){
                code.setCode(res.getString("id"));
                img = code.createImageWithBarcode(pdf.getDirectContent(), BaseColor.BLACK, BaseColor.BLACK);
                doc.add(img);
            doc.add(new Paragraph(" "));
            
            }
            
            //----------------------------------------------------
            doc.close();
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Codigo_de_Barras.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DocumentException ex) {
            Logger.getLogger(Codigo_de_Barras.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
