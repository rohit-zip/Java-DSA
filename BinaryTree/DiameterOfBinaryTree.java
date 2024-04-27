package BinaryTree;

import java.util.Stack;

public class DiameterOfBinaryTree {

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

    private static class DiameterPair{
        int height;
        int diameter;
    }

    public static Node binaryTree(Integer[] array){
        Stack<Pair> stack = new Stack<>();
        Node root = new Node(array[0]);
        Pair rootPair = new Pair(1, root);
        stack.push(rootPair);
        int idx = 0;
        while (stack.size() > 0) {
            Pair top = stack.peek();
            if (top.state == 1) {
                idx++;
                if (array[idx] != null) {
                    Node leftNode = new Node(array[idx]);
                    top.node.left = leftNode;
                    Pair leftPair = new Pair(1, leftNode);
                    stack.push(leftPair);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state == 2) {
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

    public static void display(Node root){
        String str = "";
        if (root==null)
            return;
        str+= root.left==null ? "." : root.left.data;
        str+= " <- " + root.data + " -> ";
        str+= root.right==null ? "." : root.right.data;
        System.out.println(str);
        display(root.left);
        display(root.right);
    }

    public static int height(Node root){
        if (root==null)
            return -1;
        int lch = height(root.left);
        int rch = height(root.right);
        return Math.max(lch, rch) + 1;
    }

    /**
     *
     * Time Complexity -> O(n²) as after every diameter call there is a call for height
     *                          which is also recursive in nature. That's why this program is inefficient
     * @param root
     * @return
     */
    public static int diameter(Node root){
        if (root==null)
            return 0;
        int leftDiameter = diameter(root.left); //If maximum is on left
        int rightDiameter = diameter(root.right); //If maximum is on right
        int mainHeight = height(root.left) + height(root.right) + 2; //If left + right + root 2 edges is maximum
        int d = Math.max(mainHeight, Math.max(leftDiameter, rightDiameter));
        return d;
    }

    public static DiameterPair diameter2(Node root){
        if (root==null){
            DiameterPair bp = new DiameterPair();
            bp.height = -1;
            bp.diameter = 0;
            return bp;
        }
        DiameterPair lp = diameter2(root.left);
        DiameterPair rp = diameter2(root.right);
        DiameterPair mp = new DiameterPair();
        mp.height = Math.max(lp.height, rp.height) + 1;
        int factor = lp.height + rp.height + 2;
        mp.diameter = Math.max(factor, Math.max(lp.diameter, rp.diameter));
        return mp;
    }

    public static void main(String[] args) {
        Integer[] array = {50, 25, 12, null, null, 37, 30, null, null, null,75, 62, null, 70, null, null, 87, null, null};
        Node root = binaryTree(array);
        display(root);
    }
}
