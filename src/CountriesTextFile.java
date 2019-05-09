import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

public class CountriesTextFile {
	
	public static void writeToFile(Country countries) {

		try {
			Path path = Paths.get("countries.txt");

			File file = path.toFile();
			PrintWriter output = null;
			// the FileOutputStream takes 2 params in the constructor
			// the second param is optional and if not included assumed false -- so it will
			// overwrite the file
			// if true is used, it will add additional data to the end of the file (append)
			output = new PrintWriter(new FileOutputStream(file, true));

			output.println(countries);

			output.close();
		} catch (FileNotFoundException e) {
			Path path = Paths.get("countries.txt");
			try {
				Files.createFile(path);
				System.out.println("The file was created successfully!");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public static void writeToFile(ArrayList<Country> countries) {

		try {
			Path path = Paths.get("countries.txt");

			File file = path.toFile();
			PrintWriter output = null;
			// the FileOutputStream takes 2 params in the constructor
			// the second param is optional and if not included assumed false -- so it will
			// overwrite the file
			// if true is used, it will add additional data to the end of the file (append)
			output = new PrintWriter(new FileOutputStream(file, true));

			for (Country s : countries) {
				output.println(s);
			}
			output.close();
		} catch (FileNotFoundException e) {
			Path path = Paths.get("countries.txt");
			try {
				Files.createFile(path);
				System.out.println("The file was created successfully!");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

	public static void readFromFile() {
		String file = "countries.txt";
		Path filePath = Paths.get(file);

		File f = filePath.toFile();
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(f));
			String line = br.readLine();

			while (line != null) {
				// this is just printing the line to the console
				System.out.println(line);
				// this is grabbing the next line of data
				line = br.readLine();
			}

			br.close();

		} catch (FileNotFoundException e) {
			System.out.println("The file was not found...");

		} catch (IOException e) {
			System.out.println("Something crazy happened -- call someone who can help!");

		}
	}

}
