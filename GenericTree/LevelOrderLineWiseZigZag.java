package GenericTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderLineWiseZigZag {

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static void display(Node node){
        StringBuilder st = new StringBuilder(node.data + " -> ");
        for (Node child : node.children){
            st.append(child.data).append(",");
        }
        System.out.println(st);
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

    public static void levelOrderTraversal(Node node){
        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while(queue.size()>0){
            node = queue.remove();
            System.out.print(node.data + " ");
            for (Node child : node.children){
                queue.add(child);
            }
        }
        System.out.println(".");
    }

    /**
     *
     * Time Complexity -> O(N)
     * Space Complecity -> O(N)
     * Here we use two stack, main stack and child stack and one flag variable
     * Our algorithm will be removed, print and add (rpa)
     *
     * Step-wise algorithm here
     * 1. Add 10 to main stack
     * 2. Remove 10 and print it
     * 3. Add its children to child stack
     * 4. If we are on level 1 add to child stack in same order
     * 5. Enter and change level to 2
     * 6. Then main stack = child stack and child stack = new
     * @param root
     */
    public static void levelOrderZigZag(Node root){
        Stack<Node> ms = new Stack<>();
        Stack<Node> cs = new Stack<>();
        ms.push(root);
        int level =1;
        while(ms.size()>0){
            root = ms.pop();
            System.out.print(root.data + " ");
            if (level%2==1){
                for (int i=0 ; i<root.children.size() ; i++){
                    Node child = root.children.get(i);
                    cs.push(child);
                }
            } else {
                for (int i=root.children.size()-1 ; i>=0 ; i--){
                    Node child = root.children.get(i);
                    cs.push(child);
                }
            }
            if (ms.size()==0){
                ms = cs;
                cs = new Stack<>();
                level++;
                System.out.println();
            }
        }
    }

    public static void levelOrderLineWise(Node root){
        Queue<Node> mq = new ArrayDeque<>();
        Queue<Node> cq = new ArrayDeque<>();
        mq.add(root);
        while(mq.size()>0){
            root = mq.remove();
            System.out.print(root.data + " ");
            for (Node child : root.children){
                cq.add(child);
            }
            if (mq.size()==0){
                mq = cq;
                cq = new ArrayDeque<>();
                System.out.println();
            }
        }
    }
    public static void main(String[] args) {
        int[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = new Node();
        Stack<Node> st = new Stack<>();
        for (int i : array){
            if (i==-1)
                st.pop();
            else {
                Node temp = new Node();
                temp.data = i;
                if (st.size()>0)
                    st.peek().children.add(temp);
                else
                    root = temp;
                st.push(temp);
            }
        }
        System.out.println("Level Order Zig Zag");
        levelOrderZigZag(root);
    }
}
