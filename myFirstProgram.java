/*
	Here is one way to comment, this whole block is unseen
		The purpose of comments is to benefit of the programmer and its readers.
		The computer doesn't care basically
	
	*****Some somewhat important info:*******
	- for the line
			public class myFirstProgram{
		make sure that 'myFirstProgram' matches the name of the file. In this
		case, this file should be named 
			myFirstProgram.java
	
	- everything happens in 'main'
		this means that if you want something done, it must be called or used in 'main'.
		
	- some things that you should play around with are
		- loops: for loops, while loops, do while loops
		- variables with different types 
			int (integer
			double (decimal number)
			float (decimal number)
			char (characters like 'a')
			bool (boolean that is either 1 or 0 - true or false) 
			
		- methods. they are used when u want to be lazy by reducing redundancy 
			- also, know about methods and their return types
		- if statements and if else statements are CONDITIONAL STATEMENTS
		- arrays
		- Strings
		
	- some things that you should play around with (level 2)
		- try catch (exception handling)
		- java has this thing called 'objects'
		- you can ask the user to input numbers too... 
		
	- when you are naming your variables, google 'variable naming convention'
		this will tell you what you can and cannot do...
		ex. YES:   my_Num   MY_ARRAY  yeaBoi
			NO:    1stNum   34a  L8er
		
	- a helpful link...  https://docs.oracle.com/javase/tutorial/java/nutsandbolts/index.html
	
	- and when in doubt, google it!

*/

public class myFirstProgram{
	
	public static void main(String[] args){
		
		int x; //declare variable
		x = 5; //initialize variable
		int otherNum = 10; //declare and initialize variable combo
		double myPi = 3.141592654;
				
		// this is another way to comment, this whole line is unseen..... 	
		
		System.out.println("Hey wassup homie"); //this is going to print onto the console, a full line

		System.out.println("Pi is approximately: " + myPi); //printing variables
		
		System.out.println("x (before): " + x);
		x++; //increment x by 1 (add 1 to x), if you want to minus 1 from x: x--;
		System.out.println("x (after): " + x);	
		
		System.out.println("otherNum (before): " + otherNum);	
		otherNum = otherNum + 30; //note: otherNum += 30 will do the same thing
		System.out.println("otherNum (after): " + otherNum);	
		
	}//main

}//myFirstProgram