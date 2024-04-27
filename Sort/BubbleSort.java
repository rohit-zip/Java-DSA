package Sort;

import java.util.*;

class BubbleSort{

	/**
	 * 
	 * Time Complexity -> O(n²)  θ(n²)  Ω(n)
	 * Space Complexity -> O(1)
	 * 
	 */
	public static void main(String[] args){
		int[] array = {6,1,8,4,10,5,7};
		bubbleSort(array);
		//for(int a : array) System.out.print(a + " ");
		System.out.println();
		Arrays.stream(array).forEach(System.out::println);
	}

	public static void bubbleSort(int[] array){
		for(int i=1 ; i<=array.length-1 ; i++){   // n+1
			for(int j=0 ; j<array.length-i ; j++){  // n*(n+1)
				if(array[j]>array[j+1]){ // n * n
					int temp = array[j]; // n* n
					array[j] = array[j+1]; // n* n
					array[j+1] = temp; // n * n
				}
			}
		}
	}
}
