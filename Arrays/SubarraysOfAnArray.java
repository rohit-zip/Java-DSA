package Arrays;

/**
 * @author - rohit
 * @project - Data-Structures-and-Algorithm-in-Java
 * @package - Arrays
 * @created_on - 13 October-2023
 */

public class SubarraysOfAnArray {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4};
        for (int i=0 ; i<array.length ; i++){
            for (int j=i ; j<array.length ; j++){
                for (int k=i ; k<=j ; k++){
                    System.out.print(array[k] + " ");
                }
                System.out.println();
            }
        }
    }
}
