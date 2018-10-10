import java.io.*; //want to use File class
import java.util.*; //want to use Scanner class

/******************************************************
Errors: Compile time issues
	javac fileName.java
Exceptions: RunTime issues
	java fileName
	
Files can be written or read.
Scanner can read input form console and file.

******************************************************/

public class FileIO_Demo{
	
	public static void main(String[] args){
		double x,average;
		double sum = 0;
		int count = 0;
		Random gener = new Random();
		
		int rnum = gener.nextInt(101);
		
		//generate 10 random numbers between 1-100
		for(int i = 0;i<10;i++){
			System.out.println("Random num time: " + rnum);
			rnum = gener.nextInt(101);
		}//for
		
		//create a object called inputFile
		File inputFile = new File("FileIODemoTxt.txt"); // June21.txt must be in the same directory 
												 //  of FileIO_Demo.java
		//see if the file even exists
		if(inputFile.exists()){
			System.out.println("Sucessfully found file.");
			System.out.println("Size of file's contents is: " + inputFile.length());
		}else{
			System.out.println("oh no, File not found");
		}//else
			
		//In Java, we can use "Exceptions" to prevent our program from crashing
		//reading words in the file
		try{
			Scanner fileReader = new Scanner(inputFile); //pass file object into Scanner			
			while(true){ //infinte loop
				/*
				x= fileReader.nextDouble();
				count++;
				sum +=x; */  //include the previous if the file contains numbers
				String otherWord = fileReader.next();
				System.out.println(otherWord); // when the loop has reached
											   // the end of the file, it throws
											   // the exception
		    }//while	
			
		}catch (Exception e){
			System.out.println("OMG, this file is empty");
		}//catch
		
		average = sum/count;
		System.out.println(average); //should be 0 if the file has strings
		
		int a[] = {1,2,3};
		try{
			//put suspicious statments in the try block
			System.out.println(a[3]);
		}catch(Exception e){
			System.out.println("Something went wrong... it's probably the array, this SHOULD happen");
		}//catch
		
		//2D array
		int b[][] = {
						{1,2,3},
						{4,5,6},
						{7,8,9}
					};
		print2dArr(b);
		printMaxPerRow(b);
				
		
	}//main
	
	public static void print2dArr(int[][] x){
		for(int i = 0;i<x.length;i++){ //x.length is row length
			for(int j = 0;j<x[i].length;j++){ //x[i].length is column length
				System.out.print(x[i][j] + " ");
			}//for
			System.out.println();
		}//for
	}//print2dArr
	
	public static void printMaxPerRow(int[][] x){
		int max;
		for(int i = 0;i<x.length;i++){ //x.length is row length
			System.out.print("Row "+i);
			max = 0;
			for(int j = 0;j<x[i].length;j++){ //x[i].length is column length
				if(x[i][j]>=max){
					max=x[i][j];
				}//if
			}//for
			System.out.print(" max: " +max);
			System.out.println();
		}//for
	}//print2dArr
	
	public static void rotateUp(int[][] x){
		//store the first row in a temporary array
		int[][] temp = new int[1][x[0].length];
		
		for(int i = 0;i<x.length;i++){ //x.length is row length
			//store a temp
			for(int j = 0;j<x[i].length;j++){ //x[i].length is column length
				x[i][j] = x[i+1][j+1];
				if(j==0){
					System.out.println("j is zero");
				}//if
			}//for
			System.out.println();
		}//for
	}//print2dArr
	
}//csc110Lab6