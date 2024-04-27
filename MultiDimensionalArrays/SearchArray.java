package MultiDimensionalArrays;

import java.util.Scanner;

public class SearchArray {
    /**
     *
     * Given Matrix is sorted for Rows as well as Columns
     *
     * Use approach like binary search here
     * Stand at max value of column
     * 1. If value is greater than that then move downwards
     * 2. If value is smaller than move left
     */

    public static String search(int[][] array, int data){

        int initialRow = 0;
        int initialColumn = array[0].length-1;

        String index = null;
        while(initialRow<array.length && initialColumn>=0){
            if (data>array[initialRow][initialColumn]){
                initialRow++;
            }
            else if (data<array[initialRow][initialColumn]){
                initialColumn--;
            }
            else{
                index = "Row : " + initialRow + " \n" + "Column : " + initialColumn;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] array = new int[n][n];

        for (int i=0 ; i<array.length ; i++){
            for (int j=0 ; j<array[0].length ; j++){
                array[i][j] = sc.nextInt();
            }
        }

        int data = 42;
        String search = search(array, data);
        System.out.println(search);
    }
}
