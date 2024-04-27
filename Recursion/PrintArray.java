package Recursion;

public class PrintArray {
    public static void main(String[] args) {
        printArray(new int[]{1,2,3,4,5,6,7,8}, 0);
    }

    public static void printArray(int array[], int index){
        if (array.length==index) return;
        System.out.println(array[index]);
        printArray(array, index + 1);
    }
}
