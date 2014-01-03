package org.du.dm.ws;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.SQLException;
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
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import org.du.dm.beans.Data;
import org.du.dm.constants.WekaWSConstants;
import org.du.dm.io.DatabaseUtils;

import com.sun.jersey.multipart.FormDataParam;


/**
 * Used for uploading data via REST
 */

@Path("data")
public class DataResource {

	@Path("upload")
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	public Response uploadFile(@FormDataParam("file") InputStream is) {
		String output = UUID.randomUUID().toString();
		WekaWSConstants.LOG.severe("generated output filename: ["+output+"]");
		try {
			OutputStream os = new FileOutputStream(WekaWSConstants._TMP_BASE_DIR + output);
			IOUtils.copyLarge(is,os);
		} catch (IOException e) {
			WekaWSConstants.LOG.info(e.toString());
			return Response.status(Status.BAD_REQUEST).build();
		}
		
		//insert to database
		
		Data d = new Data();
		d.setFileName(output);
		d.setId(output);
		d.setDesc("test data file");
		d.setLabeled(false);
		d.setType((byte)0);
		d.setLocation(WekaWSConstants._TMP_BASE_DIR + output);
		
		try {
			DatabaseUtils.persistData(d);
			JSONObject obj = new JSONObject();
			obj.put("id", output);
			return Response.status(Status.OK).entity(obj).build();
		} catch (SQLException e) {
			//delete the file if exists incase we are here !!!
			File f = new File(WekaWSConstants._TMP_BASE_DIR + output);
			if(f.exists()) {
				f.delete();
				WekaWSConstants.LOG.info("deleted file: ["+f.getName()+"]");
			}
			
			WekaWSConstants.LOG.info(e.toString());
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		} catch (JSONException e) {
			//we will never be here
			return null;
		}
		
		
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
