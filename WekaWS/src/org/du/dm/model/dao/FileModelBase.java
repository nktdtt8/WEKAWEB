package org.du.dm.model.dao;

import java.io.BufferedReader;
import java.io.InputStream;

<<<<<<< HEAD
import org.du.dm.dao.DatabaseDaoInterface;
import org.du.dm.model.Model;
import org.du.dm.model.ModelList;

public class FileModelBase implements DatabaseDaoInterface<Model> {
=======
import org.du.dm.dao.DatabaseDao;
import org.du.dm.model.Model;
import org.du.dm.model.ModelList;

public class FileModelBase implements DatabaseDao<Model> {
>>>>>>> branch 'master' of https://github.com/nktdtt8/WEKAWEB.git

	private ModelList models;
	private BufferedReader reader;
		
	public FileModelBase(InputStream fileStream) {
		init();
	}
	
	private void init() {
		//[TODO load models from csv file ]
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