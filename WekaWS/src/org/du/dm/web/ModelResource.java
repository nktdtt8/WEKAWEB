package org.du.dm.web;

import java.io.IOException;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.du.dm.model.Model;
import org.du.dm.model.dao.FileModelBase;



/**
 * REST service to get all services or a particular model information
 * the Path described is relative to the base URI
 * @author aniket
 *
 */

@Path("models")
public class ModelResource {

	/**
	 * add query parameter model-name
	 * @param args
	 * @throws IOException 
	 */
	 @GET
	 @Path("{model}")
	 @Produces(MediaType.APPLICATION_JSON)
	  public String getModel(@PathParam("model") String model
			  							) throws IOException {
		 
		//[TODO implement method] 
		//create a FileBase Object and load all models
		 //
		return jsonString;

	 }
	 
	 @GET
	 @Path("all")
	 @Produces(MediaType.APPLICATION_JSON)
	  public String getModelList(@PathParam("model") String model
			  							) throws IOException {
		 
		//[TODO implement method] 
		 
		return allmodel;

	 }
	}


