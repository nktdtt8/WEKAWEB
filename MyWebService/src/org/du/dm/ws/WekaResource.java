package org.du.dm.ws;

import java.util.UUID;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.du.dm.io.DatabaseUtils;
import org.du.dm.io.WekaUtils;
import org.du.dm.weka.classify.ExecuteClassifier;

import weka.classifiers.Classifier;
import weka.core.Instances;

@Path("weka1")
public class WekaResource {
	
	@GET
	@Path("classify")
	@Produces(MediaType.TEXT_PLAIN)
	public Response wekaOutput(@QueryParam("dataId") String dataId, @QueryParam("algoName") String algoName) throws Exception
	{
		   
		  Instances test = WekaUtils.convertDataIdToInstances(dataId); 
		  Classifier  cls = WekaUtils.convertModelIdToObject(algoName);
		  
		  //load classifier from database
		  test = new ExecuteClassifier().classify(cls, test);
		  
		 //generate output filename
			String outputfile = UUID.randomUUID().toString();
			
		//write instances to outputfile
			boolean _success = DatabaseUtils.writeToFile(outputfile, test.toString());
			
			if(_success) 
				return Response.status(Status.ACCEPTED).entity(outputfile).build();
			 else
				return Response.status(Status.BAD_REQUEST).build();
		
	}

}
