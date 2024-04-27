package LeetCode;

import java.util.Stack;

public class ValidParentheses {

    public static boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        for(Character ch : s.toCharArray()){
            switch(ch){
                case '(' :
                case '[' :
                case '{' :
                    stack.push(ch);
                    break;
                case ')' : {
                    if (stack.isEmpty() || stack.pop()!='(') return false;
                    break;
                }
                case ']' : {
                    if (stack.isEmpty() || stack.pop()!='[') return false;
                    break;
                }
                case '}' : {
                    if (stack.isEmpty() || stack.pop()!='{') return false;
                    break;
                }
            }
        }
        return stack.isEmpty();
    }
    public static void main(String[] args) {
        String a = "()[]{}";
    }
}