package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class Multisolver {

    static int size;
    static int min;
    static int max;
    static int height;

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
     * Time Complexity -> O(N)
     * Space Complexity -> O(1)
     */
    public static void multiSolver(Node root, int depth){
        size++;
        min = Math.min(root.data, min);
        max = Math.max(root.data, max);
        height = Math.max(height, depth);
        for (Node child : root.children){
            multiSolver(child, depth + 1);
        }
    }

    public static void main(String[] args) {
        int[] tree = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, -1, 90, -1, -1, 40, 100, -1, 110, -1, -1, -1};
        Node node = genericTree(tree);
        size=0;
        min=Integer.MAX_VALUE;
        max=Integer.MIN_VALUE;
        height=0;
        multiSolver(node, 0);
        System.out.println("Size : " + size);
        System.out.println("Min : " + min);
        System.out.println("Max : " + max);
        System.out.println("Height : " + height);
    }
}
