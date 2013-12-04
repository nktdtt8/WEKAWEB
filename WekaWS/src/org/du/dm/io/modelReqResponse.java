package mypackage;

import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//Sets the path to base URL + /hello
@Path("/modelChar")

public class modelReqResponse {

	/**
	 * @param args
	 * @throws IOException 
	 */
	 @GET
	 @Path("/{m}")

	  @Produces(MediaType.APPLICATION_JSON)
	  public String modelCharacterstics(@PathParam("m") String m
			  							) throws IOException {

		// TODO Auto-generated method stub;
		 System.out.println("Hi" + m);
		if(m.equals("models"))
		{
			String scan;
			String result= "";
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


