/**
removes duplicate chars in a string in main
*/
import java.util.*;
public class Tester{
	
	public static void main(String[] args){
		int age = 0;
		int x= 3;
		int y = 5;
		
		int[] arr = {5,4,3,2,1};
		int temp;
        for(int i=0; i < arr.length-1; i++){
 
            for(int j=1; j < arr.length-i; j++){
                if(arr[j-1] > arr[j]){
                    temp=arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = temp;
                }//if
            }//for
            
        }
		
		for(int i=0; i < arr.length; i++){
			System.out.println(arr[i]);
        }//for
		
		String point = "(" +x +"," +y+")";
		String poo = "AAAGCCTCTTTGTGTGGG";
		System.out.println(removeDup(poo));
		
		
	}//main
	
	
	public static String removeDup(String str){
		String compare = str.charAt(0)+"";
		
		for(int i = 1;i<str.length();i++){
			if(str.charAt(i-1)!=str.charAt(i)){
				compare += str.charAt(i);
			}//if
			
			//compare += str.charAt(i);
		}//for
		return compare;
	}//removeDup

}//csc106A2