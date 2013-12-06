package mypackage;
import javax.websocket.server.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;

import org.codehaus.jackson.map.ObjectMapper;
import org.xml.sax.SAXException;

import java.io.IOException;


@Path("/modelChar")


//Sets the path to base URL + /hello

public class modelReqResponse {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws JAXBException 
	 * @throws SAXException 
	 */
	
	@GET
	 @Path("{m}")

	  @Produces(MediaType.APPLICATION_JSON)
	  public String modelCharacterstics(@PathParam("m") String m
			  							) throws IOException, SAXException, JAXBException {

		// TODO Auto-generated method stub;
		 System.out.println("Hi" + m);
		if(!m.equals("models"))
		{
			CSVFileModel CSVFileModelobj= new CSVFileModel("scan.txt");
			modelList resultList = CSVFileModelobj.convert();
			resultList.print();
			ObjectMapper jsonMapper = new ObjectMapper();
			
			return jsonMapper.writeValueAsString(resultList);

		}
		return "No matching model";

	 }


	}


