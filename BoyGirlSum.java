package assignments;
import java.io.*;
import java.util.*;
import java.util.regex.Pattern;
//BoyGirlSum
//
//this takes a text file with an alternating list of boys and girls, and numbers and determines the diffence in sum
//By: m.w.
//11/4/2019
//*******************************************************************
public class BoyGirlSum {

	public static void main(String[] args) throws FileNotFoundException {
		
		//instantiate a new scanner for the text file and call method
		
		Scanner input = new Scanner(new File("boysgirls.txt"));
		boysGirls(input);
		input.close();
	}
	
	public static void boysGirls(Scanner dataToScan) {
		
		//Create variables to hold data about text file
		
		int lineFlip = 0;
		int numberOfBoys = 0;
		int numberOfGirls = 0;
		int boyScore = 0;
		int girlScore = 0;
		
		//Scan file until the end. 
		
		while(dataToScan.hasNextLine()) {
			//Determine if current position in file pattern matches a number, and 
			//use lineFlip to determine whether it is on an odd or even line to
			//correspond to the gender of the person
			if((dataToScan.hasNext(Pattern.compile("\\d+")) && lineFlip == 0)) {
				//parse the number to an int and add it to the score
				boyScore +=Integer.parseInt(dataToScan.next());
				//flip the bit
				lineFlip = 1;
				//add count to number of boys
				numberOfBoys++;
			}
			else if((dataToScan.hasNext(Pattern.compile("\\d+")) && lineFlip == 1)) {
				//parse the number to an int and add it to the score
				girlScore +=Integer.parseInt(dataToScan.next());
				//flip the bit
				lineFlip = 0;
				//add count to number of boys
				numberOfGirls++;
			}
			//conditional to check if there is any more file left.
			if(dataToScan.hasNextLine()) {
			dataToScan.next();
			}
		}
		
		//print out the result.
		System.out.println("There are " + numberOfBoys + " boys, " + numberOfGirls + " girls");
		System.out.println("Difference between boy and girl sums is: " +(Math.abs(girlScore - boyScore)));
		
	}

}
