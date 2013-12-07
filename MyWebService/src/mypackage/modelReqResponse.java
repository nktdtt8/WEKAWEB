package mypackage;

import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBException;
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
	  @Path("allModels/{m}")

	  @Produces(MediaType.APPLICATION_JSON)
	  public String allModels(@PathParam("m") String M
			  							) throws IOException, SAXException, JAXBException {

		// TODO Auto-generated method stub;
		// System.out.println("Hi" + M);
		if(M.equals("models"))
		{
			CSVFileModel CSVFileModelobj= new CSVFileModel("scan.txt");
			modelList resultList = CSVFileModelobj.convert();
			String resultString = resultList.print();
			return resultString;
		}
		return "Use 'models' keyword to search for all models available";

	 }


	@GET
	@Path("matchingModel/{q}")

	  @Produces(MediaType.APPLICATION_JSON)
	  public String matchingModel(@PathParam("q") String modelName
			  							) throws IOException, SAXException, JAXBException {

		// TODO Auto-generated method stub;
		  //  System.out.println("Hi" + modelName);	
			CSVFileModel CSVFileModelobj= new CSVFileModel("scan.txt");
			model result = CSVFileModelobj.compare(modelName);
			if(result != null)
			{		
				String resultString = result.print();
				return resultString;
			}
			else
				return "No matching model";
	 }
}


