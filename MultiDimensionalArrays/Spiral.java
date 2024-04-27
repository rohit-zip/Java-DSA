package MultiDimensionalArrays;

import java.util.Scanner;

public class Spiral {
    /**
     *
     * Here our approach is to move wall by wall
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] array = new int[n][m];
        for (int i=0 ; i<array.length ; i++){
            for (int j=0 ; j<array[0].length ; j++){
                array[i][j] = sc.nextInt();
            }
        }

        int minRow = 0;
        int minColumn = 0;
        int maxRow = array.length-1;
        int maxColumn = array[0].length-1;

        while(true){
            //Left Side Column=minimum but row->Increasing
            //left side -> minimumColumn
            for (int i = minRow ; i<array.length ; i++){
                System.out.print(array[i][minColumn]);
            }
            minColumn++;

            //Bottom Side Row=Fixed at Maximum Position and Column->Increasing
            //bottom side -> maxRow
            for (int j = minColumn ; j<maxColumn ; j++){
                System.out.print(array[maxRow][j]);
            }
            maxRow--;

            //Right Side Column=Fixed at maximum position and Row->Decreasing
            //right side -> maxColumn
            for (int i=maxRow ; i>=0 ; i--){
                System.out.print(array[i][maxColumn]);
            }
            maxColumn--;

            //Top Side Row=Fixed at minimum position and Column->Decreasing
            //top side -> minRow
            for (int j = maxColumn ; j>=0 ; j--){
                System.out.println(array[minRow][j]);
            }
            minRow++;
        }
    }
}
