package mainSrc;
import java.io.File;
import java.io.FileNotFoundException;
//import java.lang.Math;
//import java.util.Random;
import java.util.Scanner; 
public class Driver {
	public static void main(String [] args) {
		//Scanner scan = new Scanner(System.in);
		//System.out.println("Welcome! Press 2 for other stuff, anything else for debug");
		//String input = 1;//scan.nextLine();
	//	int consider = Integer.parseInt(input);
		
		//if(consider == 2) { //do we want to do other
		//	otherUtilities();}
		Cypher lechymod1 = new Cypher("Caliah. Epitaph. Omega. 0215-Daleth.");
		System.out.println("Name: ");
		System.out.println(lechymod1);
		System.out.println(lechymod1.getValue());
		
		System.out.println("Loading from file");
		//Cypher loaded = loadFromFile("preExisting.txt", 1);
		for(int x=1; x<19; x++) {//1 + lines in file
			Cypher loaded = loadFromFile("preExisting.txt", x);
			System.out.println(loaded);
			System.out.println(loaded.getValue());
		}
		
		
		
		
		//scan.close();
	}
	
	public static void otherUtilities() {
		System.out.println("Welcome to utilities. We're blank right now, but soon you'll be able to");
		System.out.println("Press 1 to read from the textfile");
		System.out.println("Or, press 2 to make your own Caliah Cypher");
		System.out.println("Or, press 3 to learn about Caliah Cyphers");
		
	}
	
	public static Cypher loadFromFile(String filename, int line) {
		try {
			//get our data set up
			Scanner reader = new Scanner(new File(filename));
			String readString = "foo";
			for(int x=1; x< line - 1; x++) {
				readString = reader.nextLine(); }
			readString = reader.nextLine();
			Cypher product = new Cypher(readString);
			return product;
			
			
		} catch(FileNotFoundException e) {
			System.out.println("Couldn't find file!");
			return null; }
	}
	
}
