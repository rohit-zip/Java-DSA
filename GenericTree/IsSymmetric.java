package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class IsSymmetric {

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

    public static boolean areMirror(Node a, Node b){
        if (a.children.size()!=b.children.size()){
            return false;
        }
        for (int i=0 ; i<a.children.size() ; i++){
            Node a1 = a.children.get(i);
            Node b1 = b.children.get(b.children.size()-1-i);
            if (!areMirror(a1, b1)){
                return false;
            }
        }
        return true;
    }

    /**
     *
     * Time Complexity -> O(N) <br/>
     * Space Complexity -> O(logn) (Proportional to Height of tree)
     */
    public static boolean isSymmetric(Node root){
        return areMirror(root, root);
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        int[] tree = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, -1, 90, -1, -1, 40, 100, -1, 110, -1, -1, -1};
        Node node = genericTree(tree);
        System.out.println(isSymmetric(node));
    }
}
