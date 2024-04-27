package BinaryTree;

import java.util.Stack;

public class PrintKLevelsDown {
    private static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private static class Pair{
        int state;
        Node node;

        public Pair(int state, Node node) {
            this.state = state;
            this.node = node;
        }
    }

    public static Node binaryTree(Integer[] array){
        Node root = new Node(array[0]);
        Pair rootPair = new Pair(1, root);
        Stack<Pair> stack = new Stack<>();
        stack.push(rootPair);
        int idx = 0;
        while (stack.size() > 0) {
            Pair top = stack.peek();
            if (top.state==1){
                idx++;
                if (array[idx]!=null){
                    Node leftNode = new Node(array[idx]);
                    top.node.left = leftNode;
                    Pair leftPair = new Pair(1, leftNode);
                    stack.push(leftPair);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state==2){
                idx++;
                if (array[idx]!=null){
                    Node rightNode = new Node(array[idx]);
                    top.node.right = rightNode;
                    Pair rightPair = new Pair(1, rightNode);
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

    public static void kLevelDown(Node root, int k){
        if (root==null || k<0){
            return;
        }
        if (k==0){
            System.out.println(root.data);
            return;
        }
        kLevelDown(root.left, k-1);
        kLevelDown(root.right, k-1);
    }

    public static void main(String[] args) {
        Integer[] array = {50, 25, 12, null, null, 37, 30, null, null, null,75, 62, null, 70, null, null, 87, null, null};
        Node node = binaryTree(array);
        kLevelDown(node, 2);
    }
}
