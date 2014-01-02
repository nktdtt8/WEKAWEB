package org.du.dm.constants;

import java.util.logging.Logger;

public interface WekaWSConstants {
	
	public String _DATABASE_CONNECTION_URL = "jdbc:h2:tcp://localhost/~/wekaWS";
	public String _TMP_BASE_DIR = "/tmp/";
	public String _MODEL_TABLE = "modelTable";
	public String _DATA_TABLE = "dataTable";
	public static final Logger LOG = Logger.getLogger("WekaWS");

}
