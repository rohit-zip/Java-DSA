package BinaryTree;

import java.util.Stack;

public class InterativeTraversals {

    private static class Node{
        int data;
        Node right;
        Node left;

        Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    private static class Pair{
        Node node;
        int state;

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    /**
     *
     * Here we are using state method to follow recursion type practice <br/>
     * If state is means it is in Pre-Order <br/>
     * State is 2 means it is in In-Order <br/>
     * State is 3 means it is in Post-Order <br/>
     *
     */
    public static void iterativeTraversal(Node root){
        Stack<Pair> stack = new Stack<>();
        Pair rootPair = new Pair(root, 1);
        stack.push(rootPair);
        String pre = "";
        String in = "";
        String post = "";
        while(stack.size()>0){
            Pair top = stack.peek();
            if (top.state==1){
                pre+= top.node.data + " ";
                top.state++;
                if (top.node.left!=null){
                    Pair leftPair = new Pair(top.node.left, 1);
                    stack.push(leftPair);
                }
            } else if (top.state==2){
                in+= top.node.data + " ";
                top.state++;
                if (top.node.right != null) {
                    Pair rightPair = new Pair(top.node.right, 1);
                    stack.push(rightPair);
                }
            } else {
                post += top.node.data + " ";
                stack.pop();
            }
        }
        System.out.println("Pre-Order : " + pre);
        System.out.println("In-Order : " + in);
        System.out.println("Post-Order : " + post);
    }

    public static void main(String[] args) {
        Integer[] array = {50, 25, 12, null, null, 37, 30, null, null, null, 75, 62, null, 70, null, null, 87, null, null};
        Stack<Pair> stack = new Stack<>();

        //Creating new Node with array[0] as it's data
        Node root = new Node(array[0], null, null);

        //Creating root pair in which root node is added and state is setting to 1
        //State 1 means add left, 2 means add right, 3 means pop
        Pair rootPair = new Pair(root, 1);

        //Pushing root pair to the stack for starting the work
        stack.push(rootPair);
        int index = 0;
        while(stack.size()>0){
            Pair top = stack.peek();

            //Means we have to work for left
            if (top.state==1){
                index++;
                if (array[index]!=null){
                    Node leftNode = new Node(array[index], null, null);
                    top.node.left = leftNode;
                    Pair leftPair = new Pair(leftNode, 1);
                    stack.push(leftPair);
                } else {
                    top.node.left = null;
                }
                top.state++;
            }
            //Means we have to work for right
            else if (top.state==2){
                index++;
                if (array[index]!=null){
                    Node rightNode = new Node(array[index], null, null);
                    top.node.right = rightNode;
                    Pair rightPair = new Pair(rightNode, 1);
                    stack.push(rightPair);
                } else {
                    top.node.right = null;
                }
                top.state++;
            } else {
                stack.pop();
            }
        }
        iterativeTraversal(root);
    }
}
