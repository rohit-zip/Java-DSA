package Stacks;

import java.util.Stack;

public class InfixEvaluation {
    public static void main(String[] args) {

        String expression = "(a+b)";
        Stack<Integer> operands = new Stack<>();
        Stack<Character> operator = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch == '(') {
                operator.push(ch);
            } else if (Character.isDigit(ch)) {
                operands.push(ch - '0'); //Character -> Integer
            } else if (ch == ')') {
                while (operator.peek() != '(') {
                    Character op = operator.pop();
                    Integer v2 = operands.pop();
                    Integer v1 = operands.pop();

                    int value = operation(v1, v2, op);
                    operands.push(value);
                }
            } else if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {

                //ch is wanting higher priority operators to solve first
                while (operator.size() > 0 && operator.peek() != '('
                        && precedence(ch) <= precedence(operator.peek())) {
                    Character a = operator.pop();
                    Integer v2 = operands.pop();
                    Integer v1 = operands.pop();
                    int operation = operation(v1, v2, a);
                    operands.push(operation);
                }

                operator.push(ch);
            }
        }

        while (operator.size() != 0) {
            Character op = operator.pop();
            Integer v2 = operands.pop();
            Integer v1 = operands.pop();

            int value = operation(v1, v2, op);
            operands.push(value);
        }

        System.out.println(operands.peek());
    }

    public static int precedence(char operator) {
        if (operator == '+') {
            return 1;
        } else if (operator == '-') {
            return 1;
        } else if (operator == '*') {
            return 2;
        } else {
            return 2;
        }
    }

    public static int operation(int v1, int v2, char operator) {
        if (operator == '+') {
            return v1 + v2;
        } else if (operator == '-') {
            return v1 - v2;
        } else if (operator == '*') {
            return v1 * v2;
        } else {
            return v1 / v2;
        }
    }
}
