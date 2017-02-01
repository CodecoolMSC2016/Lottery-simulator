public class Main {

	public static void main (String [] args) {
		int userChoice;
		
		userChoice = Logger.menu();
		switch(userChoice) {
			case 1:
				Simulation.setNumberOfBalls(5);
				Simulation.generateData(90);
				Simulation.getChosenNumbers(90);
				break;
			case 2:
				Simulation.setNumberOfBalls(5);
				Simulation.generateData(45);
				Simulation.getChosenNumbers(45);
				break;
		}
	
	}
}
