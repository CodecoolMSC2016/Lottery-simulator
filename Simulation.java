import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Collections;
import java.util.Scanner;

public class Simulation 
{
 	public static List<Integer> winningNumbers = new ArrayList<>();
	public static List<Integer> chosenNumbers = new ArrayList<>();
	public static Scanner sc = new Scanner(System.in);
	public static int winCount = 0, choice;

	public static void generateData(int numberOfBalls, int endNumber) {

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
		} Collections.sort(winningNumbers);
		System.out.println(winningNumbers);
	}
	public static void getChosenNumbers(int numberOfBalls, int endNumber)	{
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
            
            //if the chosen number is in the list of winning numbers, add one the the win count
            if (winningNumbers.contains(choice))
            {
                winCount += 1;
            }
            
        } Collections.sort(chosenNumbers);
		System.out.println(chosenNumbers);
}
	
	
}
