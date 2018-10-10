public class May30{
	/* pointer/ pass by values demo
		note: changing arrays in a method will change the array
	*/
	
	//changes the even indexes of an array to hold x
	public static void swap(int[] a, int x){
		for(int c = 0;c<a.length;c++){
			if(c%2==0){
				a[c]=x;
			}//if
		}//for
		
	}//swap
	
	public static void printArray(int[] b){
		for(int i = 0;i<b.length;i++){
			System.out.print(b[i] + " ");
		}//for
		System.out.println();
			
	}//printArray

	public static void main(String[] args){
		int[] arr = {1,2,3,4,5};

		
		printArray(arr);
		swap(arr,8);
		printArray(arr);
	
	}//main


}//My30