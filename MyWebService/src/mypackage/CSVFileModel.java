package mypackage;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class CSVFileModel {
private BufferedReader br;
	
	public  CSVFileModel(String fileName) throws FileNotFoundException {
		
		FileReader file = new FileReader("C:\\Users\\neha\\workspace\\MyWebService\\src\\mypackage\\"+fileName);
	    br = new BufferedReader(file);
	   
	}
	
	public modelList convert() throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		//[TODO] create Models and return here
	    String scan;
	    modelList list=new modelList();
	   		while((scan = br.readLine()) != null)
		         {
		           
		        	System.out.println(scan);
		            String[] parts = scan.split(";");
		            model m1 = new model();
		            
			        System.out.println(parts[0]);
					m1.algorithmName = parts[0];
					System.out.println(m1.algorithmName);
						
					System.out.println(parts[1]);
					m1.dataSet = parts[1];
					System.out.println(parts[2]);
					m1.accuracy= Float.parseFloat(parts[2]);
					//((modelList) list.modellist).add(m1);
			        
		          }
		      	        
		        br.close();

		
		return list;
	}
	

}
