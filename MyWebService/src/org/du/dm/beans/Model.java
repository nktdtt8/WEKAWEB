package org.du.dm.beans;


public class Model {

	/**
	 * @param args
	 */
	protected String id;
	protected String algorithmName;
	protected String desc;
	protected float accuracy;
	
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
}
