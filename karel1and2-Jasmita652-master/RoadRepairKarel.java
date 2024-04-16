/*
 * File: PotholeFillingKarel.java
 * -----------------------------
 * The PotholeFillingKarel class extends the basic Karel class
 * so that Karel fills a pothole with a beeper.
 //javac -cp mvKarel2019.jar *.java
 
 */

import stanford.karel.*;

public class RoadRepairKarel extends ImprovedKarel {

	public void run() 
	{
		for(int i = 0; i<5; i++)
		{
			move();
			fillPothole();
			move();
		}
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