import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		if(args[0].equals(args[1])){
			System.out.println("Error, same file used both as needle and heystack");
		}
		

		Booyer a = new Booyer();

		Scanner needle = new Scanner(new File(args[0]));

		Scanner haystack = new Scanner(new File(args[1]));
		
		
		//VIKTIG - antar et begge filene har ilke mange linjer
		while(needle.hasNextLine()){
			a.findNeedle(needle.nextLine().toCharArray(), haystack.nextLine());
		}
		
		//shutting up compiler
		needle.close();
		haystack.close();
	}

}
