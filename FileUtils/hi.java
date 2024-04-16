/**
 *	Plays the game of MasterMind.
 *	In this game we practice using iteration and conditional statements to perform a 
 *  game. This game allows the user to input 10/1296 combinations that are possible
 *  by using the letters ABCDEF. The program will check for valid inputs and will also
 *  let the user know how many pegs are in the right spot, and if there are pegs
 *  that are the right color/letter but not in the right spot.
 *  
 *	@author Jasmita Yechuri
 *  @since October 29, 2020
 */

public class MasterMind {

	private boolean reveal;			// true = reveal the master combination
	private PegArray[] guesses;		// the array of guessed peg arrays
	private PegArray master;		// the master (key) peg array
	private boolean game; 			// decides if game is over or not
	
	// Constants
	private final int PEGS_IN_CODE = 4;		// Number of pegs in code
	private final int MAX_GUESSES = 10;		// Max number of guesses
	private final int PEG_LETTERS = 6;		// Number of different letters on pegs
											// 6 = A through F
	/**
	 * 	Constructor that initializes the master and guess Arrays
	 */
	public MasterMind() 
	{
		master = new PegArray(PEGS_IN_CODE);
		for (int i = 0; i < PEGS_IN_CODE; i++) 
		{
			char ch = (char)(int)(Math.random() * PEG_LETTERS + 'A');
			master.getPeg(i).setLetter(ch);
		}
		guesses = new PegArray[MAX_GUESSES];
		for(int i = 0; i < MAX_GUESSES; i++) 
		{
			guesses[i] = new PegArray(PEGS_IN_CODE);
		}	
	}
	
	public static void main(String[] args)
	{
		MasterMind mm = new MasterMind();
		mm.printIntroduction();
		mm.startGame();
	}
	
	/**
	 *	Print the introduction screen
	 */
	public void printIntroduction() {
		System.out.println("\n");
		System.out.println("+------------------------------------------------------------------------------------+");
		System.out.println("| ___  ___             _              ___  ___ _             _                       |");
		System.out.println("| |  \\/  |            | |             |  \\/  |(_)           | |                      |");
		System.out.println("| | .  . |  __ _  ___ | |_  ___  _ __ | .  . | _  _ __    __| |                      |");
		System.out.println("| | |\\/| | / _` |/ __|| __|/ _ \\| '__|| |\\/| || || '_ \\  / _` |                      |");
		System.out.println("| | |  | || (_| |\\__ \\| |_|  __/| |   | |  | || || | | || (_| |                      |");
		System.out.println("| \\_|  |_/ \\__,_||___/ \\__|\\___||_|   \\_|  |_/|_||_| |_| \\__,_|                      |");
		System.out.println("|                                                                                    |");
		System.out.println("| WELCOME TO MONTA VISTA MASTERMIND!                                                 |");
		System.out.println("|                                                                                    |");
		System.out.println("| The game of MasterMind is played on a four-peg gameboard, and six peg letters can  |");
		System.out.println("| be used.  First, the computer will choose a random combination of four pegs, using |");
		System.out.println("| some of the six letters (A, B, C, D, E, and F).  Repeats are allowed, so there are |");
		System.out.println("| 6 * 6 * 6 * 6 = 1296 possible combinations.  This \"master code\" is then hidden     |");
		System.out.println("| from the player, and the player starts making guesses at the master code.  The     |");
		System.out.println("| player has 10 turns to guess the code.  Each time the player makes a guess for     |");
		System.out.println("| the 4-peg code, the number of exact matches and partial matches are then reported  |");
		System.out.println("| back to the user. If the player finds the exact code, the game ends with a win.    |");
		System.out.println("| If the player does not find the master code after 10 guesses, the game ends with   |");
		System.out.println("| a loss.                                                                            |");
		System.out.println("|                                                                                    |");
		System.out.println("| LET'S PLAY SOME MASTERMIND!                                                        |");
		System.out.println("+------------------------------------------------------------------------------------+");
		System.out.println("\n");
	}
	
	/**
	 *	Print the peg board to the screen
	 */
	public void printBoard() {
		// Print header
		System.out.print("+--------+");
		for (int a = 0; a < PEGS_IN_CODE; a++) System.out.print("-------+");
		System.out.println("---------------+");
		System.out.print("| MASTER |");
		for (int a = 0; a < PEGS_IN_CODE; a++)
			if (reveal)
				System.out.printf("   %c   |", master.getPeg(a).getLetter());
			else
				System.out.print("  ***  |");
		System.out.println(" Exact Partial |");
		System.out.print("|        +");
		for (int a = 0; a < PEGS_IN_CODE; a++) System.out.print("-------+");
		System.out.println("               |");
		// Print Guesses
		System.out.print("| GUESS  +");
		for (int a = 0; a < PEGS_IN_CODE; a++) System.out.print("-------+");
		System.out.println("---------------|");
		for (int g = 0; g < MAX_GUESSES - 1; g++) {
			printGuess(g);
			System.out.println("|        +-------+-------+-------+-------+---------------|");
		}
		printGuess(MAX_GUESSES - 1);
		// print bottom
		System.out.print("+--------+");
		for (int a = 0; a < PEGS_IN_CODE; a++) System.out.print("-------+");
		System.out.println("---------------+");
	}
	
	/**
	 *	Print one guess line to screen
	 *	@param t	the guess turn
	 */
	public void printGuess(int t) {
		System.out.printf("|   %2d   |", (t + 1));
		// If peg letter in the A to F range
		char c = guesses[t].getPeg(0).getLetter();
		if (c >= 'A' && c <= 'F')
			for (int p = 0; p < PEGS_IN_CODE; p++)
				System.out.print("   " + guesses[t].getPeg(p).getLetter() + "   |");
		// If peg letters are not A to F range
		else
			for (int p = 0; p < PEGS_IN_CODE; p++)
				System.out.print("       |");
		System.out.printf("   %d      %d    |\n",
							guesses[t].getExact(), guesses[t].getPartial());
	}
	
	/**
	 * Goes through each of the turns of the game and 
	 */
	public void newRound(int num) 
	{
		String letters = new String (" ");
		do{
			letters = Prompt.getString("Enter the code using (A,B,C,D,E,F). For example, ABCD or abcd from "
				+ "left-to-right");
			letters = letters.toUpperCase();
			if(! isValid(letters))
			{
				System.out.println("ERROR: Bad input, try again.");
			}
		} while (! isValid(letters));
		completeArray(num, letters);
		int exact = guesses[num].getExactMatches(master);
		int exactMatches = exact;
		int partial = guesses[num].getPartialMatches(master);
		int partialMatches = partial;
		if(exactMatches == PEGS_IN_CODE)
		{
			reveal = game = true;
		} 
	}
	
	
	public void completeArray(int num, String letters) 
	{
		for(int j = 0; j < letters.length(); j++) 
		{
			char ch = letters.charAt(j);
			guesses[num].getPeg(j).setLetter(ch);
		}
	}
	
	/**	Test if string is all letters within A-F and length of input is 4 only.
	 *	@param str		the string of characters to test
	 *	@return			true if all letters; false otherwise
	 */
	private boolean isValid(String letters) 
	{
		if (letters.length() != PEGS_IN_CODE)
		{
			return false;
		} 
		for(int a = 0; a < letters.length(); a++)
		{
			if ((letters.charAt(a) < 'A') || (letters.charAt(a) > 'F'))
			{
				return false;
			}		
		}
		return true;
	}

	/**
	*	Starts the game and keeps track of the number of rounds. If player cracks the code
	*	within the 10 guesses given, then message prints accordingly and if they don't get
	*   get the code, another message will print accordingly.
	*/
	public void startGame( )
	{
		Prompt.getString("Hit the Enter key to start the game");
		printBoard();
		int a = 0;
		for(a = 0; a < MAX_GUESSES && !game; a++) {
			System.out.println("\nGuess " + (a + 1));
			if(a == 9) reveal = true;
			newRound(a);
			printBoard();
		}
		if(game) System.out.println("\nNice work! You found the master code in " + (a + 1) + " guesses.");
		else System.out.println("\nOops. You were unable to find the solution in 10 guesses.");

		
		/*for(int i = 1; i <= MAX_GUESSES && !game; i++)
		{
			newRound(i);
			printBoard();
			System.out.println("\nGuess " + i + "\n");
			if (i == 9)
			{
				reveal = true;
			}
			// user gets code
			if(game) 
			{
				System.out.println("\nNice work! You found the master code in " + i + " guesses.");
			}
			else 
			{
				System.out.println("\nOops. You were unable to find the solution in 10 guesses.");
			}
		}	*/	
	}
}
