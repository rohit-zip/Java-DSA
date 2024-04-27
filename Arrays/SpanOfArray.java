package Arrays;

/**
 * @author - rohit
 * @project - Data-Structures-and-Algorithm-in-Java
 * @package - Arrays
 * @created_on - 12 October-2023
 */

public class SpanOfArray {
    public static void main(String[] args) {
        int[] array = {1,5,10,60,4,7,80,20,25,6};
        int max = array[0];
        int min = array[0];

        for (int i=0 ; i<array.length ; i++){
            if (array[i]>max) max = array[i];
            if (array[i]<min) min = array[i];
        }

        int span = max - min;
        System.out.println(span);
    }
}
