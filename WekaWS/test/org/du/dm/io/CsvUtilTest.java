package org.du.dm.io;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.StringReader;

import junit.framework.Assert;

import org.junit.Test;


public class CsvUtilTest {
	
	
	@Test
	public void checkCsvUtils() throws IOException {
		StringReader a = new StringReader("aniket|dutta|12|13|15");
		CsvUtil h = new CsvUtil(new BufferedReader(a), "\\|");
		
		
		Assert.assertTrue(h.hasNext());
		Assert.assertEquals(5, h.next().length);
		Assert.assertNull(h.next());
		Assert.assertFalse(h.hasNext());
		
	}

}
