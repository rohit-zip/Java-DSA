package Stacks;

import java.util.Stack;

public class BalancedBrackets {

    public static boolean handleClosing(Stack<Character> stack, char opening){
        if (stack.size()==0){
            return false;
        } else if (stack.peek() != opening) {
            return false;
        }
        else stack.pop();
        return true;
    }
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
        String a = "[(a+b) + {[a+b]}]";
        
        for (int i=0 ; i<a.length() ; i++){
            char b = a.charAt(i);
            if (b=='(' || b=='[' || b=='{'){
                stack.push(b);
            }
            else if (b==')'){
                if (!handleClosing(stack, '(')) {
                    System.out.println(false);
                    return;
                }
            }
            else if (b==']'){
                if (!handleClosing(stack, '[')) {
                    System.out.println(false);
                    return;
                }
            }
            else if (b=='}'){
                if (!handleClosing(stack, '{')) {
                    System.out.println(false);
                    return;
                }
            }
        }
        if (stack.size()==0) System.out.println(Boolean.TRUE);
        else System.out.println(Boolean.FALSE);
    }
}
