package BinaryTree;

import java.util.Stack;

public class TiltOfBinaryTree {

    static int tilt = 0;

    private static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private static class Pair{
        Node node;
        int state;

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node binaryTree(Integer[] array){
        Stack<Pair> stack = new Stack<>();
        Node root = new Node(array[0]);
        Pair rootPair = new Pair(root, 1);
        stack.push(rootPair);
        int idx = 0;
        while (stack.size() > 0) {
            Pair top = stack.peek();
            if (top.state == 1) {
                idx++;
                if (array[idx] != null) {
                    Node leftNode = new Node(array[idx]);
                    top.node.left = leftNode;
                    Pair leftPair = new Pair(leftNode, 1);
                    stack.push(leftPair);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state==2) {
                idx++;
                if (array[idx]!=null) {
                    Node rightNode = new Node(array[idx]);
                    top.node.right = null;
                    Pair rightPair = new Pair(rightNode, 1);
                    stack.push(rightPair);
                } else {
                    top.node.right = null;
                }
                top.state++;
            } else {
                stack.pop();
            }
        }
        return root;
    }

    /**
     *
     * Here we use change and travel strategy
     * Return sum and change tilt
     * As we need sum for upper nodes to calculate tilt
     */
    public static int tilt(Node root){
        if (root==null)
            return 0;
        int ls = tilt(root.left);
        int rs = tilt(root.right);
        int localTilt = Math.abs(ls-rs);
        tilt+= localTilt;
        int sum = ls + rs + root.data;
        return sum;
    }

    public static void main(String[] args) {
        Integer[] array = {50, 25, 12, null, null, 37, 30, null, null, null,75, 62, null, 70, null, null, 87, null, null};
        Node root = binaryTree(array);
        tilt(root);
        System.out.println(tilt);
    }
}
