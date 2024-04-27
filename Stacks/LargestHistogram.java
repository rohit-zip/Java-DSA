package Stacks;

import java.util.Stack;

public class LargestHistogram {
    public static void main(String[] args) {
        int[] array = {6, 2, 5, 4, 5, 1, 6};

        Stack<Integer> stack;

        //Next smaller element index on the Right
        int[] rb = new int[array.length];

        //Assume if any element has 0 size then array.length will be it's rb
        rb[array.length-1] = array.length;

        //Right to Left loop
        stack = new Stack<>();

        //Push last element to the stack
        stack.push(array.length-1);

        for (int i=array.length-1 ; i>=0 ; i--){
            while(stack.size()>0 && array[i]<array[stack.peek()]){

                //If array at i is smaller then pop
                stack.pop();
            }

            //Pop all the greater elements and peek the smaller
            if (stack.size()==0) rb[i] = array.length;
            else rb[i] = stack.peek();

            stack.push(i);
        }

        //Next smaller element index on the Left
        int[] lb = new int[array.length];

        //Left to Right loop
        stack = new Stack<>();

        //Push first element to the stack
        stack.push(0);

        lb[0] = array.length;

        for (int i=1 ; i<array.length ; i++){
            while(stack.size()>0 && array[i]<array[stack.peek()]){

                //If array at i is smaller then pop
                stack.pop();
            }

            //Pop all the greater elements and peek the smaller
            if (stack.size()==0) lb[i] = -1;
            else lb[i] = stack.peek();

            stack.push(i);
        }

        int maxArea = 0;
        for (int i=0 ; i<array.length ; i++){
            int width = rb[i] - lb[i] - 1;
            int area = array[i] * width;

            if (area>maxArea){
                maxArea = area;
            }
        }
        System.out.println(maxArea);
    }
}
