public class Simulation 
{

	public Simulation (int year, int month, String date, int number1, int number2, int number3, int number4, int number5){
		this.year = year;
		this.month = month;
		this.date = date;
		this.number1 = number1;
		this.number2 = number2;
		this.number3 = number3;
		this.number4 = number4;
		this.number5 = number5;
	}
	public static void generateData() {

	String csvFilename = "otos.csv";
	CSVReader csvReader = new CSVReader(new FileReader(csvFilename));
	String[] row = null;
	while((row = csvReader.readNext()) != null) {
		Simulation thisround = String[] (year, month, date, number1, number2, number3, number4, number5);

	csvReader.close();
	System.out.println(row);
			
	}
}
