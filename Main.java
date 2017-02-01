public class Main {

	public static void main (String [] args) {
		int userChoice;
		int repeat;		

		userChoice = Logger.menu();
		switch(userChoice) {
			case 1:
				Simulation.setNumberOfBalls(5);
				Simulation.generateData(90);
				Simulation.getChosenNumbers(90);
				break;
			case 2:
				Simulation.setNumberOfBalls(6);
				Simulation.generateData(45);
				Simulation.getChosenNumbers(45);
				break;
		}

		repeat = Integer.parseInt(args[0]);
        		for (int i = 0; i < repeat; i++) {
            			System.out.println("Yes"); // change: Type: Simulation, .generateSimulation(repeat)
			}
	
	}
}
