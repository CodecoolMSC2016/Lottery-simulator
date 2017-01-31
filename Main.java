public class Main {

	public static void main (String [] args) {
		int userChoice;
		
		userChoice = Logger.menu();
		switch(userChoice) {
			case 1:
				Simulation.generateData(5, 90);
				break;
			case 2:
				Simulation.generateData(6, 45);
				break;
		}
	
	}
}
