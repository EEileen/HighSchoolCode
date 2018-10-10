/**
asks user for age
formats decimal number too
**/
import java.util.*; //so that we can use scanner

public class scannerStuff{
	
	public static void main(String[] args){
		int age;
		Scanner myConsole = new Scanner(System.in);
		System.out.println("Please enter your age");
		age = myConsole.nextInt(); //.nextInt() reads an integer
		System.out.println("You are " + age + " years old loser");
		
		double number = 3.14159;
		System.out.println("the number initially is " + number);
		System.out.println("Changed number is: " );
		System.out.format("%.3f",number);
		System.out.println("Changed number again is: " );
		System.out.format("%.1f",number);
		
	}//main
}//scannerStuff