import java.util.*; //want scanner 
import javax.swing.*;
/*
	Program description:
	changes user number into 10 bit binary representation
	
	You have poisoned 1 out of 1000 of the king's wine bottles.
	Unfortunately you have been caught and the king has captured
	you and nine others. He is an evil king, and you don't tell him which 
	bottle contains the poison. The king decides to make all ten of you
	drink the potentially poisoned bottles. 
	
	The bottles are labelled 0-999.
	The prisoners are labelled 0-9.
	
	How can the king figure out which bottle you poisoned?
	
*/

public class PoisonedBottle {
	
	public static void printArray(int[] arr){
		int i; //printer
		for(i=0;i<arr.length;i++){
			System.out.print(arr[i] + " ");
		}//for
		System.out.println();
	}//printArray
	
	public static void decimalToBinary(int[] a, int decimal){
		
		for(int i = 9;i>=0; i--){
			
			if(decimal% 2==0){
				a[i] = 0;
			}else{
				a[i] = 1;
			}
			decimal = decimal/2;
			
		}
		
		return;
	}//decimalToBinary

	public static void main(String[] args){
		int actualBottle;
		int[] deathBin = {-1,-1,-1,-1,-1,-1,-1,-1,-1,-1};
		
		String bottleNum;
		
		//ask which bottle was poisoned
		//Scanner userInput = new Scanner(System.in);
		//System.out.println("Which bottle was poisoned?");
		
		JOptionPane.showMessageDialog(null,"You poisoned 1 out of 1000 of the king's bottles","Honey, You've Been Caught",JOptionPane.WARNING_MESSAGE );
		
	
		// get string input
        bottleNum = JOptionPane.showInputDialog("Which bottle did you poison? (0 - 999)");
		
		actualBottle = Integer.parseInt(bottleNum);//parse string to int
				
		System.out.println("death bin before:");		
		printArray(deathBin);
		
		decimalToBinary(deathBin, actualBottle);
		JOptionPane.showMessageDialog(null,actualBottle + " in binary is " + Arrays.toString(deathBin));
		printArray(deathBin);
		
	
	}//main
}//PoisonedBottle
