package MultiDimensionalArrays;

import java.sql.SQLOutput;
import java.util.Scanner;

public class MultiplyMatrix {

    /**
     *
     * Refrence -> https://www.mathsisfun.com/algebra/matrix-multiplying.html
     *
     * Matrix A -> 1    2    3           Matrix B -> 7  |  8
     *             -----------                      ---------
     *             4    5    6                       9  |  10
     *                                              ---------
     *                                               11 |  12
     *
     *          Mulitplication -> 58  |  64
     *                            ---------
     *                            139 | 154
     *
     * Condition -> Columns of 1st Matrix equals Rows of 2nd Matrix (2 X 2)
     *
     * Approach -> Create new 2D-Array [Rows of 1st Matrix][Columns of 2nd Matrix]
     *             array[0][0] = (1X7)+(2X9)+(3X11) = 58
     *             array[0][1] = (1X8)+(2X10)+(3X12) = 64
     *             array[1][0] = (4X7)+(5X9)+(6X11) = 139
     *             array[1][1] = (4X8)+(5X10)+(6X12) = 154
     */

    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);

        System.out.print("Enter Rows for Matrix 1 : ");
        int rows1 = sc.nextInt();
        System.out.println();
        System.out.print("Enter Columns for Matrix 1 : ");
        int columns1 = sc.nextInt();
        System.out.println();

        int[][] matrixOne = new int[rows1][columns1];

        for (int i=0 ; i<rows1 ; i++){
            System.out.println(i + " Row");
            for (int j=0 ; j<columns1 ; j++){
                matrixOne[i][j] = sc.nextInt();
            }
        }

        System.out.println("------------------------------------------");

        System.out.print("Enter Rows for Matrix 2 : ");
        int rows2 = sc.nextInt();
        System.out.println();
        System.out.print("Enter Columns for Matrix 2 : ");
        int columns2 = sc.nextInt();
        System.out.println();

        int[][] matrixTwo = new int[rows2][columns2];

        for (int i=0 ; i<rows2 ; i++){
            System.out.println(i + " Row");
            for (int j=0 ; j<columns2 ; j++){
                matrixTwo[i][j] = sc.nextInt();
            }
        }

        if (columns1!=rows2){
            System.err.println("Matrix cannot be Multiplied");
            return;
        }

        int[][] multiply = new int[rows1][columns2];

        for (int i=0 ; i<multiply.length ; i++){
            for (int j=0 ; j<multiply[0].length ; j++){
                for (int k=0 ; k<rows2 ; k++){
                    multiply[i][j] += matrixOne[i][k] * matrixTwo[k][j];
                }
            }
        }

        for (int i=0 ; i<multiply.length ; i++){
            System.out.println("---------------------------");
            for (int j=0 ; j<multiply[0].length ; j++){
                System.out.print(multiply[i][j] + "\t \t");
            }
        }
    }
}
