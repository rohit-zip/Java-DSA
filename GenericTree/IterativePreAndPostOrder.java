package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class IterativePreAndPostOrder {

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    private static class Pair{
        Node node;
        int state;

        public Pair(Node node, int state) {
            this.node = node;
            this.state = state;
        }
    }

    public static Node genericTree(int[] array){
        Stack<Node> stack = new Stack<>();
        Node root = new Node();
        for (int i : array){
            if (i==-1)
                stack.pop();
            else {
                Node temp = new Node();
                temp.data = i;
                if (stack.size()>0)
                    stack.peek().children.add(temp);
                else
                    root = temp;
                stack.push(temp);
            }
        }
        return root;
    }

    public static void display(Node node){
        String str = node.data + " -> ";
        for (Node child : node.children){
            str += child.data + " , ";
        }
        str += ".";
        System.out.println(str);

        for (Node child : node.children){
            display(child);
        }
    }

    /**
     *
     * -1 -> Pre-Order, State++
     * State = Children.Size -> Post-Order, Pop
     * 0 to Children.Size-1 -> Push Children, State++
     */
    public static void iterativePreAndPostOrder(Node root){
        StringBuilder pre = new StringBuilder();
        StringBuilder post = new StringBuilder();
        Stack<Pair> stack = new Stack<>();
        stack.push(new Pair(root, -1));
        while(stack.size()>0){
            Pair top = stack.peek();
            if (top.state==-1){
                pre.append(top.node.data).append(" ");
                top.state++;
            } else if (top.state==top.node.children.size()){
                post.append(top.node.data).append(" ");
                stack.pop();
            } else {
                Pair pair = new Pair(top.node.children.get(top.state), -1);
                stack.push(pair);
                top.state++;
            }
        }
        System.out.println("Pre-Order : " + pre);
        System.out.println("Post-Order : " + post);
    }
    public static void main(String[] args) {
        int[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = genericTree(array);
        iterativePreAndPostOrder(root);
    }
}
