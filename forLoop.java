/**
prints stars using a for loop
**/
public class forLoop{
	
	public static void printStars(){
		//nested loop
		int numberOfRows = 10;
		int i,j;
		for(i=0;i<numberOfRows;i++){
			for(j=0;j<=i;j++){
				System.out.print("*");
			}//for
			System.out.print("\n");
		}//for	
	}//printStars
	
	public static void printMoreStars(int numberOfRows){
		//nested loop
		int i;
		int j=numberOfRows;
		int k = numberOfRows;
		for(i=0;i<numberOfRows;i++){
			for(j=k;j>0;j--){
				System.out.print("*");
			}//for
			k--;
			System.out.print("\n");
		}//for	
	}//printMoreStars
	
	//prints the even numbers between -20 to 40
	public static void printEvens(){
		int num = -20;
		//method 1
		for(;num<=40;num ++){
			if(num%2==0){
				System.out.print(num + " ");
			}//if
		}//for
		System.out.println();
		//method 2
		for(int k = -20;k<=40;k+=2){
			System.out.print(k + " ");
		}//for
	}//printEvens
	
	//prints the sum of some integers 1+2+3+...+max
	public static void sumNums(int max){
		int sum = 0;
		for(int i = 1;i<=max;i++){
			sum = sum+i;
		}//for
		System.out.println(sum);
	}//sumNums
	
	public static void main(String[] args){
		printStars();
		printMoreStars(10);
		printEvens();
		System.out.println();
		sumNums(10);
	}//main
	
	
}//forLoop