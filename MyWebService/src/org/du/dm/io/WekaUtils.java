package org.du.dm.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.sql.SQLException;

import org.du.dm.beans.Data;
import org.du.dm.beans.Model;

import weka.classifiers.Classifier;
import weka.core.Instances;
import weka.core.SerializationHelper;
import weka.core.converters.CSVLoader;

/**
 * 
 * @author neha
 *
 */
public class WekaUtils {
	
	/**
	 * 
	 * @param path		path to arff file
	 * @return			object to weka instance
	 * @throws IOException
	 */
	public static Instances readArff(File path) throws IOException {
		
		if(path == null)
			return null;
		
		  Instances instances = new Instances(new FileReader(path));
		  instances.setClassIndex(instances.numAttributes()-1);		//always keep the last column as class index 
		  return instances;
		  		  		  
	}
	
	/**
	 * 
	 * @param path		path to the csv file
	 * @return			object of weka instance 
	 * @throws IOException
	 */
	public static Instances readCsv(File path) throws IOException {
		if(path == null)
			return null;
		CSVLoader data = new CSVLoader();
		data.setFile(path);
		Instances instance = data.getStructure();
		instance.setClassIndex(instance.numAttributes()-1);
		return instance;
	}
	
	
	/**
	 * 
	 * @param path			path from where to read the classifier object
	 * @return				the classifier model
	 * @throws FileNotFoundException
	 * @throws Exception
	 */
	public static Classifier readClassifier(File path) throws FileNotFoundException, Exception {
		if(path == null)
			return null;
		return (Classifier) SerializationHelper.read(new FileInputStream(path));
	}
	
	/**
	 * 
	 * @param outPath					output path where to write the classifier object
	 * @param classifierObject			the inmemory object of the classifier
	 * @throws FileNotFoundException	
	 * @throws Exception
	 */
	public static void writeClassifier(File outPath, Classifier classifierObject) throws FileNotFoundException, Exception {
		if(outPath == null)
			return;
		SerializationHelper.write(new FileOutputStream(outPath), classifierObject);
	}
	
	/**
	 * 
	 * @param id			id generated by the uploader/admin
	 * @return				a Model object
	 * @throws Exception		 
	 * @throws FileNotFoundException		if file is not found 
	 * 
	 */
	public static Classifier convertModelIdToObject(String id) throws FileNotFoundException, Exception {
		Model m = DatabaseUtils.readModel(id);
		return readClassifier(new File(m.getLocation()));
	}

	/**
	 * 
	 * @param dataId		the id of the data uploaded by user
	 * @return				the instances generated by the data
	 * @throws IOException file not found in the respective location or permission error or IO error
	 * @throws SQLException		Incase data couldn't be retrieved from database 
	 */
	public static Instances convertDataIdToInstances(String dataId) throws IOException, SQLException {
		Data d = DatabaseUtils.readData(dataId);
	
		switch(d.getType()) {
		
		case 0:
				return readArff(new File(d.getLocation()));
				
		case 1:
				return readCsv(new File(d.getLocation()));
				
		default:
				return null;
		}
	}
	
}