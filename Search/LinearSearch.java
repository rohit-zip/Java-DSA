package Search;

public class LinearSearch {

    /**
     *
     * Traverse an array until elements is not found
     * <p>
     * Best Case : Ω(1)
     * Average Case : θ(n)
     * Worst Case : O(n)
     * <p>
     * Space Complexity : O(1)
     */

    public static int linearSearch(int[] array, int data){
        for (int i=0 ; i<array.length ; i++){
            if (array[i]==data) return i;    //O(n)
        }
        return -1;
    }

    public static void function(int n){
        for (int i=0 ; i<n ; i++){     // n+1
            for (int j=0 ; j<n ; j++) {   //n * (n+1)
                //body   3n^2
            }
            //body -> 3n
        }

        // n+1 + n^2 + n + n^2 + n  -> 5n^2 + 3n
        
        for (int i=0 ; i<n ; i++){ // n+1
            //body    n
            //body    n
        }

        // x11
        
        // 5n² + 6n + 12
    }

    public static int function(int a, int b){
        //body

        // int -> 4 bytes
        // long -> 8 bytes
        // float -> 4 bytes
        // long -> 8 byte
        // boolean -> 1 bits
        // char -> 2 bytes

        int sum = a+b;

        /**
         *
         * a -> 4 bytes
         * b -> 4 bytes
         * sum -> 4 bytes
         * constant -> 4 bytes
         */

        return sum;
    }

    public static void main(String[] args) {
        int i = linearSearch(new int[]{4, 1, 7, 5, 6, 8}, 2);
        System.out.println(i>=0 ? "Element found at Index : " + i : "Element not found in an array");
    }
}


