package Stacks;

import java.util.Stack;

public class DuplicateBrackets {

    /**
     * If there is duplicate brackets then print true
     * Else false
     * There is (,a,+ .... then push
     * For ) pop until it will not meet (
     * Once we pop the opening bracket then peek if there is open bracket then duplicate otherwise pop until next meet
     */
    public static void main(String[] args) {
        Stack<Character> stack = new Stack<>();
//        String a = "(a+b) + ((a+b))";
        String a = "((a+b) + (a+b))";
        for (int i=0 ; i<a.length() ; i++){
            char b = a.charAt(i);
            if (b==')'){
                if (stack.peek()=='('){
                    System.out.println(Boolean.TRUE);
                    return;
                }
                else{
                    while(stack.peek()!='('){
                        stack.pop();
                    }
                    //For removing the opening bracket
                    stack.pop();
                }
            }
            else {
                stack.push(b);
            }
        }
        System.out.println(Boolean.FALSE);
    }
}
