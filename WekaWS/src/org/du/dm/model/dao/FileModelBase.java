package org.du.dm.model.dao;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStream;


import org.du.dm.dao.DatabaseDaoInterface;
import org.du.dm.model.Model;
import org.du.dm.model.ModelList;


public class FileModelBase implements DatabaseDaoInterface<Model> {

	private ModelList models;
	private BufferedReader reader;
		
	public FileModelBase(InputStream fileStream) throws FileNotFoundException {
		init();
	}
	
	private void init() throws FileNotFoundException {
		//[TODO load models from csv file ]
		reader = new BufferedReader(new FileReader(""));
	}
	@Override
	public Model get(Model i) {
		// TODO implement
		return models.get(i);
	}

	@Override
	public void modify(Model m1, Model m2) {
		// TODO Auto-generated method stub
		models.remove(m1);
		models.add(m2);
	}

	@Override
	public void insert(Model m) {
		// TODO Auto-generated method stub
		models.add(m);
	}

}
