package org.du.dm.web;

import java.io.IOException;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;



//Sets the path to base URL + /hello
@Path("models")

public class ModelReqResponse {

	/**
	 * @param args
	 * @throws IOException 
	 */
	 @GET
	 @Produces(MediaType.TEXT_PLAIN)
	  public String modelCharacterstics(@PathParam("m") String m
			  							) throws IOException {

		return "hi "+m;

	 }
	}


