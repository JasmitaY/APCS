import stanford.karel.*;

/**
 *	An improved version of Karel
 *
 *	@author	Mr Greenstein
 */
public class ImprovedKarel extends Karel {

	/** Add a turn-around method */
	public void turnAround() {
		turnLeft();
		turnLeft();
	}
	
	/** Add a turn right method using turn-around */
	public void turnRight() {
		turnAround();
		turnLeft();
	}

}