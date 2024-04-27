package Arrays;

/**
 * @author - rohit
 * @project - Data-Structures-and-Algorithm-in-Java
 * @package - Arrays
 * @created_on - 12 October-2023
 */
public class BarChart {

    public static void main(String[] args) {
        int[] array = {3, 1, 4, 0, 7, 5};

        int max = array[0];
        for (int a : array){
            if (a > max) max = a;
        }

        for (int i=max ; i>=1 ; i--){
            for (int j=0 ; j<array.length ; j++){
                if (array[j]>=i) System.out.print("|\t");
                else System.out.print("\t");
            }
            System.out.println();
        }
    }
}
