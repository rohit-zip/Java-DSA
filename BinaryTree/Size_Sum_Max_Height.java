package BinaryTree;

import java.util.Stack;

public class Size_Sum_Max_Height {

    private static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private static class Pair{
        int state;
        Node node;

        Pair(Node node, int state){
            this.node = node;
            this.state = state;
        }
    }

    public static void display(Node root){
        String str = "";
        if (root==null){
            return;
        }
        str += root.left==null ? "." : root.left.data;
        str += " <- " + root.data + " -> ";
        str += root.right==null ? "." : root.right.data;
        System.out.println(str);
        display(root.left);
        display(root.right);
    }

    public static int size(Node node) {
        if (node == null) return 0;
        int ls = size(node.left);
        int rs = size(node.right);
        return ls + rs + 1;
    }

    public static int sum(Node root){
        if (root==null)
            return 0;
        int leftSum = sum(root.left);
        int rightSum = sum(root.right);
        int total = leftSum + rightSum + root.data;
        return total;
    }

    public static int max(Node root){
        if (root==null) {
            return Integer.MIN_VALUE;
        }
        int leftMax = max(root.left);
        int rightMax = max(root.right);
        int max = Math.max(root.data, Math.max(leftMax, rightMax));
        return max;
    }

    public static int height(Node root){
        if (root==null){
            return -1; //For edges
            //return 0; //For Nodes
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        int fh = Math.max(leftHeight, rightHeight) + 1;

        return fh;
    }

    public static void main(String[] args) {
        Integer[] array = {50, 25, 12, null, null, 37, 30, null, null, null,75, 62, null, 70, null, null, 87, null, null};
        Stack<Pair> stack = new Stack<>();
        Node root = new Node(array[0], null, null);
        Pair pair = new Pair(root, 1);
        stack.push(pair);
        int idx = 0;
        while (!stack.isEmpty()) {
            Pair top = stack.peek();
            if (top.state == 1) {
                idx++;
                if (array[idx] != null) {
                    Node leftNode = new Node(array[idx], null, null);
                    top.node.left = leftNode;
                    Pair leftPair = new Pair(leftNode, 1);
                    stack.push(leftPair);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (array[idx] != null) {
                    Node rightNode = new Node(array[idx], null, null);
                    top.node.right = rightNode;
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
        System.out.println(height(root));
    }
}
