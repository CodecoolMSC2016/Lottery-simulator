import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;



public class Simulation 
{
	public static int numberOfBalls, number1, number2, number3, number4, number5;
 	public static List<Integer> winningNumbers = new ArrayList<>();
	public static List<Integer> chosenNumbers = new ArrayList<>();
	public static List<Simulation> loaded = new ArrayList<>();
	public static Scanner sc = new Scanner(System.in);
	public static int winCount = 0, choice;

	public Simulation(int numberOfBalls, int number1, int number2, int number3, int number4, int number5) {
		this.numberOfBalls = numberOfBalls;
		this.number1 = number1;
		this.number2 = number2;
		this.number3 = number3;
		this.number4 = number4;
		this.number5 = number5;

	}

	public static void setNumberOfBalls(int number) {
		numberOfBalls = number;
	}

	public static void generateData(int endNumber) {

		for (int i = 0; i < numberOfBalls; i++)        {
            		int number = (int) (Math.ceil(Math.random() * endNumber));
			if (chosenNumbers.contains(number))
            			{
                			winCount += 1;
				}
            
            		while (true)
            		{
                		if (winningNumbers.contains(number))
                		{
                    			number = (int) (Math.ceil(Math.random() * endNumber));
                		}
                
                		else
                		{
                    			winningNumbers.add(number);
                    			break;
                		}
            		}
		}
		Collections.sort(winningNumbers);

		writeCsv();
	}

	private static void writeCsv() {

		if (numberOfBalls == 5) {
			
			PrintWriter printout;
			try {				
				printout = new PrintWriter(new FileOutputStream("Simulation5.csv", true));				
				printout.append(Integer.toString(winningNumbers.get(0)));
				printout.append(",");
				printout.append(Integer.toString(winningNumbers.get(1)));
				printout.append(",");
				printout.append(Integer.toString(winningNumbers.get(2)));
				printout.append(",");
				printout.append(Integer.toString(winningNumbers.get(3)));
				printout.append(",");
				printout.append(Integer.toString(winningNumbers.get(4)));
				printout.append(",");
				printout.append(Integer.toString(winCount));				
				printout.append("\n");
				printout.close();
				Logger.log("Show generated numbers", "Generated numbers: ", "ts");
				Logger.logresult("Print out generated numbers", winningNumbers, "ts");
				Logger.log("Show matches between choosen and generated numbers", "Matches found: ", "ts");
				Logger.log("Print out matches", Integer.toString(winCount), "ts");
				Logger.logsep("Separe each generation");
				winningNumbers.clear();
				winCount = 0;
			} catch(IOException e) {}
		
			
		}
		if (numberOfBalls == 6) {
			
			PrintWriter printout;
			try {				
				if (winningNumbers.contains(choice))
            				{
                				winCount += 1;
					}
				printout = new PrintWriter(new FileOutputStream("Simulation6.csv", true));				
				printout.append(Integer.toString(winningNumbers.get(0)));
				printout.append(",");
				printout.append(Integer.toString(winningNumbers.get(1)));
				printout.append(",");
				printout.append(Integer.toString(winningNumbers.get(2)));
				printout.append(",");
				printout.append(Integer.toString(winningNumbers.get(3)));
				printout.append(",");
				printout.append(Integer.toString(winningNumbers.get(4)));
				printout.append(",");
				printout.append(Integer.toString(winningNumbers.get(5)));
				printout.append(",");
				printout.append(Integer.toString(winCount));				
				printout.append("\n");
				printout.close();
				Logger.log("Show generated numbers", "Generated numbers: ", "ts");
				Logger.logresult("Print out generated numbers", winningNumbers, "ts");
				Logger.log("Show matches between choosen and generated numbers", "Matches found: ", "ts");
				Logger.log("Print out matches", Integer.toString(winCount), "ts");
				Logger.logsep("Separe each generation");
				winningNumbers.clear();
				winCount = 0;
			} catch(IOException e) {}
		
			
		}


	}

	public static void getChosenNumbers(int endNumber)	{
        Logger.log("getNumbers", "Enter your numbers:", "ts");

        //get the numbers from the user
        for (int i = 0; i < numberOfBalls; i++)
        {
            //while the input is invalid
            while (true) 
            {  
                try 
                {
                    choice = sc.nextInt();
                    
                    //is the chosen number in the correct range
                    if (choice < 1 || choice > endNumber)
                    {
                        Logger.log("Error", "The number you entered, not in range!", "ts");
                        continue;
                    }
                    
                    //has the chosen number already been chosen
                    if (chosenNumbers.contains(choice))
                    {
                        Logger.log("Error", "This number was chosen already!", "ts");
                        continue;
                    }
                    
                    //break loop if inputted value is valid
                    break;
                } 
                
                //catch if inputted value is not integer and reset scanner so it can be re-entered
                catch (InputMismatchException exception) 
                {
                    Logger.log("Error", "The value is not an integer!", "ts");
                    sc.next();
                }
            }
            
            //add the chosen number to the list
            chosenNumbers.add(choice);
            
        } Collections.sort(chosenNumbers);
	Logger.logsep("Separe your numbers");
	Logger.log("Show your numbers", "Your numbers: ", "ts");
	Logger.logresult("Print out your numbers", chosenNumbers, "ts");
	Logger.logsep("Separe your numbers");

}	public static List<Simulation> load () {
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
				Simulation sim = createSim (attributes);
	
                	// adding all numbers into ArrayList
                		loaded.add(sim);

               		// read next line before looping
                	// if end of file reached, line would be null
                		line = br.readLine();
            		}

        	} catch (IOException ioe) {
            		ioe.printStackTrace();
        	}
        return loaded;
    	}

	public static Simulation createSim(String[] getlist) {

		numberOfBalls = 5;
		number1 = Integer.parseInt(getlist[1]);
		number2 = Integer.parseInt(getlist[1]);
		number3 = Integer.parseInt(getlist[1]);
		number4 = Integer.parseInt(getlist[1]);
		number5 = Integer.parseInt(getlist[1]);

		return new Simulation(numberOfBalls, number1, number2, number3, number4, number5);
	}
	
}
