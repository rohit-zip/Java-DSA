package GenericTree;

import java.util.ArrayList;
import java.util.Stack;

public class CeilFloor {

    static int ceil;
    static int floor;

    private static class Node{
        int data;
        ArrayList<Node> children = new ArrayList<>();
    }

    public static Node genericTree(int[] array){
        Node root = new Node();
        Stack<Node> stack = new Stack<>();
        for (int i : array){
            if (i==-1){
                stack.pop();
            } else {
                Node temp = new Node();
                temp.data = i;
                if (stack.size() > 0) {
                    stack.peek().children.add(temp);
                } else {
                    root = temp;
                }
                stack.push(temp);
            }
        }
        return root;
    }

    public static void ceilFloor(Node root, int data){
        if (root.data > data){
            if (root.data < ceil){
                ceil = root.data;
            }
        }
        if (root.data < data){
            if (root.data > floor){
                floor = root.data;
            }
        }
        for (Node child : root.children){
            ceilFloor(child, data);
        }
    }

    public static void main(String[] args) {
        int[] array = {10, 20, 50, -1, 60, -1, -1, 30, 70, -1, 80, 110, -1, 120, -1, -1, 90, -1, -1, 40, 100, -1, -1, -1};
        Node root = genericTree(array);
        ceil = Integer.MAX_VALUE; //Smallest among largest
        floor = Integer.MIN_VALUE; // largest among smaller
        ceilFloor(root, 50);
        System.out.println("Ceil : " + ceil);
        System.out.println("Floor : " + floor);
    }
}
