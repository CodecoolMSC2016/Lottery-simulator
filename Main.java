public class Main {

	public static void main (String [] args) {
		int userChoice;
		int repeat;		

		userChoice = Logger.menu();
		switch(userChoice) {
			case 1:
				Simulation.setNumberOfBalls(5);
				repeat = Integer.parseInt(args[0]);
				System.out.println(repeat);
				Simulation.getChosenNumbers(90);
        			for (int i = 0; i < repeat; i++) {
            				Simulation.generateData(90);
				}
				break;
			case 2:
				Simulation.setNumberOfBalls(6);
				repeat = Integer.parseInt(args[0]);
				System.out.println(repeat);
				Simulation.getChosenNumbers(45);
        			for (int i = 0; i < repeat; i++) {
            				Simulation.generateData(45);
				}
				break;
		}
	
	}
}
