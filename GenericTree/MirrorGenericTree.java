package GenericTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class MirrorGenericTree {

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    /**
     *
     * Time Complexity -> O(N) <br/>
     * Space Complexity -> O(nlogn) (Equal to the height of the tree due to the recursion stack) <br/>
     * Keep a faith that all subtrees knows how to transform mirror <br/>
     * Keeping in mind about this faith write code <br/>
     * @param root
     */
    public static void mirror(Node root){
        for (Node child : root.children){
            mirror(child);
        }
        Collections.reverse(root.children);
    }

    public static void display(Node root){
        StringBuilder st = new StringBuilder(root.data + " -> ");
        for (Node child : root.children){
            st.append(child.data).append(",");
        }
        st.append(".");
        System.out.println(st);
        for (Node child : root.children){
            display(child);
        }
    }
    public static void main(String[] args) {
        int[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = new Node();
        Stack<Node> stack = new Stack<>();
        for (int i=0 ; i<array.length ; i++){
            if (array[i]==-1){
                stack.pop();
            } else {
                Node temp = new Node();
                temp.data = array[i];
                if (stack.size()>0){
                    stack.peek().children.add(temp);
                } else{
                    root = temp;
                }
                stack.push(temp);
            }
        }
        System.out.println("Before Mirror");
        display(root);
        System.out.println("Mirror Of Generic Tree");
        mirror(root);
        display(root);
    }
}
