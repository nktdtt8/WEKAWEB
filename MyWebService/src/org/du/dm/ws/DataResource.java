package org.du.dm.ws;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.io.IOUtils;
import org.du.dm.constants.WekaWSConstants;

import com.sun.jersey.multipart.FormDataParam;


/**
 * Used for uploading data via REST
 */

@Path("data")
public class DataResource {

	@Path("upload")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(@FormDataParam("file") InputStream is) {

		String output = UUID.randomUUID().toString();
		
		try {
			OutputStream os = new FileOutputStream(WekaWSConstants._TMP_BASE_DIR + output);
			IOUtils.copyLarge(is,os);
		} catch (IOException e) {
			return Response.status(Status.BAD_REQUEST).build();
		}
		return Response.status(Status.OK).entity(output).build();
	}
	
	@Path("download/{id}")
	@GET
	@Produces(MediaType.APPLICATION_OCTET_STREAM)
	public Response downloadFile(@PathParam("id") String id) {
		File f = new File(WekaWSConstants._TMP_BASE_DIR + id);
		
		try {
			if(f.exists())
				return Response.status(Status.OK).entity(new FileInputStream(f)).build();
			else
				return Response.status(Status.NOT_FOUND).build();
		}catch(IOException ioe) {
			return Response.status(Status.NOT_FOUND).build();
		}
	}
}
