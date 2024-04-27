package BinarySearchTree;

public class PrintnInRange {

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

    public static Node generate(int[] array, int lo, int hi){
        if (lo > hi) {
            return null;
        }
        int mid = (lo+hi)/2;
        int data = array[mid];
        Node leftChild = generate(array, lo, mid - 1);
        Node rightChild = generate(array, mid + 1, hi);
        Node node = new Node(data, leftChild, rightChild);
        return node;
    }

    public static void printInRange(Node node, int d1, int d2){
        if (node==null){
            return;
        }
        if (d1 < node.data && d2 < node.data)
            printInRange(node.left, d1, d2);
        else if (d1 > node.data && d2 > node.data)
            printInRange(node.right, d1, d2);
        else {
            printInRange(node.left, d1, d2);
            System.out.print(node.data + " ");
            printInRange(node.right, d1, d2);
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 25, 37, 50, 62, 67, 87};
        Node node = generate(array, 0, array.length - 1);
        printInRange(node, 27, 75);
    }
}
