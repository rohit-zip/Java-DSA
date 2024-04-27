package BinarySearchTree;

public class Min {
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
        if (lo>hi)
            return null;
        int mid = (lo + hi) / 2;
        int data = array[mid];
        Node lc = binarySearchTree(array, lo, mid - 1);
        Node rc = binarySearchTree(array, mid + 1, hi);
        Node node = new Node(data, lc, rc);
        return node;
    }

    public static int min(Node node){
        if (node.left!=null)
            return min(node.left);
        else
            return node.data;
    }

    public static void main(String[] args) {
        int[] array = {12, 25, 37, 50, 62, 67, 87};
        Node node = binarySearchTree(array, 0, array.length - 1);
        System.out.println(min(node));
    }
}
