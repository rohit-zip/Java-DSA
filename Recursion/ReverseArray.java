package Recursion;

public class ReverseArray {
    public static void main(String[] args) {
        reverseArray(new int[]{1,2,3,4,5,6,7,8}, 0);
    }

    public static void reverseArray(int array[], int index){
        if (array.length==index) return;
        reverseArray(array, index + 1);
        System.out.println(array[index]);
    }
}
