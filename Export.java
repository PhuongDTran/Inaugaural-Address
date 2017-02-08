/*Phuong Tran
 * Prof. Dr.Charles Reid
 * Couse: CSC 143
 */


import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

import org.apache.commons.csv.*;


public class Export {
	private InauguralAddresses addresses;
	
	public Export( InauguralAddresses addresses)
	{
		this.addresses = addresses;
	}
	
	public void printToCSV() throws IOException
	{
		//reference: http://stackoverflow.com/questions/36289043/java-write-csv-file-with-apache-commons-csv
		String path = System.getProperty("user.dir");
		String outputFile = path + "\\output.csv";
		CSVPrinter csvFilePrinter = new CSVPrinter(new FileWriter(outputFile), CSVFormat.EXCEL.withHeader());
		
		int[][] matrix = addresses.crossWordMatrix();
		
		for(int i =0 ;i<matrix.length;i++)
		{
			for(int j = 0;j<matrix[i].length;j++)
				csvFilePrinter.print(matrix[i][j]);
			csvFilePrinter.println();
		}
		
		csvFilePrinter.close();
	}
}
