import java.util.ArrayList;
import java.util.Scanner;

public class CountriesApp {

	public static void main(String[] args) {

		Scanner scan =  new Scanner(System.in);
		ArrayList<Country> countries = new ArrayList<>();
		
		System.out.println("Welcome to the Countries Maintenance Application!");
		System.out.println("1.- See the list of countries");
		System.out.println("2.- Add a country");
		System.out.println("3.- Exit \n");
		char flag = 'y';
		do {
		String option = Validator.getStringMatchingRegex(scan, "\nEnter menu number: ", "^[123]{1}");
		
		switch (option) {
		case "1":
			CountriesTextFile.readFromFile();
			break;
		case "2":
			System.out.println();
			addingCountry(scan);
			CountriesTextFile.writeToFile(countries);
			break;
		case "3":
			System.out.println("Hasta la vista baby!");
			flag = 'n';
			break;
		} 
		
		} while (flag == 'y');
			
	}
	
	public static void addingCountry(Scanner scan) {
		System.out.println("Enter country: ");
		String country = scan.nextLine();
		System.out.println("Enter population: ");

		long population = scan.nextLong();
		scan.nextLine();
		Country pais = new Country();
		pais.setName(country);
		pais.setPopulation(population);
		CountriesTextFile.writeToFile(pais);
		System.out.println("Country has been saved!\n");
	}
	

}
