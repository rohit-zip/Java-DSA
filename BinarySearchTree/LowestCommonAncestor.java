package BinarySearchTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class LowestCommonAncestor {

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
        if (lo>hi){
            return null;
        }
        int mid = (lo+hi)/2;
        int data = array[mid];
        Node leftChild = generate(array, lo, mid - 1);
        Node rightChild = generate(array, mid + 1, hi);
        Node node = new Node(data, leftChild, rightChild);
        return node;
    }

    public static void levelOrderTraversal(Node node){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (queue.size() > 0) {
            int size = queue.size();
            for (int i=0 ; i<size ; i++){
                node = queue.remove();
                System.out.print(node.data + " ");
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            System.out.println();
        }
    }

    public static int lowestCommonAncestor(Node  node, int d1, int d2){
        if (d1 < node.data && d2 < node.data)
            return lowestCommonAncestor(node.left, d1, d2);
        else if (d1 > node.data && d2 > node.data)
            return lowestCommonAncestor(node.right, d1, d2);
        else {
            return node.data;
        }
    }

    public static void main(String[] args) {
        int[] array = {12, 25, 37, 50, 62, 67, 87};
        Node node = generate(array, 0, array.length - 1);
        System.out.println(lowestCommonAncestor(node, 87, 62));
    }
}
