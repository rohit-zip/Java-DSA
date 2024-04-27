package Recursion;

public class LastIndex {
    public static void main(String[] args) {
        int i = lastIndex(new int[]{1, 2, 4, 5, 6, 2, 7}, 2, 0);
        System.out.println(i);
    }

    public static int lastIndex(int[] array, int data, int index){
        if (index==array.length) return -1;
        int i = lastIndex(array, data, index + 1);
        if (i==-1){
            if (array[index]==data){
                return index;
            }
            else {
                return -1;
            }
        }
        else {
            return i;
        }
    }
}
