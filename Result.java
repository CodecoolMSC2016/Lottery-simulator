import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.Collections;
import java.util.*;


public class Result {

	public static List<String> allNumbers = new ArrayList<>();
	public static List<String> topNumbers = new ArrayList<>();
	public static String temp , mostCommon;	
	public static int max = 0;

	public int number1;
	public int number2;
	public int number3;
	public int number4;
	public int number5;



	public Result(int number1, int number2, int number3, int number4, int number5) {
	
		this.number1 = number1;
		this.number2 = number2;
		this.number3 = number3;
		this.number4 = number4;
		this.number5 = number5;
	}

	public static List<String> getAllNumbers () {
        	Path pathToFile = Paths.get("Simulation5.csv");

        	// create an instance of BufferedReader
        	// using try with resource, Java 7 feature to close resources
        	try (BufferedReader br = Files.newBufferedReader(pathToFile,
                	StandardCharsets.US_ASCII)) {

            	// read the first line from the text file
            	String line = br.readLine();

            	// loop until all lines are read
            	while (line != null) {

                	// use string.split to load a string array with the values from
                	// each line of
                	// the file, using a comma as the delimiter
                		String [] attributes = line.split(",");
	
                	// adding all numbers into ArrayList
				for(int i=0; i<5; i++) {
                			allNumbers.add(attributes[i]);
				}

               		// read next line before looping
                	// if end of file reached, line would be null
                		line = br.readLine();
            		}

        	} catch (IOException ioe) {
            		ioe.printStackTrace();
        	}
		Collections.sort(allNumbers);
        return allNumbers;
    	}

	public static List<String> getTopNumbers (List<String> allnumbers) {
		
		Set<String> unique = new HashSet<String>(allnumbers);
		for (int i=0; i<5; i ++ ) {
			for (String key : unique) {

				if (Collections.frequency(allnumbers, key) > max && !(topNumbers.contains(key))) {

					max = Collections.frequency(allnumbers, key);
					mostCommon = key;
					
				} 
			}topNumbers.add(mostCommon);
			max = 0;
		}

		return topNumbers;
	}
	public static Result createResult (List<String> topnumbers) {
		int number1 = Integer.parseInt(topnumbers.get(0));
		int number2 = Integer.parseInt(topnumbers.get(1));
		int number3 = Integer.parseInt(topnumbers.get(2));
		int number4 = Integer.parseInt(topnumbers.get(3));
		int number5 = Integer.parseInt(topnumbers.get(4));
			
		return new Result(number1, number2, number3, number4, number5);
	}
	
}

