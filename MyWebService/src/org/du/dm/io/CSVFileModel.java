package org.du.dm.io;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.du.dm.beans.Model;
import org.du.dm.beans.ModelList;

public class CSVFileModel implements FileModelInterface {
	private BufferedReader br;

	public  CSVFileModel(String fileName) throws FileNotFoundException {
		FileReader file = new FileReader(fileName);
		br = new BufferedReader(file);
	}

	public ModelList convert() {

		try {
			String scan;
			ModelList list = new ModelList();
			while((scan = br.readLine()) != null)
			{

				String[] parts = scan.split(";");
				Model m1 = new Model(parts[0]);
				m1.setAccuracy(Float.parseFloat(parts[2]));
				m1.setAlgoName(parts[1]);
				m1.setDescription(parts[3]);
				list.add(m1);
			}
			br.close();
			return list;
		}catch (IOException ioe){
			throw new RuntimeException(ioe);
		}

	}

	/**
	 * not required for compare better override toString()
	 */
//	public Model compare(String modelName) throws NumberFormatException, IOException {
//
//		String scan;
//		String[] parts = null;
//		boolean flag = false;
//
//		while((scan = br.readLine()) != null)
//		{
//
//			System.out.println(scan);
//			parts = scan.split(";");
//
//			if(parts[0].equals(modelName))
//			{
//				flag = true;
//				break;	
//			}
//		}
//		br.close();		
//
//		if(flag== true)
//		{
//			Model m1 = new Model();
//
//			System.out.println(parts[0]);
//			m1.algorithmName = parts[0];
//			System.out.println(m1.algorithmName);
//
//			System.out.println(parts[1]);
//			m1.dataSet = parts[1];
//			System.out.println(parts[2]);
//			m1.accuracy= Float.parseFloat(parts[2]);
//			return m1;
//		}
//		else
//		{
//			return null;
//		}			
//	}
}