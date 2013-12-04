package org.du.dm.io;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * Utility class for reading one line of csv file this class doesn't check
 * for equal dimension for all records
 * @author aniket
 *
 */
public class CsvUtil {

	public BufferedReader reader;
	public String regex;
	private String buffer; 


	public CsvUtil(BufferedReader reader, String regex) {
		this.reader = reader;
		this.regex = regex;
		buffer = "abc";
	}


	public boolean hasNext() throws IOException {
		if(buffer == null)
			reader.close();
		return buffer != null;
	}


	public String[] next() throws IOException {
		buffer = reader.readLine();
		if(buffer == null)
			return null;
		
		return buffer.split(regex);
	}

}


