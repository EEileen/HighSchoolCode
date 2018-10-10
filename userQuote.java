/**
Askes user for favorite quote using JOptionPane
and tells them information about the quote like
letters, characters etc.

**/
import javax.swing.*;

public class userQuote {

    public static void main(String[] args) {

        String quote;

        // get string input
        quote = JOptionPane.showInputDialog( "What is your favourite quote?");
        //find letter appears at index 10    
        
        JOptionPane.showMessageDialog(null, "Letter that appears at Index 10: " + quote.charAt(10));
        JOptionPane.showMessageDialog(null, "The first occurance of the letter t is at index: " + quote.indexOf('t'));
        JOptionPane.showMessageDialog(null, "The number of characters in this quote: " + quote.length());

        //replace "the" with "foobar"
        JOptionPane.showMessageDialog(null, "Changed 'the' to 'foobar', new quote is: " + quote.replace("the","foobar"));  

        //change quote to upper case
        JOptionPane.showMessageDialog(null,"Shouted quote: " + quote.toUpperCase());

        //if quote contains "horse", print "i like your taste"
        if (quote.contains("horse")){
			JOptionPane.showMessageDialog(null, "I like your taste. " + quote.contains("horse"));
		}//if
		
		System.exit(0);

    }//main
}//userQuote