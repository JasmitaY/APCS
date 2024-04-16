/*
 * Jasmita Yechuri 9-1-20
 * File: StoneMasonKarel.java
 * --------------------------
 * The StoneMasonKarel subclass as it appears here does nothing.
 * When you finish writing it, it should solve the "repair the quad"
 * problem from Assignment 1.  In addition to editing the program,
 * you should be sure to edit this comment so that it no longer
 * indicates that the program does nothing.
 */

import stanford.karel.*;

public class StoneMasonKarel extends ImprovedKarel 
{

	public void run() 
	{
        fixStones();
    }

	// Initial part - turn left to face upwards. This method
	// calls the other methods in order to tell karel to go
	// all the way up or down or move to a new column.
	// This methods will be repeated as many times as necessary
	// until karel is all the corner and the front is not clear.
    private void fixStones() 
    {
        turnLeft();
        goUp();
        turnAround();
        goDown();
        turnLeft();
        if(frontIsClear()) 
        {
            nextColumn();
            fixStones();
        }
    }  
     
    // Tells karel to continue to move upwards if there is no wall
    // and if there is no beeper than place a beeper and continue
    // to move up until Karel hits the wall. 
    private void goUp() 
    {
        while(frontIsClear()) 
        {
            if(noBeepersPresent())
            {
                putBeeper();
            }
            move();
        }
        if(noBeepersPresent()) 
        {
           putBeeper();
        }
    }
    
    // A while loop to tell karel to go back down until it runs 
    // into the wall.
    private void goDown()
     {
        while(frontIsClear()) 
        {
            move();
        }
    }
    
    // A for loop that allows karel to move to the next column 
    // that needs to be repaired. Moves down 4 columns each time
    private void nextColumn() 
    {
        for(int i=0; i<4; i++)
        {
            move();
        }
    }
}