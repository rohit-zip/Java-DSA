package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class PredecessorAndSuccessor {

    static Node predecessor;
    static Node successor;
    static int state;

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static Node genericTree(int[] array){
        Stack<Node> stack = new Stack<>();
        Node root = new Node();
        for (int i : array){
            if (i == -1) {
                stack.pop();
            } else {
                Node node = new Node();
                node.data = i;
                if (stack.size()>0){
                    stack.peek().children.add(node);
                } else {
                    root = node;
                }
                stack.push(node);
            }
        }
        return root;
    }

    /**
     *
     *
     * @param root
     * @param data
     */
    public static void predecessorAndSuccessor(Node root, int data){
        if (state==0){
            if (root.data==data)
                state=1;
            else
                predecessor = root;
        } else if (state==1){
            successor = root;
            state=2;
        }
        for (Node child : root.children){
            predecessorAndSuccessor(child, data);
        }
    }

    public static void main(String[] args) {
        int[] tree = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, -1, 90, -1, -1, 40, 100, -1, 110, -1, -1, -1};
        Node root = genericTree(tree);
        predecessor = null;
        successor = null;
        state = 0;
        predecessorAndSuccessor(root, 100);
        System.out.println("Predecessor : " + predecessor.data);
        System.out.println("Successor : " + successor.data);
    }
}
