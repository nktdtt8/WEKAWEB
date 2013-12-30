package org.du.dm.beans;

import java.util.ArrayList;
import java.util.List;


public class ModelList {

	public List<Model> modelList;
	
	public ModelList() {
		modelList = new ArrayList<Model>();
	}
		
	public Model get(Model i) {
		for(Model m : modelList)
			if(m.equals(i))
				return m;
		
		return null;
	}

	public void add(Model m) {
		modelList.add(m);		
	}

	public void remove(Model m1) {
		modelList.remove(m1);
	}
	
	public int size() {
		return modelList.size();
	}
		
	public String toString() {
		String out = "";
		for(Model m : modelList)
			out+=m + "\n";
		
		return out;
	}

	public Model[] asArray() {
		return modelList.toArray(new Model[0]);
	}
}
