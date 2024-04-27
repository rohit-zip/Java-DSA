package Stacks;

import java.util.Stack;

public class SlidingWindow {
    public static void main(String[] args) {

        int[] array = {1, 6, 2, 4, 8, 1, 6, 4, 10, 7};
        int k =4;
        Stack<Integer> a = new Stack<>();
        int[] nextGreater = new int[array.length];
        a.push(array.length-1);

        //Next Greater for last element in array is array.length
        nextGreater[array.length-1] = array.length;
        for (int i=array.length-2 ; i>=0 ; i--){
            while(a.size()>0 && array[i]>=array[a.peek()]){
                a.pop();
            }

            //If stack is empty it means there is no next greater
            if (a.size()==0){
                nextGreater[i] = array.length;
            }
            else {
                nextGreater[i] = a.peek();
            }
            a.push(i);
        }

        int j=0;
        for (int i=0 ; i<=array.length-k ; i++){
            //Entering the loop to find maximum of window at i
            if (j<i){
                j=i;
            }
            while(nextGreater[j]<i+k){
                j = nextGreater[j];
            }
            System.out.print(array[j] + " ");
        }
    }
}
