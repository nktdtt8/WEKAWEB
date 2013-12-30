package org.du.dm.ws;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.apache.commons.io.IOUtils;

import com.sun.jersey.multipart.FormDataParam;


/**
 * Used for uploading data via REST
 */

@Path("data")
public class DataResource {

	private final String BASE_DIR = "/tmp";
	@Path("upload")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(@FormDataParam("file") InputStream is) throws IOException {

		String output = UUID.randomUUID().toString();
		OutputStream os = new FileOutputStream(BASE_DIR + "/" + output);
		IOUtils.copyLarge(is,os);
		return Response.status(Status.ACCEPTED).entity(output).build();
	}
}
