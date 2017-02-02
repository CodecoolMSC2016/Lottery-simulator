import java.util.*;
import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;

public class Simulation 
{
	public static int number1, number2, number3, number4, number5;
 	public static List<Integer> winningNumbers = new ArrayList<>();
	public static List<Integer> chosenNumbers = new ArrayList<>();
	public static List<Simulation> loaded = new ArrayList<>();
	public static Scanner sc = new Scanner(System.in);
	public static int winCount = 0, choice;

	public Simulation(int number1, int number2, int number3, int number4, int number5, int winCount) {
		this.number1 = number1;
		this.number2 = number2;
		this.number3 = number3;
		this.number4 = number4;
		this.number5 = number5;
		this.winCount = winCount;

	}

	public static void generateData() {

		for (int i = 0; i < 5; i++)        {
            		int number = (int) (Math.ceil(Math.random() * 90));
			if (chosenNumbers.contains(number))
            			{
                			winCount += 1;
				}
            
            		while (true)
            		{
                		if (winningNumbers.contains(number))
                		{
                    			number = (int) (Math.ceil(Math.random() * 90));
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

	public static void getChosenNumbers()	{
        Logger.log("getNumbers", "Enter your numbers:", "ts");

        for (int i = 0; i < 5; i++)
        {
            while (true) 
            {  
                try 
                {
                    choice = sc.nextInt();
                    
                    if (choice < 1 || choice > 90)
                    {
                        Logger.log("Error", "The number you entered, not in range!", "ts");
                        continue;
                    }
                    
                    if (chosenNumbers.contains(choice))
                    {
                        Logger.log("Error", "This number was chosen already!", "ts");
                        continue;
                    }
                    
                    break;
                } 
                
                catch (InputMismatchException exception) 
                {
                    Logger.log("Error", "The value is not an integer!", "ts");
                    sc.next();
                }
            }
            chosenNumbers.add(choice);
            
        } Collections.sort(chosenNumbers);
	
	Logger.logsep("Separe your numbers");
	Logger.log("Show your numbers", "Your numbers: ", "ts");
	Logger.logresult("Print out your numbers", chosenNumbers, "ts");
	Logger.logsep("Separe your numbers");

}	public static List<Simulation> load () {
        	Path pathToFile = Paths.get("Simulation5.csv");

        	try (BufferedReader br = Files.newBufferedReader(pathToFile,
                	StandardCharsets.US_ASCII)) {

            	String line = br.readLine();

            	while (line != null) {

                		String [] attributes = line.split(",");
				Simulation sim = createSim (attributes);
	
                		loaded.add(sim);

                		line = br.readLine();
            		}

        	} catch (IOException ioe) {
            		ioe.printStackTrace();
        	}
        return loaded;
    	}

	public static Simulation createSim(String[] getlist) {

		number1 = Integer.parseInt(getlist[0]);
		number2 = Integer.parseInt(getlist[1]);
		number3 = Integer.parseInt(getlist[2]);
		number4 = Integer.parseInt(getlist[3]);
		number5 = Integer.parseInt(getlist[4]);
		winCount = Integer.parseInt(getlist[5]);

		return new Simulation(number1, number2, number3, number4, number5, winCount);
	}
	
}
