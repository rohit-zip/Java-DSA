package BinarySearchTree;

public class Find {

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
        if (lo>hi)
            return null;
        int mid = (lo + hi) / 2;
        int data = array[mid];
        Node lc = generate(array, lo, mid - 1);
        Node rc = generate(array, mid + 1, hi);
        Node node = new Node(data, lc, rc);
        return node;
    }

    public static boolean find(Node node, int data){
        if (node==null)
            return false;
        if (data>node.data){
            return find(node.right, data);
        } else if (data<node.data){
            return find(node.left, data);
        } else
            return true;
    }

    public static void main(String[] args) {
        int[] array = {12, 25, 37, 50, 62, 67, 87};
        Node node = generate(array, 0, array.length - 1);
        System.out.println(find(node, 26));
    }
}
