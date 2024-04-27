package MultiDimensionalArrays;

import java.util.Scanner;

public class TravelByColumn2DArray {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int columns = sc.nextInt();

        int[][] array = new int[rows][columns];

        for (int i=0 ; i<array.length ; i++){
            for (int j=0 ; j<array[0].length ; j++){
                array[i][j] = sc.nextInt();
            }
        }

        //Here we have to use column loop first as we have to traverse column first.
        for (int j=0 ; j<array[0].length ; j++){
            //If column is even then we have to increase row else decrease row
            if (j%2==0){
                for (int i=0 ; i<array.length ; i++){
                    System.out.print(array[i][j] + " ");
                }
            }
            else{
                for (int i=array.length-1 ; i>=0 ; i--){
                    System.out.print(array[i][j] + " ");
                }
            }
        }
    }

}
