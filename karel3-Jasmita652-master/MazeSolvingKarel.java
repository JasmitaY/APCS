/*
 * Jasmita Yechuri 8-30-20
 * File: MazeSolvingKarel.java
 * -----------------------------
 * The MazeSolvingKarelFinal class extends the basic Karel class
 * so that Karel solves a maze.
 */

import stanford.karel.*;

public class MazeSolvingKarel extends ImprovedKarel {

	public void run() 
	{
		while(noBeepersPresent())
		{
			turnRight();
			while(frontIsBlocked())
			{
				turnLeft();
			}
			move();
		}
	}
	    
}