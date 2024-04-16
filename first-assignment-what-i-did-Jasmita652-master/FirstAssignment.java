/**
 *	FirstAssignment.java
 *	Display a brief description of your summer vacation on the screen.
 *
 *	To compile:	javac -cp .:acm.jar FirstAssignment.java
 *	To execute:	java -cp .:acm.jar FirstAssignment
 *
 *	@author	Jasmita Yechuri
 *	@since	August 20, 2020
 */
import java.awt.Font;

import acm.program.GraphicsProgram;
import acm.graphics.GLabel;

public class FirstAssignment extends GraphicsProgram {
    
    public void run() {
    	//	The font to be used
    	Font f = new Font("Serif", Font.BOLD, 18);
    	
    	//	Line 1
    	GLabel s1 = new GLabel("What I did on my summer vacation ...", 10, 20);
    	s1.setFont(f);
    	add(s1);
    	    	
    	//	Continue adding lines until you have 12 to 15 lines
    	GLabel s2 = new GLabel("I celebrated my 16th birthday with my family" +
    	" and my 3 close friends. We were all wearing ", 10, 40);
    	s2.setFont(f);
    	add(s2);
    	
    	
    	GLabel s3 = new GLabel("masks and were 6 feet apart from each other." +
    	" We met at the park and had a small picnic. ", 10, 60);
    	s3.setFont(f);
    	add(s3);
    	
    	GLabel s4 = new GLabel("We took so many pictures and then played uno and" +
    	" badminton for sometime. After playing for ", 10, 80);
    	s4.setFont(f);
    	add(s4);
    	
    	GLabel s5 = new GLabel("almost 2-3 hours we then had pizza for dinner and then" +
    	" I cut my cake. It was definitely a ", 10, 100);
    	s5.setFont(f);
    	add(s5);
    	
        GLabel s6 = new GLabel("memorable birthday and the best one yet.",10, 120);
        s6.setFont(f);
    	add(s6);
    	
    	GLabel s7 = new GLabel("Another exciting thing that I did over the summer" +
    	 " was getting my permit. With my permit I ",10, 140);
        s7.setFont(f);
    	add(s7);
    	
    	GLabel s8 = new GLabel("am allowed to drive. At first when I started to " +
    	"drive the car I was very nervous. I was afraid", 10, 160);
    	s8.setFont(f);
    	add(s8);
    	
    	GLabel s9 = new GLabel("I might crash into something, but after the first 5" +
    	" minutes of driving I got the hang of it. ", 10, 180);
    	s9.setFont(f);
    	add(s9);
    	
    	GLabel s10 = new GLabel("Turning and switching lanes is a little hard" +
    	" but with practice I think I can definitely improve.", 10, 200);
    	s10.setFont(f);
    	add(s10);
    	
    	GLabel s11 = new GLabel("Also, being an athlete it is very important that I" +
    	" stay in shape. So over the summer I have been ", 10, 220);
    	s11.setFont(f);
    	add(s11);
    	 
    	GLabel s12 = new GLabel("going on runs almost everyday. On the days that I did" +
    	" not run I would try to do other activities ", 10, 240);
    	s12.setFont(f);
    	add(s12);
    	
    	GLabel s13 = new GLabel("to stay active such as playing badminton or doing some " +
    	"workouts that I find on youtube.", 10, 260);
    	s13.setFont(f);
    	add(s13);
    	
    	GLabel s14 = new GLabel("Overall, this summer has been very fun even if I was at" +
    	" home for majority of the time.", 10, 280);
    	s14.setFont(f);
    	add(s14);	
    	
    }
    
}
