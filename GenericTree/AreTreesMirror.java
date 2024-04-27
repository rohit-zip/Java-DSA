package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class AreTreesMirror {

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    /**
     *
     * Time Complexity -> O(N) <br/>
     * Space Complexity -> O(logn) (Proportional to Height of tree)
     */
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
    public static void main(String[] args) {
        Node a = genericTree(new int[]{10, 20, -1, 30, 50, -1, 60, -1, -1, 40, -1, -1});
        Node b = genericTree(new int[]{100, 200, -1, 300, 500, -1, 600, -1, -1, 400, -1, -1});
        System.out.println(areMirror(a, b));
    }
}
