package GenericTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversal {

    private static class Node {
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    //Display
    public static void display(Node node){
        String str = node.data + " -> ";
        for (Node child : node.children){
            str += child.data + ",";
        }
        str += ".";
        System.out.println(str);
        for (Node child : node.children)
            display(child);
    }

    public static int size(Node root){
        int size = 0;
        for (Node child : root.children){
            int childSize = size(child);
            size += childSize;
        }
        size += 1;
        return size;
    }

    public static int max(Node root){
        int max = Integer.MIN_VALUE;
        for (Node child : root.children){
            int childMax = max(child);
            max = Math.max(max, childMax);
        }
        max = Math.max(root.data, max);
        return max;
    }

    public static int height(Node root){
        int height  = -1;
        for (Node child : root.children){
            int childHeight = height(child);
            height = Math.max(height, childHeight);
        }
        height += 1;
        return height;
    }

    public static void traversal(Node root){
        System.out.println("Node Pre : " + root.data);
        for (Node child : root.children){
            System.out.println("Edge Pre : " + root.data + " -- " + child.data);
            traversal(child);
            System.out.println("Edge Post : " + root.data + " -- " + child.data);
        }
        System.out.println("Node Post : " + root.data);
    }

    /**
     *
     * Time Complexity -> O(N) <br/>
     * Space Complexity -> O(N) A Queue of size N is used <br/>
     * @param root
     */
    public static void levelOrderTraversal(Node root){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(root);
        while(queue.size()>0){
            root = queue.remove();
            System.out.print(root.data + " ");
            for (Node child : root.children){
                queue.add(child);
            }
        }
        System.out.print(".");
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = new Node();
        Stack<Node> st = new Stack<>();
        for (int i : array){
            if (i==-1){
                st.pop();
            } else {
                Node temp = new Node();
                temp.data = i;
                if (st.size()>0){
                    st.peek().children.add(temp);
                } else {
                    root = temp;
                }
                st.push(temp);
            }
        }
        display(root);
        System.out.println("Size of Generic tree : " + size(root));
        System.out.println("Maximum of Generic tree : " + max(root));
        System.out.println("Height of  Generic tree : " + height(root));
        traversal(root);
        levelOrderTraversal(root);
    }
}
