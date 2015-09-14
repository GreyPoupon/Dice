import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class Dice extends PApplet {

Die fate;
int diceSum;
int diceTotal = 0;
float diceAverage = 0;
float clickTime = 1;
public void setup()
{
	size(730,600);
	noLoop();
}
public void draw()
{
	background(0);
	diceSum = 0;
	for(int y = 10; y <= 430; y += 60)
	{
		for(int x = 10; x <= 670; x += 60)
		{
			fate = new Die(x, y);
			diceSum += fate.diceValue;
			diceTotal += fate.diceValue;
			fate.show();
		}
	}
	diceAverage = (diceAverage + PApplet.parseFloat(diceTotal))/clickTime;
	fate.info();
}
public void mousePressed()
{
	clickTime++;
	redraw();
}
class Die //models one single dice cube
{
	int diceX, diceY, diceValue;
	Die(int x, int y) //constructor
	{
		diceX = x;
		diceY = y;
		diceValue = (int)(Math.random()*6)+1;
	}
	public void show()
	{
		fill(255);
		rect(diceX, diceY, 50, 50);
		fill((int)(Math.random()*131),(int)(Math.random()*131),(int)(Math.random()*131));
		if(diceValue == 1)
		{
			ellipse(diceX + 25, diceY + 25, 5, 5);
		}
		if(diceValue == 2)
		{
			ellipse(diceX + 13, diceY + 37, 5, 5);
			ellipse(diceX + 37, diceY + 13, 5, 5);
		}
		if(diceValue == 3)
		{
			ellipse(diceX + 13, diceY + 13, 5, 5);
			ellipse(diceX + 25, diceY + 25, 5, 5);
			ellipse(diceX + 37, diceY + 37, 5, 5);
		}
		if(diceValue == 4)
		{
			ellipse(diceX + 13, diceY + 13, 5, 5);
			ellipse(diceX + 13, diceY + 37, 5, 5);
			ellipse(diceX + 37, diceY + 37, 5, 5);
			ellipse(diceX + 37, diceY + 13, 5, 5);
		}
		if (diceValue == 5)
		{
			ellipse(diceX + 13, diceY + 13, 5, 5);
			ellipse(diceX + 13, diceY + 37, 5, 5);
			ellipse(diceX + 25, diceY + 25, 5, 5);
			ellipse(diceX + 37, diceY + 37, 5, 5);
			ellipse(diceX + 37, diceY + 13, 5, 5);
		}
		if(diceValue == 6)
		{
			ellipse(diceX + 13, diceY + 13, 5, 5);
			ellipse(diceX + 13, diceY + 37, 5, 5);
			ellipse(diceX + 25, diceY + 13, 5, 5);
			ellipse(diceX + 25, diceY + 37, 5, 5);
			ellipse(diceX + 37, diceY + 37, 5, 5);
			ellipse(diceX + 37, diceY + 13, 5, 5);
		}
	}
	public void info()
	{
		stroke(255);
		fill(255);
		textSize(16);
		text("Sum: " + diceSum, 10, 530);
		text("Total: " + diceTotal, 10, 548);
		text("Average: " + diceAverage, 10, 566);
		stroke(0);
	}
}
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "Dice" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
