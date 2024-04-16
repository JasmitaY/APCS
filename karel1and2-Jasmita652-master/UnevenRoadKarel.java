/*
 * File: UnevenRoadKarel.java
 * -----------------------------
 * The UnevenRoadKarel class extends the basic Karel class
 * so that Karel fills a pothole with a beeper.
 //javac -cp mvKarel2019.jar *.java
 
 */

import stanford.karel.*;

public class UnevenRoadKarel extends ImprovedKarel {

	public void run() 
	{
		while (frontIsClear())  
		{
			move();
			fillPothole();
			move();
			move();
			move();
			move();
			fillPothole();
			move();
		}
		
/*		move();
		move();
		move();
		fillPothole();
		move();
*/		
		
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
     
}