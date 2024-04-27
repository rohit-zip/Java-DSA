package BinarySearchTree;

public class RemoveNode {

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
        Node lc = generate(array, lo, mid - 1);
        Node rc = generate(array, mid + 1, hi);
        Node node = new Node(data, lc, rc);
        return node;
    }

    public static Node max(Node node){
        if (node.right!=null) {
            Node max = max(node.right);
            return max;
        } else {
            return node;
        }
    }

    public static Node remove(Node node, int data){
        if (node == null) {
            return null;
        }
        if (node.data < data)
            node.left = remove(node.right, data);
        else if (node.data > data)
            node.left = remove(node.left, data);
        else{
            if (node.left!=null && node.right!=null){
                Node leftMax = max(node.left);
                node.data = leftMax.data;
                node.left = remove(node.left, leftMax.data);
                return node;
            } else if (node.left!=null) {
                return node.left;
            } else if (node.right!=null) {
                return node.right;
            } else {
                return null;
            }
        }
        return node;
    }

    public static void main(String[] args) {
        int[] array = {12, 25, 37, 50, 62, 67, 87};
        Node node = generate(array, 0, array.length - 1);
    }
}
