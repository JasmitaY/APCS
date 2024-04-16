/*
 * Jasmita Yechuri 8-30-20
 * File: DoubleBeeperKarel.java
 * -----------------------------
 * The DoubleBeeperKarel class extends the basic Karel class
 * so that Karel doubles the number of beepers on a corner.
 */

import stanford.karel.*;

public class DoubleBeeperKarel extends ImprovedKarel {

	public void run() {
		move();
		doubleBeepers();
		move();
	}
	
	public void doubleBeepers() 
	{
		While(beepersPresent())
		{
			pickBeeper();
			move();
			putBeeper();
			putBeeper();
			turnAround();
			move();
			turnAround();
		}
		move();
		turnAround();
		while(beepersPresent())
		{
			pickBeeper();
			move();
			putBeeper();
			turnAround();
			move();
			turnAround();
		}
	    turnAround();
		turnAround();
		move();
		turnAround();
	
	}
}