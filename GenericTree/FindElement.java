package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class FindElement {

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    /**
     *
     * Time Complexity -> O(N)
     * Space Compelexity -> O(1)
     * We have a faith that sub trees of root knows how to find the data
     * Note : Half Euler will be made in this question
     * @param root
     * @param data
     * @return
     */
    public static boolean find(Node root, int data){
        if (root.data == data)
            return true;
        for (Node child : root.children){
            boolean isFound = find(child, data);
            if (isFound)
                return true;
        }
        return false;
    }
    public static void main(String[] args) {
        int[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Stack<Node> stack = new Stack<>();
        Node root = new Node();
        for (int i : array){
            if (i==-1)
                stack.pop();
            else {
                Node node = new Node();
                node.data = i;
                if (stack.size()>0)
                    stack.peek().children.add(node);
                else
                    root = node;
                stack.push(node);
            }
        }
        System.out.println(find(root, 70));
    }
}
