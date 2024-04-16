/*
 * Jasmita Yechuri 9-1-20
 * File: MidpointFindingKarel.java
 * -------------------------------
 * When you finish writing it, the MidpointFindingKarel class should
 * leave a beeper on the corner closest to the center of 1st Street
 * (or either of the two central corners if 1st Street has an even
 * number of corners).  Karel can put down additional beepers as it
 * looks for the midpoint, but must pick them up again before it
 * stops.  The world may be of any size, but you are allowed to
 * assume that it is at least as tall as it is wide.
 */

import stanford.karel.*;

public class MidpointFindingKarel extends ImprovedKarel
 {

		public void run () 
		{
			if (frontIsBlocked()) // special case for the 1x8
			{
				putBeeper();
				return;
			}
			putBeeper(); // place beeper at start
			while (frontIsClear())
			{
				move();
			}
			putBeeper(); // goes all the way until path is blocked then 
							//places beeper
			turnAround();
			move();
			checkforBeeper();
		}
		
		/* This method uses a while loop for karel to check if the front 
		way is clear from the walls and then keeps moving until it finds a 
		a beeper then places it right next to it. Once it turns and notices 
		that 2 beepers are next to each other then it picks one and ends up 
		moving to the center*/ 
		public void checkforBeeper()
		{
			while (frontIsClear())
			{
				while (noBeepersPresent()) 
				{
					move();
				}
				pickBeeper();
				turnAround();
				move();
				putBeeper(); 
				move();     
				// beepers are next to each other  
				if (beepersPresent()) 
				{
					pickBeeper();
					turnAround();
					move();
					if (facingEast()) 
					{
						turnRight();
					}
					else 
					{
						turnLeft();
					}
				}
			}
			turnLeft(); // normal position
		}
}	
