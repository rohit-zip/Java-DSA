package BinarySearchTree;

public class SizeSum {

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

    public static Node binarySearchTree(int[] array, int lo, int hi){
        if (lo > hi) {
            return null;
        }
        int mid = (lo + hi) / 2;
        int data = array[mid];
        Node lc = binarySearchTree(array, lo, mid-1);
        Node rc = binarySearchTree(array, mid+1, hi);
        Node node = new Node(data, lc, rc);
        return node;
    }

    public static int size(Node node){
        if (node==null)
            return 0;
        int leftSize = size(node.left);
        int rightSize = size(node.right);
        int total = leftSize + rightSize + 1;
        return total;
    }

    public static int sum(Node node){
        if (node == null) {
            return 0;
        }
        int leftSum = sum(node.left);
        int rightSum = sum(node.right);
        int total = leftSum + rightSum + node.data;
        return total;
    }

    public static void main(String[] args) {
        int[] array = {12, 25, 37, 50, 62, 67, 87};
    }
}
