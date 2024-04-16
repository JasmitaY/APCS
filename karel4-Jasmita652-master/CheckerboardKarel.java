/*
 * Jasmita Yechuri 9-2-20
 * File: CheckerboardKarel.java
 * ----------------------------
 * When you finish writing it, the CheckerboardKarel class should draw
 * a checkerboard using beepers, as described in Assignment Karel4.  You
 * should make sure that your program works for all of the sample
 * worlds supplied in the starter folder.
 */

import stanford.karel.*;

public class CheckerboardKarel extends ImprovedKarel 
{
	/*Starts off by placing a beeper and then calls the method
	to see if there is a wall infront of Karel. Then there is a
	while loop to say while there is nothing ahead then check to 
	see what side karel is facing. */
	public void run() 
	{
	 	putBeeper();
        wallPresent();
        while (frontIsClear()) 
        {
            rightSide();
            leftSide();
        }
    }
    
    /*This method is there to see if there is a wall that is blocking
    Karel from moving and allows Karel to move up if there is only 
    one column present in the world*/
    private void wallPresent() 
    {
        if (frontIsBlocked()) 
        {
            turnLeft();
            while (frontIsClear()) 
            {
                move();
                if (frontIsClear()) 
                {
                    move();
                    putBeeper();
                }
            }
        }
	}

    /*This method is used to make sure while Karel is facing the East side
    then it will continue to move and place a beeper until it hits the wall.
    Then the method rightUp() is called to see if Karel should place a beeper
    as it moves up or not. */
    private void rightSide() 
    {
        while (facingEast()) 
        {
            move();
            if (frontIsClear())
            {
                move();
                putBeeper();
            }
            rightUp();
        }
    }
    
    /*While Karel is facing the east side and hits the wall.
    I use if-else conditions to see if where karel is at the   
    moment has a beeper or not. Depending on that then karel
    will place or not place a beeper once it moves upwards.*/
    private void rightUp() 
    {
        if (frontIsBlocked())
         {
            if (beepersPresent()) 
            {
                turnLeft();
            	if (frontIsClear()) 
           	 	{
                    move();
                    turnLeft();
                    move();
                    putBeeper();
                }
            }
     		else 
     		{
                turnLeft();
                if (frontIsClear()) 
                {
                    move();
                    turnLeft();
                    putBeeper();
                }
            }
        }
    }
    
    /*This method is used to make sure while Karel is facing the West side
    then it will continue to move and place a beeper until it hits the wall.
    Then the method leftUp() is called to see if Karel should place a beeper
    as it moves up or not. */
    private void leftSide() 
    {
        while (facingWest()) 
        {
            move();
            if (frontIsClear())
            {
                move();
                putBeeper();
            }
            leftUp();
        }
    }
    
    /*While Karel is facing the West side and hits the wall.
    I use if-else conditions to see if where karel is at the   
    moment has a beeper or not. Depending on that then karel
    will place or not place a beeper once it moves upwards.*/
    private void leftUp() 
    {
        if (frontIsBlocked()) 
        {
            if (beepersPresent()) 
            {
               turnRight();
                if (frontIsClear()) 
                {
                    move();
                    turnRight();
                    move();
                    putBeeper();
                } 
            }
            else 
            {
            	turnRight();
                if (frontIsClear()) 
                {
                    move();
                    turnRight();
                    putBeeper();
                }
                
            }
        }
    }
} 


 
