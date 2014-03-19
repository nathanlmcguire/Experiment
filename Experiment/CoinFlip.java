//Nathan McGuire Showcase #3.
import java.util.Random;
import java.util.Scanner;

public class CoinFlip 
	{
	
	static String nameOfPlayer;
	static int secretNumber;
	static int numberOfCoinFlips;
	static int numberOfHeads;
	static int numberOfTails;
	static int i;
	
	public static void main(String[] args) 
		{
		askName();
		complimentPlayer();
		askForNumberOfCoinFlipsThenFlipCoin();
		showNumberOfHeadsAndTails();
		}
	
	public static String askName()
		{
		System.out.println("Hello. What is your name?");
		Scanner userInput1 = new Scanner(System.in);        
	    nameOfPlayer = userInput1.nextLine();        
	    System.out.println("Nice to meet you " + nameOfPlayer + ".");	
	    System.out.println();
	    return nameOfPlayer;
		}

	public static void flipCoin()
		{
		generateNumberOne();
		String [] headsOrTails = {"Heads", "Tails"};
		System.out.println(headsOrTails[secretNumber]);
		if(secretNumber == 0)
			{
			numberOfHeads++;
			}
		else if(secretNumber == 1)
			{
			numberOfTails++;
			}
		}
	
	public static int generateNumberOne()
		{
		Random randomNumber = new Random();
		secretNumber = randomNumber.nextInt(2);
		return secretNumber;
		}
	
	public static void complimentPlayer()
		{
		generateNumberTwo();
		String [] randomCompliment = {"You are looking tall today, for a midget.", 
				"Have you been working out?  Just kidding, I know you haven't.", 
				"I want to stab you less today.", 
				"You are being nice today, what do you want from me?"};
		System.out.println(randomCompliment[secretNumber]); 
		System.out.println();
		}
	
	public static int generateNumberTwo()
		{
		Random randomNumber = new Random();
		secretNumber = randomNumber.nextInt(3);
		return secretNumber;
		}
	
	public static int askForNumberOfCoinFlipsThenFlipCoin()
		{
		System.out.println("How many times would you like to flip the coin " + nameOfPlayer + "?");
		Scanner userInput1 = new Scanner(System.in);
		numberOfCoinFlips = userInput1.nextInt();
		for (i = 1; i <= numberOfCoinFlips; i++)
			{
			flipCoin();
			}
		return numberOfCoinFlips;
		}
	
	public static void showNumberOfHeadsAndTails()
		{
		System.out.println("" + numberOfHeads + " of your flips came up heads.");
		System.out.println("" + numberOfTails + " of your flips came up tails." );
		}
	
	}
		
	


	


	
	