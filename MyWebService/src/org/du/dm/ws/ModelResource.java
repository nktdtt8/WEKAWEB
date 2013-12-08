package org.du.dm.ws;

import java.io.FileNotFoundException;

import javax.ws.rs.PathParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.du.dm.beans.Model;
import org.du.dm.beans.ModelList;
import org.du.dm.io.CSVFileModel;
import org.du.dm.io.FileModelInterface;


@Path("weka")

//Sets the path to base URL + /hello

public class ModelResource {

	/**
	 * @param args
	 * @throws FileNotFoundException 
	 * @throws IOException 
	 * @throws JAXBException 
	 * @throws SAXException 
	 */

	@GET
	@Path("models")
	@Produces(MediaType.TEXT_PLAIN)
	public String getAllModels() throws FileNotFoundException {

		FileModelInterface csvFileModelobj= new CSVFileModel("/home/aniket/scan.txt");
		
		ModelList resultList = csvFileModelobj.convert();
		return resultList.toString();

	}


	@GET
	@Path("models/{q}")

	@Produces(MediaType.TEXT_PLAIN)
	public String matchingModel(@PathParam("q") String modelId
			) throws FileNotFoundException {

		FileModelInterface csvFileModelobj= new CSVFileModel("/home/aniket/scan.txt");
		ModelList lst = csvFileModelobj.convert();
		Model q = new Model(modelId);
		return lst.get(q).toString();
	}
}


