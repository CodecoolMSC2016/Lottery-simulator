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


public class Result {

	public static List<String> topNumbers = new ArrayList<>();

	public static int number1;
	public static int number2;
	public static int number3;
	public static int number4;
	public static int number5;
	public static int number6;

	public Result() {
	
		this.number1 = number1;
		this.number2 = number2;
		this.number3 = number3;
		this.number4 = number4;
		this.number5 = number5;
		this.number6 = number6;
	}

	public static List<String> getTopNumbers () {
        	Path pathToFile = Paths.get("Simulation5.csv");
<<<<<<< HEAD

<<<<<<< HEAD
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
                			topNumbers.add(attributes[i]);
				}
=======
	    String csvFile = "Simulation5.csv";
            String line = "";
            String cvsSplitBy = ",";
		
            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            	while ((line = br.readLine()) != null) {
=======
>>>>>>> 0636eea3867f3c509f22de47fe3466f672468570

        	// create an instance of BufferedReader
        	// using try with resource, Java 7 feature to close resources
        	try (BufferedReader br = Files.newBufferedReader(pathToFile,
                	StandardCharsets.US_ASCII)) {

            	// read the first line from the text file
            	String line = br.readLine();

            	// loop until all lines are read
            	while (line != null) {

            } catch (IOException e) {
            e.printStackTrace();
            }	

	}
                	// use string.split to load a string array with the values from
                	// each line of
                	// the file, using a comma as the delimiter
                		String [] attributes = line.split(",");
	
                	// adding all numbers into ArrayList
				for(int i=0; i<5; i++) {
                			topNumbers.add(attributes[i]);
				}
>>>>>>> 0636eea3867f3c509f22de47fe3466f672468570

               		// read next line before looping
                	// if end of file reached, line would be null
                		line = br.readLine();
            		}

        	} catch (IOException ioe) {
            		ioe.printStackTrace();
        	}
		Collections.sort(topNumbers);
        return topNumbers;
    }
	
}

