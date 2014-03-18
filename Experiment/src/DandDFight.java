import java.util.Scanner;
import java.util.Random;
	
public class DandDFight 
	{
	//Health and level variables.
	static int playerHitPoints, monsterHitPoints, godHealth, levelOfPlayer = 1;
	//Dice Roll variables.
	static int diceRollOne, diceRollTwo, diceRollThree, totalDice;
	//Difficulty variables.
	static int difficultyHealth, difficultyDamage, difficultyLevel;
	//Choice variables.
	static int playAgainChoice = 1, actionChoice;
	//Luck variables/
	static int lootNumber, findingLuck, playerLuck; 
	//Bonus point variables.
	static int armorBonus, weaponBonus, fireballBonus, healingSpellBonus, classWeaponBonus = 0, classFireballBonus = 0, classHealingBonus = 0;
	//Achievement variables.
	static int numberOfSlainEnemies;
	//Player identity variables.
	static String nameOfPlayer, jobOfPlayer, homeLand;
	
	public static void main(String[] args) 
		{
		askName();
		startIntro();
		while (playAgainChoice == 1)
			{
			generatePlayerHitPoints();
			generateMonsterHitPoints();
			chooseAction();
			simulateCombat();
			}
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
		diceRollOne = 2 + randomNumber.nextInt(7 + weaponBonus);
		diceRollTwo = 2 + randomNumber.nextInt(7 + weaponBonus);
		diceRollThree = 2 + randomNumber.nextInt(7 + weaponBonus);
		totalDice = diceRollOne + diceRollTwo + diceRollThree + classWeaponBonus;
		System.out.println("You swing your blade and do " + totalDice + " damage!");
		System.out.println();
		return totalDice;
    	}

	public static int generatePlayerHitPoints()
		{
	    Random randomNumber = new Random();
	    playerHitPoints = 5 + randomNumber.nextInt(godHealth + (levelOfPlayer * 10) + armorBonus);
	    System.out.println("You awake in an areana with a vicious beast in front of you.");
		System.out.println();
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
		System.out.println("Would you like to use a 1)Sword, 2)Fireball Spell, 3)Healing Spell, "
				+ "or 4) Lightning Blast?(do not try unless Level 10)");
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
				diceRollThree = 1 + randomNumber.nextInt(50 + fireballBonus);
				totalDice = diceRollOne + diceRollTwo + diceRollThree + classFireballBonus;
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
				diceRollThree = 1 + randomNumber.nextInt(4 + healingSpellBonus);
				totalDice = diceRollOne + diceRollTwo + diceRollThree + classHealingBonus;
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
				if(levelOfPlayer == 10)
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
				System.out.println("This level is difficult but not immposible. "
						+ "Maybe soon you can try the Master level.");
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
		System.out.println("You can be an Fighter, Healer or a Mage.");
		jobOfPlayer = userInput1.nextLine();
		System.out.println("An interesting choice.  I wouldn't have guessed that you would be a " + jobOfPlayer + ".");
		if ("Fighter".equals(jobOfPlayer))
			{
			System.out.println();
			System.out.println("But I know that you will crush your enemies!");
			classWeaponBonus = 2;
			}
		if ("Mage".equals(jobOfPlayer))
			{
			System.out.println();
			System.out.println("But I know that you will use your powers well!");
			classFireballBonus = 2;
			}
		if ("Healer".equals(jobOfPlayer))
			{
			System.out.println();
			System.out.println("But I know that you will protect and heal with your skills.");
			classHealingBonus = 2;
			}
		System.out.println();	
		System.out.println("You will awake soon " + nameOfPlayer + " of " + homeLand + ".");
		System.out.println(" ");
		System.out.println("I wish you the best of luck.");
		if ("5".equals(difficultyLevel))
			{
			System.out.println(" ");	
			System.out.println("Not that you will live.");
 			}
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
				askPlayerIfTheyWantToPlayAgain();
				break;
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
			numberOfSlainEnemies++;
			lootBeast();
			System.out.println();
			System.out.println("You have leveled up " + nameOfPlayer + "!");
			levelOfPlayer++;
			System.out.println();
			System.out.println("You are now a Level " + levelOfPlayer + "!");
			askPlayerIfTheyWantToPlayAgain();
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
			case 17:
			case 18:	
				{
				System.out.println("You have found a Shield Scroll!");
				System.out.println();
				armorBonus = 3;
				System.out.println("Your max HP has now been increased by 3.");
				break;
				}
			case 4:
			case 5:
			case 6:	
				{
				System.out.println("You have found some Iron Armor!");
				System.out.println();
				armorBonus = 2;
				System.out.println("Your max HP has now been increased by 2.");
				break;
				}
			case 7:
			case 8:
				{
				System.out.println("You have found some Steel Armor!");
				System.out.println();
				armorBonus = 5;
				System.out.println("Your max HP has now been increased by 5.");
				break;
				}
			case 11:
				{
				System.out.println("You have found some Titanium Armor!");
				System.out.println();
				armorBonus = 10;
				System.out.println("Your max HP has now been increased by 10.");
				break;
				}
			case 1:
			case 2:
			case 3:	
				{
				System.out.println("You have found an Iron Sword!");
				System.out.println();
				weaponBonus = 2;
				System.out.println("You now do more damage with your blade!");
				break;
				}
			case 9:
			case 10:
				{
				System.out.println("You have found a Steel Sword!");
				System.out.println();
				weaponBonus = 5;
				System.out.println("You now do more damage with your blade!");
				break;
				}
			case 12:
				{
				System.out.println("You have found a Titanium Sword!");
				System.out.println();
				weaponBonus = 10;
				System.out.println("You now do more damage with your blade!");
				break;
				}
			case 13:
			case 14:
				{
				System.out.println("You have found a Fireball Scroll!");
				System.out.println();
				fireballBonus = 2;
				System.out.println("Your Fireball Spell does more damage now.");
				break;
				}
			case 15:
			case 16:
				{
				System.out.println("You have found a Healing Scroll!");
				System.out.println();
				healingSpellBonus = 3;
				System.out.println("Your Healing Spell heals you up more now.");
				break;
				}	
			}
		return lootNumber;
		}
	
	public static int generateNumber()
	{
	Random randomNumber = new Random();
	lootNumber = 1 + randomNumber.nextInt(18);
	return lootNumber;
	}
	
	public static int askPlayerIfTheyWantToPlayAgain()
		{
		System.out.println();
		System.out.println("Would you like to play again " + nameOfPlayer + "?");
		System.out.println();
		System.out.println("Or does " + homeLand + " need you?");
		System.out.println();
		System.out.println("Press 1 to play again and press 2 to exit the game.");
		Scanner userInput1 = new Scanner(System.in);
		playAgainChoice = userInput1.nextInt();
		if (playAgainChoice == 2)
			{
			System.out.println("Farewell " + nameOfPlayer + " of " + homeLand + ".");
			System.out.println();
			System.out.println("Let Everyone know that you were a Level " + levelOfPlayer + " " + jobOfPlayer + " and you fought "
					+ "valiantly, defeating " + numberOfSlainEnemies + " deadly beasts.");
			System.out.println();
			System.out.println("Best of luck to you.");
			System.exit(0);
			}
		return playAgainChoice;
		}
	}






