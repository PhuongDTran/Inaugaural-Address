/*Phuong Tran
 * Prof. Dr.Charles Reid
 * Couse: CSC 143
 */




import java.io.IOException;
import java.util.ArrayList;



public class InauguralAddresses {

	private ArrayList<InauguralAddr> addresses;
	
	//constructor
	public InauguralAddresses()
	{
		addresses = new ArrayList<InauguralAddr>();
	}
	
	//accessor
	public ArrayList<InauguralAddr> getAddrs()
	{
		return this.addresses;
	}




	//import inaugural addresses
	public void setAddresses() throws IOException
	{
		String location = System.getProperty("user.dir");
		LoadingCSV csv = new LoadingCSV(location + "\\data\\metadata.csv");
		
		
		for( int i=0; i<csv.getRecords().size();i++)
		{
			String fileName = csv.getRecords().get(i)[0];
			String filePath = location + "\\data\\" + fileName;
			String name = csv.getRecords().get(i)[1];
			String date = csv.getRecords().get(i)[2];

			InauguralAddr addr = new InauguralAddr(filePath, name, date);
			addresses.add(addr);
		}
	}
	
	
	//return a matrix of the numbers of shared words
	public int[][] crossWordMatrix()
	{
		int size = addresses.size();

		int[][] matrix = new int[size][size];
		
		for(int i=0; i<size;i++)
		{
			
			for(int j=i;j<size;j++)
				if ( i==j)
					matrix[i][j] = 0;
				else
				{
					int number = addresses.get(i).totalSharedWords(addresses.get(j));
					matrix[i][j] = number;
					matrix[j][i] = number;
				}
		}

		return matrix;
	}
}
