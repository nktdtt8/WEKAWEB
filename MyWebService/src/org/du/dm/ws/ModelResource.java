package org.du.dm.ws;

import java.io.InputStream;
import java.sql.SQLException;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.du.dm.beans.Model;
import org.du.dm.beans.ModelList;
import org.du.dm.io.DatabaseUtils;

import com.sun.jersey.multipart.FormDataParam;


@Path("model")

public class ModelResource {

	
	@GET
	@Path("all")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllModels() {

		ModelList list;
		try {
			list = DatabaseUtils.readAllModel();
			return Response.status(Status.OK).entity(list).build();
		} catch (SQLException e) {
			return Response.status(Status.NOT_FOUND).build();
		} 
		

	}


	@GET
	@Path("{q}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response matchingModel(@PathParam("q") String modelId
			) {

		Model m;
		try {
			m = DatabaseUtils.readModel(modelId);
		} catch (SQLException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		if( m==null )
			return Response.status(Status.NOT_FOUND).build();
		else
			return Response.status(Status.OK).entity(m).build();
	}
	
	@POST
	@Path("upload")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public Response uploadModel(@FormDataParam("file") InputStream is) {
		throw new RuntimeException("IMPLEMENT THIS");
		
	}
}


