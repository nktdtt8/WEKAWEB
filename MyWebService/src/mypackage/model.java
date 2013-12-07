package mypackage;


public class model {

	/**
	 * @param args
	 */
	public String algorithmName;
	public String dataSet;
	public float accuracy;
	
	public void getData()
	{
		
		
	}
	public void setData()
	{
		
	}
	public String print() {
		// TODO Auto-generated method stub
		System.out.println(algorithmName);
		System.out.println(dataSet);
		System.out.println(accuracy);
		String model1= algorithmName+";"+dataSet+";"+accuracy;
		return model1;
		
	}

}
