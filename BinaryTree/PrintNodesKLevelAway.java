package BinaryTree;

import java.util.ArrayList;
import java.util.Stack;

public class PrintNodesKLevelAway {

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

    static ArrayList<Node> list;
    public static boolean nodeToRootPath(Node node, int data){
        if (node==null){
            return false;
        }

        if (node.data==data){
            list.add(node);
            return true;
        }

        boolean leftPath = nodeToRootPath(node.left, data);
        if (leftPath){
            list.add(node);
            return true;
        }

        boolean rightPath = nodeToRootPath(node.right, data);
        if (rightPath) {
            list.add(node);
            return true;
        }

        return false;
    }

    public static void kLevelDown(Node node, int k, Node blocker){
        if (node==null || k<0 || blocker==null){
            return;
        }

        if (k == 0) {
            System.out.println(node.data);
            return;
        }

        kLevelDown(node.left, k-1, blocker);
        kLevelDown(node.right, k-1, blocker);
    }

    public static void printKNodesFar(Node node, int data, int k){
        list = new ArrayList<>();
        nodeToRootPath(node, data);
        for (int i=0 ; i<list.size() ; i++){
            kLevelDown(list.get(i), k-i, i==0 ? null : list.get(i-1));
        }
    }

    public static void main(String[] args) {
        Integer[] array = {50, 25, 12, null, null, 37, 30, null, null, null,75, 62, null, 70, null, null, 87, null, null};
        Node node = binaryTree(array);
        printKNodesFar(node, 30, 2);
    }
}
