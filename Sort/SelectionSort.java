package Sort;

import java.util.Arrays;

class SelectionSort{
	public static void main(String[] args){
		int[] array = {6,4,8,1,10,2,7,5};
		selectionSort(array);
		Arrays.stream(array).forEach(e-> System.out.print(e + " "));
	}

	private static void selectionSort(int[] array){
		for(int i=0 ; i<array.length-1 ; i++){  //1 2 4 5 6 7 8 10
			int m = i;
			for(int j = i+1 ; j<array.length ; j++){
				if(array[j]<array[m]) m = j;
			}
			int temp = array[i];
			array[i] = array[m];
			array[m] = temp;
		}
	}
}
