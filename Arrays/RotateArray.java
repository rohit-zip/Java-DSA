package Arrays;

/**
 * @author - rohit
 * @project - Data-Structures-and-Algorithm-in-Java
 * @package - Arrays
 * @created_on - 12 October-2023
 */

public class RotateArray {

    public static void reverse(int[] array, int low, int high){
        int li = low;
        int ri = high;
        while(li<ri){
            int temp = array[li];
            array[li] = array[ri];
            array[ri] = temp;

            li++;
            ri--;
        }
    }

    public static void rotate(int[] array, int k){
        //First Part
        reverse(array, 0, array.length-k-1);

        //Second Part
        reverse(array, array.length-k, array.length-1);

        //All
        reverse(array, 0, array.length-1);
    }

    public static void print(int[] array){
        for (int a : array) System.out.print(a);
    }

    public static void main(String[] args) {
        int[] array = {1,5,4,7,2,8,6};
        rotate(array, 2);
        print(array);
    }
}
