package Arrays;

/**
 * @author - rohit
 * @project - Data-Structures-and-Algorithm-in-Java
 * @package - Arrays
 * @created_on - 13 October-2023
 */

public class SubsetsOfAnArray {
    public static void main(String[] args) {
        int[] array = {10, 20, 30};
        int limit = (int) Math.pow(2, array.length);
        for (int i=0 ; i<limit ; i++){
            String data = "";
            int temp = i;
            for (int j = array.length-1 ; j>=0 ; j--){
                int binary = temp%2;
                temp = temp/2;

                if (binary==0){
                    data = "-\t" + data;
                } else {
                    data = array[j] + "\t" + data;
                }
            }
            System.out.println(data);
        }
    }
}
