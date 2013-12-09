package org.du.dm.ws;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import weka.classifiers.Classifier;
import weka.classifiers.Evaluation;
import weka.core.Instances;

//@Path("weka")
public class WekaResource {
	/*
	@GET
	@Path("models")
	@Produces(MediaType.TEXT_PLAIN)
	*/
	public void wekaOutput() throws Exception
	{
		  BufferedReader breader = new BufferedReader (new FileReader("C:/Program Files/Weka-3-6/data/weather.nominaltest.arff")); 
		  Instances test = null; 
		  test = new Instances (breader); 
		  test.setClassIndex(test.numAttributes()-1); 

		//and this section for loading the model: 
		Classifier  cls = (Classifier) weka.core.SerializationHelper.read("C:/Users/neha/workspace/MyWebService/src/J48.model"); 
		for (int i = 0; i < test.numInstances(); i++) { 

			  // either: 
			  // 1) This gives the index of the predicted class label as a double 
			  double pred = cls.classifyInstance(test.instance(i)); 
			  System.out.println(pred);
		}
		//return null;		
	}

}
