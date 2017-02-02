import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;


public class Result {

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

	public static List<String> getAllNumbers (String filename) {
		List<String> allNumbers = new ArrayList<>();
        	Path pathToFile = Paths.get(filename);

        	try (BufferedReader br = Files.newBufferedReader(pathToFile,
                	StandardCharsets.US_ASCII)) {

            	String line = br.readLine();

            	while (line != null) {

                		String [] attributes = line.split(",");
	
				for(int i=0; i<5; i++) {
                			allNumbers.add(attributes[i]);
				}

                		line = br.readLine();
            		}

        	} catch (IOException ioe) {
            		ioe.printStackTrace();
        	}
		Collections.sort(allNumbers);
        return allNumbers;
    	}

	public static List<String> getTopNumbers (List<String> allnumbers) {
		List<String> topNumbers = new ArrayList<>();		
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

