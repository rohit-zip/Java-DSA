package BinarySearchTree;

public class AddNode {

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

    public static Node addNode(Node node, int data){
        if (node==null){
            return new Node(data, null, null);
        }
        if (data>node.data){
            node.right = addNode(node.right, data);
        } else if (data<node.data){
            node.left = addNode(node.left, data);
        }
        return node;
    }

    public static void display(Node node){
        if (node==null)
            return;
        String str = "";
        str+= node.left==null ? "." : node.left.data;
        str+= " <- " + node.data + " -> ";
        str+= node.right==null ? "." : node.right.data;
        System.out.println(str);
        display(node.left);
        display(node.right);
    }

    public static void main(String[] args) {
        int[] array = {12, 25, 37, 50, 62, 67, 87};
        Node node = generate(array, 0, array.length - 1);
        display(node);
        Node addedNode = addNode(node, 40);
        display(addedNode);
    }
}
