/*Phuong Tran
 * Prof. Dr.Charles Reid
 * Couse: CSC 143
 */


import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;


public class InauguralAddr
{
	private ArrayList<String> text; // unique words of inaugural address
	private String name; // president's name
	private String date; // date of the speech
	
	
	//constructor
	public InauguralAddr(String filePath, String name, String date) 
			throws FileNotFoundException
	{
		this.text = uniqueWord(filePath);
		this.name = name;
		this.date = date;
	}
	
	
	
	//accessors
	public ArrayList<String> getText()
	{
		return text;		
	}
	public String getName()
	{
		return name;
	}
	public String getDate()
	{
		return date;
	}
	
	
	
	//return a number of common words between the two inaugural addresses
	public int totalSharedWords(InauguralAddr other)
	{
		int count = 0;
		for ( String item: other.getText())
			if (text.contains(item))
					count++;
		return count;
	}
	
	
	//return unique words of the inaugural address file
	private ArrayList<String> uniqueWord(String path) 
			throws FileNotFoundException
	{
		Scanner input = new Scanner( new File(path));
		ArrayList<String> unique_words = new ArrayList<String>();
		
		while (input.hasNext())
		{
			String word = input.next().toLowerCase().replaceAll("[^a-z0-9-]","").trim();
			if(!unique_words.contains(word))
				unique_words.add(word);
		
		}
		
		input.close();
		
		return unique_words;
		
	}
}
