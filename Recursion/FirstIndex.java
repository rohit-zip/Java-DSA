package Recursion;

public class FirstIndex {
    public static void main(String[] args) {
//        int i = firstIndex(new int[]{2, 1, 4, 6, 2, 7}, 2, 0);
        int i = optimisedApproach(new int[]{2, 1, 4, 6, 2, 7}, 2, 0);
        System.out.println(i);
    }

    //This approach is not very good as it will iterate whole array in reverse
    public static int firstIndex(int array[], int data, int index){
        //Faith firstIndex(array, data, index + 1)
        if (array.length==index) return -1;
        int i = firstIndex(array, data, index + 1);
        if (array[index]==data) return index;
        else return i;
    }

    public static int optimisedApproach(int[] array, int data, int index){
        if (index==array.length) return -1;
        if (array[index]==data) return index;
        else{
            int i = optimisedApproach(array, data, index + 1);
            return i;
        }
    }
}
