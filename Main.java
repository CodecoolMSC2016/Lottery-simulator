import java.util.*;

public class Main {

	static int round;
	public static List<Simulation> sims = new ArrayList<Simulation>();
	public static int number1, number2, number3, number4, number5, winCount;

	public static void main (String [] args) {
		int userChoice;
		int repeat;
		Result getnumbers;
		Result getnums;
	
		Logger.printLogo();	

		userChoice = Logger.menu();
		switch(userChoice) {
			case 1:
				repeat = Integer.parseInt(args[0]);
				Simulation.getChosenNumbers();
				Logger.printLottery();
				Logger.waitTime(3000);
				generateSimulation(repeat);
				getnumbers = Simulator.run(Result.getTopNumbers((Result.getAllNumbers("Simulation5.csv"))));
				Logger.log("Result", Simulator.toString(getnumbers), "ts");
				Logger.log("History", "The last 5 years' most common numbers are:", "ts");
				getnums = Result.createResult(Result.getTopNumbers((Result.getAllNumbers("otos.csv"))));
				Logger.log("History", Simulator.toString(getnums), "ts");
				
				break;

		}
	
	}
	public static Simulation generateSimulation(int round) {
		Simulation sim = new Simulation(number1, number2, number3, number4, number5, winCount);
			for(int i = 1; i<= round; i++) {
				sim.generateData();
			}
		return sim;
	}
}
