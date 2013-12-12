package org.du.dm.ws;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Writer;
import java.util.UUID;
import javax.ws.rs.core.Response;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response.ResponseBuilder;


import weka.classifiers.Classifier;
import weka.core.Instances;

@Path("weka1")
public class WekaResource {
	
	@GET
	@Path("test")
	@Produces(MediaType.TEXT_PLAIN)
	
	public javax.ws.rs.core.Response wekaOutput(@QueryParam("dataId") String dataId, @QueryParam("algoName") String algoName) throws Exception
	{
		  BufferedReader breader = new BufferedReader (new FileReader("D:/tmp/"+ dataId)); 
		  Instances test = null; 
		  test = new Instances (breader); 
		  test.setClassIndex(test.numAttributes()-1); 
//System.out.println("hi");
		
		  Classifier  cls = (Classifier) weka.core.SerializationHelper.read("C:/Users/neha/workspace/MyWebService/J48.model"); 
		  for (int i = 0; i < test.numInstances(); i++)
		  { 

			  double pred = cls.classifyInstance(test.instance(i)); 
	     
			  test.instance(i).setValue(test.numAttributes()-1, pred);
			  System.out.println(test.instance(i).classValue());
			  System.out.println(test.instance(i).numAttributes());
		  }
		  
		 // int a = 1;
			String outputfile = UUID.randomUUID().toString();

			File file = new File("D:/dataset/" + outputfile);
			FileWriter fw = new FileWriter(file);
	    	 BufferedWriter writer = new BufferedWriter(fw);
			 writer.write(test.toString());
			 writer.flush();
			 writer.close();
			 
			 ResponseBuilder builder = Response.ok((Object)file);
			 builder.header("Content-Disposition","attachment; filename= result.arff");
			 return builder.build();	 
		
	}

}
