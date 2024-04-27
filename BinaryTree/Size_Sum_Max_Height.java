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
    }

    private static class Pair{
        int state;
        Node node;

        Pair(int state, Node node){
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
        str += " -> " + root.data + " <- ";
        str += root.right==null ? "." : root.right.data;
        System.out.println(str);
        display(root.left);
        display(root.right);
    }

    public static int size(Node root){
        if (root==null)
            return 0;
        int leftSize = size(root.left);
        int rightSize = size(root.right);
        return leftSize + rightSize + 1;
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
        int height = Math.max(leftHeight, rightHeight) + 1;

        return height;
    }

    public static void main(String[] args) {
        Integer[] array = {50, 25, 12, null, null, 37, 30, null, null, null,75, 62, null, 70, null, null, 87, null, null};
        Stack<Pair> stack = new Stack<>();
        Node root = new Node(array[0]);
        Pair pair = new Pair(1, root);
        stack.push(pair);
        int idx = 0;
        while(stack.size()>0){
            Pair top = stack.peek();
            if (top.state==1){
                idx++;
                if (array[idx]!=null){
                    Node leftNode = new Node(array[idx]);
                    top.node.left = leftNode;
                    Pair leftPair = new Pair(1, leftNode);
                    stack.push(leftPair);
                } else{
                    top.node.left = null;
                }
                top.state++;
            }
            if (top.state==2){
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
            }
            else {
                stack.pop();
            }
        }
        display(root);
        System.out.println(size(root));
        System.out.println(sum(root));
        System.out.println(max(root));
        System.out.println(height(root));
    }
}
