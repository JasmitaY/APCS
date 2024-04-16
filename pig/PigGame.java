/**
 *	The game of Pig.
 *	In order to win the player needs to have a score of 100 or higher after they finish
 *  their turn. The player is going against the computer and the computer can not get 
 *  more that 21 points in a turn. This program requires implementing Dice.java- to draw
 *  the dice - and Prompt.java - or getting user input to continue to role or hold.
 *
 *	@author	Jasmita Yechuri
 *	@since	September 17, 2020
 */

public class PigGame 
{

	private final int MAX_GAME_PTS = 100;	// game ends at this number of points
	private int playerTotal, playerScore;   // hold player's score and total score
	private int compTotal, compScore;		// hold computer's score and total score
	private int rollNum;			// the value of the dice after rolled
	private char option;			// hold user value of 'r' or 'h'
	Dice diceRoll = new Dice();     // object of the dice in order to roll
	
	public PigGame()
	{
		playerTotal = playerScore = 0;
		compTotal = compScore = 0;
		rollNum = 0;
		option = ' ';
	}
	
	public static void main(String[]args)
	{
		PigGame pg = new PigGame();
		pg.printIntroduction();
		pg.startGame();
	}
	
	/**	Print the introduction to the game */
	public void printIntroduction()
	{
		System.out.println("\n");
		System.out.println("______ _         _____");
		System.out.println("| ___ (_)       |  __ \\");
		System.out.println("| |_/ /_  __ _  | |  \\/ __ _ _ __ ___   ___");
		System.out.println("|  __/| |/ _` | | | __ / _` | '_ ` _ \\ / _ \\");
		System.out.println("| |   | | (_| | | |_\\ \\ (_| | | | | | |  __/");
		System.out.println("\\_|   |_|\\__, |  \\____/\\__,_|_| |_| |_|\\___|");
		System.out.println("          __/ |");
		System.out.println("         |___/");
		System.out.println("\nThe Pig Game is human vs computer. Each takes a"
		+ " turn rolling a die and");
		System.out.println("the first to score to score " + MAX_GAME_PTS
		+ " points wins. A player can either ROLL or");
		System.out.println("HOLD. A turn works this way:");
		System.out.println("\nROLL:\t2 through 6: add points to turn total, "
		+ "player's turn continues");
		System.out.println("\t1: player loses turn");
		System.out.println("HOLD:\tturn total is added to player's score, "
		+ "turn goes to other player");
		System.out.println("\n");
	}
	/** 
	*   Calls the methods to tell who's turn it is to play, while using a while loop to 
	*   check if the game is over and if-else conditions to switch turns between players.
	* 	It also prints the results of the game using if-else conditions.
	*/
	public void startGame() 
	{
		while(playerTotal < MAX_GAME_PTS && compTotal < MAX_GAME_PTS)
		{
			playerTurn();
			if(playerTotal < MAX_GAME_PTS)
			{
				compTurn();	
			} 
		}
		if(playerTotal > compTotal)
		{
			System.out.println("\nCongratulations! YOU WON!!!");
			System.out.println("\nThanks for playing the Pig Game!");
		}
		else 
		{
			System.out.println("\nSorry. The COMPUTER WON.");
			System.out.println("\nThanks for playing the Pig Game!");
		}
	}
	
	/** 
	*   Rolls the dice from Dice.java and stores value in rollNum, then prints the dice 
	*   on terminal.
	* 	@return  	The value after dice is rolled 
	*/
	public int rollDice()
	{ 
		rollNum = diceRoll.roll();
		diceRoll.printDice();
		return rollNum;
	}

	/** 
	*   Prompts the user for a character of either 'r' or 'h' then prints turnScore and
	*	playerScore accordingly. To make terminal doesn't accept other characters. I use  
	*   a do-while loop to ask the question unless the character the user enters satisfies 
	*   the condition. If the number rolled is 1 then player loses turn, if not and 
	*  	the player's score for that turn is added with the dice number that is rolled.
	*	If player enters 'h' then the turn ends changing the rolled number as 1, and 
	*   the player's score for that turn is added to player's total score. This only happens
	*   if the player's total score is less than 100 and the rolled number is not 1.
	*/
	public void playerTurn() 
	{ 
		playerScore = 0;
		System.out.println("**************** PLAYER'S TURN ****************");
		System.out.println("Your turn score: " + playerScore);
		System.out.println("Your total score: " + playerTotal);
		do 
		{
			rollNum = 0;
			do 
			{
				 option = Prompt.getChar("(r)oll or (h)old");
			} while ((option != 'r') && (option != 'h'));
		
			if(option == 'r')
			{
				System.out.println("You ROLL");
				rollNum = rollDice();
				if(rollNum == 1) 
				{
					System.out.println("You LOSE YOUR TURN.");
					System.out.println("Your total score: " + playerTotal);
				}
				else 
				{
					playerScore += rollNum;
					System.out.println("Your turn score: " + playerScore);
					System.out.println("Your total score: " + playerTotal);
				}
			}
			else if(option == 'h')
			{
				playerTotal += playerScore;
				System.out.println("You HOLD.");
				System.out.println("Your total score: " + playerTotal);
				rollNum = 1;
			}
		} while(playerTotal < MAX_GAME_PTS && rollNum != 1 );
	}

	/** 
	*   Prompts the user to press enter so computer can roll. Similar to playerTurn()
	*   If the number rolled is 1 then computer loses its turn. Computer can only
	*   play until 21 points and less than 100 total points. All of this only happens
	*   if the computer's total score is less than 100 and the rolled number is not 1.
	*/
	public void compTurn()
	{
		compScore = 0;
		System.out.println("**************** COMPUTER'S TURN ****************");
		System.out.println("Computer turn score: " + compScore);
		System.out.println("Computer total score: " + compTotal);
		do 
		{
			String enter = Prompt.getString("Press enter for computer turn");
			if(compScore < 21 && (compScore + compTotal) < MAX_GAME_PTS)
			{
				System.out.println("Computer will ROLL");
				rollNum = rollDice();
				if(rollNum == 1)
				{
					System.out.println("Computer LOSES TURN.");
					System.out.println("Computer total score: " + compTotal);
				}
				else 
				{
					compScore += rollNum;
					System.out.println("Computer turn score: " + compScore);
					System.out.println("Computer total score: " + compTotal);
				}			
			}
			else 
			{
				compTotal += compScore;
				System.out.println("Computer HOLDS.");
				System.out.println("Computer total score: " + compTotal);
				rollNum = 1;
			}
		} while(compTotal < MAX_GAME_PTS && rollNum != 1 );
	}
}