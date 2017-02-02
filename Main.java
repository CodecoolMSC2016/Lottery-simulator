public class Main {

	public static void main (String [] args) {
		int userChoice;
		int repeat;
		Result getnumbers;
		Result getnums;	

		userChoice = Logger.menu();
		switch(userChoice) {
			case 1:
				repeat = Integer.parseInt(args[0]);
				Simulation.getChosenNumbers();
        			for (int i = 0; i < repeat; i++) {
            				Simulation.generateData();
				}
				getnumbers = Simulator.run(Result.getTopNumbers((Result.getAllNumbers("Simulation5.csv"))));
				Logger.log("Result", Simulator.toString(getnumbers), "ts");
				Logger.log("History", "The last 5 years' most common numbers are:", "ts");
				getnums = Result.createResult(Result.getTopNumbers((Result.getAllNumbers("otos.csv"))));
				Logger.log("History", Simulator.toString(getnums), "ts");
				
				break;

		}
	
	}
}
