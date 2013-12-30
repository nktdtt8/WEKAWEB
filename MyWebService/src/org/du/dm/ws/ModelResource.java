package org.du.dm.ws;

import java.sql.SQLException;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.du.dm.beans.Model;
import org.du.dm.beans.ModelList;
import org.du.dm.io.DatabaseUtils;


@Path("weka/trained")

public class ModelResource {

	
	@GET
	@Path("models")
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
	@Path("models/{q}")
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
}


