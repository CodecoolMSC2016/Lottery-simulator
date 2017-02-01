import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.File;
import java.io.IOException;
import java.io.FileOutputStream;


public class Simulation 
{
	public static int numberOfBalls;
 	public static List<Integer> winningNumbers = new ArrayList<>();
	public static List<Integer> chosenNumbers = new ArrayList<>();
	public static Scanner sc = new Scanner(System.in);
	public static int winCount = 0, choice;

	public Simulation(int numberOfBalls) {
		this.numberOfBalls = numberOfBalls;
	}

	public static void setNumberOfBalls(int number) {
		numberOfBalls = number;
	}

	public static void generateData(int endNumber) {

		for (int i = 0; i < numberOfBalls; i++)        {
            		int number = (int) (Math.ceil(Math.random() * endNumber));
            
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

    		PrintWriter printout;
		try {
			printout = new PrintWriter(new FileOutputStream("Simulation.csv", true));
			printout.append(Integer.toString(winningNumbers.get(0)));
			printout.append(",");
			printout.append(Integer.toString(winningNumbers.get(1)));
			printout.append(",");
			printout.append(Integer.toString(winningNumbers.get(2)));
			printout.append(",");
			printout.append(Integer.toString(winningNumbers.get(3)));
			printout.append(",");
			printout.append(Integer.toString(winningNumbers.get(4)));
			if (numberOfBalls == 6){
				printout.append(",");
				printout.append(Integer.toString(winningNumbers.get(5)));				
			}
			printout.append("\n");
			printout.close();
		} catch(IOException e) {}
		
		System.out.println(winningNumbers);
            	
		if (winningNumbers.contains(choice))
            	{
                	winCount += 1;
		}
		System.out.println(winCount);
		winningNumbers.clear();
		winCount = 0;
	}
	public static void getChosenNumbers(int endNumber)	{
        Logger.getNumbers();

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
                        Logger.error();
                        continue;
                    }
                    
                    //has the chosen number already been chosen
                    if (chosenNumbers.contains(choice))
                    {
                        Logger.error();
                        continue;
                    }
                    
                    //break loop if inputted value is valid
                    break;
                } 
                
                //catch if inputted value is not integer and reset scanner so it can be re-entered
                catch (InputMismatchException exception) 
                {
                    Logger.error();
                    sc.next();
                }
            }
            
            //add the chosen number to the list
            chosenNumbers.add(choice);
            
        } Collections.sort(chosenNumbers);
		System.out.println(chosenNumbers);

}
	
	
}
