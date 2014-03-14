import java.util.Scanner;
public class ExperimentOne {
	static double numberOfFeet, convertedToYards, convertedToInches;	
		public static void main(String[] args) 
		{
			System.out.println("Type in the number of feet and it will be converted it to yards.");
			Scanner userInput1 = new Scanner(System.in);		
			numberOfFeet = userInput1.nextDouble();  //This connects the variable numberOfFeet to the number of feet that was typed in.
			convertedToYards = (numberOfFeet / 14);  //Converts the number of feet that was typed in to yards by multiplying it by 3.
			convertedToInches = (numberOfFeet / 2.2);
			System.out.println("" + convertedToYards + " yards, and " + convertedToInches + " inches.");  //Prints the number of yards that the number of feet was converted to.
		}

	}


