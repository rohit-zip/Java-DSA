package MultiDimensionalArrays;

import java.util.Scanner;

public class StoringData {
    /**
     * Store this elements into 2D-Array
     * | 1 | 2  | 2  | 4  |
     * | 5 | 6  | 7  | 8  |
     * | 9 | 10 | 11 | 12 |
     */

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();

        int[][] array = new int[a][b];

        for (int i=0 ; i<a ; i++){
            for (int j=0 ; j<b ; j++){
                array[i][j] = sc.nextInt();
            }
        }

        for (int i=0 ; i<array.length ; i++){
            for(int j=0 ; j<array[0].length ; j++){
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
    }
}
