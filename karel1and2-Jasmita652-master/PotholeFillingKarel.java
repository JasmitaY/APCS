/*
 * File: PotholeFillingKarel.java
 * -----------------------------
 * The PotholeFillingKarel class extends the basic Karel class
 * so that Karel fills a pothole with a beeper.
 */

import stanford.karel.*;

public class PotholeFillingKarel extends ImprovedKarel {

	public void run() 
	{
		move();
		fillPothole();
	/*	turnRight();
		move();
		putBeeper();
		turnAround();
		move();
		turnRight();
	*/
		move();
	}
	
	public void fillPothole()
	{
		turnRight();
		move();
		putBeeper();
		turnAround();
		move();
		turnRight();
	}
     
    // Decomposition
   /* 
    public void turnRight()
    {
    	turnLeft();
    	turnAround();
    }
    
    public void turnAround()
    {
    	turnLeft();
		turnLeft();
    } 
    */
}