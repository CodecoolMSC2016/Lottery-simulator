public class Main {

	public static void main (String [] args) {
		int userChoice;
		int repeat;		

		userChoice = Logger.menu();
		switch(userChoice) {
			case 1:
				Simulation.generateData(5, 90);
				Simulation.getChosenNumbers(5, 90);
				break;
			case 2:
				Simulation.generateData(6, 45);
				Simulation.getChosenNumbers(6, 45);
				break;
		}

		repeat = Integer.parseInt(args[0]);
        		for (int i = 0; i < repeat; i++) {
            			System.out.println("Yes"); // change: Type: Simulation, .generateSimulation(repeat)
			}
	
	}
}
