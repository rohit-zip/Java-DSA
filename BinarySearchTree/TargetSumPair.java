package BinarySearchTree;

public class TargetSumPair {

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

    public static boolean find(Node node, int data){
        if (node==null)
            return false;
        if (data < node.data)
            return find(node.left, data);
        else if (data > node.data)
            return find(node.right, data);
        else
            return true;
    }

    public static void travelAndPrint(Node root, Node node, int target){
        if (node==null)
            return;
        travelAndPrint(root, node.left, target);
        int compare = target - node.data;
        if (node.data < compare){
            if (find(root, compare))
                System.out.println(node.data + " " + compare);
        }
        travelAndPrint(root, node.right, target);
    }

    public static void main(String[] args) {
        int[] array = {12, 25, 37, 50, 62, 67, 87};
        Node node = generate(array, 0, array.length - 1);
        System.out.println(find(node, 16));
        travelAndPrint(node, node, 75);
    }
}
