package Stacks;

import java.util.Stack;

public class NextGreaterElementToRight {
    public static void main(String[] args) {
        int[] nextGreater = nextGreater(new int[]{2, 5, 4, 10, 1, 12, 6, 8, 7});
        for (int a : nextGreater){
            System.out.print(a + " ");
        }
    }

    public static int[] nextGreater(int[] array){
        int[] a = new int[array.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(array.length-1);
        a[array.length-1] = -1;
        for (int i=a.length-2 ; i>=0 ; i--){
            while(stack.size()>0 && array[i]>=stack.peek()){
                stack.pop();
            }
            if (stack.size()==0){
                a[i] = -1;
            }
            else {
                a[i] = stack.peek();
            }
            stack.push(array[i]);
        }
        return a;
    }
}
