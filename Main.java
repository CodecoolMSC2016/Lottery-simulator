public class Main {

	public static void main (String [] args) {
		int userChoice;
		int repeat;
		Result new1;	

		userChoice = Logger.menu();
		switch(userChoice) {
			case 1:
				Simulation.setNumberOfBalls(5);
				repeat = Integer.parseInt(args[0]);
				Simulation.getChosenNumbers(90);
        			for (int i = 0; i < repeat; i++) {
            				Simulation.generateData(90);
				}
				System.out.println(Result.getTopNumbers((Result.getAllNumbers())));
				new1 = Simulator.run(Result.getTopNumbers((Result.getAllNumbers())));
				System.out.println(Simulator.toString(new1));
				
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
