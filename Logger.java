import java.util.*;
import java.text.*;
import java.time.*;

public class Logger
{

	String type;
	String message;
	String timeStamp;
	List<Integer> resultList;

	public Logger(String gettype, String text, List<Integer> resultList) {

		type = gettype;
		message = text;
		resultList = resultList;
		timeStamp = getDateTime();
	}

	public static void log(String type, String message, String ts) {
		System.out.println(getDateTime() + " " + message + "\n");
	}

	public static void logresult(String type, List<Integer> resultList, String ts) {
		System.out.println(getDateTime() + " " + resultList + "\n");
	}

	public static void logsep(String type) {
		System.out.println("--------------------------------------------------\n");
	}

    	public static String getDateTime() {
        	DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        	Date date = new Date();

        	return "[" + dateFormat.format(date) + "] ";
	}

	public static int menu()
	{
		int selection;
		Scanner input = new Scanner (System.in);

		System.out.println("Choose lottery type:");
		System.out.println("-------------------------\n");
		System.out.println("1. Ötös lottó");
		System.out.println("2. Quit");

		selection = input.nextInt();

		System.out.print("\033[H\033[2J");
		System.out.flush();

		switch(selection) {
			case 1:
				System.out.println("Ötös lottó menu");
				System.out.println("-------------------------\n");
				break;

			case 2:
				break;
				
		}
		return selection;
	}

}
