/*Phuong Tran
 * Prof. Dr.Charles Reid
 * Couse: CSC 143
 */




import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;

import org.apache.commons.csv.*;




public class LoadingCSV {
	
	private ArrayList<String[]> records;
	
	
	public LoadingCSV(String filePath) 
			throws IOException
	{
		records = new ArrayList<String[]>();
		
		// Reference: commons.apache.org/proper/commons-csv/user-guide.html
		Reader in = new FileReader(filePath);
		Iterable<CSVRecord> data = CSVFormat.EXCEL.withHeader().parse(in);
		for(CSVRecord row: data)
		{
			String[] item = new String[3];
			
			item[0] = row.get("filename"); 
			item[1] = row.get("name");
			item[2] = row.get("date");
			
			records.add(item);
		}
		
		
	}
	
	
	public ArrayList<String[]> getRecords()
	{
		return records;
	}
	
	
}
