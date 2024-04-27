package BinaryTree;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class LevelOrderTraversal {

    private static class Node{
        int data;
        Node left;
        Node right;

        Node(int data){
            this.data = data;
        }
    }

    private static class Pair{
        int state;
        Node node;

        public Pair(int state, Node node) {
            this.state = state;
            this.node = node;
        }
    }

    /**
     * Time Complexity -> O(N) <br/>
     * Space Complexity -> O(N) <br/>
     * Algorithm : <br/>
     *  1. RPA (Remove, Print, Add) to be followed <br/>
     *  2. Add in the queue <br/>
     *  3. Remove root element add it's child in the queue and print the root element <br/>
     *  4. Enter for next line <br/>
     *  5. Now two childs then loop will be executed two times <br/>
     *  6. Again follow the same steps to achieve our results <br/>
     */
    public static void levelOrderTraversal(Node root){
        Queue<Node> mainQueue = new ArrayDeque<>();
        mainQueue.add(root);
        while(mainQueue.size()>0){
            int queueSize = mainQueue.size();
            for (int i=0 ; i<queueSize ; i++){
                root = mainQueue.remove();
                System.out.print(root.data + " ");
                if (root.left!=null){
                    mainQueue.add(root.left);
                }
                if (root.right!=null){
                    mainQueue.add(root.right);
                }
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Integer[] array = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Stack<Pair> stack = new Stack<>();
        Node root = new Node(array[0]);
        Pair rootPair = new Pair(1, root);
        stack.push(rootPair);
        int idx = 0;
        while(stack.size()>0){
            Pair top = stack.peek();
            if (top.state==1){
                idx++;
                if (array[idx]!=null){
                    Node leftNode = new Node(array[idx]);
                    Pair leftPair = new Pair(1, leftNode);
                    top.node.left = leftNode;
                    stack.push(leftPair);
                } else {
                    top.node.left = null;
                }
                top.state++;
            } else if (top.state==2){
                idx++;
                if (array[idx]!=null){
                    Node rightNode = new Node(array[idx]);
                    Pair rightPair = new Pair(1, rightNode);
                    top.node.right = rightNode;
                    stack.push(rightPair);
                } else {
                    top.node.right = null;
                }
                top.state++;
            } else {
                stack.pop();
            }
        }
        levelOrderTraversal(root);
    }
}
