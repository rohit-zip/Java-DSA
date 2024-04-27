package Recursion;

public class MaxOfArray {
    public static void main(String[] args) {
        System.out.println(maxArray(new int[]{1,2,3,4,5,16,7,8}, 0));
    }

    public static int maxArray(int[] array, int index){
        //If we did not find any maximum till second last array then last will be our maximum
        if (index==array.length-1) return array[array.length-1];
        int i = maxArray(array, index + 1);
        if (i>array[index]) return i;
        else return array[index];
    }
}
