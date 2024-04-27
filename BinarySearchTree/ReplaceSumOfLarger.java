package BinarySearchTree;

import java.util.ArrayDeque;
import java.util.Queue;

public class ReplaceSumOfLarger {

    static int sum = 0;

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
        int mid = (lo + hi) / 2;
        int data = array[mid];
        Node leftChild = generate(array, lo, mid - 1);
        Node rightChild = generate(array, mid + 1, hi);
        Node node = new Node(data, leftChild, rightChild);
        return node;
    }

    public static Node max(Node node){
        if (node.right!=null){
            return max(node.right);
        } else {
            return node;
        }
    }

    public static int size(Node node){
        if (node==null)
            return 0;
        int leftSize = size(node.left);
        int rightSize = size(node.right);
        int total = leftSize + rightSize + 1;
        return total;
    }

    public static boolean find(Node node, int data){
        if (node==null){
            return false;
        }
        if (node.data>data){
            return find(node.left, data);
        } else if (node.data<data){
            return find(node.right, data);
        } else {
            return true;
        }
    }

    public static Node addNode(Node node, int data){
        if (node==null){
            return new Node(data, null, null);
        }
        if (node.data > data){
            node.right = addNode(node.right, data);
        } else if (node.data < data){
            node.left = addNode(node.left, data);
        }
        return node;
    }

    public static Node removeNode(Node node, int data){
        if (node.data < data){
            node.left = removeNode(node.left, data);
        } else if (node.data > data){
            node.right = removeNode(node.right, data);
        } else {
            if (node.left!=null && node.right!=null){
                Node leftMax = max(node.left);
                node.data = leftMax.data;
                node.left = removeNode(node.left, leftMax.data);
                return node;
            } else if (node.left!=null){
                return node.left;
            } else if (node.right != null) {
                return node.right;
            } else {
                return null;
            }
        }
        return node;
    }

    /**
     *
     * In-Order of BST will always visit tree in sorted form
     * We will use reverse recursion here
     */
    public static void replaceSumOfLarger(Node node){
        if (node==null)
            return;
        replaceSumOfLarger(node.right);
        int originalData = node.data;
        node.data = sum;
        sum+= originalData;
        replaceSumOfLarger(node.left);
    }

    public static void levelOrderTraversal(Node node){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while(queue.size()>0){
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

    public static void main(String[] args) {
        int[] array = {12, 25, 37, 50, 62, 67, 87};
        Node node = generate(array, 0, array.length - 1);
        replaceSumOfLarger(node);
        levelOrderTraversal(node);
    }
}
