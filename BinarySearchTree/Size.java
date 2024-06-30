package BinarySearchTree;

/**
 * Owner - Rohit Parihar
 * Author - rohit
 * Project - Java Questions
 * Package - BinarySearchTree
 * Created_on - June 30 - 2024
 * Created_at - 17:23
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

    private static Node generateTree(int[] array, int lo, int hi) {
        if (lo > hi) return null;
        int mid = (lo + hi) / 2;
        int data = array[mid];
        Node lc = generateTree(array, lo, mid - 1);
        Node rc = generateTree(array, mid + 1, hi);
        return new Node(data, lc, rc);
    }

    private static void display(Node root) {
        if (root == null) return;
        String str = "";
        str+= root.left == null ? "." : root.left.data + "";
        str+= " <- " + root.data + " -> ";
        str+= root.right == null ? "." : root.right.data + "";
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

    public static void main(String[] args) {

        // In order
        int[] array = {12, 25, 37, 50, 62, 75, 87};
        Node root = generateTree(array, 0, array.length - 1);
        display(root);
        System.out.println(size(root));
    }
}
