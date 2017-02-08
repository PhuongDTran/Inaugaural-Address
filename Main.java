import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import org.apache.commons.csv.*;

public class Main {

	public static void main(String[] args) 
			throws FileNotFoundException,IOException
	{
		InauguralAddresses addrs = new InauguralAddresses();
		addrs.setAddresses();
		
		int[][] m = addrs.crossWordMatrix();

		//print to screen
		for( int i =0 ;i<m.length;i++)
			System.out.println(Arrays.toString(m[i]));
		
		//export to csv file
		Export ex = new Export(addrs);
		ex.printToCSV();
	}

}
