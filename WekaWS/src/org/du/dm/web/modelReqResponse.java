package org.du.dm.web;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import javax.websocket.server.PathParam;

import com.google.common.net.MediaType;

//Sets the path to base URL + /hello
@Path("/models")

public class modelReqResponse {

	/**
	 * @param args
	 * @throws IOException 
	 */
	 @GET
	 @Path("{m}")

	  @Produces(MediaType.APPLICATION_JSON)
	  public String modelCharacterstics(@PathParam("m") String m
			  							) throws IOException {

		// TODO Auto-generated method stub;
		 System.out.println("Hi" + m);
		if(m.equals("models"))
		{
			String scan;
			String result= "";
			//[TODO remove hard coded file name and use CsvUtil add validation]
	        FileReader file = new FileReader("C:\\Users\\neha\\workspace\\MyWebService\\src\\mypackage\\scan.txt");
	        BufferedReader br = new BufferedReader(file);

	        while((scan = br.readLine()) != null)
	         {
	            System.out.println(scan);
	            String[] parts = scan.split(";");

		        for(int i =0;i<3;i++)
		        {
		        	System.out.println(parts[i]);
		        	
		
					result += parts[i];
		        }
	          }
	      	        br.close();
					return result;
		}
		return "No matching model";

	 }
	}


