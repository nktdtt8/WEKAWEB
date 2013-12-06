package mypackage;

import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;

public class Main {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 * @throws JAXBException 
	 * @throws SAXException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException, SAXException, JAXBException {
		// TODO Auto-generated method stub
			CSVFileModel a = new CSVFileModel("scan.txt");
			modelList resultList = a.convert();
			resultList.print();
			
		
		
		
	}

}
