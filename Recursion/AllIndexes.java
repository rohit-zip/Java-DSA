package Recursion;

public class AllIndexes {
    public static void main(String[] args) {
        for (int a : allIndexes(new int[]{1,2,4,5,6,2,7,2,8,2}, 2, 0, 0)){
            System.out.println(a);
        }
    }

    public static int[] allIndexes(int[] array, int data, int index, int founds) {
        if (index == array.length) {
            return new int[founds];
        }
        if (array[index] == data) {
            int[] ints = allIndexes(array, data, index+1, founds+1);
            ints[founds] = index;
            return ints;
        } else {
            int[] ints = allIndexes(array, data, index+1, founds);
            return ints;
        }
    }
}
