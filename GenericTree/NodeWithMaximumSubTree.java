package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class NodeWithMaximumSubTree {

    static int maximumSumNode = 0;
    static int maximumSum = Integer.MIN_VALUE;
    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static Node genericTree(int[] array){
        Node root = new Node();
        Stack<Node> stack = new Stack<>();
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

    public static int nodeWithMaximumSubtree(Node root){
        int sum = 0;
        for (Node child : root.children){
            int childSum = nodeWithMaximumSubtree(child);
            sum+= childSum;
        }
        sum+= root.data;

        if (sum > maximumSum){
            maximumSumNode = root.data;
            maximumSum = sum;
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = genericTree(array);
        nodeWithMaximumSubtree(root);
        System.out.println("Maximum Sum Node is : " + maximumSumNode);
        System.out.println("Maximum Sum is : " + maximumSum);
    }
}
