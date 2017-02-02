import java.util.concurrent.TimeUnit;
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
