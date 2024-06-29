package BinaryTree;

import java.util.Stack;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Java Questions
 * Package - BinaryTree
 * Created_on - June 29 - 2024
 * Created_at - 21:00
 */

public class Size {

    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private static class Pair {
        Node node;
        int state;

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static int size(Node node) {
        if (node == null) return 0;
        int ls = size(node.left);
        int rs = size(node.right);
        int total = ls + rs + 1;
        return total;
    }

    public static void main(String[] args) {
        Integer[] array = {50, 25, 12, null, null, 37, 30, null, null, null,75, 62, null, 70, null, null, 87, null, null};
        Stack<Pair> stack = new Stack<>();
        Node rootNode = new Node(array[0], null, null);
        Pair rootPair = new Pair(rootNode, 0);
        stack.push(rootPair);
        int index = 0;

        while (!stack.isEmpty()) {
            Pair top = stack.peek();
            if (top.state == 0) {
                index++;
                if (array[index] != null) {
                    Node leftNode = new Node(array[index], null, null);
                    top.node.left = leftNode;
                    Pair leftPair = new Pair(leftNode, 0);
                    stack.push(leftPair);
                } else {
                    top.node.left = null;
                }
            } if (top.state == 1) {
                index++;
                if (array[index] != null) {
                    Node rightNode = new Node(array[index], null, null);
                    top.node.right = rightNode;
                    Pair rightPair = new Pair(rightNode, 0);
                    stack.push(rightPair);
                } else {
                    top.node.right = null;
                }
            } else {
                stack.pop();
            }
        }
    }
}
