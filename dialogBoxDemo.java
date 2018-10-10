import javax.swing.*;
import java.awt.Graphics;
/*
Gets user input to calculate their test score
*/
public class dialogBoxDemo {

    public static void main(String[] args) {
        String name;
        String inputNum;
        double num1 = 0;
        double num2 = 0;

        // get integer input from user
        inputNum = JOptionPane.showInputDialog( "Please enter YOUR test mark:");

        // parse string to a double
        try {
            num1 = Double.parseDouble(inputNum);
        } catch (Exception e) {
            System.out.println("Invalid mark");
        } // catch

        // get double input
        inputNum = JOptionPane.showInputDialog( "Please enter the total mark possible on test:");

        // parse string to a double
        try {
            num2 = Double.parseDouble(inputNum);
        } catch (Exception e) {
            System.out.println("Invalid total.");
        } // catch

        String input;

        // display test percentage
         JOptionPane.showMessageDialog(null,"Test percentage: " + num1/num2*100);

        System.exit(0);
    } // main
	
}  // dialogBoxDemo