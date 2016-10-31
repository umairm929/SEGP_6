package snippet;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

public class CreatePDF {
	public void createPDF(String[][] Data, String fileName){ 
		try {
            Document doc = new Document();
            PdfWriter.getInstance(doc, new FileOutputStream(fileName));
            doc.open();
            PdfPTable pdfTable = new PdfPTable(8);
            //adding table headers
        
            int row=0;
            for(int i=0;i<8;i++){
            	for (int j= 0;j<8;j++) {
                    pdfTable.addCell(Data[i][j]);
                }
            	row ++;
							}
            //extracting data from the JTable and inserting it to PdfPTable
//            for (int rows = 0; rows < table.getRowCount() - 1; rows++) {
//                for (int cols = 0; cols < table.getColumnCount(); cols++) {
//                    pdfTable.addCell(table.getModel().getValueAt(rows, cols).toString());
//
//                }
//            }
            doc.add(pdfTable);
            doc.close();
           // System.out.println("done");
        } catch (DocumentException ex) {
        	System.out.println("Error occured");
            
        } catch (FileNotFoundException ex) {
        	System.out.println("Error occured");
            
            
        }
		
	}
	public static void main(String[] args) {
		String[][] arr= {{"absd"}};
		String s ="test";
		
		CreatePDF a = new CreatePDF();
		a.createPDF(arr, s);

	}

}