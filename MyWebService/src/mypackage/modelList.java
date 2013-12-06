package mypackage;

import javax.xml.bind.JAXBException;

import org.xml.sax.SAXException;

import com.sun.xml.internal.bind.v2.runtime.reflect.ListIterator;
import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

public class modelList {

	/**
	 * @param args
	 */	
	
	
	public List modellist;
	public  void print() throws SAXException, JAXBException
	{
		ListIterator<model> iterator=  (ListIterator<model>) modellist;
		while(iterator.hasNext())
		{
			model m = (model) iterator.next();
			m.print();
		}
	}
	
	public model get(model i) {
		// TODO Auto-generated method stub
		return null;
	}

	public void add(model m) {
		// TODO Auto-generated method stub
		
	}

	public void remove(model m1) {
		// TODO Auto-generated method stub
		
	}
	//[TODO implement getter and setter for this]
	
	
}
