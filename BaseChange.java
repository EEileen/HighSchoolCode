import java.util.*;
import javax.swing.*;
import java.awt.*;
/******************************************
Eileen Eng
dialog box, user input demo

program is incomplete

Program asks user to for either a decimal, binary, or hexadecimal value and converts it to a different base
******************************************/
public class BaseChange{
	
	public static void decToBinary(){
		
	}//decToBinary
	
	public static void binaryToHex(){
		
	}//binaryToHex
	
	public static void main(String[] args){
		String inputNum;
		
		JOptionPane.showMessageDialog(null,"This is a base changer. To change your decimal, 8 bit binary, or hexadecimal");
		
		inputNum = JOptionPane.showInputDialog( "Please enter your number you wish to convert:");

        // parse string to a double
        try {
            num1 = Double.parseDouble(inputNum);
        } catch (Exception e) {
            System.out.println("Invalid mark");
        } // catch
		
	}//main
	
}//BaseChange