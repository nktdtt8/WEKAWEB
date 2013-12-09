package org.du.dm.ws;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;
import java.io.File;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import com.sun.jersey.multipart.FormDataParam;


/**
 * Used for uploading data via REST
 */

@Path("/weka")
public class UploadDataResource {

	private final String BASE_DIR = "D:/tmp";
	@Path("/fileupload")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(@FormDataParam("file") InputStream is) throws IOException {

		String output = UUID.randomUUID().toString();
		OutputStream os = new FileOutputStream(BASE_DIR + "/" + output);
		saveFileTo(is,os);
		System.out.println("File Uploaded");
		return Response.status(200).entity(output).build();
	}

	private void saveFileTo(InputStream is, OutputStream os) throws IOException {
		int read = 0;
		byte[] bytes = new byte[1024];
		while ((read = is.read(bytes)) != -1) {
			os.write(bytes, 0, read);
		}
		os.flush();
		os.close();
	}
}
