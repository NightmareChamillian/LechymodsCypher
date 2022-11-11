package mainSrc;
//import java.io.*;
//import java.util.*;
//import java.math.*;

public class Cypher {
	public String key1;
	public String key2;
	public String key3;
	public String hash;
	public String abjad;
	
	public Cypher() {//make the breaker cypher 
		this("Homestead. Ziasharah. Homestead. 1111-Aleph.");}
	
	//construct one from variables sent
	public Cypher (String first, String second, String third, int code, String master) {
		key1 = first;
		key2 = second;
		key3 = third;
		hash = String.valueOf(code);
		abjad = master;
		
	}
	
	public Cypher (String first, String second, String third, String code, String master) {
		key1 = first;
		key2 = second;
		key3 = third;
		hash = code;
		abjad = master;
		
	}
	//construct based off a string
	public Cypher(String input) {
		String [] processed = input.split(" ");
		//System.out.println(processed[0]);
		//System.out.println(processed[1]);
		//System.out.println(processed[2]);
		//System.out.println(processed[3]);
		
		//assign, trim period
		key1 = processed[0];
		key1 = key1.substring(0, key1.length() -1);
		
		key2 = processed[1];
		key2 = key2.substring(0, key2.length() -1);
		
		key3 = processed[2];
		key3 = key3.substring(0, key3.length() -1);
		
		//break the final one up according to the dash
		String[] furtherProcessing = processed[3].split("-");
		
		//the hash's pretty easy to grab
		hash = furtherProcessing[0];
		
		
		//treat the abjad like you would the alphanumeric keys, just with the other array
		abjad = furtherProcessing[1];
		abjad = abjad.substring(0, abjad.length() -1);
	}
	
	public String toString() {
		String sep = ". ";
		String result = "";
		result += key1+sep+key2+sep+key3+sep +hash+"-"+abjad+".";
		return result;
		}
	
	public String getValue() { //returns the value of the three keywords, the value of the hash, and the hash, all separated by a # sign
		//process the three keywords
		int l1 = key1.length() -3;
		int l2 = key2.length() -3;
		int l3 = key3.length() -3;
		
		String Str = key1.substring(0, 1); //grab first letter
		l1 *= letterToValue(Str); //figure out it's value, multiply
		
		Str = key2.substring(0, 1);
		l2 *= letterToValue(Str);
		
		Str = key3.substring(0, 1);
		l3 *= letterToValue(Str);
		
		//process the hash
		int nullcounter=0;
		String ha1, ha2, ha3, ha4 = "";//get four strings
		
		
		ha1 = "" + hash.charAt(0);//assign them to the four numbers
		ha2 = "" + hash.charAt(1);
		ha3 = "" + hash.charAt(2);
		ha4 = "" + hash.charAt(3);
		
		//bad code but an else block wouldn't help out here
		if(ha1.equals("0"))
			nullcounter++;
		if(ha2.equals("0"))
			nullcounter++;
		if(ha3.equals("0"))
			nullcounter++;
		if(ha4.equals("0"))
			nullcounter++;
		
				
		//add up the hash's values- the zeros won't affect this so we don't have to worry about them
		int hashVal = Integer.parseInt(ha1) + Integer.parseInt(ha2) + Integer.parseInt(ha3) + Integer.parseInt(ha4);
		hashVal *= nullcounter; //multiply by the zeros	
		
		//without compensation, we can't have numbers 1 and 2:
		//0000 = 0; 0111 = 3; 0010 = 3; 1100 = 4; 0112 = 4; 0113 = 5
		if(hashVal != 0)//so, compensate it!
			hashVal -=2;
		
		String result = "";
		String sep = "#";
		result = (String) (l1 + sep + l2 + sep + l3 + sep + hash + sep + hashVal);
		return result;	
		
	}
	
	public int letterToValue(String S) {
		S = S.toUpperCase(); //Lechymods should be case sensitive, but to be safe, uppercase
		//System.out.println(S);
		if(S.equals("L"))
			return 6;
		if(S.equals("E"))
			return 7;
		if(S.equals("A")) //cant believe I fucking forgot A
			return 10;
		if(S.equals("C"))
			return 2;
		if(S.equals("H"))
			return 1;
		if(S.equals("Y"))
			return 9;
		if(S.equals("M"))
			return 4;
		if(S.equals("O"))
			return 8;
		if(S.equals("D"))
			return 5;	
		if(S.equals("S"))
			return 3;	
		if(S.equals("Z"))
			return 0;	

		//if we've not gotten this far, return a harmless value
		System.out.println("Non-lechymods letter detected, bad user!");
		return 0;
		
	}
	

	
}
