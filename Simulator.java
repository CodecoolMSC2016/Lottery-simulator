import java.io.*;
import java.nio.charset.*;
import java.nio.file.*;
import java.util.*;


public class Simulator
{
    public Simulation simulation;
    public static Logger logger;
	
    public Simulator(Simulation simulation, Logger logger)
    {
        this.simulation = simulation;
	this.logger = logger;
    }

    public static Result run(List<String> topnumbers)
    {
		Logger.log("Result", "Calculate the best numbers to win: ", "ts");
    		Logger.waitTime(3000); 
		Logger.log("Result", "These are your winning numbers!: ", "ts");
		
		int number1 = Integer.parseInt(topnumbers.get(0));
		int number2 = Integer.parseInt(topnumbers.get(1));
		int number3 = Integer.parseInt(topnumbers.get(2));
		int number4 = Integer.parseInt(topnumbers.get(3));
		int number5 = Integer.parseInt(topnumbers.get(4));
			
		return new Result(number1, number2, number3, number4, number5);
		
    }
	public static String toString(Result result) {
		return result.number1 + " " + result.number2 + " " + result.number3 + " " + result.number4 + " " + result.number5;
	}

	


}
