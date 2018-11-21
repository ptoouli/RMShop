package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class CSV {

	

	// This method will read a CSV file and return a List of String[]
	public static List<String[]> get(String filename) {
		
		List<String[]> data = new ArrayList<String[]>();
		String testRow;
		try 
		{
			// Open and read the file
			BufferedReader br = new BufferedReader(new FileReader(filename));
			// Read data as long as it's not empty
			// Parse the data by comma using .split() method
			// Place into a temporary array, then add to List 
			while ((testRow = br.readLine()) != null) 
			{
				String[] line = testRow.split(",");
				data.add(line);
			}
			
			br.close();
			
		} catch (FileNotFoundException e) {
			System.out.println("ERROR: File not found " + filename);
		} catch (IOException e) {
			System.out.println("ERROR: Could not read " + filename);
		}

		return data;
		
		
		
	}
	
	public static String[] random(String filename) {
		//Assign the csv to an array
		List<String[]> csv = new ArrayList<String[]>();
		csv = CSV.get(filename);
		//Select a random integer (min = 1, max = max rows in array)
		int itemCount = csv.size();
		Random rand = new Random();
		int  n = rand.nextInt(itemCount - 1) + 1;
				
		String[] row = csv.get(n);
		
		return row;
	}
	
	public static String[] specific(String filename, String skuSearch) {
		List<String[]> csv = new ArrayList<String[]>();
		csv = CSV.get(filename);
		int itemCount = csv.size();
		String[] ln = null;
		String[] row = ln;
		
		for (int i=1; i<itemCount; i++) {
			ln = csv.get(i);
			if (skuSearch.equalsIgnoreCase(ln[0])) {
				row = ln;
			} 

		}
		return row;
	}
}
