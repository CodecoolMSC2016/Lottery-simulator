import java.util.Scanner;

public class Logger
{

	public static int menu()
	{
		int selection;
		Scanner input = new Scanner (System.in);

		System.out.println("Choose lottery type:");
		System.out.println("-------------------------\n");
		System.out.println("1. Ötös lottó");
		System.out.println("2. Hatos lottó");
		System.out.println("3. Quit");

		selection = input.nextInt();
		// return selection;

		System.out.print("\033[H\033[2J"); // the next 2 lines cleares the console 
		System.out.flush();

		switch(selection) {
			case 1:
				System.out.println("Ötös lottó menu");
				System.out.println("-------------------------\n");
				break;
			case 2:
				System.out.println("Hatos lottó menu");
				System.out.println("-------------------------\n");
				break;
			case 3:
				break;
				
		}
		return selection;

	}
}
