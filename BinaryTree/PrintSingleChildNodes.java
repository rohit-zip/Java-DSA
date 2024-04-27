package BinaryTree;

import java.util.Stack;

public class PrintSingleChildNodes {
    private static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }

    private static class Pair {
        int state;
        Node node;

        public Pair(int state, Node node) {
            this.state = state;
            this.node = node;
        }
    }

    /**
     * Time Complexity -> O(N) Tree Traversal is involved which is required
     * Space Complexity -> O(N) Space used by Stack
     */
    public static Node binaryTree(Integer[] array) {
        Node root = new Node(array[0]);
        Pair rootPair = new Pair(1, root);
        Stack<Pair> stack = new Stack<>();
        stack.push(rootPair);
        int idx = 0;
        while (stack.size() > 0) {
            Pair top = stack.peek();
            if (top.state == 1) {
                idx++;
                if (array[idx] != null) {
                    Node leftNode = new Node(array[idx]);
                    Pair leftPair = new Pair(1, leftNode);
                    top.node.left = leftNode;
                    stack.push(leftPair);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state == 2) {
                idx++;
                if (array[idx] != null) {
                    Node rightNode = new Node(array[idx]);
                    Pair leftPair = new Pair(1, rightNode);
                    top.node.right = rightNode;
                    stack.push(leftPair);
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

    public static void printSingleChildNodes(Node node, Node parent){
        if (node==null){
            return;
        }
        if (parent!=null && parent.left==node && parent.right==null)
            System.out.println(node.data);
        if (parent!=null && parent.right==node && parent.left==null)
            System.out.println(node.data);
        printSingleChildNodes(node.left, node);
        printSingleChildNodes(node.right, node);
    }

    public static void main(String[] args) {
        Integer[] array = {50, 25, 12, null, null, 37, 30, null, null, null,75, 62, null, 70, null, null, 87, null, null};
        Node node = binaryTree(array);
        printSingleChildNodes(node, null);
    }
}
