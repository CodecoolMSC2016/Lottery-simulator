import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Result {

	public List<Integer> topNumbers = new ArrayList<>();

	int number1;
	int number2;
	int number3;
	int number4;
	int number5;
	int number6;

	public Result() {
	
		this.number1 = number1;
		this.number2 = number2;
		this.number3 = number3;
		this.number4 = number4;
		this.number5 = number5;
		this.number6 = number6;
	}

	public static void getTopNumbers() {

	    String csvFile = "Simulation5.csv";
            String line = "";
            String cvsSplitBy = ",";
		
            try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            	while ((line = br.readLine()) != null) {

                    // use comma as separator
                    String[] number = line.split(cvsSplitBy);

                    System.out.println("[first= " + number[0] + ", secound= " + number[1] + ", third= " + number[2] + ", fourth= " + number[3] + ", fifth= " + number[4]+"]");

            	}

            } catch (IOException e) {
            e.printStackTrace();
            }	

	}


}
