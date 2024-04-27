package Stacks;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {
    //Like NextGreaterElementThanLeft
    //Pop all small elements
    public static void main(String[] args) {
        int[] ints = stockSpan(new int[]{2, 5, 9, 3, 1, 12, 6, 8, 7});
        Arrays.stream(ints).forEach(System.out::print);
    }

    public static int[] stockSpan(int[] array){
        int[] span = new int[array.length];
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        span[0] = 1;
        for (int i=1 ; i<array.length ; i++){
            while(stack.size()>0 && array[i]>array[stack.peek()]){
                stack.pop();
            }
            if (stack.size()==0){
                span[i] = i+1;
            }
            else {
                span[i] = i-stack.peek();
            }
            stack.push(i);
        }
        return span;
    }
}
