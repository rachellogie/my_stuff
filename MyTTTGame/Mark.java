package tictac.test;

import acm.graphics.*;

import java.awt.Color;
import java.awt.event.*;

public class Mark extends GCompound{

		public Mark(double boxSize, int counter){
			if(counter == 1){
                //if player1, makes frog-kitten
				GImage frog = new GImage("frog.jpeg");
				frog.setBounds(10,10, boxSize-20, boxSize-20);
				add(frog);
			} else {
                //if player2, makes puppy
				GImage dog = new GImage("dog.jpeg");
				dog.setBounds(10,10, boxSize-20, boxSize-20);
				add(dog);
				
				
				/*  Feel free to use the circle instead:
				GOval circle = new GOval(boxSize, boxSize);
				circle.setFilled(true);
				add(circle);
				GOval circle2 = new GOval(boxSize/2, boxSize/2);
				circle2.setFilled(true);
				circle2.setFillColor(Color.white);
				add(circle2, circle.getWidth()/4, circle.getHeight()/4);
				*/
			}
		}
}
