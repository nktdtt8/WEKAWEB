package org.du.dm.beans;


public class Model {

	/**
	 * @param args
	 */
	private String id;
	private String algorithmName;
	private float accuracy;
	private float precision;
	private float recall;
	private long userid;
	private String location;
	private String desc;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Model() { }
	
	public Model(String id) {
		this.id = id;
	}
	public String getDescription()
	{
		return desc;
		
	}
	
	public float getAccuracy() {
		return accuracy;
	}
	
	public void setAccuracy(float f) {
		accuracy = f;
	}
	
	public void setAlgoName(String name) {
		algorithmName = name;
	}
	public String getAlgoName() {
		return algorithmName;
	}
	
	
	public void setDescription(String data)
	{
		this.desc = data;
	}
	
	
	public String toString() {
		String str = algorithmName+";"+desc+";"+accuracy;
		return str;
	}
 
	@Override
	public boolean equals(Object o ) {
		if(o instanceof Model) {
			return id.equals(((Model) o).id);
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
	public float getPrecision() {
		return precision;
	}
	public void setPrecision(float precision) {
		this.precision = precision;
	}
	public float getRecall() {
		return recall;
	}
	public void setRecall(float recall) {
		this.recall = recall;
	}
	public long getUserid() {
		return userid;
	}
	public void setUserid(long userid) {
		this.userid = userid;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
}
