package GenericTree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderLineWise {

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    //Here we have to add all level in one line and other in next line

    /**
     *
     * Time Complexity -> O(N)
     * Space Complexity -> O(N) Storing in one or other Queue
     * @param root
     */
    public static void levelOrderLineWise(Node root){
        Queue<Node> mq = new ArrayDeque<>();
        mq.add(root);
        Queue<Node> cq = new ArrayDeque<>();
        while(mq.size()>0){
            root = mq.remove();
            System.out.print(root.data + " ");
            for (Node child : root.children){
                cq.add(child);
            }

            //Means one level is completed now we have to copy mq to cq
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
        levelOrderLineWise(root);
    }
}
