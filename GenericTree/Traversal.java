package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class Traversal {

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static int height(Node node){
        int height = -1;
        for (Node child : node.children){
            int childHeight = height(child);
            height = Math.max(childHeight, height);
        }
        height += 1;
        return height;
    }

    /**
     *
     * @Time_Complexity O(2ⁿ)
     * @Space_Complexity O(1)
     */
    public static void traversals(Node root){
        //Area1 || Euler's Left || While going deep in the recursion || Preorder
        System.out.println("Node Pre " + root.data);
        for (Node child : root.children){

            //Edge Pre
            System.out.println("Edge Pre " + root.data + " -- " + child.data);
            traversals(child);

            //Edge Post
            System.out.println("Edge Post " + root.data + " -- " + child.data);
        }
        //Area2 || Euler's Right || While coming out of the recursion || Postorder
        System.out.println("Node Post " + root.data);
    }
    public static void main(String[] args) {
        int[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = new Node();
        Stack<Node> stack = new Stack<>();
        for (int j : array) {
            if (j == -1) {
                stack.pop();
            } else {
                Node node = new Node();
                node.data = j;
                if (stack.size() > 0) {
                    stack.peek().children.add(node);
                } else {
                    root = node;
                }
                stack.push(node);
            }
        }
        traversals(root);
    }
}