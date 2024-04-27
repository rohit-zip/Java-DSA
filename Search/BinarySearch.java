package Search;

public class BinarySearch {

    /**
     *
     * Condition :
     *      Data Structure must be of sorted form
     * <p>
     * When to use Binary search :
     *      1. When dataset is sorted
     *      2. When we have to search large dataset as it's time complexity is O(log n)
     * <p>
     * Time Complexity :
     *      Best Case : Ω(1) (When element is at the middle of an Array)
     *      Average Case : θ(log n)
     *      Worst Case : O(log n)
     * <p>
     * Space Complexity :
     *      Auxiliary Space : O(1) As no extra space is required
     */

    public static int binarySearch(int[] array, int data){
        int lowerBound = 0, higherBound = array.length-1;

        while(lowerBound<=higherBound){
            int middleIndex = (lowerBound + higherBound)/2;

            if (array[middleIndex]>data) higherBound = middleIndex -1;
            if(array[middleIndex]<data) lowerBound = middleIndex + 1;
            else return middleIndex;
        }
        return -1;
    }

    public static void main(String[] args) {
        int i = binarySearch(new int[]{1, 2, 4, 5, 6, 7, 8, 10, 14, 16, 18}, 18);
        System.out.println(i>=0 ? "Element found at Index : " + i : "Element not found in an array");
    }
}
