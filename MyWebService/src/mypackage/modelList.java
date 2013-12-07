package mypackage;

import java.util.ArrayList;
import java.util.List; 

import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;

public class modelList {

	/**
	 * @param args
	 */	
	
	
	public List<model> modellist;
	
	public modelList() {
		modellist = new ArrayList<model>();
	}
	public  String print() throws SAXException, JAXBException
	{
		String models = "";
		for(model m : modellist)
		{	models = models + m.print();
			models = models + "\n";
		}
		return models;
	}
	
	public model get(model i) {
		
		return null;
	}

	/*public void add(model m) {
		// TODO Auto-generated method stub
		
	}*/

	public void remove(model m1) {
		// TODO Auto-generated method stub
		
	}
	//[TODO implement getter and setter for this]
	
	
}
