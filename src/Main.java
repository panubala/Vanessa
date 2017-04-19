import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.encryption.InvalidPasswordException;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.pdfbox.text.PDFTextStripperByArea;

import com.opencsv.CSVReader;

public class Main {

	public static void main(String[] args) throws InvalidPasswordException, IOException{
		PDDocument document = null;
	    document = PDDocument.load(new File("/Users/panuyabalasuntharam/Desktop/Vanessa/Wirtschaft.pdf"));
	    document.getClass();
	    String text = "";
	    if (!document.isEncrypted()) {
	        PDFTextStripperByArea stripper = new PDFTextStripperByArea();
	        stripper.setSortByPosition(true);
	        PDFTextStripper Tstripper = new PDFTextStripper();
	        text = Tstripper.getText(document);
	        System.out.println("Text:" + text);
	        
	    }
	    
	    Scanner reader = new Scanner(new FileReader("/Users/panuyabalasuntharam/Desktop/Vanessa/Suchwörter_SA.csv"));
	    ArrayList searchWords = new ArrayList<>();
	    
	    while (reader.hasNext()) {
			searchWords.add(reader.nextLine());
			
		}
	    System.out.println(searchWords.toString());
	    
	    Pattern p = Pattern.compile("Unternehmen");
		Matcher m = p.matcher(text);
		if (m.find()){
			System.out.println("gefunden");
		}else{
			System.out.println("nicht gefunden");
		}
		
	}
}
