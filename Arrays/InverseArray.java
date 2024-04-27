package Arrays;

/**
 * @author - rohit
 * @project - Data-Structures-and-Algorithm-in-Java
 * @package - Arrays
 * @created_on - 12 October-2023
 */

public class InverseArray {
    public static void main(String[] args) {

        int[] array = {3, 2, 0, 1, 4};
        int[] inverse = new int[array.length];

        for (int i=0 ; i<array.length ; i++){
            int data = array[i];
            inverse[data] = i;
        }

        for (int a : inverse) System.out.print(a + " " );
    }
}
