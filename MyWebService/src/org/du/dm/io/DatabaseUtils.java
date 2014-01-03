package org.du.dm.io;

import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.commons.io.FileUtils;
import org.du.dm.beans.Data;
import org.du.dm.beans.Model;
import org.du.dm.beans.ModelList;
import org.du.dm.constants.WekaWSConstants;

/**
 * 
 * Create new Database instance
 * All database activities are done here
 * @author neha
 *
 */
public class DatabaseUtils {
	
	private static Connection conn;
	
	
	static {
		try {
			Class.forName("org.h2.Driver");
			setConn(DriverManager.getConnection(WekaWSConstants._DATABASE_CONNECTION_URL, "sa", ""));
		} catch (SQLException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		} 
	}

	public static Connection getConn() {
		return conn;
	}

	private static void setConn(Connection connection) {
		conn = connection;
	}

	/**
	 * 
	 * @param id		the model id
	 * @return			if model exists then model bean null otherwise
	 * @throws SQLException
	 */
	public static Model readModel(String id) throws SQLException {
		PreparedStatement stm = conn.prepareStatement("select * from "+WekaWSConstants._MODEL_TABLE+" where id = '"+id+"'");
		ResultSet result = stm.executeQuery();
		Model m = new Model();
		while(result.next()) {
			m.setAccuracy(result.getFloat("accuracy"));
			m.setAlgoName(result.getString("algoName"));
			m.setDescription(result.getString("desc"));
			m.setLocation(result.getString("location"));
			m.setPrecision(result.getFloat("precision"));
			m.setRecall(result.getFloat("recall"));
			m.setId(result.getString("id"));
			m.setUserid(result.getLong("userid"));
		}
		
		if(m.getId() == null || m.getId().isEmpty())
			return null;
		else
			return m;
	}
	
	/**
	 * 
	 * @return				the whole list of models present
	 * @throws SQLException
	 */
	public static ModelList readAllModel() throws SQLException {
		PreparedStatement stm = conn.prepareStatement("select * from "+WekaWSConstants._MODEL_TABLE);
		ResultSet result = stm.executeQuery();
		ModelList list = new ModelList();
		while(result.next()) {
			Model m = new Model();
			m.setAccuracy(result.getFloat("accuracy"));
			m.setAlgoName(result.getString("algoName"));
			m.setDescription(result.getString("desc"));
			m.setLocation(result.getString("location"));
			m.setPrecision(result.getFloat("precision"));
			m.setRecall(result.getFloat("recall"));
			m.setId(result.getString("id"));
			m.setUserid(result.getLong("userid"));
			list.add(m);
		}
		
		return list;
	}
	/**
	 * 
	 * @param dataId		the id in the datatable
	 * @return				incase data is found null otherwise
	 * @throws SQLException
	 */
	public static Data readData(String dataId) throws SQLException {
		PreparedStatement stm = conn.prepareStatement("select * from "+WekaWSConstants._DATA_TABLE+" where id = '"+dataId+"'");
		ResultSet result = stm.executeQuery();
		Data d = new Data();
		while(result.next()) {
			d.setDesc(result.getString("desc"));
			d.setFileName(result.getString("filename"));
			d.setId(result.getString("id"));
			d.setLabeled(result.getBoolean("islabel"));
			d.setType(result.getByte("type"));
			d.setLocation(result.getString("location"));
		}
		
		if(d.getId() == null || d.getId().isEmpty())
			return null;
		else
			return d;
	}
	
	/**
	 * 
	 * @param d			the data bean
	 * @throws SQLException		incase of any type mismatch (order is important)
	 */
	public static void persistData(Data d) throws SQLException {
		PreparedStatement stm = conn.prepareStatement("insert into "+WekaWSConstants._DATA_TABLE+" values(?,?,?,?,?,?)");
		stm.setString(3,d.getId());
		stm.setString(2, d.getFileName());
		stm.setString(1, d.getDesc());
		stm.setString(6, d.getLocation());
		stm.setByte(5, d.getType());
		stm.setBoolean(4, d.isLabeled());
		stm.executeUpdate();
	}
	
	public static void persistModel(Model m) {
		throw new RuntimeException("TO BE IMPLEMENTED SOON");
	}
	
	/**
	 * 
	 * @param fileName		name of the output file
	 * @param data			the data to be written
	 * @return				if successfully written to disk
	 */
	public static boolean writeToFile(String fileName, String data) {
		File newFile = new File(WekaWSConstants._TMP_BASE_DIR + fileName);
		if(newFile.exists())
			return false;
		try {
			System.out.println(data);
			FileUtils.write(newFile, data);
		} catch (IOException e) {
			return false;	//incase of any IO error
		}
		
		
		return true;
	}
}
