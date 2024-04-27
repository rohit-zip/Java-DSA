package BinaryTree;

import java.util.Stack;

public class Display {

    private static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
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

    /**
     *
     * Time Complexity -> O(N)
     * Space Comple xity -> O(N) Recursion Stack
     * @param node
     */
    public static void display(Node node){
        String str = "";
        if (node == null){
            return;
        }
        str += node.left == null ? "." : node.left.data + "";
        str += " <- " + node.data + " -> ";
        str += node.right == null ? "." : node.right.data + "";
        System.out.println(str);
        display(node.left);
        display(node.right);
    }
    public static void main(String[] args) {
        Integer[] array = {50, 25, 12, null, null, 37, 30, null, null, null,75, 62, null, 70, null, null, 87, null, null};
        Stack<Pair> stack = new Stack<>();
        Node root = new Node(array[0], null ,null);
        Pair pair = new Pair(root, 1);
        stack.push(pair);
        int idx = 0;
        while(!stack.isEmpty()){
            Pair top = stack.peek();
            if (top.state == 1){
                idx++;
                if (array[idx]!=null){
                    Node leftNode = new Node(array[idx], null, null);
                    top.node.left = leftNode;
                    Pair leftPair = new Pair(leftNode, 1);
                    stack.push(leftPair);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state==2) {
                idx++;
                if (array[idx]!=null){
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
        display(root);
    }
}
