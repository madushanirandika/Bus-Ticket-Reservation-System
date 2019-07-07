package Includes;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Madu Randi
 */
public class CreatePDF {

    /**
     * @param args the command line arguments
     */
    public static void printTicket(String[] text, String fileName) {
        Document document = new Document();
        try {

            Date d = new Date();
            SimpleDateFormat s = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat s1 = new SimpleDateFormat("hh:mm:ss");
            String realdate = s.format(d);
            String realtime = s1.format(d);
            Connection con = Database.getConnected();
            String query = "SELECT * FROM company_data";
            ResultSet rs = Database.executeQuery(con, query);
            rs.next();

            String companyName = rs.getString(4);
            String hotline = rs.getString(2);
            String email = rs.getString(3);

            PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(fileName + ".pdf"));
            document.open();
            document.add(new Paragraph("*******************************************************************************"));
            document.add(new Paragraph(" " + companyName + "                 "));
            document.add(new Paragraph(" " + hotline + "                  "));
            document.add(new Paragraph(" " + email + "                     "));
            document.add(new Paragraph("*******************************************************************************"));
            document.add(new Paragraph("====================================================="));

            for (String textLine : text) {
                document.add(new Paragraph(textLine));
            }

            document.add(new Paragraph("*******************************************************************************"));
            document.add(new Paragraph(" Date : " + realdate + " "));
            document.add(new Paragraph(" Time : " + realtime + " "));
            document.add(new Paragraph("-------------------------------------------END-------------------------------------------"));

            document.close();
            writer.close();
        } catch (DocumentException e) {

        } catch (FileNotFoundException e) {

        } catch (SQLException ex) {
            Logger.getLogger(CreatePDF.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CreatePDF.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
