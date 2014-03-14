import java.util.Scanner;
import java.util.Random;
	
public class DandDFight 
	{
	static int playerHitPoints;
	static int monsterHitPoints;
	static int actionChoice;
	static int diceRollOne;
	static int diceRollTwo;
	static int diceRollThree;
	static int totalDice;
	static int godHealth;
	static int difficultyHealth;
	static int difficultyDamage; 
	static int difficultyLevel;
	static int lootNumber, findingLuck, playerLuck;
	static String nameOfPlayer, jobOfPlayer, homeLand;
	
	public static void main(String[] args) 
		{
		askName();
		startIntro();
		generatePlayerHitPoints();
		generateMonsterHitPoints();
		chooseAction();
		simulateCombat();
		}

	public static String askName()
    	{
		System.out.println("Hello. What is your name?");
		Scanner userInput1 = new Scanner(System.in);        
	    nameOfPlayer = userInput1.nextLine();        
	    System.out.println("Nice to meet you " + nameOfPlayer + ".");
	    if ("TGM".equals(nameOfPlayer))
	    	{
	    	godHealth = 1000;
	    	}
	    else
	    	{
	    	godHealth = 15;
	    	}	
	    System.out.println();
	    return nameOfPlayer;
    	}

	public static int playerAttackRoll()
    	{
		Random randomNumber = new Random();
		diceRollOne = 2 + randomNumber.nextInt(7);
		diceRollTwo = 2 + randomNumber.nextInt(7);
		diceRollThree = 2 + randomNumber.nextInt(7);
		totalDice = diceRollOne + diceRollTwo + diceRollThree;
		System.out.println("You swing your blade and do " + totalDice + " damage!");
		System.out.println();
		return totalDice;
    	}

	public static int generatePlayerHitPoints()
		{
	    Random randomNumber = new Random();
	    playerHitPoints = 5 + randomNumber.nextInt(godHealth);
	    System.out.println("You have " + playerHitPoints + " health.");
	    System.out.println();
	    return playerHitPoints;
	    }
	
	public static int generateMonsterHitPoints()
		{
		Random randomNumber = new Random(); 
		monsterHitPoints = 10 + randomNumber.nextInt(difficultyHealth);
		System.out.println("The enemy has " + monsterHitPoints + " health.");
		System.out.println();
		return monsterHitPoints;
		}
	
	public static int monsterAttackRoll()
		{
 		System.out.println("The creature growls at you and attacks!");
 		System.out.println();
		Random randomNumber = new Random();
		diceRollOne = 1 + randomNumber.nextInt(difficultyDamage);
		diceRollTwo = 1 + randomNumber.nextInt(difficultyDamage);
		diceRollThree = 1 + randomNumber.nextInt(difficultyDamage);
		totalDice = diceRollOne + diceRollTwo + diceRollThree;
		System.out.println("The creature does " + totalDice + " damage!");
		System.out.println();
		playerHitPoints = (playerHitPoints - totalDice);
		System.out.println("You have " + playerHitPoints + " HP left!");
		System.out.println();
		return totalDice;
		}
	
	public static int chooseAction()

		{
		System.out.println("Would you like to use a 1)Sword, 2)Fireball Spell, 3)Healing Spell, or 4) Lightning Blast?(do not try unless Level 100)");
		Scanner userInput1 = new Scanner(System.in);
		actionChoice = userInput1.nextInt();
		
		switch (actionChoice)
			{
			case 1:
				{
				playerAttackRoll();
				monsterHitPoints = (monsterHitPoints - totalDice);
				System.out.println("The creature has " + monsterHitPoints + " HP left!");
				System.out.println();
				break;
				}
				
			case 2:
				{
				Random randomNumber = new Random();
				diceRollOne = randomNumber.nextInt(1);
				diceRollTwo = randomNumber.nextInt(1);
				diceRollThree = 1 + randomNumber.nextInt(50);
				totalDice = diceRollOne + diceRollTwo + diceRollThree;
				monsterHitPoints = (monsterHitPoints - totalDice);
				System.out.println("You blast the enemy with flames and do " + totalDice + " damage!");
				System.out.println();
				System.out.println("The creature has " + monsterHitPoints + " HP left!");
				System.out.println();
				break;
				}
			case 3:	
				{
				Random randomNumber = new Random();
				diceRollOne = 1 + randomNumber.nextInt(4);
				diceRollTwo = 1 + randomNumber.nextInt(4);
				diceRollThree = 1 + randomNumber.nextInt(4);
				totalDice = diceRollOne + diceRollTwo + diceRollThree;
				playerHitPoints = (playerHitPoints + totalDice);
				System.out.println("You heal yourself " + totalDice + " points of health!");
				System.out.println();
				System.out.println("You have " + playerHitPoints + " HP.");
				System.out.println();
				break;	
				}
			case 4:
				{
				if("TGM".equals(nameOfPlayer))
					{
					Random randomNumber = new Random();
					diceRollOne = 50 + randomNumber.nextInt(200);
					diceRollTwo = 50 + randomNumber.nextInt(200);
					diceRollThree = 50 + randomNumber.nextInt(200);
					totalDice = diceRollOne + diceRollTwo + diceRollThree;
					monsterHitPoints = (monsterHitPoints - totalDice);
					System.out.println("Lightning erupts from your hand and archs towards the vicious beast doing " + totalDice + " points of damage");
					System.out.println();
					System.out.println("The creature has " + monsterHitPoints + " HP left!");
					System.out.println();
					}
				else
					{
					Random randomNumber = new Random();
					diceRollOne = 1 + randomNumber.nextInt(2);
					diceRollTwo = 1 + randomNumber.nextInt(2);
					diceRollThree = 1 + randomNumber.nextInt(2);
					totalDice = diceRollOne + diceRollTwo + diceRollThree;
					playerHitPoints = (playerHitPoints - totalDice);
					System.out.println("You raise your hands to attack, but the spell backfires and throws you across the room doing " + totalDice + " points of damage to yourself.");
					System.out.println();
					System.out.println("You have " + playerHitPoints + " HP left.");
					System.out.println();
					}
				break;
				}
			}
		return actionChoice;
		}
	
	public static int startIntro()
		{
		System.out.println("Where are you from " + nameOfPlayer + "?"); 
		Scanner userInput1 = new Scanner(System.in);
		homeLand = userInput1.nextLine();
		System.out.println("So you are from " + homeLand + "?!  Interesting.");
		System.out.println(" ");
		System.out.println("Choose the difficulty level.");
		System.out.println(" ");
		System.out.println("1)Trainee, 2)Adept, 3)Journyman, 4)Master, or 5)DEATH.");
		Scanner userInput2 = new Scanner(System.in);
		difficultyLevel = userInput2.nextInt();
			if (1 == difficultyLevel)
				{
				System.out.println("The easiest of the levels.  A novice player I see.");
				difficultyHealth = 20;
				difficultyDamage = 4;
				}
			if (2 == difficultyLevel)
				{
				System.out.println("The normal level. A smart choice " + nameOfPlayer + "." );
				difficultyHealth = 40;
				difficultyDamage = 6;
				}
			if (3 == difficultyLevel)
				{
				System.out.println("This level is difficult but not immposible. Maybe soon you can try the Master level.");
				difficultyHealth = 80;
				difficultyDamage = 8;
				}
			if (4 == difficultyLevel)
				{
				System.out.println("I bow in respect to a Master of Imaginex.");
				difficultyHealth = 100;
				difficultyDamage = 10;
				}
			if (5 == difficultyLevel)
				{
				System.out.println("I will attend your funeral.");
				difficultyHealth = 1000;
				difficultyDamage = 20;
				}
		System.out.println(" ");	
		System.out.println("Choose your class "
				+ "" + nameOfPlayer + " of " + homeLand + ".");	
		System.out.println(" ");
		System.out.println("You can be an Iron Fist, a Light Foot, or a Thought Mage.");
		jobOfPlayer = userInput1.nextLine();
			System.out.println("An interesting choice.  I wouldn't of guessd that you would be a " + jobOfPlayer + ".");
			if ("Iron Fist".equals(jobOfPlayer))
				{
				System.out.println("But I know that you will crush your enemies!");
				}
			if ("Light Foot".equals(jobOfPlayer))
				{
			 	System.out.println("But I know that you will be quick, silent, and deadly!");
				}
			if ("Thought Mage".equals(jobOfPlayer))
				{
			 	System.out.println("But I know that you will use your powers well!");
				}
		System.out.println(" ");	
		System.out.println("You will awake soon " + nameOfPlayer + " of " + homeLand + ".");
		System.out.println(" ");
		System.out.println("I wish you the best of luck.");
		if ("5".equals(difficultyLevel))
			{
			System.out.println(" ");	
			System.out.println("Not that you will live.");
			System.out.println();
 			}
		System.out.println("You awake in an areana with a vicious beast in front of you.");
		System.out.println();	
		return difficultyLevel;	
		}
	
	
	public static int simulateCombat()
		{
		while(monsterHitPoints > 0)
			{
			monsterAttackRoll();
			if (playerHitPoints <= 0)
				{
				System.out.println("You died to the beast's claws!");
				System.exit(0);
				}
			else if (playerHitPoints != 0)
				{
				chooseAction();
				}
			}
		
		if (monsterHitPoints <= 0)
			{
			System.out.println("You have slain the beast!");
			System.out.println();
			System.out.println("You find some treasure on the body of the beast.");
			System.out.println();
			lootBeast();
			System.exit(0);
			}	
		return monsterHitPoints;
		}

	public static int lootBeast()
		{
		generateNumber();
		System.out.println("You open the bag of loot at your feet.");
		System.out.println("");
		switch (lootNumber)
			{ 
			case 1:System.out.println("You have found an Iron Sword!");
				{
				System.out.println("You have found 100 Gold!");
				}
			case 2:
				{
				System.out.println("You have found a Steel Sword!");
				}
			case 3:
				{
				System.out.println("You have found a Titanium Sword!");
				}
			case 4:
				{
				System.out.println("You have found a Fireball Scroll!");
				}
			case 5:
				{
				System.out.println("You have found a Healing Scroll!");
				}
			case 6:
				{
				System.out.println("You have found a Shield Scroll!");
				}
			case 7:
				{
				System.out.println("You have found some Iron Armor!");
				}
			case 8:
				{
				System.out.println("You have found some Steel Armor!");
				}
			case 9:
				{
				System.out.println("You have found some Titanium Armor!");
				}
			case 10:
				{
				System.out.println("You have found a Bow and Iron Arrows!");
				}
			case 11:
				{
				System.out.println("You have found a Bow and Steel Arrows!");
				}
			case 12:
				{
				System.out.println("You have found a Bow and Titanium Arrows!");
				}
			case 13:
				{
				System.out.println("You have found 25 Gold!");
				}
			case 14:
				{
				System.out.println("You have found 50 Gold!");
				}
			case 15:
				{
				System.out.println("You have found 75 Gold!");
				}
			case 16:
				{
				System.out.println("You have found 100 Gold!");
				}
			}
		return lootNumber;
		}
	
	public static int generateNumber()
	{
	Random randomNumber = new Random();
	lootNumber = 1 + randomNumber.nextInt(16);
	return lootNumber;
	}
	}