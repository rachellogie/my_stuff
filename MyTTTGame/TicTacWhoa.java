package tictac.test;


import java.io.*;
import acm.util.*;
import java.util.*;
import acm.program.*;
import acm.graphics.*;
import java.awt.*;
import java.awt.event.MouseEvent;

import javax.swing.*;


public class TicTacWhoa extends GraphicsProgram{

	public void init(){
		drawGrid();
		putSquares();
		initArray();
		addMouseListeners();
		counter = 1;
		whatevs = 0;
		
	}
	
	public void mouseClicked(MouseEvent e){
		int x = e.getX();
		int y = e.getY();
		if(checkElements(x,y) == true){
				//getElementAt(x,y) != null){
			GObject temp = getElementAt(x,y);
			double newX = temp.getX();
			double newY = temp.getY();		
			Mark marker = new Mark (boxSize, counter);			
			add(marker, newX, newY);
			remove(temp);
			updateArray(temp);
			if(counter < 2){
				counter++;
			}else{
				counter = 1;
			}
			whatevs++;
		}
	}
	
	private boolean checkElements(int x,int y){
		GObject temp = getElementAt(x, y);
		
		if ((temp == box1) || (temp == box2)){	//replace all of the below with temp
			return true;	
		} else if ((temp == box3) || (temp == box4)){
			return true;
		} else if ((temp == box5) || (temp == box6)){
			return true;
		} else if ((temp == box7) || (temp == box8)){
			return true;
		} else if (temp == box9){
			return true;
		} else {
			return false;
		}
	}
	
	private void initArray(){
		for(int i = 0; i < 9; i++){
			array[i] = i + 20;
		}
	}
	
	private void updateArray(GObject temp){
		int boxNumber = map.get(temp);
		array[boxNumber - 1] = counter;
		checkArray(boxNumber);
		
		GLabel label = new GLabel("array spot: " + (boxNumber - 1) + " array value: " + array[boxNumber-1], 20, whatevs*15 +40);
		add(label);
	}
	
	private void checkArray(int boxNumber){
		String winner = "";
		if(counter == 2){
			winner = "cute puppy!";
		} else {
			winner = "frog-kitten!";
		}
		GLabel win = new GLabel("You win, " + winner, 20,20);
		
		//if boxNumber == 0??
		if(array[0] == array[1] && array[1] == array[2]){
			add(win);
		} else if(array[3] == array[4] && array[4] == array[5]){
			add(win);
		}else if(array[6] == array[7] && array[7] == array[8]){
			add(win);
		}else if(array[0] == array[3] && array[3] == array[6]){
			add(win);
		}else if(array[1] == array[4] && array[4] == array[7]){
			add(win);
		}else if(array[2] == array[5] && array[5] == array[8]){
			add(win);
		}else if(array[0] == array[4] && array[4] == array[8]){
			add(win);
		}else if(array[2] == array[4] && array[4] == array[6]){
			add(win);
		}
	}
	
	
	
	
	
	
		
	private void putSquares(){
		//This could all be done by a loop?  and then put map.put(box1, 1) separate
		box1 = new GRect(getWidth()*1/5, getHeight()/8 + 0*boxSize, boxSize, boxSize);
		box1.setColor(Color.red);
		add(box1);
		box1.setVisible(false);
		map.put(box1, 1);
		
		box2 = new GRect(getWidth()*2/5, getHeight()/8 + 0*boxSize, boxSize, boxSize);
		box2.setColor(Color.red);
		add(box2);
		box2.setVisible(false);
		map.put(box2, 2);
		
		box3 = new GRect(getWidth()*3/5, getHeight()/8 + 0*boxSize, boxSize, boxSize);
		box3.setColor(Color.red);
		add(box3);
		box3.setVisible(false);
		map.put(box3, 3);
		
		box4 = new GRect(getWidth()*1/5, getHeight()/8 + 1*boxSize, boxSize, boxSize);
		box4.setColor(Color.red);
		add(box4);
		box4.setVisible(false);
		map.put(box4, 4);
		
		box5 = new GRect(getWidth()*2/5, getHeight()/8 + 1*boxSize, boxSize, boxSize);
		box5.setColor(Color.red);
		add(box5);
		box5.setVisible(false);
		map.put(box5, 5);
		
		box6 = new GRect(getWidth()*3/5, getHeight()/8 + 1*boxSize, boxSize, boxSize);
		box6.setColor(Color.red);
		add(box6);
		box6.setVisible(false);
		map.put(box6, 6);
		
		box7 = new GRect(getWidth()*1/5, getHeight()/8 + 2*boxSize, boxSize, boxSize);
		box7.setColor(Color.red);
		add(box7);
		box7.setVisible(false);
		map.put(box7, 7);
		
		box8 = new GRect(getWidth()*2/5, getHeight()/8 + 2*boxSize, boxSize, boxSize);
		box8.setColor(Color.red);
		add(box8);
		box8.setVisible(false);
		map.put(box8, 8);
		
		box9 = new GRect(getWidth()*3/5, getHeight()/8 + 2*boxSize, boxSize, boxSize);
		box9.setColor(Color.red);
		add(box9);
		box9.setVisible(false);
		map.put(box9, 9);
	}
	
	/*private void putSquares(){
		for(int j = 0; j<3; j++){
			for(int i = 1; i<4; i++){
				GRect box = new GRect(getWidth()*i/5, getHeight()/8 + j*boxSize, boxSize, boxSize);
				box.setColor(Color.red);
				add(box);
				//add box to an array? or a hashmap using a different counter for the value
			}
		}
	}
	*/
	
	
	private void drawGrid(){
		boxSize = getWidth() * boxParameter;

		GLine line1 = new GLine(getWidth()*(boxParameter*2), getHeight()/8, getWidth()*2/5, getHeight()/8 + boxSize*3);
		add(line1);
		
		GLine line2 = new GLine(getWidth()*3/5, getHeight()/8, getWidth()*3/5, getHeight()/8 + boxSize *3);
		add(line2);
		
		GLine line3 = new GLine(boxSize, getHeight()/8 + boxSize, getWidth()*4/5, getHeight()/8 + boxSize);
		add(line3);
		
		GLine line4 = new GLine(boxSize, getHeight()/8 + boxSize*2, getWidth()*4/5, getHeight()/8 + boxSize*2);
		add(line4);
	}
	
	
	
	private static final double boxParameter = .2;
	
	
	//ivars
	private double boxSize;
	private int counter;
	private int[] array = new int[9];
	private GRect box1;
	private GRect box2;
	private GRect box3;
	private GRect box4;
	private GRect box5;
	private GRect box6;
	private GRect box7;
	private GRect box8;
	private GRect box9;
	private Map <GObject, Integer> map = new HashMap<GObject, Integer>();
	private int whatevs;
	
}