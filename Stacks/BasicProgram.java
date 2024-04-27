package Stacks;

import java.util.Stack;

public class BasicProgram {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);
        System.out.println(stack);

        System.out.println("Peek : " + stack.peek());

        Integer pop = stack.pop();
        System.out.println("Poped : " + pop);
        System.out.println("Peek : " + stack.peek());
    }
}
