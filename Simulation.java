import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;

public class Simulation 
{
 	public static List<Integer> winningNumbers = new ArrayList<>();

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
		} System.out.println(winningNumbers);			
	}
	
}
